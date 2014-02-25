
package dao.impl;

import dao.DAO;
import exceptions.DatabaseException;
import exceptions.ProjectException;
import java.sql.Clob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import manager.DatabaseManager;
import model.Project;

/**
 * Class to insert, update, delete or find projet information in the database
 * @author Felix
 */
public class ProjectDAO extends DAO<Project> {
    
    /**
     * Constructor : initialize the dao object with the database manager providing the connection to the database
     * @param db : database manager
     */
    public ProjectDAO(DatabaseManager db) {
        super(db);
    }
    
    @Override
    public void create(Project project) throws DatabaseException {
        
        try{
            
            db.startTransaction();
            
            PreparedStatement stmt = db.getConnection().prepareStatement(
                    "INSERT INTO projectDefinition.project "
                    + "(project_label, project_name, project_description, customer_name, user_projectManagerId) "
                    + "VALUES (?, ?, ?, ?, ?) RETURNING project_id");
            
            stmt.setString(1, project.getLabel());
            stmt.setString(2, project.getName());
            
            Clob description = db.getConnection().createClob();
            description.setString(1, project.getDescription());
            stmt.setClob(3, description);
            
            stmt.setString(4, project.getCustomerName());
            stmt.setLong(5, project.getprojectManagerId());
            
            stmt.executeQuery();
            
            db.commit();
        }
        catch(SQLException e){
            throw new DatabaseException(e);
        }
    }
    
    @Override
    public boolean delete(Project project) {
        return false;
    }
    
    @Override
    public boolean update(Project project) {
        return false;
    }
    
    @Override
    public Project find(long id) throws DatabaseException {
        
        try{
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
            
            Project result = new Project(null, label, name, description, customer, projectManagerId);
            
            return result;
        }
        
       catch(SQLException e){
           throw new DatabaseException(e);
           
       }
    }
}
