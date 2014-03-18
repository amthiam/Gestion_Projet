
package dao.impl;

import dao.DAO;
import exceptions.DatabaseException;
import exceptions.ProjectException;
import exceptions.ResultCode;
import java.math.BigDecimal;
import java.sql.Clob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Date;
import java.util.LinkedList;
import manager.DatabaseManager;
import model.Activity;
import model.Place;
import model.State;
import model.WBSElement;

/**
 * Implementation of the abstract DAO class Class used to create, update, find
 * and delete information about activities in the database
 * @author Felix
 */
public class ActivityDAO extends DAO<Activity> {
    
    /**
     * Constructor
     *
     * @param db : database manager providing a connection to the database
     */
    public ActivityDAO(DatabaseManager db) {
        super(db);
    }

    @Override
    public Long create(Activity activity) throws ProjectException {
        
        // The fields project_id and activity_label are compulsory in the database
        if (activity.getLabel().isEmpty()) {
            throw new ProjectException(ResultCode.INVALID_OBJECT, "An activity must have a label");
        }
        if (activity.getIdProject() == null) {
            throw new ProjectException(ResultCode.INVALID_OBJECT, "An activity must belong to a project");
        }

        //Insertion in the database
        try {

            db.startTransaction();

            // SQL query
            String sql = "INSERT INTO projectDefinition.activity "
                    + "(project_id, activity_label, activity_description, activity_workload, activity_duration, "
                    + "activity_hypothesis, activity_calcNote, activity_constDateValue, element_id, constraintDateType_id, place_id) "
                    + "VALUES (?,?,?,?,?,?,?,?,?,?,?)";

            //Creation of the sql statement
            PreparedStatement stmt = db.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            stmt.setLong(1, activity.getIdProject());
            stmt.setString(2, activity.getLabel());

            // Field description is optional
            if (activity.isNull("description")) {
                stmt.setNull(3, java.sql.Types.CLOB);
            } else {
                Clob description = db.getConnection().createClob();
                description.setString(1, activity.getDescription());
                stmt.setClob(3, description);
            }
            
            // Field workload is optional
            if (activity.isNull("workload")) {
                stmt.setNull(4, java.sql.Types.DECIMAL);
            } else {
                stmt.setBigDecimal(4, activity.getWorkload());
            }
            
            // Field duration is optional
            if (activity.isNull("duration")) {
                stmt.setNull(5, java.sql.Types.DECIMAL);
            } else {
                stmt.setBigDecimal(5, activity.getDuration());
            }
            
            // Field hypothesis is optional
            if (activity.isNull("hypothesis")) {
                stmt.setNull(6, java.sql.Types.CLOB);
            } else {
                Clob hypothesis = db.getConnection().createClob();
                hypothesis.setString(1, activity.getHypothesis());
                stmt.setClob(6, hypothesis);
            }
            
            // Field calculationNote is optional
            if (activity.isNull("calculationNote")) {
                stmt.setNull(7, java.sql.Types.CLOB);
            } else {
                Clob calcNote = db.getConnection().createClob();
                calcNote.setString(1, activity.getCalculationNote());
                stmt.setClob(7, calcNote);
            }
            
            // Field constDateValue is optional
            if (activity.isNull("constDateValue")) {
                stmt.setNull(8, java.sql.Types.TIMESTAMP);
            } else {
                stmt.setTimestamp(8, new Timestamp(activity.getConstDateValue().getTime()));
            }

            // Field element_id is optional
            if (activity.isNull("element")) {
                stmt.setNull(9, java.sql.Types.BIGINT);
            } else {
                stmt.setLong(9, activity.getElement().getId());
            }
            
            // Field constraintDateType_id is optional
            if (activity.isNull("constraintDateType")) {
                stmt.setNull(10, java.sql.Types.BIGINT);
            } else {
                //Query to find the id of the constraint
                ResultSet ids = db.executeRequest("SELECT constraintDateType_id FROM projectDefinition.constraintDateType"
                        + "WHERE constraintDateType_label = "+ activity.getConstraintDateType());
                if(ids == null){
                    stmt.setNull(10, java.sql.Types.BIGINT);
                }
                else {
                    Long constraintDateType_id = ids.getLong("constraintDateType_id");
                stmt.setLong(10, constraintDateType_id);
                }
            }
            
            // Field place_id is optional
            if (activity.isNull("place")) {
                stmt.setNull(11, java.sql.Types.BIGINT);
            } else {
                stmt.setLong(11, activity.getPlace().getId());
            }
            
            
            //Execution of the query
            stmt.executeUpdate();

            // Retrieve the id of the element just created
            ResultSet generatedKeys = stmt.getGeneratedKeys();
            if (!generatedKeys.next()) {
                throw new DatabaseException(ResultCode.DATABASE_ERROR, "The creation of the activity in the database failed");
            }
            Long idActivity = generatedKeys.getLong(1);

            
            
            //Insertion of the states preceding this activity in the table statePredecessorToActivity
            LinkedList<State> statePredecessors = activity.getListOfStatePredecessors();
            System.out.println("Taille de la liste des états prédécesseurs : " + statePredecessors.size());
            for (State state : statePredecessors){
                db.executeUpdate("INSERT INTO projectDefinition.statePredecessorToActivity "
                        + "(state_id, activity_id) VALUES (" + state.getId() + ", " + idActivity + ")");
            }
            
            db.commit();

            return idActivity;
        }
        catch(SQLException e){
    throw new DatabaseException(e);            
        }
    }

    @Override
    public boolean delete(Activity obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Activity obj) throws ProjectException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Activity find(long id) throws ProjectException {
        
        try {

            ResultSet response = db.executeRequest(
                    "SELECT activity_id, project_id, activity_label, activity_description, activity_workload, "
                    + "activity_duration, activity_hypothesis, activity_calcNote, activity_constDateValue, "
                    + "element_id, constraintDateType_id, place_id "
                    + "FROM projectDefinition.activity "
                    + "WHERE activity_id = " + id);
            
            if (!response.next()) {
                throw new DatabaseException(ResultCode.DATABASE_ERROR, "Object not found");
            }

            Long idActivity = response.getLong("activity_id");
            Long idProject = response.getLong("project_id");
            String label = response.getString("activity_label");
            Clob descriptionCl = response.getClob("activity_description");
            BigDecimal workload = response.getBigDecimal("activity_workload");
            BigDecimal duration = response.getBigDecimal("activity_duration");
            Clob hypothesisCl = response.getClob("activity_hypothesis");
            Clob calcNoteCl = response.getClob("activity_calcNote");
            Date constDateValue = response.getTimestamp("activity_constDateValue");
            Long elementId = response.getLong("element_id");
            Long constraintDateTypeId = response.getLong("constraintDateType_id");
            Long placeId = response.getLong("place_id");
            
            String description = null;
            if (descriptionCl != null){
            description = descriptionCl.getSubString(1, (int) descriptionCl.length());
            }
            String hypothesis = null;
            if (hypothesisCl != null) {
            hypothesis = hypothesisCl.getSubString(1, (int) hypothesisCl.length());
            }
            String calculationNote = null;
            if (calcNoteCl != null) {
            calculationNote = calcNoteCl.getSubString(1, (int) calcNoteCl.length());
            }

            //Creation of the WBS element  and place objects
            WBSElementDAO wbsDAO = new WBSElementDAO(db);
            PlaceDAO placeDAO = new PlaceDAO(db);
            
            WBSElement element = null;
            if (elementId != 0) {
            element = wbsDAO.find(elementId);
            }
            
            Place place = null;
            if(placeId != 0){
            place = placeDAO.find(placeId);}
            
            //Query to find the string matching the constraintDateTypeId
            String constraintDateType = null;
            if(constraintDateTypeId != 0){
                ResultSet labelConstraint = db.executeRequest("SELECT constraintDateType_label FROM projectDefinition.constraintDateType "
                        + "WHERE constraintDateType_id = "+ constraintDateTypeId);
                if (labelConstraint.next()){
                    constraintDateType = labelConstraint.getString("constraintDateType_label");
                }
            }
            
            
            //Query to find the list of states preceding the activity
            LinkedList<State> listOfStatePredecessors = new LinkedList();
            ResultSet statePredecessorsSet = db.executeRequest("SELECT state_id "
                    + "FROM projectDefinition.statePredecessorToActivity WHERE activity_id = " + idActivity);
            StateDAO stateDAO = new StateDAO(db);
            while (statePredecessorsSet.next()){
                Long stateId = statePredecessorsSet.getLong("state_id");
                listOfStatePredecessors.add(stateDAO.find(stateId));
            }
            
            Activity result = new Activity(idActivity, idProject, label, description, workload, duration, hypothesis, calculationNote, constDateValue, element, constraintDateType, place, listOfStatePredecessors);

            return result;
        } catch (SQLException e) {
            throw new DatabaseException(e);
        }


    }
    
    
    
    
    /**
     * Method returning the list of activities stored in the database concerning a given project
     * @param projectId : id of the project 
     * @return the list of activities 
     */
    public LinkedList<Activity> ListActivitiesOfProject(long projectId) throws ProjectException{
        
        LinkedList<Activity> resultList = new LinkedList();
        
        //Query into the database to return the list of ids of activities.
        try{
            
            ResultSet response = db.executeRequest(
                    "SELECT activity_id FROM project WHERE project_id = " + projectId);
            
            //Creating the activity objects from the list of ids found, and adding them to the result list
            while(response.next()){
                Long activityId = response.getLong("activity_id");
                Activity activity = find(activityId);
                resultList.add(activity);
                
            }
        }
        catch(SQLException e){
            throw new DatabaseException(e);
        }
        return resultList;
    }
    
}
