
package model;

/**
 * Class representing a place
 * @author Felix
 */
public class Place {
    
    //ATTRIBUTES
    /* id of the place in the database */
    protected long id;
    
    /* short code of the place */
    protected String code;
    
    /* label of the place */
    protected String label;
    
    
    //GET METHODS
    public long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getLabel() {
        return label;
    }
    
}
