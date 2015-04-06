import model.Modele;
import controler.Controleur;
import vue.Fenetre;

/**
 * 
 */

/**
 * @author Alex
 *
 */
public class FabriqueMVC {

	public FabriqueMVC() {
		Modele modele = Modele.getInstance();
		Controleur controleur = new Controleur(modele);
		Fenetre fenetre = new Fenetre(modele, controleur);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		FabriqueMVC creator = new FabriqueMVC();
	}

}
