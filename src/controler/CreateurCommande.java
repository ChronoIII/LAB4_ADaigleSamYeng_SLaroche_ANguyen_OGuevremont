package controler;

/**
 * @author Alex
 *
 */
public class CreateurCommande {

	public CommandeZoom zoom(int aId, int aVariation) {
		return new CommandeZoom(aId, aVariation);
	}

	public CommandeFermer fermer() {
		return new CommandeFermer();
	}

	public CommandeOpen open(String path) {
		return new CommandeOpen(path);
	}

	public CommandeDeplacer deplacer(int aId, int aVariationX,
			int aVariationY) {
		return new CommandeDeplacer(aId, aVariationX, aVariationY);
	}

	public CommandeSave save() {
		return new CommandeSave();
	}

	public CommandeUndo undo(int id) {
		return new CommandeUndo(id);
	}

}
