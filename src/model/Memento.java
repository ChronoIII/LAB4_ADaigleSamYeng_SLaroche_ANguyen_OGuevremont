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

import java.io.Serializable;

public class Memento implements Serializable{//les memento doivent être serializable pour que l'illustration soit serializable
	private String state;

	/**
	 * toute l'état des l'image est conserv. dans un string
	 * @param state
	 */
	public Memento(String state) {
		this.state = state;
	}

	/**
	 * 
	 * @return
	 */
	public String getState() {
		return state;
	}
}
