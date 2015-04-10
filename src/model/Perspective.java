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

/*
 * un perspective représente les propriétés de l'image et ils sont modifiable
 */
public class Perspective implements Serializable{//les perspectives doivent être serializable pour que l'illustration soit serializable
	private int id;//l'identidiant de la perspective
	private int x;
	private int y;
	private double zoom;

	GestionnaireMemento gestionnaire = new GestionnaireMemento();

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

	/**
	 * permet de changer la position de l'image selon le déplacement de la souris
	 * @param aVariationX
	 * @param aVariationY
	 */
	public void deplacer(int aVariationX, int aVariationY) {
		if (!(this instanceof Vignette)) {
			x = x + aVariationX;
			y = y + aVariationY;
			gestionnaire.addState(createMemento());
			Modele.getInstance().notifierChangement();
		}
	}

	/**
	 * permet de changer le zoom de l'image selon la roulette
	 * @param variation
	 */
	public void zoomer(double variation) {
		if (zoom + variation < 10 && zoom + variation > 0.01
				&& !(this instanceof Vignette)) {
			zoom = zoom + variation;
			gestionnaire.addState(createMemento());
			Modele.getInstance().notifierChangement();
		}
	}

	/**
	 * permet de revenir d'une perspective précédante, à l'aide des mementos et du gestionnaire du memento
	 */
	public void undo() {
		try {
			setMemento(gestionnaire.getPreviousState());
			Modele.getInstance().notifierChangement();
		System.out.println("undoID:" + id);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Il n'y a pas d'action précédente pour id:"+id);
		}
	}

	/**
	 * setter pour les mementos
	 * @param aMemento
	 */
	public void setMemento(Memento aMemento) {
		String state = aMemento.getState();
		x = Integer.parseInt(state.split(";")[0]);
		y = Integer.parseInt(state.split(";")[1]);
		zoom = Double.parseDouble(state.split(";")[2]);
	}

	/**
	 * pour instancier un memento
	 * @return
	 */
	public Memento createMemento() {
		return new Memento(x + ";" + y + ";" + zoom);
	}

	/**
	 * 
	 * @return
	 */
	public int getId() {
		return id;
	}

	/**
	 * 
	 * @return
	 */
	public int getX() {
		return x;
	}

	/**
	 * 
	 * @return
	 */
	public int getY() {
		return y;
	}

	/**
	 * 
	 * @return
	 */
	public double getZoom() {
		return zoom;
	}
}
