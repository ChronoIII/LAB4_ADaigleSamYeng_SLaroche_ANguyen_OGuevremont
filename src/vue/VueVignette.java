package vue;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import model.Modele;
import model.Perspective;
import controler.Controleur;

public class VueVignette extends VueModifiable {
	private int width = 250;
	private int height = 250;

	public VueVignette(int id, Image image, Controleur aControleur) {
		super(id, image, aControleur);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(super.getImage(), 0, 0, 250, 250, this);
		Perspective p = Modele.getInstance().getPerspectiveById(1);
		g.drawRect((int) (-p.getX() / p.getZoom()),
				(int) (-p.getY() / p.getZoom()), (int) (width / p.getZoom()),
				(int) (height / p.getZoom()));
		p = Modele.getInstance().getPerspectiveById(2);
		g.drawRect((int) (-p.getX() / p.getZoom()),
				(int) (-p.getY() / p.getZoom()), (int) (width / p.getZoom()),
				(int) (height / p.getZoom()));
	}
}
