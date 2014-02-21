
package model;

import java.math.BigDecimal;

/**
 * Class representing a material resource of the project 
 * @author Felix
 */
public class MaterialResource {
    
    //ATTRIBUTES
    
    /* id of the material resource in the database */
    protected long id;
    
    /* short code designating the resource */
    protected String code;
    
    /* label of the material resource */
    protected String label;
    
    /* description of the material resource */
    protected String description;
    
    /* initials of the resource */
    protected String initials;
    
    /* standard rate of the resource */
    protected BigDecimal standardRate;
    
    /* overtime rate of the resource */
    protected BigDecimal overtimeRate;
    
    /* use cost of the resource */
    protected BigDecimal useCost;
    
    /* boolean indicating if the resource is critical */
    protected boolean isCritical;
    
    /* capacity (in %) of the resource */
    protected BigDecimal capacity;
    
    /*label of the place where the resource belongs */
    protected String place;
    
    /* name of the unit the resource belongs to */
    protected String unit;
    
    /* allocation mode of the resource : proportion, start or end */
    protected String allocationMode;
    
    /* type of the resource : labor, equipment or cost */
    protected String resourceType;
    
    
    //GET METHODS
    public long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getLabel() {
        return label;
    }

    public String getDescription() {
        return description;
    }

    public String getInitials() {
        return initials;
    }

    public BigDecimal getStandardRate() {
        return standardRate;
    }

    public BigDecimal getOvertimeRate() {
        return overtimeRate;
    }

    public BigDecimal getUseCost() {
        return useCost;
    }

    public boolean isIsCritical() {
        return isCritical;
    }

    public BigDecimal getCapacity() {
        return capacity;
    }

    public String getPlace() {
        return place;
    }

    public String getUnit() {
        return unit;
    }

    public String getAllocationMode() {
        return allocationMode;
    }

    public String getResourceType() {
        return resourceType;
    }
    
    
}
