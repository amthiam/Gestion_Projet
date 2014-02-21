
package model;

/**
 * Class representing a document used in a project
 * @author Felix
 */
public class Document {
    
    //ATTRIBUTES
    
    /* id of the document in the database */
    protected long id;
    
    /*  short code of the document */
    protected String code;
    
    /* label of the document */
    protected String label;
    
    /* type of the record carrier : mail, intranet, paper */
    protected String recordCarrier;
    
    /* dispatching frequency of the document */
    protected String dispatchFrequency;
    
    /* name of the resource responsible  for the document */
    protected String responsibleResource;
    
    /* label of the target group concerned by the document */
    protected String targetGroup;
    
    /* name of the resource responsible for the dispatch */
    protected String dispatcher;
    
    
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

    public String getRecordCarrier() {
        return recordCarrier;
    }

    public String getDispatchFrequency() {
        return dispatchFrequency;
    }

    public String getResponsibleResource() {
        return responsibleResource;
    }

    public String getTargetGroup() {
        return targetGroup;
    }

    public String getDispatcher() {
        return dispatcher;
    }
    
    
}
