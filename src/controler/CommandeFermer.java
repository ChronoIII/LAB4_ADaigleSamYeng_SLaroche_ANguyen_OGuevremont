package controler;

public class CommandeFermer extends Commande {
	@Override
	public void execute() {
		System.exit(0);
	}
}
