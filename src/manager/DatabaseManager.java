
package manager;

import exceptions.DatabaseException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Class managing the connection to the database and executing the requests
 * @author Felix
 */
public class DatabaseManager {
    
    //Connection interface to the database
    private Connection connection;
    
    /**
     * Method to connect to the database
     * @return connector to database
     * @throws DatabaseException 
     */
    private static Connection connect(String url, String user, String passwd) throws DatabaseException {

		Connection connection;
		try {

			// load the database driver
			Class.forName("org.h2.Driver");


			//Open a connection to the database
			connection = DriverManager.getConnection(url, user, passwd);

		} catch (Exception e) {
			throw new DatabaseException(e);
		}

		return connection;
	}
    
    /**
     * Main constructor : opens a connection to the database
     * @throws DatabaseException 
     */
    public DatabaseManager(String url, String user, String passwd) throws DatabaseException {
		connection = connect(url, user, passwd);
	}
    
    /**
     * Closes the connection to the database
     * @return 
     */
    public boolean close() {
		try {
			connection.close();
			return true;
		} catch (SQLException e) {
			return false;
		}
	}
    
    /**
     * Execute a SQL request 
     * @param request to execute
     * @return result of the request or NULL if the request gives empty result (or the request is empty)
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
         * @param query to execute
         * @return number of rows updated or inserted, 0 if query does not return anything, -1 if the query is empty
         * @throws DatabaseException 
         */
        	public int executeUpdate(String query) throws DatabaseException  {
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
}
