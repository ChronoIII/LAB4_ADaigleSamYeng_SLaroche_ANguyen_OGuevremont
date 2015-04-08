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

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.IOException;
import java.util.*;

import javax.imageio.ImageIO;
import javax.swing.*;

import com.sun.prism.Graphics;

import controler.*;
import model.*;

/**
 * @author Samuel
 *
 */
public class Fenetre extends JFrame implements Observer {

	private VueVignette vignette;
	private VueModifiable vue1;
	private VueModifiable vue2;
	private VueModifiable[] vues;
	private JMenuBar menuBar;
	private Image image;
	private Modele modele = null;
	private Controleur controleur = null;
	private JPanel espaceTravail;

	public Fenetre(Modele aModele, Controleur aControleur) {
		espaceTravail = new JPanel();
		trouverImage();
		modele = aModele;
		controleur = aControleur;
		this.setLayout(new GridLayout(2, 2));
		// this.add(menuBar, BorderLayout.NORTH);
		vignette = new VueVignette(1, image);
		vue1 = new VueModifiable(1, image, aControleur);
		vue2 = new VueModifiable(2, image, aControleur);

		this.add(vignette, BorderLayout.SOUTH);
		this.add(vue1);
		this.add(vue2);
		vue1.addMouseListener(aControleur);
		vue1.addMouseMotionListener(aControleur);
		vue2.addMouseMotionListener(aControleur);
		vue2.addMouseListener(aControleur);
		this.addMouseWheelListener(aControleur);

		this.setPreferredSize(new Dimension(image.getHeight(null) * 2, image
				.getHeight(null) * 2)); // Ajuste la dimension
		pack();// de la fenÃªtre
		// principale selon
		// celle de ses composants
		this.setVisible(true); // Rend la fenÃªtre principale visible.
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ... Ã  rÃ©viser
																// selon le
																// comportement
																// que vous
																// dÃ©sirez ...
	}

	public void trouverImage() {
		File fichierImage = new File("image.jpg");
		try {
			image = ImageIO.read(fichierImage);
		} catch (IOException e) {
		}

	}

	@Override
	public void update(Observable arg0, Object arg1) {
		for (VueModifiable vm : vues) {
			vm.update();
		}
	}

}
