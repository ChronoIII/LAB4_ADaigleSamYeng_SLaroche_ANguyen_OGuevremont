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

import java.io.Serializable;
import java.util.ArrayList;

public class GestionnaireMemento implements Serializable{//le gestionnaire de memento doit être serializable pour que l'illustration soit serializable
	private ArrayList<Memento> mementos = new ArrayList<Memento>();

	/**
	 * ajoute la nouvelle état des images à la list des memento
	 * @param aMemento
	 */
	public void addState(Memento aMemento) {
		mementos.add(aMemento);
	}

	/**
	 * getter pour l'état de l'image à un moment précis
	 * @param index
	 * @return Memento
	 */
	public Memento getState(int index) {
		return mementos.get(index);
	}
	
	/**
	 * getter pour l'état précédant
	 * @return
	 */
	public Memento getPreviousState(){
		Memento toReturn = mementos.get(size()-2);
		mementos.remove(mementos.get(size()-1));
		mementos.remove(mementos.get(size()-1));
		return toReturn;
	}

	/**
	 * @return nombre de memento
	 */
	public int size() {
		return mementos.size();
	}
}