
package model;

import java.math.BigDecimal;
import java.util.GregorianCalendar;

/**
 * Class representing a risk on a WBS element
 * @author Felix
 */
public class Risk {
    
    //ATTRIBUTES
    /* id of the risk in the database */
    protected long id;
    
    /* label of the risk */
    protected String label;
    
    /* description of the risk */
    protected String description;
    
    /* event that triggers the risk */
    protected String triggerEvent;
    
    /* probability of occurence of the risk : int varying between 1 and 9 */
    protected int probability;
    
    /* impact of the risk on the project : int value varying from 1 to 9 */
    protected int impact;
    
    /* difficulty of detection of the risk : int value varying from 1 to 9 */
    protected int detectionDifficulty;
    
    /* outcome of the risk */
    protected String outcome;
    
    /* economic stakes */
    protected BigDecimal financial;
    
    /* provision to be made to cover the risk */
    protected BigDecimal provision;
    
    /* processing modality */
    protected String modality;
    
    /* horizon of occurence */
    protected GregorianCalendar horizon;
    
    /* label of the WBS element concerned by the risk */
    protected String elementLabel;
    
    /* response strategy */
    protected String responseStrategy;
    
    /* name of the resource responsible for the detection of the risk */
    protected String detectionResponsible;
    
    /* name of the resource responsible for resolving */
    protected String resolvingResponsible;
    
    /* nature of the risk : technical, calendar, budget, financial */
    protected String riskNature;

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

    public String getTriggerEvent() {
        return triggerEvent;
    }

    public int getProbability() {
        return probability;
    }

    public int getImpact() {
        return impact;
    }

    public int getDetectionDifficulty() {
        return detectionDifficulty;
    }

    public String getOutcome() {
        return outcome;
    }

    public BigDecimal getFinancial() {
        return financial;
    }

    public BigDecimal getProvision() {
        return provision;
    }

    public String getModality() {
        return modality;
    }

    public GregorianCalendar getHorizon() {
        return horizon;
    }

    public String getElementLabel() {
        return elementLabel;
    }

    public String getResponseStrategy() {
        return responseStrategy;
    }

    public String getDetectionResponsible() {
        return detectionResponsible;
    }

    public String getResolvingResponsible() {
        return resolvingResponsible;
    }

    public String getRiskNature() {
        return riskNature;
    }
    
}
