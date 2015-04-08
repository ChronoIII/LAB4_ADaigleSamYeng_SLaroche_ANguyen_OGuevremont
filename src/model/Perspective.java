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

public class Perspective {
	private int id;
	private int x;
	private int y;
	private double zoom;
	
	//Amelie: J'assume que le memento vient ici selon le UML? x)
	
	Originator originator = new Originator();
	GestionnaireMemento gestionnaire = new GestionnaireMemento();
	
	// pour changer de state il faut faire orignator.setState ("qqch") et 
	//sauvegarder c'est gestionnaire.addState(orignator.sauvegardeAMemento());

	private static int nextId = 1;

	/**
	 * Cr�er une perspective � partir de rien
	 */
	public Perspective() {
		x = 0;
		y = 0;
		zoom = 1.0;

		id = nextId;
		nextId++;
	}

	/**
	 * Cr�er une perspective � partir d'une sauvegarde (donc les param�tres sont
	 * d�j� choisis)
	 * 
	 * @param aX
	 * @param aY
	 * @param aZoom
	 * @param aId
	 */
	public Perspective(int aX, int aY, double aZoom, int aId) {
		x = aX;
		y = aY;
		zoom = aZoom;

		id = aId;
	}

	public void deplacer(int aVariationX, int aVariationY) {
		x = x + aVariationX;
		y = y + aVariationY;
		Modele.getInstance().notifyAll();
	}

	public void zoomer(double variation) {
		zoom = zoom + variation;
		Modele.getInstance().notifyAll();
	}

	public void undo() {
		// � FAIRE
		// utiliser memento i guess
	}

	public void getLastState() {

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
