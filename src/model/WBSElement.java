
package model;

import java.math.BigDecimal;
import java.util.Date;



/**
 * Class representing the model of an element of the WBS
 * @author flecuyer
 */
public class WBSElement {
    
    //ATTRIBUTES
    
    /* id of the element in the database */
    protected long id;
    
    /* label of the element */
    protected String label; 
    
    /* description of the element */
    protected String description;
    
    /* boolean indicating if the element is a workpackage */
    protected boolean isWorkpackage;
    
    /* startdate of the element */
    protected Date startDate;
    
    /* workload expected for the element */
    protected BigDecimal workload;
    
    /* expected duration of the element */
    protected BigDecimal duration;
    
    /* boolean indicating if the element is contractual */
    protected boolean isContractual;
    
    /* description of the achievment criterias of the element */
    protected String achievmentCriteria;
    
    /* delivery date of the element */
    protected Date deliveryDate;
    
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
    protected Date earlyStart;
    
    /* early finish date */
    protected Date earlyFinish;
    
    /* late start date */
    protected Date lateStart;
    
    /* late finish date */
    protected Date lateFinish;
    
    /* total slack of the element */
    protected BigDecimal totalSlack;
    
    /* free slack of the element */
    protected BigDecimal freeSlack;
    
    /* id of the parent element */
    protected long idParentElement;
    
    /* rank of the element on its level */
    protected int rank;
   
    //CONSTRUCTOR
    public WBSElement(long id, String label, String description, boolean isWorkpackage, Date startDate, BigDecimal workload, BigDecimal duration, boolean isContractual, String achievmentCriteria, Date deliveryDate, BigDecimal laborAmount, BigDecimal purchaseAmount, BigDecimal expenseAmount, BigDecimal rentAmount, BigDecimal subcontractAmount, Date earlyStart, Date earlyFinish, Date lateStart, Date lateFinish, BigDecimal totalSlack, BigDecimal freeSlack, long idParentElement, int rank) {
        this.id = id;
        this.label = label;
        this.description = description;
        this.isWorkpackage = isWorkpackage;
        this.startDate = startDate;
        this.workload = workload;
        this.duration = duration;
        this.isContractual = isContractual;
        this.achievmentCriteria = achievmentCriteria;
        this.deliveryDate = deliveryDate;
        this.laborAmount = laborAmount;
        this.purchaseAmount = purchaseAmount;
        this.expenseAmount = expenseAmount;
        this.rentAmount = rentAmount;
        this.subcontractAmount = subcontractAmount;
        this.earlyStart = earlyStart;
        this.earlyFinish = earlyFinish;
        this.lateStart = lateStart;
        this.lateFinish = lateFinish;
        this.totalSlack = totalSlack;
        this.freeSlack = freeSlack;
        this.idParentElement = idParentElement;
        this.rank = rank;
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

    public boolean isIsWorkpackage() {
        return isWorkpackage;
    }

    public Date getStartDate() {
        return startDate;
    }

    public BigDecimal getWorkload() {
        return workload;
    }

    public BigDecimal getDuration() {
        return duration;
    }

    public boolean isIsContractual() {
        return isContractual;
    }

    public String getAchievmentCriteria() {
        return achievmentCriteria;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public BigDecimal getLaborAmount() {
        return laborAmount;
    }

    public BigDecimal getPurchaseAmount() {
        return purchaseAmount;
    }

    public BigDecimal getExpenseAmount() {
        return expenseAmount;
    }

    public BigDecimal getRentAmount() {
        return rentAmount;
    }

    public BigDecimal getSubcontractAmount() {
        return subcontractAmount;
    }

    public Date getEarlyStart() {
        return earlyStart;
    }

    public Date getEarlyFinish() {
        return earlyFinish;
    }

    public Date getLateStart() {
        return lateStart;
    }

    public Date getLateFinish() {
        return lateFinish;
    }

    public BigDecimal getTotalSlack() {
        return totalSlack;
    }

    public BigDecimal getFreeSlack() {
        return freeSlack;
    }

    public long getIdParentElement() {
        return idParentElement;
    }

    public int getRank() {
        return rank;
    }
    
}
