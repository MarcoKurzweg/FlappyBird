package main;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class SteuerungPanel extends JPanel {
	
	public SteuerungPanel(){
	
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		
		ImageIcon background = new ImageIcon("src/Steuerung.png");
		Image bg = background.getImage();
		Image bag = bg.getScaledInstance(600, 600, java.awt.Image.SCALE_SMOOTH);
		background = new ImageIcon(bag);
		
		
		g.drawImage(bag, 0 ,0, null);
	}
}
