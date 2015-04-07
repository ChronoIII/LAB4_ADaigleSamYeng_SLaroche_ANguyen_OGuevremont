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
