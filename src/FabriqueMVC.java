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
import model.Modele;
import controler.Controleur;
import vue.Fenetre;

/**
 * @author Alex
 *
 */
public class FabriqueMVC {

	/*
	 * Initialise les composantes nécessaires pour le programme
	 */
	public FabriqueMVC() {
		Modele modele = Modele.getInstance();
		Controleur controleur = new Controleur(modele);
		Fenetre fenetre = new Fenetre(modele, controleur);
		modele.addObserver(fenetre);
	}
	
	/**
	 * Crée une instance de FabriqueMVC qui crée la solution dans son constructeur
	 * @param args
	 */
	public static void main(String[] args) {

		FabriqueMVC creator = new FabriqueMVC();
	}

}
