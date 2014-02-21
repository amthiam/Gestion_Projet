
package model;

/**
 * Class representing a meeting 
 * @author Felix
 */
public class Meeting {
    
    //ATTRIBUTES
    
    /* id of the meeting in the database */
    protected long id;
    
    /* short code of the meeting */
    protected String code;
    
    /* label of the meeting */
    protected String label;
    
    /* frequency of the meeting */
    protected String frequency;
    
    /* media used for the meeting : meeting, videoconference, audioconference */
    protected String media;
    
    /* place label where the meeting occurs */
    protected String place;
    
    
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

    public String getFrequency() {
        return frequency;
    }

    public String getMedia() {
        return media;
    }

    public String getPlace() {
        return place;
    }
    
    
}
