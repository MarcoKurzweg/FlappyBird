package main;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class StartPanel extends JPanel {

	public StartPanel(){
		
		
		
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		ImageIcon background = new ImageIcon("src/background.png");
		Image bg = background.getImage();
		ImageIcon flappy = new ImageIcon("src/Flappy-Bird.png");
		Image fl = flappy.getImage();
		Image fla = fl.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);
		flappy = new ImageIcon(fla);

		g.drawImage(bg, 0 ,0, null);
		g.drawImage(fla, 430 ,200, null);
	}
	
}
