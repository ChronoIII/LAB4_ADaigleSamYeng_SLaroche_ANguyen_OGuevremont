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
 2015-05-07 Finalisation
 *******************************************************/
package vue;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import model.Modele;
import model.Perspective;
import controler.Controleur;

public class VueVignette extends VueModifiable {
	private int width = 250;
	private int height = 250;

	/*
	 * Constructeur
	 */
	public VueVignette(int id, Image image, Controleur aControleur) {
		super(id, image, aControleur);
	}

	/*
	 * Affiche l'image avec les indicateurs de ce que les vues affichent
	 * */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(super.getImage(), 0, 0, 250, 250, this);
		g.setColor(Color.RED);
		Perspective p = Modele.getInstance().getPerspectiveById(1);
		g.drawRect((int) (-p.getX() / p.getZoom()),
				(int) (-p.getY() / p.getZoom()), (int) (width / p.getZoom()),
				(int) (height / p.getZoom()));
		g.setColor(Color.BLUE);
		p = Modele.getInstance().getPerspectiveById(2);
		g.drawRect((int) (-p.getX() / p.getZoom()),
				(int) (-p.getY() / p.getZoom()), (int) (width / p.getZoom()),
				(int) (height / p.getZoom()));
	}
}
