/******************************************************
Cours:   LOG121
Session: H2015
Groupe: 03
Projet: Laboratoire # 4
Étudiant(e)s: Samuel Laroche, Olivier Gévremont, Amélie Nguyen, Alexemdre Daigle-Sam yeng
              
              
Chargé de cours : Francis Cardinal
Chargé de laboratoire : Patrice Boucher
Date créé: 2015-05-01
*******************************************************
Historique des modifications
*******************************************************
2015-05-01 Version initiale
*******************************************************/ 

package model;

//La classe Originator crée et sauvegarde les states dans Memento.
public class Originator {
private String state;


public void setState (String state) { //le state recu va être l'original
	
	System.out.println("Le state va être "+state);
	this.state = state;
	
}

public String getState(){
	
	return state;
	
}
public Memento sauvegardeAMemento(){ //sauvegarde
	
	return new Memento(state);
}

public void ouvrirDeMemento (Memento memento){ //load
	
	state = memento.getPrecedent();
	
}
}
