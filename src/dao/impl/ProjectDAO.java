package dao.impl;

import dao.DAO;
import exceptions.DatabaseException;
import exceptions.ProjectException;
import exceptions.ResultCode;
import java.sql.Clob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import manager.DatabaseManager;
import model.Project;


/**
 * Class to insert, update, delete or find projet information in the database
 *
 * @author Felix
 */
public class ProjectDAO extends DAO<Project> {

    /**
     * Constructor : initialize the dao object with the database manager
     * providing the connection to the database
     *
     * @param db : database manager
     */
    public ProjectDAO(DatabaseManager db) {
        super(db);
    }

    @Override
    public Long create(Project project) throws ProjectException {

        try {

            db.getConnection();
            
            db.startTransaction();


            //Check that the compulsory fields are not empty
            if (project.getLabel().isEmpty()) {
                throw new ProjectException(ResultCode.INVALID_OBJECT, "A project must have a label");
            }

            //Preparation of the sql query
            String sql = "INSERT INTO projectDefinition.project "
                    + "(project_label, project_name, project_description, customer_name, user_projectManagerId) "
                    + "VALUES (?, ?, ?, ?, ?)";

            //Creation of the prepared statement
            PreparedStatement stmt = db.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            stmt.setString(1, project.getLabel());

            // Field name is optional
            if (project.isNull("name")) {
                stmt.setNull(2, java.sql.Types.VARCHAR);
            } else {
                stmt.setString(2, project.getName());
            }

            // Field description is optional
            if (project.isNull("description")) {
                stmt.setNull(3, java.sql.Types.CLOB);
            } else {
                Clob description = db.getConnection().createClob();
                description.setString(1, project.getDescription());
                stmt.setClob(3, description);
            }

            //Field CustomerName is optional
            if (project.isNull("customerName")) {
                stmt.setNull(4, java.sql.Types.VARCHAR);
            } else {
                stmt.setString(4, project.getCustomerName());
            }

            stmt.setLong(5, project.getprojectManagerId());


            // Execution of the query
            stmt.executeUpdate();

            // Retrieve the id of the project just created
            ResultSet generatedKeys = stmt.getGeneratedKeys();
            if (!generatedKeys.next()) {
                throw new DatabaseException(ResultCode.DATABASE_ERROR, "The creation of the project in the database failed");
            }
            Long idProject = generatedKeys.getLong(1);

            db.commit();
            
            return idProject;
        } catch (SQLException e) {
            throw new DatabaseException(e);
        }
    }

    @Override
    public boolean delete(Project project) {
        return false;
    }

    @Override
    public void update(Project project) throws ProjectException {
        
        try{
            
            db.startTransaction();


            //Check that the compulsory fields are not empty
            if (project.getLabel().isEmpty()) {
                throw new ProjectException(ResultCode.INVALID_OBJECT, "A project must have a label");
            }
            
            //Check if the information of the id of the object in the database is available
            if (project.isNull("id")){
                throw new ProjectException(ResultCode.INVALID_OBJECT, "The id of the project must be known to update the element");
            }

            //Preparation of the sql query
            String sql = "UPDATE projectDefinition.project "
                    + "SET project_label = ?, "
                    + "project_name = ?, "
                    + "project_description = ?, "
                    + "customer_name = ?, "
                    + "user_projectManagerId = ? "
                    + "WHERE project_id = " + project.getId();

            //Creation of the prepared statement
            PreparedStatement stmt = db.getConnection().prepareStatement(sql);

            stmt.setString(1, project.getLabel());

            // Field name is optional
            if (project.isNull("name")) {
                stmt.setNull(2, java.sql.Types.VARCHAR);
            } else {
                stmt.setString(2, project.getName());
            }

            // Field description is optional
            if (project.isNull("description")) {
                stmt.setNull(3, java.sql.Types.CLOB);
            } else {
                Clob description = db.getConnection().createClob();
                description.setString(1, project.getDescription());
                stmt.setClob(3, description);
            }

            //Field CustomerName is optional
            if (project.isNull("customerName")) {
                stmt.setNull(4, java.sql.Types.VARCHAR);
            } else {
                stmt.setString(4, project.getCustomerName());
            }

            stmt.setLong(5, project.getprojectManagerId());


            // Execution of the query
            stmt.executeUpdate();

            db.commit();
            
        } catch (SQLException e) {
            throw new DatabaseException(e);
        }
        
        }


    @Override
    public Project find(long id) throws ProjectException {

        try {
            
            ResultSet response = db.executeRequest(
                    "SELECT project_label, project_name, project_descrption, customer_name, user_projectManagerId "
                    + "FROM projectDefinition.project "
                    + "WHERE project_id = " + id);

            String label = response.getString("project_label");
            String name = response.getString("project_name");
            Clob descriptionClob = response.getClob("project_description");
            String customer = response.getString("customer_name");
            Long projectManagerId = response.getLong("user_projcetManagerId");

            String description = descriptionClob.getSubString(1, (int) descriptionClob.length());

            Project result = new Project(id, label, name, description, customer, projectManagerId);
            
            return result;
        } catch (SQLException e) {
            throw new DatabaseException(e);
        }
   
    }
    
    public LinkedList<Project> listOfProjects() throws ProjectException{
        
        LinkedList<Project> resultList = new LinkedList();
        
        //Query into the database to return the list of ids of projects.
        try{
            
            ResultSet response = db.executeRequest(
                    "SELECT project_id FROM projectDefinition.project ");
            
            //Creating the state objects from the list of ids found, and adding them to the result list

            while(response.next()){
                Long projectId = response.getLong("project_id");
                Project project = find(projectId);
                resultList.add(project);
            }
            
                    return resultList;
        }
        catch(SQLException e){
            throw new DatabaseException(e);
        }
    }
    
    public LinkedList<String> listOfProjectId() throws ProjectException{
        
        LinkedList<String> resultList = new LinkedList();
        
        //Query into the database to return the list of ids of projects.
        try{
            
            ResultSet response = db.executeRequest(
                    "SELECT project_id FROM projectDefinition.project ");
            
            //Creating the state objects from the list of ids found, and adding them to the result list

            while(response.next()){
                 resultList.add(String.valueOf(response.getLong("project_id")));
            }
            
                    return resultList;
        }
        catch(SQLException e){
            throw new DatabaseException(e);
        }
    }
}
