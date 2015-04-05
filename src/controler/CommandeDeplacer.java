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
		try {
			aModif = Modele.getInstance().getPerspectiveById(id);
		} catch (NoIllustrationException e) {
			System.out.println(e.getMessage());
			System.exit(1);
		}
		aModif.deplacer(variationX, variationY);
	}

}
