
package model;

import java.math.BigDecimal;

/**
 * Class representing a human resource of the project
 * @author Felix
 */
public class HumanResource {
    
    /* id of the human resource in the database */
    protected long id;
    
    /* profile code of the resource */
    protected String code;
    
    /* profile name of the resource */
    protected String name;
    
    /* initials of the profile */
    protected String initials;
    
    /* capacity of the resource */
    protected BigDecimal capacity;
    
    /* standard rate of the resource */
    protected BigDecimal standardRate;
    
    /* overtime rate of the resource */
    protected BigDecimal overtimeRate;
    
    /* use cost of the resource */
    protected BigDecimal useCost;
    
    /* boolean indicating if the resource is critical */
    protected boolean isCritical;
    
    /* minimum skill of the resource needed : expert, confirmed.. */
    protected String skill;
    
    /* allocation mode of the resource : proportion, start, finish. */
    protected String allocationMode;
    
    /* label of  target group which the resource belongs to */
    protected String targetGroup;
    
    /* name of the unit the resource belongs to */
    protected String unit;
    
    /* name of the place of the resource */
    protected String place;
    
    
    
}
