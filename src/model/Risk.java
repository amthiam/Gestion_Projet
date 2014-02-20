
package model;

import java.math.BigDecimal;
import java.util.GregorianCalendar;

/**
 * Class representing a risk on a WBS element
 * @author Felix
 */
public class Risk {
    
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
    
}
