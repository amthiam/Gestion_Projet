/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gestion_projet;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import model.*;



/**
 *
 * @author amadou
 */
public class ObjetsBDD {
    
    public ArrayList<WBSElement> elements;
    public  ArrayList<Activity> activites;
    public  ArrayList<HumanResource> rh;
    public  ArrayList<MaterialResource> MR;
    public  ArrayList<Meeting> meeting;
    public  ArrayList<Place> places;
    public  ArrayList<Project> projets;
    public  ArrayList<Requirement> requirememt;
    public ArrayList<Risk> risques;
    public ArrayList<State> states;
    public ArrayList<TargetGroup> targetgroup;
    public ArrayList<Unit>unit;
    public ArrayList<User> user;
    
 public ObjetsBDD(){   
    //Normalement dans cette partie, on accède à la base de données, on en récupère le contenu et on le stocke dans la case correspondante de ObjetsBDD

  //Creation d'un nouvel element du WBS
            Date dateLivraison = new Date(114, 03, 24);
            long x=2l;
            WBSElement elementTest = new WBSElement(null, "Element père", "Element de test d'arbre WBS : élément père", false, null, new BigDecimal(10), new BigDecimal(1), true, "Achevé lorsque le projet est achevé", dateLivraison, null, null, null, null, null, null, null, null, null, null, null, null, new Integer(1), x);
            WBSElement elementTest2 = new WBSElement(null, "Element père", "Element de test d'arbre WBS :élément quelconque", false, null, new BigDecimal(10), new BigDecimal(1), true, "Achevé lorsque le projet est achevé", dateLivraison, null, null, null, null, null, null, null, null, null, null, null, null, new Integer(1), x);

            this.elements = new ArrayList<WBSElement>();
            
            elements.add(elementTest);
            elements.add(elementTest2);
 //Création d'un nouvel élément à des fins de test
            
 }

    public ArrayList<WBSElement> getElements() {
        return elements;
    }

    public void setElements(ArrayList<WBSElement> elements) {
        this.elements = elements;
    }

    public ArrayList<Activity> getActivites() {
        return activites;
    }

    public void setActivites(ArrayList<Activity> activites) {
        this.activites = activites;
    }

    public ArrayList<HumanResource> getRh() {
        return rh;
    }

    public void setRh(ArrayList<HumanResource> rh) {
        this.rh = rh;
    }

    public ArrayList<MaterialResource> getMR() {
        return MR;
    }

    public void setMR(ArrayList<MaterialResource> MR) {
        this.MR = MR;
    }

    public ArrayList<Meeting> getMeeting() {
        return meeting;
    }

    public void setMeeting(ArrayList<Meeting> meeting) {
        this.meeting = meeting;
    }

    public ArrayList<Place> getPlaces() {
        return places;
    }

    public void setPlaces(ArrayList<Place> places) {
        this.places = places;
    }

    public ArrayList<Project> getProjets() {
        return projets;
    }

    public void setProjets(ArrayList<Project> projets) {
        this.projets = projets;
    }

    public ArrayList<Requirement> getRequirememt() {
        return requirememt;
    }

    public void setRequirememt(ArrayList<Requirement> requirememt) {
        this.requirememt = requirememt;
    }

    public ArrayList<Risk> getRisques() {
        return risques;
    }

    public void setRisques(ArrayList<Risk> risques) {
        this.risques = risques;
    }

    public ArrayList<State> getStates() {
        return states;
    }

    public void setStates(ArrayList<State> states) {
        this.states = states;
    }

    public ArrayList<TargetGroup> getTargetgroup() {
        return targetgroup;
    }

    public void setTargetgroup(ArrayList<TargetGroup> targetgroup) {
        this.targetgroup = targetgroup;
    }

    public ArrayList<Unit> getUnit() {
        return unit;
    }

    public void setUnit(ArrayList<Unit> unit) {
        this.unit = unit;
    }

    public ArrayList<User> getUser() {
        return user;
    }

    public void setUser(ArrayList<User> user) {
        this.user = user;
    }
    
    
    
    
    
    
    
    
}
