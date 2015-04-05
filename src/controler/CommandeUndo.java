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
