package test;

import dao.impl.*;
import exceptions.DatabaseException;
import exceptions.ProjectException;
import java.math.BigDecimal;
import java.util.Date;
import manager.DatabaseManager;
import model.*;

/**
 * Test class
 *
 * @author Felix
 */
public class Test {

    public static void main(String[] args) {

        System.out.println("debut du test");

        try {
            
            //Connection à la base de données
            DatabaseManager dbManager = new DatabaseManager("jdbc:h2:~/test", "sa", "");
            System.out.println("DatabaseManager créé");
            
            //Creation des objets DAO
            ProjectDAO projetDao = new ProjectDAO(dbManager);
            WBSElementDAO elementDAO = new WBSElementDAO(dbManager);
            UserDAO userDao = new UserDAO(dbManager);
            
            //Création d'un user
            User projectManager = new User("Project Manager", "pwd");
            //Insertion dans la base de données
            Long idProjectManager = userDao.create(projectManager);
            projectManager.setId(idProjectManager);
            System.out.println("User créé, Nom : "+projectManager.getName()+", id : "+projectManager.getId());
            
            //Creation d'un nouveau projet
            Project projetTest = new Project("Projet Test", "Projet Test", "Projet test : test d'insertion et de manipulation d'objets du WBS", "", projectManager.getId());
            //Insertion du projet dans la base de données
            Long idProjetTest = projetDao.create(projetTest);
            //Mise à jour du champ id du projet
            projetTest.setId(idProjetTest);
            
            //Creation d'un nouvel element du WBS
            Date dateLivraison = new Date(114, 02, 24);
            WBSElement elementTest = new WBSElement(null, "Element père", "Element de test d'arbre WBS : élément père", false, null, new BigDecimal(10), new BigDecimal(1), true, "Achevé lorsque le projet est achevé", dateLivraison, null, null, null, null, null, null, null, null, null, null, null, null, new Integer(1), projetTest.getId());
            //Insertion de l'élément dans la base de données
            Long idElementTest = elementDAO.create(elementTest);
            
            System.out.println("id element du WBS créé : "+idElementTest);
            
            //On vérifie que les éléments ont bien été créé dans la base de données
            WBSElement elementTrouve = elementDAO.find(idElementTest);
            
            System.out.println("Element trouvé dans la base :");
            System.out.println("id : "+elementTrouve.getId());
            System.out.println("label : "+elementTrouve.getLabel());
            System.out.println("name : "+elementTrouve.getDescription());
            System.out.println("isWorkpackage :"+elementTrouve.isIsWorkpackage());
            System.out.println("Date de livraison :" + elementTrouve.getDeliveryDate());
            System.out.println("Workload : " + elementTrouve.getWorkload());
            System.out.println("Id élement parent : " + elementTrouve.getIdParentElement());
            System.out.println("Rang : " + elementTrouve.getRank());
            System.out.println("id du Projet : " + elementTrouve.getIdProject());
            
            //Création d'un élément fils
            WBSElement elementFils1 = new WBSElement(null, "Element fils 1", "Element de test d'arbre WBS : élément fils", false, null, new BigDecimal(5), new BigDecimal(2), true, "Achevé lorsque le projet est achevé", dateLivraison, null, null, null, null, null, null, null, null, null, null, null, idElementTest, new Integer(1), projetTest.getId());
            //Insertion de l'élément dans la base de données
            Long idElementFils1 = elementDAO.create(elementFils1);
            
            //On vérifie que les éléments ont bien été créé dans la base de données
            WBSElement elementFils1Trouve = elementDAO.find(idElementFils1);
            
            System.out.println("Element trouvé dans la base :");
            System.out.println("id : "+elementFils1Trouve.getId());
            System.out.println("label : "+elementFils1Trouve.getLabel());
            System.out.println("name : "+elementFils1Trouve.getDescription());
            System.out.println("isWorkpackage :"+elementFils1Trouve.isIsWorkpackage());
            System.out.println("Date de livraison :" + elementFils1Trouve.getDeliveryDate());
            System.out.println("Workload : " + elementFils1Trouve.getWorkload());
            System.out.println("Id élement parent : " + elementFils1Trouve.getIdParentElement());
            System.out.println("Rang : " + elementFils1Trouve.getRank());
            System.out.println("id du Projet : " + elementFils1Trouve.getIdProject());

            
            //Création d'un 2ème élément fils
            WBSElement elementFils2 = new WBSElement(null, "Element fils 2", "Element de test d'arbre WBS : élément fils", false, null, new BigDecimal(5), new BigDecimal(2), true, "Achevé lorsque le projet est achevé", dateLivraison, null, null, null, null, null, null, null, null, null, null, null, idElementTest, new Integer(2), projetTest.getId());
            //Insertion de l'élément dans la base de données
            Long idElementFils2 = elementDAO.create(elementFils2);
            
            //On vérifie que les éléments ont bien été créé dans la base de données
            WBSElement elementFils2Trouve = elementDAO.find(idElementFils2);
            
            System.out.println("Element trouvé dans la base :");
            System.out.println("id : "+elementFils2Trouve.getId());
            System.out.println("label : "+elementFils2Trouve.getLabel());
            System.out.println("name : "+elementFils2Trouve.getDescription());
            System.out.println("isWorkpackage :"+elementFils2Trouve.isIsWorkpackage());
            System.out.println("Date de livraison :" + elementFils2Trouve.getDeliveryDate());
            System.out.println("Workload : " + elementFils2Trouve.getWorkload());
            System.out.println("Id élement parent : " + elementFils2Trouve.getIdParentElement());
            System.out.println("Rang : " + elementFils2Trouve.getRank());
            System.out.println("id du Projet : " + elementFils2Trouve.getIdProject());
            
        } catch (DatabaseException e) {
            System.out.println("Erreur BDD :" + e.getMessage() + ", ResultCode :" + e.getResultCode().name());
            System.out.println(e.getStackTrace().toString());
            e.printStackTrace();
        }
        catch(ProjectException e){
            System.out.println("Erreur Projet :" + e.getMessage() + ", ResultCode :" + e.getResultCode().name());
            System.out.println(e.getStackTrace().toString());
            e.printStackTrace();
        }
    }
}
