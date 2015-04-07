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