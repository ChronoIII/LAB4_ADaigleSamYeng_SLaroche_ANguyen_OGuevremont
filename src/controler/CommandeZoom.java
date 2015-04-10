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

package controler;

import model.Modele;
import model.Perspective;

public class CommandeZoom extends Commande {

	private int id;
	private double variation;

	/*
	 * Constructeur
	 */
	public CommandeZoom(int aId, double aVariation) {
		variation = aVariation;
		id = aId;
	}

	/*
	 * Modifie le zoom de la perspective en cours
	 */
	@Override
	public void execute() {
		Perspective aModif = null;
		aModif = Modele.getInstance().getPerspectiveById(id);
		aModif.zoomer(variation);
	}
}
