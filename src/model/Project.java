package model;

/**
 * Class project identifying the current selected project
 * Singleton class : only one project can be opened at a time
 * @author Felix
 */
public class Project {
    
    //ATTRIBUTES
    /* database id of the project */
    protected long id;
    
    /* label of the project */
    protected String label;
    
    //GET METHODS
    public long getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }
    
}
