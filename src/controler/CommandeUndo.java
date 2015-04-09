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

public class CommandeUndo extends Commande {

	private Controleur controleur;

	public CommandeUndo(Controleur aControleur) {
		controleur = aControleur;
	}

	@Override
	public void execute() {
		Perspective aModif = null;
		aModif = Modele.getInstance().getPerspectiveById(controleur.getIdEnCours());
		aModif.undo();
	}
}
