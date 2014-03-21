package gestion_projet;
import dao.impl.ProjectDAO;
import dao.impl.WBSElementDAO;
import exceptions.ProjectException;
import gestion_projet.Arbre;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;

import java.awt.*;
import java.util.LinkedList;

import manager.DatabaseManager;
import model.Project;
import model.WBSElement;






/*
 * Author : amadou
 * Classe permettant l'affichage de l'arbre
 * 
 * 
 */




public class TreeView extends javax.swing.JFrame implements ActionListener, MouseListener {
	
	WBSElement mag;
	boolean active;
        DatabaseManager db;
        long projectId;
        private javax.swing.JScrollPane jScrollPane1;
        private JTree tree;
        private javax.swing.JButton reload;

	public TreeView(DatabaseManager db, long projectId) throws ProjectException  {
		active = false;
                this.db=db;
                this.projectId=projectId;
                
                reload();
    
    
		

	// *******************   Arrangement des bouttons ************************
		jScrollPane1 = new javax.swing.JScrollPane(tree);
        
reload = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        

        reload.setText("Reload Tree");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(reload)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(200, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(reload)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();


		this.setVisible(true);
        }


	

	@Override
	public void actionPerformed(ActionEvent e) {
		/*DefaultMutableTreeNode selectedNode = tree.getLastSelectedNode();
		
		if (selectedNode != null){
			

		}
                        */
	}

	

	public void updateTree() throws ProjectException {
	//	arbre.updateTree();
	}

	@Override
	

	
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	
         public void activate() throws ProjectException {
        /*
        arbre.setRoot(mag);
        this.updateTree();
        */
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void createNodes(DefaultMutableTreeNode top, WBSElement racine) throws ProjectException {
              
                WBSElementDAO elementDAO = new WBSElementDAO(db);
                LinkedList<WBSElement> list = elementDAO.listElementOfProject(projectId);
       
                for (WBSElement e : list){
                    if (racine.getId()==e.getIdParentElement()){
                        DefaultMutableTreeNode fils = new DefaultMutableTreeNode(e);
                        createNodes(fils,e);
                        top.add(fils);
                    }
                }
                
                
                
                
        }
    
    private void reload() throws ProjectException{
        
        WBSElementDAO p = new WBSElementDAO(db);
                LinkedList<WBSElement> list = p.listElementOfProject(projectId);
                        
                
                        
                WBSElement mag=null;
                for (WBSElement e:list){
                      if (e.getIdParentElement()==0){
                        System.out.println("Trouvé");
                        mag=e;
                    }
                    
                }
                System.out.println(list.size());
                
		DefaultMutableTreeNode top = new DefaultMutableTreeNode(mag);
            createNodes(top,mag);
         tree = new JTree(top);
    
}
    
    private void reloadActionPerformed(java.awt.event.ActionEvent evt) throws ProjectException {                                       
        reload();
    }   
    }
    
    



