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

import java.io.Serializable;

public class Memento implements Serializable{//les memento doivent �tre serializable pour que l'illustration soit serializable
	private String state;

	/**
	 * toute l'�tat des l'image est conserv. dans un string
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
