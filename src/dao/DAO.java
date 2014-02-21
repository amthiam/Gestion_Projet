package dao;
import java.sql.Connection;

/**
 * Generic class for finding, creating, updating or deleting an object in the database
 * Class to be implemented by each model object
 * @author Felix
 */
public abstract class DAO<T> {
    
    protected Connection connect = null;
    
    public DAO(Connection conn){
        this.connect = conn;
        }
    
    /**
     * Object creation method
     * @param obj : object to insert in the database
     * @return boolean : indicates if creation has been successful
     */
    public abstract boolean create(T obj);
    
    /**
     * Object deletion method
     * @param obj : object to be deleted from the database
     * @return boolean
     */
    public abstract boolean delete(T obj);
    
    /**
     * Object updating method
     * @param obj : object to update 
     * @return boolean 
     */
    public abstract boolean update(T obj);
    
    /**
     * Method finding the object in the database 
     * @param id : id of the object to find
     * @return object 
     */
    public abstract T find(long id);
}
