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

import model.Modele;

public class Controleur {
	
	private CreateurCommande commandes;
	private Modele modele = null;

	/**
	 * 
	 * @param aModele
	 */
	public Controleur(Modele aModele) {
		modele = aModele;
		commandes = new CreateurCommande();
	}
	//ou qqch du genre
	public void actionPerformed(){
		//si (déplacer){
		//commande = commandes.deplacer();
		//commande.execute();}
		//par exemple
	}
	
}
