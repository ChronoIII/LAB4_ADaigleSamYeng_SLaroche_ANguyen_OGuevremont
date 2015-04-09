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

package controler;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import model.Modele;

public class CommandeOpen extends Commande {

	private String name;

	public CommandeOpen() {

	}

	@Override
	public void execute() {
		JFileChooser choix = new JFileChooser();
		FileNameExtensionFilter filtreA = new FileNameExtensionFilter(
				"FIF save", "fif");
		FileNameExtensionFilter filtreB = new FileNameExtensionFilter("JPEG",
				"jpg");
		choix.addChoosableFileFilter(filtreA);
		choix.addChoosableFileFilter(filtreB);
		choix.showOpenDialog(null);
		choix.resetChoosableFileFilters();
		try {
			name = choix.getSelectedFile().getName();
			Modele.getInstance().open(name);
			System.out.println(name);
		} catch (Exception ee) {
		}
	}
}
