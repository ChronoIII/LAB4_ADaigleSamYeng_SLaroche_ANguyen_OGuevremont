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
	private int zoom = 100;
	private Controleur controleur;

	public VueModifiable(int id, Image image, Controleur contrl) {
		this.image = image;
		this.id = id;
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
		zoom = (int) (base.getZoom() * 100);
		repaint();
	}

	public void paintComponent(Graphics g) {

		super.paintComponent(g);
		g.drawImage(image, x, y, zoom, zoom, this);
		g.drawRect(0,0 , 100, 100);
		

	}

	public int getId() {
		return (this.id);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}

}
