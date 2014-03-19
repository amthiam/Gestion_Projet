
package model;

import exceptions.ProjectException;
import exceptions.ResultCode;
import java.math.BigDecimal;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedList;

/**
 * Class representing an activity of the project
 * @author Felix
 */
public class Activity extends Task {

    //ATTRIBUTES
    /* id of the activity in the database */
    protected Long id;
    
    /* id of the project the activity is associated to */
    protected Long idProject;
    
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
    protected String calculationNote;
    
    /* value of the date constraint */
    protected Date constDateValue;
    
    /* WBS element to which the activity is related. 
     * This element must be a work package
     */
    protected WBSElement element;
    
    /* type of the constraint on date */
    protected String constraintDateType;
        
    /* place of the activity */
    protected Place place;

    public Activity(long id, String label, String description, BigDecimal workload, BigDecimal duration, String hypothesis, String calculationNote, Date constDateValue, WBSElement element, String constraintDateType, Place place) {
        this.id = id;
        this.label = label;
        this.description = description;
        this.workload = workload;
        this.duration = duration;
        this.hypothesis = hypothesis;
        this.calculationNote = calculationNote;
        this.constDateValue = constDateValue;
        this.element = element;
        this.constraintDateType = constraintDateType;
        this.place = place;
    }
    
    
    
    /* List of states preceding the activity */
    protected LinkedList<State> listOfStatePredecessors;
    
    
    //CONSTRUCTOR
    public Activity(Long id, Long idProject, String label, String description, BigDecimal workload, BigDecimal duration, String hypothesis, String calculationNote, Date constDateValue, WBSElement element, String constraintDateType, Place place, LinkedList<State> listOfStatePredecessors) {
        this.id = id;
        this.idProject = idProject;
        this.label = label;
        this.description = description;
        this.workload = workload;
        this.duration = duration;
        this.hypothesis = hypothesis;
        this.calculationNote = calculationNote;
        this.constDateValue = constDateValue;
        this.element = element;
        this.constraintDateType = constraintDateType;
        this.place = place;
        this.listOfStatePredecessors = listOfStatePredecessors;
    }
    
    
    //GET METHODS
    public Long getId() {
        return id;
    }
    
    public Long getIdProject() {
        return idProject;
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

    public String getCalculationNote() {
        return calculationNote;
    }

    public Date getConstDateValue() {
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
    
    public LinkedList<State> getListOfStatePredecessors(){
        return listOfStatePredecessors;
    }
    
    
    //SET METHODS
    public void setId(Long id) {
        this.id = id;
    }
    
    
    
    
    //METHODS
    /**
     * Check if the attribute given in parameter is null
     *
     * @param attribute : one attribute of the considered user
     * @return boolean : true if the given attribute is null
     */
    public boolean isNull(String attribute) throws ProjectException {

        boolean result = false;

        switch (attribute) {
            case "id":
                if (this.id == null) {
                    result = true;
                }
                break;
            case "idProject":
                if (this.idProject == null) {
                    result = true;
                }
                break;
            case "label":
                if (this.label == null) {
                    result = true;
                }
                break;
            case "description":
                if (this.description == null) {
                    result = true;
                }
                break;
            case "workload":
                if (this.workload == null) {
                    result = true;
                }
                break;
                case "duration":
                if (this.duration == null) {
                    result = true;
                }
                break;
                    case "hypothesis":
                if (this.hypothesis == null) {
                    result = true;
                }
                break;
                        case "calculationNote":
                if (this.calculationNote == null) {
                    result = true;
                }
                break;
                            case "constDateValue":
                if (this.constDateValue == null) {
                    result = true;
                }
                break;
                                      case "element":
                if (this.element == null) {
                    result = true;
                }
                break;
                                                case "constraintDateType":
                if (this.constraintDateType == null) {
                    result = true;
                }
                break;
                              case "place":
                if (this.place == null) {
                    result = true;
                }
                break;
                              case "listOfStatePredecessors":
                                  if (this.listOfStatePredecessors == null){
                                      result = true;
                                  }
                                  break;
                                  default : 
                    throw new ProjectException(ResultCode.INVALID_OBJECT, "Invalid argument for isNull method : argument must be an attribute");
        }
        return result;
    }
}
