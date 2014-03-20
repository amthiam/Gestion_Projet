
package dao.impl;

import dao.DAO;
import exceptions.DatabaseException;
import exceptions.ProjectException;
import exceptions.ResultCode;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import manager.DatabaseManager;
import model.Project;
import model.User;

/**
 * Class to insert, update, delete or find user information in the database
 * @author Felix
 */
public class UserDAO extends DAO<User> {
    
    /**
     * Constructor : initialize the dao object with the database manager
     * providing the connection to the database
     *
     * @param db : database manager
     */
    public UserDAO(DatabaseManager db) {
        super(db);
    }
    
    @Override
    public Long create(User user) throws ProjectException {

        try {

            
            db.startTransaction();


            //Check that the compulsory fields are not empty
            if (user.getName().isEmpty()) {
                throw new ProjectException(ResultCode.INVALID_OBJECT, "A user must have a name");
            }

            //Preparation of the sql query
            String sql = "INSERT INTO projectDefinition.user "
                    + "(user_name, user_password, project_idLastProject) "
                    + "VALUES (?, ?, ?)";

            //Creation of the prepared statement
            PreparedStatement stmt = db.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            stmt.setString(1, user.getName());
            stmt.setString(2, user.getPassword());
            
            //field idLastProject is optional
            if(user.isNull("idLastProject")){
                stmt.setNull(3, java.sql.Types.BIGINT);
            }
            else {
                stmt.setLong(3, user.getIdLastProject());
            }
            
            // Execution of the query
            stmt.executeUpdate();
            
            // Retrieve the id of the project just created
            ResultSet generatedKeys = stmt.getGeneratedKeys();
            if (!generatedKeys.next()) {
                throw new DatabaseException(ResultCode.DATABASE_ERROR, "The creation of the user in the database failed");
            }
            Long idUser = generatedKeys.getLong(1);
            
            db.commit();

            return idUser;
        } catch (SQLException e) {
            throw new DatabaseException(e);
        }
    }
    
    @Override
    public boolean delete(User user) {
        return false;
    }

    @Override
    public void update(User user) throws ProjectException {
        
    }

    @Override
    public User find(long id) throws DatabaseException {

        try {
            
            ResultSet response = db.executeRequest(
                    "SELECT user_name, user_password, user_idLastProject"
                    + "FROM projectDefinition.user"
                    + "WHERE user_id = " + id);
            
            String name = response.getString("user_name");
            String password = response.getString("user_password");
            Long idLastProject = response.getLong("user_idLastProject");
            
            User result = new User(id, name, password, idLastProject);
            return result;
        }
        catch(SQLException e){
            throw new DatabaseException(e);
        }
    }
    
}
