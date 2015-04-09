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
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import vue.*;
import model.Modele;

public class Controleur implements MouseListener, MouseWheelListener,
		MouseMotionListener, ActionListener, MenuListener, Cloneable {

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

	// ou qqch du genre
	// si (déplacer){
	// commande = commandes.deplacer();
	// commande.execute();}
	// par exemple

	@Override
	public void mouseClicked(MouseEvent e) {
		this.idClique = ((VueModifiable) e.getSource()).getId();

	}

	public int getIdEnCours() {
		return idEnCours;
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if (e.getSource() instanceof VueModifiable) {
			this.idEnCours = ((VueModifiable) e.getSource()).getId();
			System.out.println("idEnCours:" + idEnCours);
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
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

	@Override
	public void mouseDragged(MouseEvent arg0) {
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		comm.execute();
	}

	@Override
	public void menuCanceled(MenuEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void menuDeselected(MenuEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void menuSelected(MenuEvent arg0) {
		comm.execute();
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
		return this;
	}

	public Controleur saveActionPerformed() {
		return this;
	}

	public Controleur zoomActionPerformed() {
		return this;
	}

	public Controleur deplacerActionPerformed(int aId, int aVariationX,
			int aVariationY) {
		comm = creatorComm.deplacer(aId, aVariationX, aVariationY);
		return this;
	}

	public Controleur undoActionPerformed() {
		comm = creatorComm.undo(this);
		try {
			return ((Controleur) this.clone());
		} catch (CloneNotSupportedException e) {
			return null;
		}
	}
}
