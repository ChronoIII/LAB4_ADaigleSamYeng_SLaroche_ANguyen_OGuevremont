/**
 * 
 */
package vue;

import java.util.*;

import javax.swing.*;

import model.*;

/**
 * @author Samuel
 *
 */
public class Fenetre extends JFrame implements Observer {

	private VueVignette vignette;
	private VueModifiable[] vues;
	private JMenuBar menuBar;

	@Override
	public void update(Observable arg0, Object arg1) {
		for (VueModifiable vm : vues) {
			vm.update();
		}
	}

}
