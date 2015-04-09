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
		modele.addObserver(fenetre);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String a = "chose";
		System.out.println(a);
		
		a = "avant" + a + "arrrière";
		System.out.println(a);

		FabriqueMVC creator = new FabriqueMVC();
	}

}
