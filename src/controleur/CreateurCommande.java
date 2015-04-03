package controleur;

/**
 * @author Alex
 *
 */
public class CreateurCommande {
	private CommandeZoom zoom;
	private CommandeFermer fermer;
	private CommandeOpenSave openSave;
	private CommandeDeplacer deplacer;
	private CommandeSave save;
	private CommandeUndo undo;

	public CreateurCommande() {
		zoom = new CommandeZoom();
		fermer = new CommandeFermer();
		openSave = new CommandeOpenSave();
		deplacer = new CommandeDeplacer();
		save = new CommandeSave();
		undo = new CommandeUndo();
	}

	public CommandeZoom getZoom() {
		return zoom;
	}

	public CommandeFermer getFermer() {
		return fermer;
	}

	public CommandeOpenSave getOpenSave() {
		return openSave;
	}

	public CommandeDeplacer getDeplacer() {
		return deplacer;
	}

	public CommandeSave getSave() {
		return save;
	}

	public CommandeUndo getUndo() {
		return undo;
	}

}
