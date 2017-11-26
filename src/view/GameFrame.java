package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

public class GameFrame extends JFrame {

	JButton a = new JButton("Menu");
	
	private GamePanel gamePanel = new GamePanel();
	public GameFrame() {
		// TODO Auto-generated constructor stub
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		setSize(900,600);
		setTitle("FlappyBird");
		getContentPane();
		setLocationRelativeTo(null);
	
	}
	

	public GamePanel getGamePanel() {
		return gamePanel;
	}
	
}
