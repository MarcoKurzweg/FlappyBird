package controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.Timer;
import javax.sound.sampled.*;
import java.io.*;

import model.Bird;
import model.PipeManager;
import model.Pipes;
import view.GameFrame;
import view.GamePanel;
import main.StartMenu;

public class Controller {

	private PipeManager pipeManager;
	private Bird bird;
	private GameFrame frame;
	private GamePanel panel;
	private Timer timer;
	private Pipes pip;
	int counter;
	private ArrayList<Pipes> pipes = new ArrayList<>();
	String fly = "src/flug.wav";
	String crash = "src/crash.wav";
	String success = "src/success.wav";
	int score;
	int highscore;

	JButton main = new JButton("Main");
	
	public Controller() {

		readUser("src/Highscore.txt");
		
		panel = new GamePanel();
		bird = new Bird();
		panel.setBird(bird.getBird());
		pipeManager = new PipeManager();
		pipeManager.addPipe();
		panel.setPipes(pipeManager.getPipes());
		bird.fallDown();
		panel.setScore(bird.getScore());
		pipes = pipeManager.getPipes();
		pip = new Pipes();
		main.setBounds(400, 400, 100, 50);
		main.setBackground(Color.ORANGE);
		main.setFont(new Font("Arial", Font.BOLD, 20));
		main.setForeground(Color.WHITE);
		
		main.addActionListener(new java.awt.event.ActionListener(){
			
			@Override
			public void actionPerformed( java.awt.event.ActionEvent ae) {
				
					buttonActionPerformed(ae);
					StartMenu menu = new StartMenu();
			}
						
					
				});
		frame = new GameFrame();
		frame.add(panel);
		frame.addKeyListener (new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_SPACE){
					bird.jump();
			 }

				
				try {
					AudioInputStream stream = AudioSystem.getAudioInputStream(new File(fly));
					AudioFormat af = stream.getFormat();
					int size = (int) (af.getFrameSize() * stream.getFrameLength());
					byte[] audio  = new byte[size];
					DataLine.Info info = new DataLine.Info(Clip.class, af, size);
					stream.read(audio, 0, size);
					
					// for(int i=0; i < 32; i++) {
					Clip clip = (Clip) AudioSystem.getLine(info);
					clip.open(af, audio, 0, size);
					clip.start();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		counter = 0;
		timer = new Timer(30, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				counter++;
					
				update();
				
				panel.repaint();

			}	
		});
		timer.start();


	}

	public void buttonActionPerformed(java.awt.event.ActionEvent ae){
		frame.dispose();
	}
	
	private boolean checkCollision() {
		boolean collides = false;
		for(Pipes pipe : pipes){
			if(bird.getBird().intersects(pipe.getLower())  || bird.getBird().intersects(pipe.getUpper()) || bird.getBird().intersects(pip.getGround())
					|| bird.getBird().intersects(pip.getSky())){
				collides = true;
				timer.stop();
				panel.setEnd();  
				panel.add(main);
				try {
					AudioInputStream stream = AudioSystem.getAudioInputStream(new File(crash));
					AudioFormat af = stream.getFormat();
					int size = (int) (af.getFrameSize() * stream.getFrameLength());
					byte[] audio  = new byte[size];
					DataLine.Info info = new DataLine.Info(Clip.class, af, size);
					stream.read(audio, 0, size);
					
					// for(int i=0; i < 32; i++) {
					Clip clip = (Clip) AudioSystem.getLine(info);
					clip.open(af, audio, 0, size);
					clip.start();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if (bird.getScore() > highscore){
				saveUser("src/Highscore.txt");
				}
			}
			else {
				collides = false;
			}	
		}
		return collides;
		
	}
	
	private void update () {
		
		if (counter == 60){
			pipeManager.addPipe();
			counter = 0;
		}
		bird.fallDown();
		panel.setVelocity(bird.getVelocity());
		pipeManager.movePipes();
		if (checkCollision()){
			
			}

		panel.setBird(bird.getBird());
		panel.setPipes(pipeManager.getPipes());
		

		for(Pipes pipe : pipes){
		if(bird.getBird().x == (pipe.getUpper().x) + 50){
		bird.increaseScore();
		try {
			AudioInputStream stream = AudioSystem.getAudioInputStream(new File(success));
			AudioFormat af = stream.getFormat();
			int size = (int) (af.getFrameSize() * stream.getFrameLength());
			byte[] audio  = new byte[size];
			DataLine.Info info = new DataLine.Info(Clip.class, af, size);
			stream.read(audio, 0, size);
			
			// for(int i=0; i < 32; i++) {
			Clip clip = (Clip) AudioSystem.getLine(info);
			clip.open(af, audio, 0, size);
			clip.start();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			}
		}
		
		panel.setScore(bird.getScore());
		panel.repaint();
		pipeManager.removePipe();
	}
	public void saveUser (String filePath) {
		File outputFile;
		BufferedWriter outputWriter;
		
		try {
			outputFile = new File(filePath);
			outputWriter = new BufferedWriter (new FileWriter(outputFile));
			
			score = bird.getScore();
				outputWriter.write((Integer.toString(score)));
			
			
			
			outputWriter.close();
		} catch (Exception e){
			e.printStackTrace();
		}
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
}


