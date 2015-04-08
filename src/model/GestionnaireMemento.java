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

import java.util.ArrayList;

public class GestionnaireMemento {
	private ArrayList<Memento> mementos = new ArrayList<Memento>();

	public void addState(Memento state) { //ajoute state dans la liste
		mementos.add(state);
	}

	
	public Memento getState(int index) {
		return mementos.get(index);
	}

	/**
	 * @return nombre de memento
	 */
	public int size() {
		return mementos.size();
	}
}