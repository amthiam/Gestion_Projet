/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gestion_projet;

import dao.impl.WBSElementDAO;
import exceptions.ProjectException;
import java.util.LinkedList;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import manager.DatabaseManager;
import model.WBSElement;

/**
 *
 * @author amadou
 */
public class Arbre extends JTree{
        /**
         * @param args
         */
        protected JTree arbre;
        protected DefaultTreeModel treeModel;
        protected DefaultMutableTreeNode node;
        protected WBSElement root;
        protected long projectId;
        protected DatabaseManager db;

        // *********** Constructeur *********************
        public Arbre(WBSElement root, long ProjectId, DatabaseManager db) throws ProjectException{
                this.db=db;
                this.projectId=projectId;
                this.root = root;
                node = buildTree(root);
                treeModel = new DefaultTreeModel(node);
                arbre = new JTree(treeModel);
                arbre.setEditable(false);
        }


        // **************** Methodes ********************
        /*
         * Methode permettant de creer un arbre
         * Methode recursive
         * Parametre en entree : category
         */
        private DefaultMutableTreeNode buildTree(WBSElement cat) throws ProjectException{
                //Création d'une racine initiale
                DefaultMutableTreeNode racine = new DefaultMutableTreeNode(cat);
                //Récupération des fils.
                WBSElementDAO elementDAO = new WBSElementDAO(db);
                LinkedList<WBSElement> list = elementDAO.listElementOfProject(projectId);
       
                for (WBSElement e : list){
                    if (e.getIdParentElement()==cat.getId()){
                        racine.add(buildTree(e));
                    }
                }
                
                return racine;
                
                
        }
        
        public DefaultMutableTreeNode getLastSelectedNode(){
                return (DefaultMutableTreeNode) arbre.getLastSelectedPathComponent();
        }



        
        
        
        public DefaultMutableTreeNode findNode(WBSElement cat){

                DefaultMutableTreeNode del = new DefaultMutableTreeNode();
                return del;
                /*
                 * a completer
                 */
        }
        
        public void updateTree() throws ProjectException{
                node = buildTree(root);
                treeModel.setRoot(node);
                treeModel.reload();
        }

        public void setRoot(WBSElement c){
            root = c;
        }


        public static void main(String[] args) {
                // TODO Auto-generated method stub
                //Category magasin = new Category("Magasin");
        }


}
