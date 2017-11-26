package main;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Image;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StartMenu extends JFrame{

	JPanel main;
	JLabel title;
	JButton start, highscore, anleitung;
	
	public StartMenu(){
		
		setVisible(true);
		setSize(900,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("FlappyBird");
		getContentPane();
		setLocationRelativeTo(null);
	
		JPanel main = new StartPanel();
		main.setLayout(null);
		
		JLabel title = new JLabel("FlappyBird");
		JLabel title2 = new JLabel("FlappyBird");
		
		JButton start = new JButton("Start");
		JButton highscore = new JButton("Highscore");
		JButton anleitung = new JButton("Anleitung");
		
		title.setBounds(270, 50, 500, 100);
		title.setFont(new Font("Arial", Font.BOLD, 70));
		title.setForeground(Color.WHITE);
		title2.setBounds(273, 53, 500, 100);
		title2.setFont(new Font("Arial", Font.BOLD, 70));
		title2.setForeground(Color.BLACK);
		
		start.setBounds(350, 310, 200, 50);
		start.setBackground(Color.ORANGE);
		start.setFont(new Font("Arial", Font.BOLD, 20));
		start.setForeground(Color.WHITE);
		highscore.setBounds(350, 380, 200, 50);
		highscore.setBackground(Color.ORANGE);
		highscore.setFont(new Font("Arial", Font.BOLD, 20));
		highscore.setForeground(Color.WHITE);
		anleitung.setBounds(350,450,200,50);
		anleitung.setBackground(Color.ORANGE);
		anleitung.setFont(new Font("Arial", Font.BOLD, 20));
		anleitung.setForeground(Color.WHITE);
		
		
		main.add(start);
		main.add(highscore);
		main.add(anleitung);
		main.add(title);
		main.add(title2);
		
		add(main);
		
		start.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent ae) {
				MainApp dlg = new MainApp();
				dispose();
				dlg.addWindowListener(new WindowAdapter() {
				
					
					@Override
					public void windowClosed(WindowEvent e) {

					}
						
					
				});
			}	
		});
		
		highscore.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent ae) {
				High dia = new High();
				dia.addWindowListener(new WindowAdapter() {
					
					
					@Override
					public void windowClosed(WindowEvent e) {

						
					}
						
					
				});
				}	
			});
		
		anleitung.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent ae) {
				SteuerungMain sm = new SteuerungMain();
				dispose();
				sm.addWindowListener(new WindowAdapter() {
					
					
					@Override
					public void windowClosed(WindowEvent e) {

						
					}
						
					
				});
				}	
			});
	}

	public static void main(String args[]){
		StartMenu menu = new StartMenu();
	}
	
}
