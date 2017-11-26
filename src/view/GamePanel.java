package view;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Pipes;


public class GamePanel extends JPanel{

	private Rectangle bird = new Rectangle();
	private Rectangle gras;
	private ArrayList<Pipes> pipes = new ArrayList<>();
	private int score; 
	JLabel wert = new JLabel(""+score);
	JLabel end = new JLabel("");
	JButton back = new JButton("Hauptmenü");
	private int velocity;
	
	
	public GamePanel(){
		setLayout(null);
		wert.setBounds(800, 20, 50, 50);
		wert.setFont(new Font("Arial", Font.BOLD,24));
		wert.setForeground(Color.WHITE);
		add(wert);
		end.setBounds(300, 100, 400, 300);
		end.setFont(new Font("Algerian", Font.ITALIC, 48));
		end.setForeground(Color.RED);
		add(end);
	

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		ImageIcon background = new ImageIcon("src/background.png");
		Image bg = background.getImage();
		ImageIcon flappy = new ImageIcon("src/Flappy-Bird-Up.png");
		Image fl = flappy.getImage();
		Image fla = fl.getScaledInstance(bird.width, bird.height, java.awt.Image.SCALE_SMOOTH);
		flappy = new ImageIcon(fla);
		ImageIcon flappy2 = new ImageIcon("src/Flappy-Bird-Down.png");
		Image fl2 = flappy2.getImage();
		Image fla2 = fl2.getScaledInstance(bird.width, bird.height, java.awt.Image.SCALE_SMOOTH);
		flappy2 = new ImageIcon(fla2);
		ImageIcon flappy3 = new ImageIcon("src/Flappy-Bird.png");
		Image fl3 = flappy3.getImage();
		Image fla3 = fl3.getScaledInstance(bird.width, bird.height, java.awt.Image.SCALE_SMOOTH);
		flappy3 = new ImageIcon(fla3);
		
		
		
		g.drawImage(bg, 0 ,0, null);
		if(velocity <= -4){
		g.drawImage(fla, bird.x, bird.y, null);
		}
		if(velocity >= 4){
			g.drawImage(fla2, bird.x, bird.y, null);
		}
		if(velocity <=3 && velocity >= -3){
			g.drawImage(fla3, bird.x, bird.y, null);
		}
		for(Pipes pipe: pipes){
			g.setColor(new Color(0,0,0));
			g.drawRect(pipe.getUpper().x, pipe.getUpper().y, pipe.getUpper().width, pipe.getUpper().height);
			g.drawRect(pipe.getLower().x, pipe.getLower().y, pipe.getLower().width, pipe.getLower().height);
			
			ImageIcon rohr = new ImageIcon("src/Röhre.png");
			Image ro = rohr.getImage();
			Image roh = ro.getScaledInstance(50, pipe.getLower().height, java.awt.Image.SCALE_SMOOTH);
			rohr = new ImageIcon(roh);
			
			ImageIcon rohr2 = new ImageIcon("src/Röhre.png");
			Image ro2 = rohr2.getImage();
			Image roh2 = ro2.getScaledInstance(50, pipe.getUpper().height, java.awt.Image.SCALE_SMOOTH);
			rohr2 = new ImageIcon(roh2);
			
			ImageIcon rohr3 = new ImageIcon("src/deckel.jpg");
			Image ro3 = rohr3.getImage();
			Image roh3 = ro3.getScaledInstance(60, 30, java.awt.Image.SCALE_SMOOTH);
			rohr3 = new ImageIcon(roh3);
			
			g.drawImage(roh, pipe.getLower().x, pipe.getLower().y, null);
			g.drawImage(roh2, pipe.getUpper().x, pipe.getUpper().y, null);
			g.drawImage(roh3, pipe.getUpperquer().x, pipe.getUpperquer().y, null);
			g.drawImage(roh3, pipe.getLowerquer().x, pipe.getLowerquer().y, null);
			
		
		}	
	}
	
	public void setBird(Rectangle bird) {
		this.bird = bird;
	}
	
	public void setPipes(ArrayList<Pipes> pipes) {
		this.pipes = pipes;
	}
	
	public void setScore(int score) {
		
		this.score = score;
		wert.setText(""+score);
	}
	public void setEnd(){
		end.setText("Game Over");
//		add(back);
		
	}
	public void setVelocity(int velocity){
		this.velocity = velocity;
	}
	public JButton GetBack ( ){
		return back;
	}

}
