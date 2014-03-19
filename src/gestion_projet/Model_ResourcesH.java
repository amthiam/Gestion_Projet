package gestion_projet;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;
import model.HumanResource;
import model.WBSElement;
class Model_ResourcesH extends AbstractTableModel{
    
    public Model_ResourcesH(ObjetsBDD a){
        this.list = a.getRh();
        
    }

    private ArrayList<HumanResource> list;    
    

    
    public int getColumnCount() {
        return 13;
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        HumanResource r = list.get(rowIndex);
        switch (columnIndex) {
        case 0: return r.getCode(); 
       case 1: return r.getId(); //A vérifier
        case 2: return r.getInitials();
        case 3:return r.getUnit(); 
        case 4: return r.getSkill();
        case 5: return r.getCapacity();
        case 6: return r.getStandardRate();
        case 7: return r.getOvertimeRate();
        case 8: return r.getUseCost();
        case 9: return r.isIsCritical();
        case 10: return r.getAllocationMode();
        case 11: return r.getTargetGroup();
        case 12: return r.getPlace();
         
          
        }
            return null;
    }

    
}

    
    

