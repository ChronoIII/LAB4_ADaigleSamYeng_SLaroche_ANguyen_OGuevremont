package vue;

import java.awt.*;

import javax.swing.JPanel;

import model.*;

public class VueModifiable extends JPanel {

	private int id;
	private Image image;
	private int x;
	private int y;
	private double zoom;

	
	public void update() {
		Perspective base = null;
		try {
			base = Modele.getInstance().getPerspectiveById(id);
		} catch (NoIllustrationException e) {
			System.out.println(e.getMessage());
			System.exit(1);
		}
		x = base.getX();
		y = base.getY();
		zoom = base.getZoom();
		repaint();
	}
	
	public void paintComponent(Graphics g){}
}
