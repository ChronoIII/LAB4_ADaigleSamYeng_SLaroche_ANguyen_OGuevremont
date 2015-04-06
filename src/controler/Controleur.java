package controler;

import model.Modele;

public class Controleur {
	private CreateurCommande commandes;
	private Modele modele = null;

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
