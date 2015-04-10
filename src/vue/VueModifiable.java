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
package vue;

import java.awt.*;
import java.awt.geom.Line2D;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import controler.Controleur;
import model.*;

public class VueModifiable extends JPanel implements Observer {

	private int id;
	private Image image;
	private int x;
	private int y;
	private int zoom = 250;// en pourcentage, ex:100% est écrit 100 et dessinera
							// 100px
	private Controleur controleur;

	/*
	 * Constructeur
	 */
	public VueModifiable(int id, Image image, Controleur contrl) {
		this.image = image;
		this.id = id;
	}

	/*
	 * Fonction Update du patron Observer qui modifie l'image quand une
	 * modification est faite.
	 */
	public void update() {
		Perspective base = null;
		base = Modele.getInstance().getPerspectiveById(id);
		x = base.getX();
		y = base.getY();
		zoom = (int) (base.getZoom() * 250);
		repaint();
	}

	/*
	 * Affiche l'image
	 */
	public void paintComponent(Graphics g) {

		super.paintComponent(g);
		g.drawImage(image, x, y, zoom, zoom, this);

		// g.drawRect(0, 0, 100,100);

	}

	/*
	 * Retourne le Id de l'image
	 */
	public int getId() {
		return (this.id);
	}

	/*
	 * Retourne l'image
	 */
	public Image getImage() {
		return image;
	}

	/*
	 * Affixe une image a la vignette
	 */
	public void setImage(Image aImg) {
		image = aImg;
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub

	}

}
