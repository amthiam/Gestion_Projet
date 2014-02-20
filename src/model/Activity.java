
package model;

import java.math.BigDecimal;
import java.util.GregorianCalendar;

/**
 * Class representing an activity of the project
 * @author Felix
 */
public class Activity {
    
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
    
}
