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

public class Perspective implements Serializable{
	private int id;
	private int x;
	private int y;
	private double zoom;

	// Amelie: J'assume que le memento vient ici selon le UML? x)

	GestionnaireMemento gestionnaire = new GestionnaireMemento();

	// pour changer de state il faut faire orignator.setState ("qqch") et
	// sauvegarder c'est gestionnaire.addState(orignator.sauvegardeAMemento());

	private static int nextId = 0;

	/**
	 * Créer une perspective à partir de rien
	 */
	public Perspective() {
		x = 0;
		y = 0;
		zoom = 1.0;

		id = nextId;
		nextId++;
	}

	/**
	 * Créer une perspective à partir de paramètres déjà choisis
	 * 
	 * @param aX
	 * @param aY
	 * @param aZoom
	 * @param aId
	 */
	public Perspective(int aX, int aY, double aZoom) {
		x = aX;
		y = aY;
		zoom = aZoom;

		id = nextId;
		nextId++;
	}

	public void deplacer(int aVariationX, int aVariationY) {
		if (!(this instanceof Vignette)) {
			x = x + aVariationX;
			y = y + aVariationY;
			gestionnaire.addState(createMemento());
			Modele.getInstance().notifierChangement();
			System.out.println("x,y:" + x + "," + y);
		}
	}

	public void zoomer(double variation) {
		if (zoom + variation < 10 && zoom + variation > 0.01
				&& !(this instanceof Vignette)) {
			zoom = zoom + variation;
			gestionnaire.addState(createMemento());
			Modele.getInstance().notifierChangement();
			System.out.println("zoom:" + zoom);
		}
	}

	public void undo() {
		try {
			setMemento(gestionnaire.getPreviousState());
			Modele.getInstance().notifierChangement();
		System.out.println("undoID:" + id);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Il n'y a pas d'action précédente pour id:"+id);
		}
	}

	public void setMemento(Memento aMemento) {
		String state = aMemento.getState();
		x = Integer.parseInt(state.split(";")[0]);
		y = Integer.parseInt(state.split(";")[1]);
		zoom = Double.parseDouble(state.split(";")[2]);
	}

	public Memento createMemento() {
		return new Memento(x + ";" + y + ";" + zoom);
	}

	public int getId() {
		return id;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public double getZoom() {
		return zoom;
	}
}
