
package model;

/**
 *  Abstract class representing an Activity or a State.
 * This class will be used to generate the activity and state graph
 * @author Felix
 */
public abstract class Task {
    
    //ATTRIBUTES
    /* id of the task in the database */
    protected Long id;
    
    /* id of the project the task is related to */
    protected Long idProject;
    
    /* label of the state */
    protected String label;
    
    /* work package the state belongs to */
    protected WBSElement element;
    
    
    //GET METHODS
    public abstract Long getId();
    public abstract Long getIdProject();
    public abstract String getLabel();
    public abstract WBSElement getElement();
    
}
