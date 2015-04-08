package controler;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import vue.VueModifiable;
import model.Modele;

public class Controleur implements MouseListener, MouseWheelListener,
		MouseMotionListener {
	private CreateurCommande commandes;
	private Modele modele = null;
	private int idEnCours;
	private int idClique;
	private int deplacementX;
	private int deplacementY;
	private int actuelX;
	private int actuelY;

	public Controleur(Modele aModele) {
		modele = aModele;
		commandes = new CreateurCommande();
	}

	// ou qqch du genre
	// si (déplacer){
	// commande = commandes.deplacer();
	// commande.execute();}
	// par exemple

	@Override
	public void mouseClicked(MouseEvent e) {
		this.idClique = ((VueModifiable) e.getSource()).getId();
		this.deplacementX = e.getX();
		this.deplacementY = e.getY();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		this.idEnCours = ((VueModifiable) e.getSource()).getId();

	}

	@Override
	public void mouseExited(MouseEvent e) {
		this.idEnCours = 0;

	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		this.idClique = 0;

	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent arg0) {
		commandes.zoom(idEnCours, arg0.getWheelRotation());

	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		commandes.deplacer(idClique, deplacementX - actuelX, deplacementX
				- actuelX);

	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
	}

}
