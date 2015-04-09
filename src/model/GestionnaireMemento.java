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

import java.io.Serializable;
import java.util.ArrayList;

public class GestionnaireMemento implements Serializable{
	private ArrayList<Memento> mementos = new ArrayList<Memento>();

	public void addState(Memento aMemento) { //ajoute state dans la liste
		mementos.add(aMemento);
	}

	
	public Memento getState(int index) {
		return mementos.get(index);
	}
	
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