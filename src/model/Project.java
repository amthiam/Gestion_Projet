package model;

import exceptions.ProjectException;
import exceptions.ResultCode;

/**
 * Class project identifying the current selected project
 * Singleton class : only one project can be opened at a time
 * @author Felix
 */
public class Project {
    
    //ATTRIBUTES
    /* database id of the project */
    protected Long id;
    
    /* label of the project */
    protected String label;
    
    /* name of the project */
    protected String name;
    
    /* description of the project */
    protected String description;
    
    /* name of the customer of the project */
    protected String customerName;
    
    /* id of the projectManager */
    protected Long projectManagerId;
    
    //CONSTRUCTORS
    
    /**
     * Constructor : generate an object Project from a list of value of its attributes
     * @param id : id of the project
     * @param label : label of the project
     * @param name : name of the project
     * @param description : description of the project 
     * @param customerName : name of the customer of the project
     * @param projectManagerId : id in the database of the manager of the project
     */
    public Project(Long id, String label, String name, String description, String customerName, Long projectManagerId) {
        this.id = id;
        this.label = label;
        this.name = name;
        this.description = description;
        this.customerName = customerName;
        this.projectManagerId = projectManagerId;
    }
    
    /**
     * Constructor : generate a Project object from a list of value
     * Does not indicate the value of the id of the project in the database
     * @param label : label of the project
     * @param name : name of the project
     * @param description : description of the project 
     * @param customerName : name of the customer of the project
     * @param projectManagerId : id in the database of the manager of the project
     */
    public Project(String label, String name, String description, String customerName, Long projectManagerId) {
        this.label = label;
        this.name = name;
        this.description = description;
        this.customerName = customerName;
        this.projectManagerId = projectManagerId;
    }
    
 
    //GET METHODS
    public Long getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }
    
    public String getName() {
        return name;
    }
    
    public String getDescription() {
        return description;
    }
    
    public String getCustomerName() {
        return customerName;
    }
    
    public Long getprojectManagerId() {
        return projectManagerId;
    }
    
    //SET METHODS
    public void setId(Long id) {
        this.id = id;
    }
    
    
    //METHODS
     /**
     * Check if the attribute given in parameter is null
     * @param attribute : one attribute of the considered user
     * @return boolean : true if the given attribute is null
     */
    public boolean isNull(String attribute) throws ProjectException{
        
        boolean result = false;
        switch(attribute){
            case "id" :
                if(this.id == null) {
                    result = true;
                }
                break;
            case "label" :
                if (this.label == null) {
                    result = true;
                }
                break;
            case "name" :
                if (this.name == null) {
                    result = true;
                }
                break;
            case "description" :
                if (this.description == null) {
                    result = true;
                }
                break;
            case "customerName" :
                if (this.customerName == null) {
                    result = true;
                }
                break;
            case "projectManagerId" :
                if (this.projectManagerId == null) {
                    result = true;
                }
                break;
                default : 
                    throw new ProjectException(ResultCode.INVALID_OBJECT, "Invalid argument for isNull method : argument must be an attribute");
        }
        
        return result;
        
    }
   
}
