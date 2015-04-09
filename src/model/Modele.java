/******************************************************
Cours:   LOG121
Session: H2015
Groupe: 03
Projet: Laboratoire # 4
Étudiant(e)s: Samuel Laroche, Olivier Gévremont, Amélie Nguyen, Alexemdre Daigle-Sam yeng
              
              
Chargé de cours : Francis Cardinal
Chargé de laboratoire : Patrice Boucher
Date créé: 2015-05-01
 *******************************************************
Historique des modifications
 *******************************************************
2015-05-01 Version initiale
 *******************************************************/

package model;

import java.util.Observable;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.imageio.ImageIO;

public class Modele extends Observable {
	private static Modele instance;
	private Illustration illustration;
	private Image image;

	private Modele() {
		createIllustration();
	}

	public static Modele getInstance() {
		if (instance == null) {
			instance = new Modele();

		}
		return instance;
	}

	public void notifierChangement() {
		super.setChanged();
		super.notifyObservers();
	}

	public Perspective getPerspectiveById(int id) {
		if (illustration == null) {// in which case you should paint a black
			System.out.println("Il n'y a pas d'illustation");// rectangle
			return null;
		}
		return illustration.getPerspectiveById(id);
	}

	public Illustration getIllustration() {
		return illustration;
	}

	public Image getImage() {
		return image;
	}

	// public void createIllustration(Image img) {
	public void createIllustration() {
		File fichierImage = new File("default.jpg");
		image = null;
		try {
			image = ImageIO.read(fichierImage);
		} catch (IOException e) {
		}
		if (illustration == null) {
			illustration = new Illustration();
		}
	}

	public void open(String name) {// open quelque chose
		/*
		 * Créé l'insatance d'un objet avec une sauvegarde
		 * 
		 * http://www.tutorialspoint.com/java/java_serialization.htm
		 */
		if (name.split("\\.")[1].equals("fif")) {
			try {
				FileInputStream fileIn = new FileInputStream(name);
				ObjectInputStream in = new ObjectInputStream(fileIn);
				illustration = (Illustration) in.readObject();
				in.close();
				fileIn.close();
				notifierChangement();
			} catch (IOException i) {
				i.printStackTrace();

				return;
			} catch (ClassNotFoundException c) {
				System.out.println(" Illustration not found");
				c.printStackTrace();
				return;
			}
		}
		/*
		 * fin du code emprunté
		 */
		if (name.split("\\.")[1].equals("jpg")) {
			File fichierImage = new File(name);
			try {
				image = ImageIO.read(fichierImage);
			} catch (IOException e) {
			}
			notifierChangement();
		}
	}

	public void save(String path) {
		path = path + ".fif";
		/*
		 * Créé un sauvegare de l'insatance d'un objet
		 * 
		 * http://www.tutorialspoint.com/java/java_serialization.htm
		 */
		try {
			FileOutputStream fileOut = new FileOutputStream(path);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(illustration);
			out.close();
			fileOut.close();
		} catch (IOException i) {
			i.printStackTrace();
		}
		/*
		 * fin du code emprunté
		 */
	}
}
