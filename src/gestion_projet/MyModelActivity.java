package gestion_projet;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;
import model.Activity;
import model.WBSElement;
class MyModelActivity extends AbstractTableModel{
    
    public MyModelActivity(ObjetsBDD a){
        this.list = a.getActivites();
        
    }

    private ArrayList<Activity> list;    
    

    
    public int getColumnCount() {
        return 8;
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Activity r = list.get(rowIndex);
        switch (columnIndex) {
        case 0: return r.getLabel(); 
        //case 1: return r.get(); //A compléter après, demander à Félix comment récupérer States at the origin of the activity
        case 2: return r.getWorkload();
        case 3:return r.getConstraintDateType(); //A revérifier
        case 4:return r.getDuration();
        //case 5: return r.get(); //A compléter après, demander à Félix comment récupérer Imposed Date
        case 6: return r.getPlace();
        case 7: //A compléter après, je ne sais pas comment retourner une case à cocher. Demander de l'aide à Mr J Y Martin.
          
        }
            return null;
    }

    
}

    
    

