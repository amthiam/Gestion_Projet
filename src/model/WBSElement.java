
package model;

import java.math.BigDecimal;
import java.util.GregorianCalendar;


/**
 * Class representing the model of an element of the WBS
 * @author flecuyer
 */
public class WBSElement {
    
    //Attributes
    
    /* id of the project this element is related to */
    protected Project project;
    
    /* label of the element */
    protected String label; 
    
    /* description of the element */
    protected String description;
    
    /* boolean indicating if the element is a workpackage */
    protected boolean isWorkpackage;
    
    /* startdate of the element */
    protected GregorianCalendar startDate;
    
    /* workload expected for the element */
    protected BigDecimal workload;
    
    /* expected duration of the element */
    protected BigDecimal duration;
    
    /* boolean indicating if the element is contractual */
    protected boolean isContractual;
    
    /* description of the achievment criterias of the element */
    protected String achievmentCriteria;
    
    /* delivery date of the element */
    protected GregorianCalendar deliveryDate;
    
    /* expected labor amount of the element */
    protected BigDecimal laborAmount;
    
    /* expected amount of purchases for the element */
    protected BigDecimal purchaseAmount;
    
    /* expected amount for expenses */
    protected BigDecimal expenseAmount;
    
    /* expected amount for renting */
    protected BigDecimal rentAmount;
    
    /* amount for subcontractor */
    protected BigDecimal subcontractAmount;
    
    /* early start date of the element */
    protected GregorianCalendar earlyStart;
    
    /* early finish date */
    protected GregorianCalendar earlyFinish;
    
    /* late start date */
    protected GregorianCalendar lateStart;
    
    /* late finish date */
    protected GregorianCalendar lateFinish;
    
    /* total slack of the element */
    protected BigDecimal totalSlack;
    
    /* free slack of the element */
    protected BigDecimal freeSlack;
    
    /* parent element */
    protected WBSElement parentElement;
    
    /* rank of the element on its level */
    protected int rank;
   
    
}
