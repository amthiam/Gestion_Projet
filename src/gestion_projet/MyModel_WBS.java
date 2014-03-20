package gestion_projet;
import dao.impl.WBSElementDAO;
import exceptions.ProjectException;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.table.AbstractTableModel;
import manager.DatabaseManager;
import model.WBSElement;
class MyModel_WBS extends AbstractTableModel{
    
    public MyModel_WBS(long ProjectId, DatabaseManager db) throws ProjectException{
          WBSElementDAO elementDAO = new WBSElementDAO(db);
          list = elementDAO.listElementOfProject(ProjectId);
          
          System.out.println(list.size());
        
    }

    
    private LinkedList<WBSElement> list;   
    
    

    
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

    
    

