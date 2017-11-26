package main;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Steuerung extends JFrame {

	JButton back = new JButton("Back");
	SteuerungPanel p = new SteuerungPanel();
	public Steuerung(){
		
		
		
		p.setLayout(null);
		setSize(600, 600);
		setLocationRelativeTo(null);
		setTitle("Highscore");
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		

		back.setBounds(200, 450, 200, 50);
		back.setBackground(Color.ORANGE);
		back.setFont(new Font("Arial", Font.BOLD, 20));
		back.setForeground(Color.WHITE);
		
		back.addActionListener(new java.awt.event.ActionListener(){
			
			@Override
			public void actionPerformed( java.awt.event.ActionEvent ae) {
				
					buttonActionPerformed(ae);
					StartMenu menu = new StartMenu();
			}
		});
		
		p.add(back);
		add(p);
	}
	public void buttonActionPerformed(java.awt.event.ActionEvent ae){
		this.dispose();
	}
}
