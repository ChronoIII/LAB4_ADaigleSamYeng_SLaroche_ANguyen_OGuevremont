package vue;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import controler.Controleur;
import model.*;

public class VueModifiable extends JPanel implements Observer {

	private int id;
	private Image image;
	private int x;
	private int y;
	private double zoom;
	private Controleur controleur;

	public VueModifiable(int id, Image image, Controleur contrl) {
		this.image = image;
		
	}

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

	public void paintComponent(Graphics g) {

		super.paintComponent(g);
		g.drawImage(image, 0, 0, 100, 100, this);

	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

	
}
