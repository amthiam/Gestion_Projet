package test;

import dao.impl.*;
import exceptions.DatabaseException;
import exceptions.ProjectException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.LinkedList;
import manager.DatabaseManager;
import manager.GraphManager;
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
            
            
            
            
            //Tests activités et états
            
            //Création d'une activité
            Activity activiteTest = new Activity(null, idProjetTest, "Activité test", "Création d'une activité test", new BigDecimal(10), new BigDecimal(1), "Pas d'hypothèses pour cette activité", "Pas de notes de calcul", dateLivraison, elementFils1Trouve, null, null, new LinkedList<State>());
            //Creation de l'objet activiteDAO
            ActivityDAO activiteDAO = new ActivityDAO(dbManager);
            //Insertion dans la base de donnée
            Long idActiviteTest = activiteDAO.create(activiteTest);
            //On cherche l'activite
            Activity activiteTestTrouve = activiteDAO.find(idActiviteTest);
            
            System.out.println("Activité trouvée dans la base :");
            System.out.println("id : "+activiteTestTrouve.getId());
            System.out.println("label : "+ activiteTestTrouve.getLabel());
            System.out.println("Description : "+ activiteTestTrouve.getDescription());
            System.out.println("workload : " + activiteTestTrouve.getWorkload());
            System.out.println("duration : " + activiteTestTrouve.getDuration());
            System.out.println("hypothesis : " + activiteTestTrouve.getHypothesis());
            System.out.println("calculation note : " + activiteTestTrouve.getCalculationNote());
            System.out.println("constraint date value : " + activiteTestTrouve.getConstDateValue());
            System.out.println("Label de l'élément du WBS auquel est rattachée l'activité : "+ activiteTestTrouve.getElement().getLabel());
            
            //Création de l'état d'arrivée de l'activité
            State etatTest = new State(null, idProjetTest, "Etat test", false, elementFils1Trouve, activiteTestTrouve);
            //Création de l'objet StateDAO
            StateDAO stateDAO = new StateDAO(dbManager);
            //Insertion dans la base de données
            Long idEtatTest = stateDAO.create(etatTest);
            //On cherche l'état tout juste créée
            State etatTestTrouve = stateDAO.find(idEtatTest);
            
            System.out.println("Etat trouvé dans la base :");
            System.out.println("id : "+ etatTestTrouve.getId());
            System.out.println("label : " + etatTestTrouve.getLabel());
            System.out.println("Milestone ? : " + etatTestTrouve.isMilestone());
            System.out.println("Label de l'élément du WBS auquel est rattaché l'état : " + etatTestTrouve.getElement().getLabel());
            System.out.println("Label de l'activité précédant l'état : " + etatTestTrouve.getPredecessorActivity().getLabel());
            
            
            //Création de deux activités parallèles
            LinkedList<State> etatPred = new LinkedList();
            etatTest.setId(idEtatTest);
            etatPred.add(etatTest);
            Activity activite2 = new Activity(null, idProjetTest, "Activité 2", "Création de deux activités parallèle", null, null, null, null, dateLivraison, elementFils1Trouve, null, null, etatPred);
            Long idActivite2 = activiteDAO.create(activite2);
            activite2.setId(idActivite2);
            Activity activite3 = new Activity(null, idProjetTest, "Activité 3", "Création de deux activités parallèle", null, null, null, null, dateLivraison, elementFils1Trouve, null, null, etatPred);
            Long idActivite3 = activiteDAO.create(activite3);
            activite3.setId(idActivite3);
            //Création des états correspondants
            State etat2 = new State(null, idProjetTest, "Etat 2", false, elementFils1Trouve, activite2);
            Long idEtat2 = stateDAO.create(etat2);
            etat2.setId(idEtat2);
            State etat3 = new State(null, idProjetTest, "Etat 3", false, elementFils1Trouve, activite3);
            Long idEtat3 = stateDAO.create(etat3);
            etat3.setId(idEtat3);
            //Création de l'activité suivant ces deux activités parallèle
            etatPred.clear();
            etatPred.add(etat2);
            etatPred.add(etat3);
            Activity activite4 = new Activity(null, idProjetTest, "Activité 4", "Activité suivant deux activités s'étant déroulée en parallèle", null, null, null, null, dateLivraison, elementFils1Trouve, null, null, etatPred);
            Long idActivite4 = activiteDAO.create(activite4);
            activite4.setId(idActivite4);
            activite4 = activiteDAO.find(idActivite4);
            
            System.out.println("Activité 4 :");
            System.out.println("id : "+activite4.getId());
            System.out.println("label : "+ activite4.getLabel());
            System.out.println("Description : "+ activite4.getDescription());
            System.out.println("workload : " + activite4.getWorkload());
            System.out.println("duration : " + activite4.getDuration());
            System.out.println("hypothesis : " + activite4.getHypothesis());
            System.out.println("calculation note : " + activite4.getCalculationNote());
            System.out.println("constraint date value : " + activite4.getConstDateValue());
            System.out.println("Label de l'élément du WBS auquel est rattachée l'activité : "+ activite4.getElement().getLabel());
            System.out.println("Etats précédant l'activité : ");
            for (State etatPredecesseur : activite4.getListOfStatePredecessors()){
                System.out.println(etatPredecesseur.getLabel());
            }
            
            //Affichage de tous les éléments du WBS du projet
            LinkedList<WBSElement> elementList = elementDAO.listElementOfProject(idProjetTest);
            System.out.println("Affichage de l'enesemble des éléments du WBS : ");
            for (WBSElement element : elementList){
                System.out.println(element.getLabel());
                        }
            //Test de création de graphe
            //GraphManager graphGenerator = new GraphManager(dbManager);
            //graphGenerator.writeStateActivity(idProjetTest);
            
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
