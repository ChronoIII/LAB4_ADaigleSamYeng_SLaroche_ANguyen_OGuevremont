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

import model.*;

public class CommandeDeplacer extends Commande {

	private int variationX;
	private int variationY;
	private int id;

	public CommandeDeplacer(int aId, int aVariationX, int aVariationY) {
		variationX = aVariationX;
		variationY = aVariationY;
		id = aId;
	}

	@Override
	public void execute() {
		Perspective aModif = null;
		aModif = Modele.getInstance().getPerspectiveById(id);
		aModif.deplacer(variationX, variationY);
	}

}
