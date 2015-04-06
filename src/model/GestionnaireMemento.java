package model;

import java.util.ArrayList;

public class GestionnaireMemento<Param> {
	private ArrayList<Memento<Param>> mementos = new ArrayList<Memento<Param>>();

	public void addParam(Memento<Param> memento) {
		mementos.add(memento);
	}

	
	public Memento<Param> getParam(int index) {
		return mementos.get(index);
	}

	/**
	 * @return nombre de memento
	 */
	public int size() {
		return mementos.size();
	}
}