
package manager;

import dao.impl.ActivityDAO;
import dao.impl.StateDAO;
import dao.impl.WBSElementDAO;
import exceptions.ProjectException;
import exceptions.ResultCode;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import model.Activity;
import model.State;
import model.Task;
import model.WBSElement;

/**
 *
 * @author Felix
 */
public class GraphManager {
    
    protected DatabaseManager db;
    protected Long projectId;
    
    public GraphManager(DatabaseManager db, Long projectId) {
        this.db = db;
        this.projectId = projectId;
    }
    
   
     
    /**
     * Method to generate the graphviz code of an element an its sons. To be called recursively by the main graph method
     * @param element : WBS element to plot
     * @param out : writer ti write in the result file
     * @param clusterNumber : the name of the cluster
     */
    private void writeCluster(WBSElement element, FileWriter out, int clusterNumber) throws ProjectException {
        
        //If the element is a workpackage, we have to print the graph of activities and states
        //If the element is the parent of another element, we need to call this method again on this element
        try{
            
            
            
        if(element.isIsWorkpackage()){
            
            // We draw the cluster
            out.write("subgraph cluster_"+clusterNumber+" {\n"
                    + "label=\""+element.getLabel()+"\";labeljust=l;\n");
            

            
            //We list the activities and states linked to this element
            ActivityDAO activityDAO = new ActivityDAO(db);
            StateDAO stateDAO = new StateDAO(db);
            LinkedList<Activity> activityList = activityDAO.listActivitiesOfElement(element.getId());
            LinkedList<State> stateList = stateDAO.listStatesOfElement(element.getId());
            
            LinkedList<Task> taskList = new LinkedList();
        
        taskList.addAll(activityList);
        taskList.addAll(stateList);
        
        
             for (Activity activity : activityList) {
                LinkedList<State> listOfStatePredecessors = activity.getListOfStatePredecessors();
                if (listOfStatePredecessors.size()>0) {
                    for (State pred : listOfStatePredecessors) {
                        out.write(" \"" + pred.getLabel() + "\" -> \"" + activity.getLabel()+ "\";\n");
                    }
                }
            }
            
            for (State state : stateList) {
                if (state.getPredecessorActivity() != null) {
                    out.write(" \"" + state.getPredecessorActivity().getLabel() + "\" -> \"" + state.getLabel() + "\";\n");
                }
            }
            out.write("}\n");
        }
        //If the element is not a workpackage
        //We need to find in the list of elements of the project the elements that have the given element as a parent
        else{
            
            // We draw the cluster
            out.write("subgraph cluster_"+clusterNumber+" {\n"
                    + "label=\""+element.getLabel()+"\";labeljust=l;\n");
            
            
            // We find the children
            WBSElementDAO elementDAO = new WBSElementDAO(db);
            LinkedList<WBSElement> elementList = elementDAO.listElementOfProject(projectId);
            
            LinkedList<WBSElement> childrenList = new LinkedList();
            //List containing all children element
            for(WBSElement checkElement : elementList){
                //We check if the element is a children of our given element
                if((long)checkElement.getIdParentElement()==(long)element.getId()){
                    childrenList.add(checkElement);
                }
            }
            
            
            clusterNumber = clusterNumber * 10;
            //We apply the same method to all the children
            for(WBSElement childElement : childrenList){
                clusterNumber = clusterNumber +1;
                writeCluster(childElement, out, clusterNumber );
            }
            out.write("}\n");
        }
        
        }
            catch(IOException e){
        throw new ProjectException(ResultCode.WRITING_ERROR);
    }
        
    }
    
    
    public void writeStateActivityClusters(Long idProject, String fileName) throws ProjectException {
        
        try {
        //Creation of the list containing all WBS Element
        WBSElementDAO elementDAO = new WBSElementDAO(db);
        LinkedList<WBSElement> elementList = elementDAO.listElementOfProject(idProject);
        
        //Finding the root of the WBS
        WBSElement rootElement = null;
        for (WBSElement element : elementList) {
            
            if (element.getIdParentElement() == 0){
                rootElement = element;
                System.out.println("Root element trouvé");
            }
        }
        
        //Initialization of the graph
        File file = new File(fileName);
        FileWriter out = new FileWriter(file);
            out.write("digraph G {\n");
            out.write("rankdir=LR;\n" +
" labeljust=c;labelloc=t;fontname=helvetica;fontsize=14;compound=true;\n" +
" node[style=filled,shape=box,fontname=helvetica,fontsize=16,fillcolor=\"#E9FECE\"];\n");
            
            //Writing the clusters and activities and states thanks to recursive method writeCluster
            writeCluster(rootElement, out, 1);
            
            //Closing the writer
            out.write("}");
            out.close();
    }
        catch(IOException e){
        throw new ProjectException(ResultCode.WRITING_ERROR);
    }
        
    }
}
