package main;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Highscore extends JFrame{
	
	JLabel score;
	JButton button = new JButton("Back");
	JLabel title = new JLabel("Your Highscore: ", SwingConstants.CENTER);
	int highscore;
	
	public Highscore(){
		readUser("src/Highscore.txt");
		JPanel high = new JPanel();
		
		ImageIcon background = new ImageIcon("src/backgroundstart.png");
		Image bg = background.getImage();
		Image bga = bg.getScaledInstance(900, 480, java.awt.Image.SCALE_SMOOTH);
		background = new ImageIcon(bga);
		
		score = new JLabel("" + highscore, SwingConstants.CENTER);
		
		high.setLayout(new BorderLayout());
		setSize(900, 600);
		setLocationRelativeTo(null);
		setTitle("Highscore");
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		title.setPreferredSize(new Dimension(900, 60));
		title.setOpaque(true);
		title.setBackground(Color.YELLOW);
		title.setFont(new Font("Arial", Font.BOLD, 20));
		title.setForeground(Color.BLACK);
		
		score.setBackground(Color.YELLOW);
		score.setOpaque(true);
		score.setFont(new Font("Arial", Font.BOLD, 80));
		
		button.setPreferredSize(new Dimension(900, 60));
		button.setBackground(Color.ORANGE);
		button.setFont(new Font("Arial", Font.BOLD, 20));
		button.setForeground(Color.WHITE);
		
		button.addActionListener(new java.awt.event.ActionListener(){
			
			@Override
			public void actionPerformed( java.awt.event.ActionEvent ae) {
				
					buttonActionPerformed(ae);
			}
		});
		
		high.add(score, BorderLayout.CENTER);
		high.add(button, BorderLayout.SOUTH);
		high.add(title, BorderLayout.NORTH);
		add(high);
	}
	public void readUser (String filePath) {
		File inputFile;
		BufferedReader inputReader;
		
		try {
			inputFile = new File(filePath);
			inputReader = new BufferedReader (new FileReader(inputFile));
			
				highscore = Integer.parseInt(inputReader.readLine());
				
				
			
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	public void buttonActionPerformed(java.awt.event.ActionEvent ae){
		this.dispose();
	}
}
