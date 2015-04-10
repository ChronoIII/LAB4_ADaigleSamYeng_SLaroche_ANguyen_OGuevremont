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
2015-09-5 Finalisation
 *******************************************************/

package vue;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.IOException;
import java.util.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

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
	private VueModifiable[] vues = new VueModifiable[3];
	private JMenuBar menuBar;
	private Image image;
	private Modele modele = null;
	private Controleur aControleur = null;
	private JPanel espaceTravail;
	private JButton undoButton = new JButton("Undo");
	private JButton aideButton = new JButton("Aide");
	private JMenuBar menu = new JMenuBar();
	private JMenu openActionMenu = new JMenu("Open");
	private JMenu saveActionMenu = new JMenu("Save");
	private JMenu exitActionMenu = new JMenu("Exit");

	/*
	 * Initialise une Fenetre dans laquelle l'application vas se d�rouler
	 */
	public Fenetre(Modele aModele, Controleur aControleur) {
		super("Fantastic Image Fisualisator - Labo4");
		setLocation(300, 50);
		espaceTravail = new JPanel();

		trouverImage();

		modele = aModele;
		this.aControleur = aControleur;

		this.setLayout(new GridLayout(2, 2));
		// this.add(menuBar, BorderLayout.NORTH);
		vignette = new VueVignette(0, image, aControleur);
		vue1 = new VueModifiable(1, image, aControleur);
		vue2 = new VueModifiable(2, image, aControleur);
		vues[0] = vignette;
		vues[1] = vue1;
		vues[2] = vue2;

		espaceTravail.add(undoButton);
		espaceTravail.add(aideButton);

		this.add(vignette);
		this.add(vue1);
		this.add(vue2);
		this.add(espaceTravail);
		this.setJMenuBar(menu);
		ajoutListeners();
		this.setPreferredSize(new Dimension(500, 500)); // Ajuste la dimension
		pack();// de la fenêtre
		// principale selon
		// celle de ses composants
		this.setVisible(true); // Rend la fenêtre principale visible.
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ... à réviser
																// selon le
																// comportement
																// que vous
																// désirez ...
	}

	/*
	 * Initialise l'image utilis�e dans la fenetre selon le Modele
	 */
	public void trouverImage() {
		image = Modele.getInstance().getImage();
	}

	
	@Override
	public void update(Observable arg0, Object arg1) {
		trouverImage();
		for (VueModifiable vm : vues) {
			vm.setImage(image);
			vm.update();
		}
	}

	/*
	 * Ajoute les listeners n�cessaires pour que le programme soit fonctionnel
	 */
	public void ajoutListeners() {
		openActionMenu.addMouseListener(aControleur.openActionPerformed());
		saveActionMenu.addMouseListener(aControleur.saveActionPerformed());
		exitActionMenu.addMouseListener(aControleur.fermerActionPerformed());
		undoButton.addActionListener(aControleur.undoActionPerformed());
		vignette.addMouseListener(aControleur);
		vignette.addMouseMotionListener(aControleur);
		vue1.addMouseListener(aControleur);
		vue1.addMouseMotionListener(aControleur);
		vue2.addMouseMotionListener(aControleur);
		vue2.addMouseListener(aControleur);
		aideButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane
						.showMessageDialog(
								aideButton,
								"Cliquez et glissez les images pour les d�placer. Utilisez la roulette de votre souris pour zoomer sur l'image sur laquelle votre souris plane. ");
			}
		});

		this.addMouseWheelListener(aControleur);
		menu.add(openActionMenu);
		menu.add(saveActionMenu);
		menu.add(exitActionMenu);
	}

}
