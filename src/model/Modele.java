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

	private Modele() {
		createIllustration();
	}

	public static Modele getInstance() {
		if (instance == null) {
			instance = new Modele();
			
		}
		return instance;
	}

	public Perspective getPerspectiveById(int id) {
		if (illustration == null) {// in which case you should paint a black
			System.out.println("Il n'y a pas d'illustation");// rectangle
			return null;
		}
		return illustration.getPerspectiveById(id);
	}

	//public void createIllustration(Image img) {
	public void createIllustration() {
		if (illustration == null) {
			File fichierImage = new File("image.jpg");
			Image image = null;
			try {
				image = ImageIO.read(fichierImage);
			} catch (IOException e) {
			}
			illustration = new Illustration(image);
		}
	}

	public void open(String path) {// open quelque chose
		/*
		 * Créé l'insatance d'un objet avec une sauvegare
		 * 
		 * http://www.tutorialspoint.com/java/java_serialization.htm
		 */

		try {

			FileInputStream fileIn = new FileInputStream(path);
			ObjectInputStream in = new ObjectInputStream(fileIn);
			illustration = (Illustration) in.readObject();
			in.close();
			fileIn.close();

		} catch (IOException i) {
			i.printStackTrace();

			return;
		} catch (ClassNotFoundException c) {
			System.out.println(" Illustration not found");
			c.printStackTrace();

			return;
		}
		/*
		 * fin du code emprunté
		 */
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
