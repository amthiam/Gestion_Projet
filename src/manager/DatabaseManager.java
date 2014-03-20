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
    //boolean indicating if the connection to the database is open
    protected boolean connectionOpen;


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
            this.connectionOpen = false;
            
            // load the database driver
            Class.forName("org.h2.Driver");
        } catch (Exception e) {
            throw new DatabaseException(e);
        }

    }

    /**
     * Opens a connection to the database. Allows to make queries with parameters.
     * @return connection object 
     */
    public Connection getConnection() throws DatabaseException{
        
        try{
            if(connectionOpen = false){
        //Open a connection to the database
           this.connection = DriverManager.getConnection(url, user, passwd);
           this.connectionOpen = true;
            }
        } catch (Exception e) {
            throw new DatabaseException(e);
        }

        return connection;
    }
    
    
    /**
     * Closes the connection to the database
     *
     * @return boolean 
     */
    public void close() {
        try {
            if(connectionOpen = true){
            connection.close();
            this.connectionOpen = false;
            }
        } catch (SQLException e) {
            //The connection object failed to close the connection
            this.connectionOpen = true;
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

            //Open a connection to the database
            getConnection();
            
            // Preparation of the query
            PreparedStatement preparedRequest = connection.prepareStatement(request);

            // Exécute la requête et récupère le résultat s'il y en a un
            if (preparedRequest.execute()) {
                result = preparedRequest.getResultSet();
            }
            
            //Close the connection to the database
            close();
            
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

            //Open a connection to the database
            getConnection();
            
            // Preparation of the query
            PreparedStatement preparedStmt = connection.prepareStatement(query);

            // Execution of the query and storage of the result
            count = preparedStmt.executeUpdate();
            
            //Close the connection to the database
            close();

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
            connection.setAutoCommit(false);
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
