
package dao.impl;

import dao.DAO;
import exceptions.DatabaseException;
import exceptions.ProjectException;
import exceptions.ResultCode;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import manager.DatabaseManager;
import model.Activity;
import model.State;
import model.WBSElement;

/**
 * Implementation of the abstract DAO class Class used to create, update, find
 * and delete information about activities in the database
 * @author Felix
 */
public class StateDAO extends DAO<State> {

/**
     * Constructor
     *
     * @param db : database manager providing a connection to the database
     */
    public StateDAO(DatabaseManager db) {
        super(db);
    }
    
    @Override
    public Long create(State state) throws ProjectException {
        
        // The fields project_id and state_label are compulsory in the database
        if (state.getLabel().isEmpty()) {
            throw new ProjectException(ResultCode.INVALID_OBJECT, "A state must have a label");
        }
        if (state.getIdProject() == null) {
            throw new ProjectException(ResultCode.INVALID_OBJECT, "A state must belong to a project");
        }

        //Insertion in the database
        try {

            db.startTransaction();

            // SQL query
            String sql = "INSERT INTO projectDefinition.state "
                    + "(project_id, state_label, state_isMilestone, element_id, "
                    + "activity_idActivityPredecessorToState) "
                    + "VALUES (?,?,?,?,?)";

            //Creation of the sql statement
            PreparedStatement stmt = db.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            stmt.setLong(1, state.getIdProject());
            stmt.setString(2, state.getLabel());
            stmt.setBoolean(3, state.isMilestone());
            
            // Field element_id is optional
            if (state.isNull("element")) {
                stmt.setNull(4, java.sql.Types.BIGINT);
            } else {
                stmt.setLong(4, state.getElement().getId());
            }
            
            // Field activity_idActivityPredecessorToState is optional
            if (state.isNull("predecessorActivity")) {
                stmt.setNull(5, java.sql.Types.BIGINT);
            } else {
                stmt.setLong(5, state.getPredecessorActivity().getId());
            }
            
            //Execution of the query
            stmt.executeUpdate();

            // Retrieve the id of the element just created
            ResultSet generatedKeys = stmt.getGeneratedKeys();
            if (!generatedKeys.next()) {
                throw new DatabaseException(ResultCode.DATABASE_ERROR, "The creation of the activity in the database failed");
            }
            Long idState = generatedKeys.getLong(1);

  
  db.commit();

            return idState;
        }
        catch(SQLException e){
    throw new DatabaseException(e);            
        }
    }

    @Override
    public boolean delete(State obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(State obj) throws ProjectException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public State find(long id) throws ProjectException {
        
        try {

            ResultSet response = db.executeRequest(
                    "SELECT state_id, project_id, state_label, state_isMilestone, "
                    + "element_id, activity_idActivityPredecessorToState "
                    + "FROM projectDefinition.state "
                    + "WHERE state_id = " + id);
            
            if (!response.next()) {
                throw new DatabaseException(ResultCode.DATABASE_ERROR, "Object not found");
            }

            Long idState = response.getLong("state_id");
            Long idProject = response.getLong("project_id");
            String label = response.getString("state_label");
            boolean milestone = response.getBoolean("state_isMilestone");
            Long idElement = response.getLong("element_id");
            Long idPredecessorActivity = response.getLong("activity_idActivityPredecessorToState");
            
            //Creation of the WBSElement and Activity objects
            WBSElementDAO elementDAO = new WBSElementDAO(db);
            ActivityDAO activityDAO = new ActivityDAO(db);
            WBSElement element = null;
            if (idElement != 0) {
                element = elementDAO.find(idElement);
            }
            Activity predecessorActivity = null;
            if (idPredecessorActivity != 0) {
                predecessorActivity = activityDAO.find(idPredecessorActivity);
            }
            
            //Creation of the resulting state object
            State result = new State(id, idProject, label, milestone, element, predecessorActivity);
            
            return result;
            
        } catch (SQLException e) {
            throw new DatabaseException(e);    
    }
        
    
    }
    
    
    
    /**
     * Method returning the list of states stored in the database concerning a given project
     * @param projectId : id of the project 
     * @return the list of states 
     */
    public LinkedList<State> listStatesOfProject(long projectId) throws ProjectException{
        
        LinkedList<State> resultList = new LinkedList();
        
        //Query into the database to return the list of ids of states.
        try{
            
            ResultSet response = db.executeRequest(
                    "SELECT state_id FROM projectDefinition.state WHERE project_id = " + projectId);
            
            //Creating the state objects from the list of ids found, and adding them to the result list
            while(response.next()){
                Long stateId = response.getLong("state_id");
                State state = find(stateId);
                resultList.add(state);
                
            }
        }
        catch(SQLException e){
            throw new DatabaseException(e);
        }
        return resultList;
    }
    
}
