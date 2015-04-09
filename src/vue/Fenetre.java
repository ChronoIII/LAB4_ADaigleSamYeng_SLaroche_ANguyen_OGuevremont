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
	private VueModifiable[] vues= new VueModifiable[3];
	private JMenuBar menuBar;
	private Image image;
	private Modele modele = null;
	private Controleur controleur = null;
	private JPanel espaceTravail;
	private JButton undo = new JButton("Undo");
	private JButton aide = new JButton("Aide");
	private JMenuBar menu = new JMenuBar();
	private JMenu undoAction = new JMenu("Undo");
	private JMenu openAction = new JMenu("Open");
	private JMenu saveAction = new JMenu("Save");
	private JMenu exitAction = new JMenu("Exit");

	public Fenetre(Modele aModele, Controleur aControleur) {
		espaceTravail = new JPanel();

		trouverImage();
		
		
		modele = aModele;
		controleur = aControleur;
		
		
		this.setLayout(new GridLayout(2, 2));
		// this.add(menuBar, BorderLayout.NORTH);
		vignette = new VueVignette(0, image, aControleur);
		vue1 = new VueModifiable(1, image, aControleur);
		vue2 = new VueModifiable(2, image, aControleur);
		vues[0]=vignette;
		vues[1]=vue1;
		vues[2]=vue2;
		
		espaceTravail.add(undo);
		espaceTravail.add(aide);
		
		menu.add(openAction);
		menu.add(saveAction);
		menu.add(undoAction);
		menu.add(exitAction);
		
		this.add(vignette);
		this.add(vue1);
		this.add(vue2);
		this.add(espaceTravail);
		this.setJMenuBar(menu);
		
		openAction.addMouseListener(aControleur);
		undo.addActionListener(aControleur);
		vue1.addMouseListener(aControleur);
		vue1.addMouseMotionListener(aControleur);
		vue2.addMouseMotionListener(aControleur);
		vue2.addMouseListener(aControleur);
		aide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(aide, "Cliquez et glissez les images pour les déplacer. Utilisez la roulette de votre souris pour zoomer sur l'image sur laquelle votre souris plane. ");
			}
		});
		
		//undoAction.addMenuListener(aControleur);
		exitAction.addMenuListener(aControleur.fermerActionPerformed());
		//bouttonDeplaerRight.addMouseListener(aControleur.deplacerActionPerformed(aId, 10, 0);
		
		this.addMouseWheelListener(aControleur);

		this.setPreferredSize(new Dimension(500, 500)); // Ajuste la dimension
		pack();// de la fenÃªtre
		// principale selon
		// celle de ses composants
		this.setVisible(true); // Rend la fenÃªtre principale visible.
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ... Ã  rÃ©viser
																// selon le
																// comportement
																// que vous
																// dÃ©sirez ...
	}

	public void trouverImage() {
		image= Modele.getInstance().getIllustration().getImage();
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		System.out.println("update been called");
		for (VueModifiable vm : vues) {
			vm.update();
		}
	}

}
