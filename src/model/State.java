
package model;

/**
 * Class representing a state. 
 * A state is the result of an Activity. Therefore a state is the predecessor of only one activity.
 * On the contrary a state may have multiple activity as predecessors.
 * @author Felix
 */
public class State {
    
    //ATTRIBUTES
    /* id of the state in the database */
    protected long id;
    
    /* label of the state */
    protected String label;
    
    /* boolean indicating if the state is a milestone */
    protected boolean isMilestone;
    
    /* work package the state belongs to */
    protected WBSElement element;
    
    /* activity generator of the considered state */
    protected Activity predecessorActivity;

    //GET METHODS
    public long getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public boolean isIsMilestone() {
        return isMilestone;
    }

    public WBSElement getElement() {
        return element;
    }

    public Activity getPredecessorActivity() {
        return predecessorActivity;
    }
    
}
