package manager;

import exceptions.DatabaseException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Class managing the connection to the database and executing the requests
 *
 * @author Felix
 */
public class DatabaseManager {
    
    //Information to connect to the database
    protected String url;
    protected String user;
    protected String passwd;
    
    //Connection to the database
    protected Connection connection;




    /**
     * Main constructor : load the database driver and stores connection information
     *
     * @throws DatabaseException
     */
    public DatabaseManager(String url, String user, String passwd) throws DatabaseException {
        try {
            
            this.url = url;
            this.user = user;
            this.passwd = passwd;
            
            // load the database driver
            Class.forName("org.h2.Driver");
          connection = DriverManager.getConnection(url, user, passwd);
        } catch (Exception e) {
            throw new DatabaseException(e);
        }

    }

    /**
     * Opens a connection to the database. Allows to make queries with parameters.
     * @return connection object 
     */
    public Connection getConnection() throws DatabaseException{

        return connection;
    }
    
    
    /**
     * Closes the connection to the database
     *
     * @return boolean 
     */
    public void close() throws DatabaseException {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new DatabaseException(e);
        }
    }

    /**
     * Execute a SQL request
     *
     * @param request to execute
     * @return result of the request or NULL if the request gives empty result
     * (or the request is empty)
     * @throws DatabaseException
     */
    public ResultSet executeRequest(String request) throws DatabaseException {

        ResultSet result = null;

        try {
            
            // Preparation of the query
            PreparedStatement preparedRequest = connection.prepareStatement(request);

            // Exécute la requête et récupère le résultat s'il y en a un
            if (preparedRequest.execute()) {
                result = preparedRequest.getResultSet();
            }
            
            
        } catch (SQLException e) {
            throw new DatabaseException(e);
        }

        return result;
    }

    /**
     * Execution of an update or insert SQL query
     *
     * @param query to execute
     * @return number of rows updated or inserted, 0 if query does not return
     * anything, -1 if the query is empty
     * @throws DatabaseException
     */
    public int executeUpdate(String query) throws DatabaseException {
        int count = -1;

        try {

            
            // Preparation of the query
            PreparedStatement preparedStmt = connection.prepareStatement(query);

            // Execution of the query and storage of the result
            count = preparedStmt.executeUpdate();

        } catch (SQLException e) {
            throw new DatabaseException(e);
        }

        return count;
    }

    /**
     * Start a transaction with the connection associated to this database
     * manager
     *
     * @throws DatabaseException
     */
    public void startTransaction() throws DatabaseException {
        try {
            
            this.connection.setAutoCommit(false);
        } catch (SQLException e) {
            throw new DatabaseException(e);
        }
    }

    /**
     * Commit a transaction associated to the connection of this database
     * manager
     *
     * @throws DatabaseException
     */
    public void commit() throws DatabaseException {
        try {
            connection.commit();
        } catch (SQLException e) {
            throw new DatabaseException(e);
        }
    }

    
    
  
}
