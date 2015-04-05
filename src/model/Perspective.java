package model;

public class Perspective {
	private int id;
	private int x;
	private int y;
	private double zoom;

	private static int nextId = 1;

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
	 * Créer une perspective à partir d'une sauvegarde (donc les paramètres sont
	 * déjà choisis)
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
		// À FAIRE
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
