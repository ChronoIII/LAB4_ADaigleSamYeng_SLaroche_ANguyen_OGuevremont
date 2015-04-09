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
import model.Perspective;

public class CommandeZoom extends Commande {

	private int id;
	private double variation;

	public CommandeZoom(int aId, double aVariation) {
		variation = aVariation;
		id = aId;
	}

	@Override
	public void execute() {
		Perspective aModif = null;
		aModif = Modele.getInstance().getPerspectiveById(id);
		System.out.println(id);
		aModif.zoomer(variation);
	}
}
