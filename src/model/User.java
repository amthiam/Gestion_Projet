
package model;

import exceptions.ProjectException;
import exceptions.ResultCode;

/**
 * Model class of a user of the application
 * @author Felix
 */
public class User {
    
    //ATTRIBUTES
    /* id of the user in the database */
    protected Long id;
    
    /* user name */
    protected String name;
    
    /* password of the user */
    private String password;
    
    /* id of the last project the user worked on */
    protected Long idLastProject;
    
    
    //CONSTRUCTOR
    /**
     * Constructor : generate a user knowing its name and password
     * @param name
     * @param password 
     * @param idLastProject 
     */
    public User(String name, String password, Long idLastProject) {
        this.name = name;
        this.password = password;
        this.idLastProject = idLastProject;
    }
    
    /**
     * Constructor : generate a user knowing its name and password
     * @param name
     * @param password 
     * @param idLastProject 
     */
    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }
    
    /**
     * Constructor : to generate a user knowing its id in the database
     * @param id
     * @param name
     * @param password 
     * @param idLastProject 
     */
    public User(Long id, String name, String password, Long idLastProject) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.idLastProject = idLastProject;
    }
    
    //GET METHODS
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Long getIdLastProject() {
        return idLastProject;
    }

    public String getPassword() {
        return password;
    }
    
    
    
    // SET METHODS
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setIdLastProject(Long idLastProject) {
        this.idLastProject = idLastProject;
    }
    
    
    
    //METHODS
    /**
     * Check if password given in parameter matches the stored password
     * @param password
     * @return boolean indicating if the match is positive or not
     */
    public boolean matchPassword(String password){
        return this.password.equals(password);
    }
    
    /**
     * Check if the attribute given in parameter is null
     * @param attribute : one attribute of the considered user
     * @return boolean : true if the given attribute is null
     */
    public boolean isNull(String attribute) throws ProjectException{
        
        boolean result = false;
        switch(attribute){
            case "id" : 
                if (this.id == null) {
                    result = true;
                }
            case "name" :
                if (this.name == null) {
                    result = true;
                }
                break;
            case "password" :
                if (this.password == null) {
                    result = true;
                }
                break;
            case "idLastProject" :
                if (this.idLastProject == null) {
                    result = true;
                }
                break;
                default : 
                    throw new ProjectException(ResultCode.INVALID_OBJECT, "Invalid argument for isNull method : argument must be an attribute");
        }
        
        return result;
        
    }
    
}
