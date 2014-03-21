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
	
	Arbre arbre;
	int a=0;
	DefaultMutableTreeNode nodeToMove;	//utilis� pour le d�placement d'une cat�gorie

	public TreeView(DatabaseManager db, long projectId) throws ProjectException  {
		active = false;
                this.db=db;
                this.projectId=projectId;
                
                WBSElementDAO p = new WBSElementDAO(db);
                LinkedList<WBSElement> list = p.listElementOfProject(projectId);
                        
                        
                WBSElement racine=null;
                for (WBSElement e:list){
                    if (e.getIdParentElement()==null){
                        racine=e;
                    }
                    
                }
                
		this.mag=racine ;
		
		



		// ******************* Actions Listener  ****************************
		



		// *******************   Arrangement des bouttons ************************
		JPanel buttonZone = new JPanel();
		GridLayout south = new GridLayout();
		south.setColumns(3);
		south.setRows(3);
		south.setHgap(5);
		south.setVgap(5);

		
		buttonZone.setLayout(south);
		
		buttonZone.setVisible(true);


		

		// ******************  Affichage de l'arbre **************************
		arbre = new Arbre(mag, projectId,db);
                
		JScrollPane treeZone = new JScrollPane(arbre.arbre);
		arbre.arbre.addMouseListener(this);


		BorderLayout test = new BorderLayout();
		this.setLayout(test);

		this.add(treeZone, BorderLayout.NORTH);
		this.add(buttonZone, BorderLayout.SOUTH);
                this.activate();
		this.setVisible(true);
                System.out.println("TreeView lancé");


	}


	

	@Override
	public void actionPerformed(ActionEvent e) {
		DefaultMutableTreeNode selectedNode = arbre.getLastSelectedNode();
		
		if (selectedNode != null){
			

		}
	}

	

	public void updateTree() throws ProjectException {
		arbre.updateTree();
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
        
        arbre.setRoot(mag);
        this.updateTree();
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}


