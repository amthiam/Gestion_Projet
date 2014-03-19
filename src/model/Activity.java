
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

    public Activity(long id, String label, String description, BigDecimal workload, BigDecimal duration, String hypothesis, String caculationNote, GregorianCalendar constDateValue, WBSElement element, String constraintDateType, Place place) {
        this.id = id;
        this.label = label;
        this.description = description;
        this.workload = workload;
        this.duration = duration;
        this.hypothesis = hypothesis;
        this.caculationNote = caculationNote;
        this.constDateValue = constDateValue;
        this.element = element;
        this.constraintDateType = constraintDateType;
        this.place = place;
    }
    
    public Activity(){
        
    }
    
    
    
    
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

    public void setId(long id) {
        this.id = id;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setWorkload(BigDecimal workload) {
        this.workload = workload;
    }

    public void setDuration(BigDecimal duration) {
        this.duration = duration;
    }

    public void setHypothesis(String hypothesis) {
        this.hypothesis = hypothesis;
    }

    public void setCaculationNote(String caculationNote) {
        this.caculationNote = caculationNote;
    }

    public void setConstDateValue(GregorianCalendar constDateValue) {
        this.constDateValue = constDateValue;
    }

    public void setElement(WBSElement element) {
        this.element = element;
    }

    public void setConstraintDateType(String constraintDateType) {
        this.constraintDateType = constraintDateType;
    }

    public void setPlace(Place place) {
        this.place = place;
    }
    
    
    
}
