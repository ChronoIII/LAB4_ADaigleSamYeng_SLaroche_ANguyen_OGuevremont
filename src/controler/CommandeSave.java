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

import javax.swing.JOptionPane;

import model.*;

public class CommandeSave extends Commande {

	public CommandeSave() {
	}

	@Override
	public void execute() {
		try {
			String name = JOptionPane
					.showInputDialog("Quel nom voulez-vous donner à votre fichier?");
			while (!name.matches("[a-zA-Z0-9]+")) {
				name = JOptionPane
						.showInputDialog("Veuillez n'entrer que des lettres ou des chiffres. Quel nom voulez-vous donner à votre fichier?");
			}
			Modele.getInstance().save(name);
		} catch (NullPointerException e) {
		}
	}
}
