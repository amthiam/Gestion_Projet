
package model;

import java.math.BigDecimal;

/**
 * Class representing a human resource of the project
 * @author Felix
 */
public class HumanResource {
    
    //ATTRIBUTES
    
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
    
    
    //GET METHODS
    public long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getInitials() {
        return initials;
    }

    public BigDecimal getCapacity() {
        return capacity;
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

    public String getSkill() {
        return skill;
    }

    public String getAllocationMode() {
        return allocationMode;
    }

    public String getTargetGroup() {
        return targetGroup;
    }

    public String getUnit() {
        return unit;
    }

    public String getPlace() {
        return place;
    }

    public HumanResource(long id, String code, String name, String initials, BigDecimal capacity, BigDecimal standardRate, BigDecimal overtimeRate, BigDecimal useCost, boolean isCritical, String skill, String allocationMode, String targetGroup, String unit, String place) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.initials = initials;
        this.capacity = capacity;
        this.standardRate = standardRate;
        this.overtimeRate = overtimeRate;
        this.useCost = useCost;
        this.isCritical = isCritical;
        this.skill = skill;
        this.allocationMode = allocationMode;
        this.targetGroup = targetGroup;
        this.unit = unit;
        this.place = place;
    }
    
    
}
