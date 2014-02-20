
package model;

/**
 * Class representing a requirement on the project
 * @author Felix
 */
public class Requirement {
    
    /* id of the requirement in the database */
    protected long id;
    
    /* short code of the requirement */
    protected String code;
    
    /* label of the requirement */
    protected String label;
    
    /* description of the acceptance criterias for the requirement */
    protected String acceptanceCriteria;
    
    /* criticity of the requirement : low, medium or high */
    protected String criticityLevel;
    
    /* hardness to satisfy the requirement : low, medium or high */
    protected String hardnessLevel;
    
    /* flexibility of the requirement */
    protected String flexibility;
    
    /* resource owner of the requirement */
    protected String owner;
    
    /* resource responsible of the requirement */
    protected String responsible;
    
    /* tracking method for the requirement */
    protected String trackingMethod;
    
    /* WBS element concerned by the requirement */
    protected WBSElement element;
    
}
