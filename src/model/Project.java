package model;

/**
 * Class project identifying the current selected project
 * Singleton class : only one project can be opened at a time
 * @author Felix
 */
public class Project {
    
    //ATTRIBUTES
    /* database id of the project */
    protected long id;
    
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
    
    /**
     * Constructor : generate an object Project from a list of value of its attributes
     * @param id : id of the project
     * @param label : label of the project
     * @param name : name of the project
     * @param description : description of the project 
     * @param customerName : name of the customer of the project
     */
    public Project(Long id, String label, String name, String description, String customerName, Long projectManagerId) {
        this.id = id;
        this.label = label;
        this.name = name;
        this.description = description;
        this.customerName = customerName;
        this.projectManagerId = projectManagerId;
    }
    
    //GET METHODS
    public long getId() {
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
}
