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

package controler;

import model.*;

public class CommandeSave extends Commande {
	
	private String nameSave = "";

	public CommandeSave() {
		nameSave = "illu1";
	}
	
	@Override
	public void execute() {
		Modele.getInstance().save(nameSave);
	}
}
