package gestion_projet;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;
import model.WBSElement;
class MyModel extends AbstractTableModel{
    
    public MyModel(){
                
    }

    private ArrayList<WBSElement> list;    
    

    
    public int getColumnCount() {
        return 6;
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        WBSElement r = list.get(rowIndex);
        switch (columnIndex) {
        case 0: return r.getId(); 
        case 1: return r.getLabel();
       // case 2: return r.getWorkpackage;// A compléter après, récupérer le WP 
        case 3:return r.getSubcontractAmount(); //A revérifier
        case 4: return r.getEarlyStart(); //A vérifier aussi
        case 5: return r.getDeliveryDate();
          
        }
            return null;
    }

    
}

    
    

