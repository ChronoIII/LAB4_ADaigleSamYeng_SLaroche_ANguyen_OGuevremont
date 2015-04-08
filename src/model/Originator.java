/******************************************************
Cours:   LOG121
Session: H2015
Groupe: 03
Projet: Laboratoire # 4
�tudiant(e)s: Samuel Laroche, Olivier G�vremont, Am�lie Nguyen, Alexemdre Daigle-Sam yeng
              
              
Charg� de cours : Francis Cardinal
Charg� de laboratoire : Patrice Boucher
Date cr��: 2015-05-01
*******************************************************
Historique des modifications
*******************************************************
2015-05-01 Version initiale
*******************************************************/ 

package model;

//La classe Originator cr�e et sauvegarde les states dans Memento.
public class Originator {
private String state;


public void setState (String state) { //le state recu va �tre l'original
	
	System.out.println("Le state va �tre "+state);
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
