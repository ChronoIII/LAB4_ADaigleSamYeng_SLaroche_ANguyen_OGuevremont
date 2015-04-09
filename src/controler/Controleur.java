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

package controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import vue.*;
import model.Modele;

public class Controleur implements MouseListener, MouseWheelListener,
		MouseMotionListener, ActionListener, Cloneable {

	private CreateurCommande creatorComm;
	private Commande comm;
	private Modele modele = null;
	private int idEnCours;
	private int idClique;
	// points de début et de fin d'une translation
	private int debutX;
	private int debutY;
	private int finX;
	private int finY;
	private int derniereAction;

	/**
	 * 
	 * @param aModele
	 */
	public Controleur(Modele aModele) {
		modele = aModele;
		creatorComm = new CreateurCommande();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() instanceof VueModifiable) {
			this.idClique = ((VueModifiable) e.getSource()).getId();
		}
		if (e.getSource() instanceof JMenu) {
			comm.execute();
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		comm.execute();
	}

	public int getIdEnCours() {
		return idEnCours;
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if (e.getSource() instanceof VueModifiable) {
			this.idEnCours = ((VueModifiable) e.getSource()).getId();
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getSource() instanceof VueModifiable) {
			this.idEnCours = ((VueModifiable) e.getSource()).getId();
			debutX = e.getX();
			debutY = e.getY();
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (debutX != 0 && debutY != 0) {
			finX = e.getX();
			finY = e.getY();
			creatorComm.deplacer(idEnCours, finX - debutX, finY - debutY)
					.execute();
		}
		debutX = 0;
		debutY = 0;
		finX = 0;
		finY = 0;
		derniereAction = idEnCours;
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent arg0) {
		creatorComm.zoom(idEnCours, arg0.getWheelRotation()).execute();
		derniereAction = idEnCours;
	}

	public Controleur fermerActionPerformed() {
		comm = creatorComm.fermer();
		try {
			return ((Controleur) this.clone());
		} catch (CloneNotSupportedException e) {
			return null;
		}
	}

	public Controleur openActionPerformed() {
		comm = creatorComm.open();
		try {
			return ((Controleur) this.clone());
		} catch (CloneNotSupportedException e) {
			return null;
		}
	}

	public Controleur saveActionPerformed() {
		comm = creatorComm.save();
		try {
			return ((Controleur) this.clone());
		} catch (CloneNotSupportedException e) {
			return null;
		}
	}

	public Controleur undoActionPerformed() {
		comm = creatorComm.undo(this);
		try {
			return ((Controleur) this.clone());
		} catch (CloneNotSupportedException e) {
			return null;
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
	}

}
