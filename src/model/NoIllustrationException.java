package model;

@SuppressWarnings("serial")
public class NoIllustrationException extends Exception {
	public NoIllustrationException() {
		super("Il n'y a pas d'illustration sélectionnée.");
	}
}
