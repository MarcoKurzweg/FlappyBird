package model;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Timer;

public class PipeManager {

	private ArrayList<Pipes> pipes = new ArrayList<>();
	
	public PipeManager() {
		
	}
	
	public void movePipes() {
		for(Pipes pipe: pipes){
			pipe.getUpper().x -= 5;
			pipe.getLower().x -= 5;
			pipe.getUpperquer().x -= 5;
			pipe.getLowerquer().x -= 5;
		}
	}
	
	public void addPipe (){
		pipes.add(new Pipes());
	}
	
	public void removePipe(){
		if(pipes.get(0).getLower().x < -100)
			pipes.remove(0);
		
//		for (Pipes pipe : pipes){
//			if(pipe.getUpper().x == 100){
//				pipes.remove(pipe);
//			}
//		}
	}
	
	public ArrayList<Pipes> getPipes() {
		return pipes;
	}
}
