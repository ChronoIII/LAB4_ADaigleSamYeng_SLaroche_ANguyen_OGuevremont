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

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import javax.imageio.ImageIO;

public class Illustration implements Serializable {//l'illustration peut être sauvegarder en fichier

	private Perspective[] perspectives;

	/**
	 * constructeur
	 */
	public Illustration() {
		Perspective vignette = new Vignette();
		Perspective premPers = new Perspective();
		Perspective deuxPers = new Perspective();
		perspectives = new Perspective[3];
		perspectives[0] = vignette;
		perspectives[1] = premPers;
		perspectives[2] = deuxPers;
	}

	/**
	 * getter pour les persperctives
	 * @param id
	 * @return perspective
	 */
	public Perspective getPerspectiveById(int id) {
		Perspective perspective = new Perspective();
		for (Perspective p : perspectives) {
			if (p.getId() == id) {
				perspective = p;
				break;
			}
		}
		return perspective;
	}
}
