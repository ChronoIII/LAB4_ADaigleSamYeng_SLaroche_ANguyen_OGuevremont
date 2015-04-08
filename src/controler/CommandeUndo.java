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
import model.NoIllustrationException;
import model.Perspective;

public class CommandeUndo extends Commande {

	private int id;

	public CommandeUndo(int aId) {
		id = aId;
	}

	@Override
	public void execute() {
		Perspective aModif = null;
		try {
			aModif = Modele.getInstance().getPerspectiveById(id);
		} catch (NoIllustrationException e) {
			System.out.println(e.getMessage());
			System.exit(1);
		}
		aModif.undo();
	}
}
