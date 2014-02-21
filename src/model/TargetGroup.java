
package model;

/**
 * Class representing a target group of the project
 * @author Felix
 */
public class TargetGroup {
    
    //ATTRIBUTES
    /* id of the target group in the database */
    protected long id;
    
    /* code representing the target group */
    protected String code;
    
    /* label of the target group */
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
