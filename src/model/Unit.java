
package model;

/**
 * Class representing an organizational unit of the projet
 * @author Felix
 */
public class Unit {
    
    //ATTRIBUTES
    /* id of the unit in the database */
    protected long id;
    
    /* short code of the unit */
    protected String code;
    
    /* name of the unit */
    protected String name;
    
    
    //GET METHODS
    public long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
    
}
