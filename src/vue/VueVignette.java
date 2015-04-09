package vue;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import controler.Controleur;

public class VueVignette extends VueModifiable {

	public VueVignette(int id, Image image, Controleur aControleur) {
		super(id, image, aControleur);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(super.getImage(), 0, 0, 100, 100, this);
		g.drawRect(0, 0, 100, 100);
	}
}
