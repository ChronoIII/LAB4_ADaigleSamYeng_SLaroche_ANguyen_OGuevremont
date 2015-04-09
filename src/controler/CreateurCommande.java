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

public class CreateurCommande {

	public CommandeZoom zoom(int aId, int aVariation) {
		return new CommandeZoom(aId, -aVariation*0.05);
	}

	public CommandeFermer fermer() {
		return new CommandeFermer();
	}

	public CommandeOpen open(String path) {
		return new CommandeOpen(path);
	}

	public CommandeDeplacer deplacer(int aId, int aVariationX,
			int aVariationY) {
		return new CommandeDeplacer(aId, aVariationX, aVariationY);
	}

	public CommandeSave save() {
		return new CommandeSave();
	}

	public CommandeUndo undo(int id) {
		return new CommandeUndo(id);
	}

}
