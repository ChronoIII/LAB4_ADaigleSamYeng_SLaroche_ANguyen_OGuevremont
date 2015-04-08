/******************************************************
Cours:   LOG121
Session: H2015
Groupe: 03
Projet: Laboratoire # 4
�tudiant(e)s: Samuel Laroche, Olivier G�vremont, Am�lie Nguyen, Alexemdre Daigle-Sam yeng
              
              
Charg� de cours : Francis Cardinal
Charg� de laboratoire : Patrice Boucher
Date cr��: 2015-05-01
*******************************************************
Historique des modifications
*******************************************************
2015-05-01 Version initiale
*******************************************************/ 

package model;

import java.util.Observable;
import java.awt.Image;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

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

	public void open(String path) {// open quelque chose
		/*
		 * Cr�� l'insatance d'un objet avec une sauvegare
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
		  *  fin du code empeinter
		  */
	}

	public void save(String path) {
		path = path + ".fif";
		/*
		 * Cr�� un sauvegare de l'insatance d'un objet
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
		  *  fin du code empeinter
		  */
	}
}
