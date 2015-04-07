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
