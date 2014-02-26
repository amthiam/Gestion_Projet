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
            Date dateLivraison = new Date(114, 03, 24);
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
