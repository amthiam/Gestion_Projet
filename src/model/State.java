
package model;

import exceptions.ProjectException;
import exceptions.ResultCode;

/**
 * Class representing a state. 
 * A state is the result of an Activity. Therefore a state is the predecessor of only one activity.
 * On the contrary a state may have multiple activity as predecessors.
 * @author Felix
 */
public class State {
    
    //ATTRIBUTES
    /* id of the state in the database */
    protected Long id;
    
    /* id of the project the state is related to */
    protected Long idProject;
    
    /* label of the state */
    protected String label;
    
    /* boolean indicating if the state is a milestone */
    protected boolean milestone;
    
    /* work package the state belongs to */
    protected WBSElement element;
    
    /* activity generator of the considered state */
    protected Activity predecessorActivity;
    
    //CONSTRUCTOR

    public State(Long id, Long idProject, String label, boolean milestone, WBSElement element, Activity predecessorActivity) {
        this.id = id;
        this.idProject = idProject;
        this.label = label;
        this.milestone = milestone;
        this.element = element;
        this.predecessorActivity = predecessorActivity;
    }
    

    //GET METHODS
    public Long getId() {
        return id;
    }

    public Long getIdProject() {
        return idProject;
    }
    
    public String getLabel() {
        return label;
    }

    public boolean isMilestone() {
        return milestone;
    }

    public WBSElement getElement() {
        return element;
    }

    public Activity getPredecessorActivity() {
        return predecessorActivity;
    }
    
    
    //SET METHODS
    public void setId(Long id){
        this.id = id;
    }
    
    //METHODS
    
    /**
     * Check if the attribute given in parameter is null
     *
     * @param attribute : one attribute of the considered user
     * @return boolean : true if the given attribute is null
     */
    public boolean isNull(String attribute) throws ProjectException {

        boolean result = false;

        switch (attribute) {
            case "id":
                if (this.id == null) {
                    result = true;
                }
                break;
            case "label":
                if (this.label == null) {
                    result = true;
                }
            break;
            case "element":
                if (this.element == null) {
                    result = true;
                }
                break;
            case "predecessorActivity":
                if (this.predecessorActivity == null) {
                    result = true;
                }
                break;
            default: 
                 throw new ProjectException(ResultCode.INVALID_OBJECT, "Invalid argument for isNull method : argument must be an attribute");
        }
        return result;
    }
}
