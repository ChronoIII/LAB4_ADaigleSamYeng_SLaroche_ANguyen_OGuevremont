package controler;

import model.Modele;

public class CommandeOpen extends Commande {

	private String path;

	public CommandeOpen(String aPath) {
		path = aPath;
	}

	@Override
	public void execute() {
		Modele.getInstance().open(path);
	}
}
