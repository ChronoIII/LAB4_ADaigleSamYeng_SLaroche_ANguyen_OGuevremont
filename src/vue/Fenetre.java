/**
 * 
 */
package vue;

import java.awt.BorderLayout;
import java.util.*;

import javax.swing.*;

import controler.*;
import model.*;

/**
 * @author Samuel
 *
 */
public class Fenetre extends JFrame implements Observer {

	private VueVignette vignette;
	private VueModifiable[] vues;
	private JMenuBar menuBar;
	
	private Modele modele = null;
	private Controleur controleur = null;
	
	public Fenetre(Modele aModele, Controleur aControleur){
		modele = aModele;
		controleur = aControleur;
		
		this.setLayout(new BorderLayout());
		this.add(menuBar, BorderLayout.NORTH);
		vignette = new VueVignette();
		this.add(vignette);
		this.pack(); // Ajuste la dimension de la fenêtre principale selon celle de ses composants
		this.setVisible(true); // Rend la fenêtre principale visible.
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //... à réviser selon le comportement que vous désirez ...
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		for (VueModifiable vm : vues) {
			vm.update();
		}
	}

}
