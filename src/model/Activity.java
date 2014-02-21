
package model;

import java.math.BigDecimal;
import java.util.GregorianCalendar;

/**
 * Class representing an activity of the project
 * @author Felix
 */
public class Activity {

    //ATTRIBUTES
    /* id of the activity in the database */
    protected long id;
    
    /* label of the activity */
    protected String label;
    
    /* description of the activity */
    protected String description;
    
    /* workload needed for the activity */
    protected BigDecimal workload;
    
    /* duration of the activity */
    protected BigDecimal duration;
    
    /* hypothesis made about the activity */
    protected String hypothesis;
    
    /* calcultation note for the activity */
    protected String caculationNote;
    
    /* value of the date constraint */
    protected GregorianCalendar constDateValue;
    
    /* WBS element to which the activity is related. 
     * This element must be a work package
     */
    protected WBSElement element;
    
    /* type of the constraint on date */
    protected String constraintDateType;
        
    /* place of the activity */
    protected Place place;
    
    
    //GET METHODS
    public long getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getWorkload() {
        return workload;
    }

    public BigDecimal getDuration() {
        return duration;
    }

    public String getHypothesis() {
        return hypothesis;
    }

    public String getCaculationNote() {
        return caculationNote;
    }

    public GregorianCalendar getConstDateValue() {
        return constDateValue;
    }

    public WBSElement getElement() {
        return element;
    }

    public String getConstraintDateType() {
        return constraintDateType;
    }

    public Place getPlace() {
        return place;
    }
    
}
