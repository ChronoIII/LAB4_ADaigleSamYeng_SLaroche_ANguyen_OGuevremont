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
 *******************************************************/
import model.Modele;
import controler.Controleur;
import vue.Fenetre;

/**
 * @author Alex
 *
 */
public class FabriqueMVC {

	/*
	 * Initialise les composantes n�cessaires pour le programme
	 */
	public FabriqueMVC() {
		Modele modele = Modele.getInstance();
		Controleur controleur = new Controleur(modele);
		Fenetre fenetre = new Fenetre(modele, controleur);
		modele.addObserver(fenetre);
	}
	
	/**
	 * Cr�e une instance de FabriqueMVC qui cr�e la solution dans son constructeur
	 * @param args
	 */
	public static void main(String[] args) {

		FabriqueMVC creator = new FabriqueMVC();
	}

}
