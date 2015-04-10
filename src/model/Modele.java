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
	
	private static Modele instance;//l'instance du modèle pour n'avoir qu'un seule instance de cette classe qui est un singleton
	private Illustration illustration;
	private Image image;

	/**
	 * constructeur
	 */
	private Modele() {
		createIllustration();//la première création du l'illustration
	}

	/**
	 * 
	 * @return instance
	 */
	public static Modele getInstance() {//l'instanciation de la classe en singleton
		if (instance == null) {
			instance = new Modele();

		}
		return instance;
	}

	/**
	 * méthode pour faire les mise à jour avec les méthodes de la super class Observable
	 */
	public void notifierChangement() {
		super.setChanged();
		super.notifyObservers();
	}

	/**
	 * getter pour les perspectives
	 * @param id
	 * @return perspective
	 */
	public Perspective getPerspectiveById(int id) {
		if (illustration == null) {//s'il n'y a pas d'illustration, il ne va pas retourner de perspective
			System.out.println("Il n'y a pas d'illustation");
			return null;
		}
		return illustration.getPerspectiveById(id);
	}

	/**
	 * getter pour l'illustration
	 * @return illustration
	 */
	public Illustration getIllustration() {
		return illustration;
	}

	/**
	 * getter pour l'image utiliser par l'illustration
	 * @return image
	 */
	public Image getImage() {
		return image;
	}

	/**
	 * crée un illustration à partir d'une image, nous utilisons cette méthode pour créer la première illustration
	 */
	public void createIllustration() {
		File fichierImage = new File("default.jpg");
		image = null;
		try {
			image = ImageIO.read(fichierImage);
		} catch (IOException e) {
		}
		if (illustration == null) {//crée un illustration, s'il n'en exist aucune
			illustration = new Illustration();
		}
	}

	/**
	 * Permet d'ouvrire une image selon le lien qui est donné en paramètre
	 * @param name
	 */
	public void open(String name) {// open quelque chose
		/*
		 * Créé l'insatance d'un objet avec une sauvegarde
		 * 
		 * http://www.tutorialspoint.com/java/java_serialization.htm
		 */
		if (name.split("\\.")[1].equals("fif")) {//si l'utilisateur veut ouvrir un .fif
			try {
				FileInputStream fileIn = new FileInputStream(name);
				ObjectInputStream in = new ObjectInputStream(fileIn);
				illustration = (Illustration) in.readObject();//change l'illustration pour la sauvegarde sélectionner
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
		if (name.split("\\.")[1].equals("jpg")) {//si l'utilisateur veut ouvrir un .jpg
			File fichierImage = new File(name);
			try {
				image = ImageIO.read(fichierImage);//change l'image de l'illustration pour la nouvelle image
			} catch (IOException e) {
			}
			notifierChangement();
		}
	}

	/**
	 * permet de sauvegarder l'instance de l'illustration du moment, il demande un nom pour le fichier qui va être saugarder
	 * @param path
	 */
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
			out.writeObject(illustration);//sauvegarde de l'illustration 
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
