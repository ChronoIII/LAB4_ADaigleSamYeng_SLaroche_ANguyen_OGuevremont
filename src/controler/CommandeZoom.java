package controler;

import model.Modele;
import model.NoIllustrationException;
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
		try {
			aModif = Modele.getInstance().getPerspectiveById(id);
		} catch (NoIllustrationException e) {
			System.out.println(e.getMessage());
			System.exit(1);
		}
		aModif.zoomer(variation);
	}
}
