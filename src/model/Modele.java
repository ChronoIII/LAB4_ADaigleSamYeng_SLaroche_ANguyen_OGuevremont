package model;

import java.util.Observable;
import java.awt.Image;

public class Modele extends Observable {
	private static Modele instance;
	private Illustration illustration;

	private Modele() {
	}

	public static Modele getInstance() {
		if (instance == null) {
			instance = new Modele();
		}
		return instance;
	}

	public Perspective getPerspectiveById(int id)
			throws NoIllustrationException {
		if (illustration == null) {// in which case you should paint a black
									// rectangle
			throw new NoIllustrationException();
		}
		return illustration.getPerspectiveById(id);
	}
	
	public void createIllustration(Image img){
		if(illustration == null) {
			illustration = new Illustration(img);
		}
	}

	public void open(String path)// open quelque chose
	{// if()//c'est une image
		// {illustration = new Illustration(image);}
		// else if()//c'est un .fif
		// {illustration= (Illustration)fichierOuvert;}
	}

	public void save() {
	}
}
