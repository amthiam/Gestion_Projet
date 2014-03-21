package gestion_projet;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;
import model.Activity;
import model.WBSElement;
import dao.impl.WBSElementDAO;
class MyModelActivity extends AbstractTableModel{
    
    public MyModelActivity(Long projectId){
       // this.list = a.getActivites();
        
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
        
           
        }
            return null;
    }

    
}

    
    

