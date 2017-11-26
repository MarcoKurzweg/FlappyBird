package model;
import java.awt.Rectangle;

import values.Values;

public class Pipes{

	private Rectangle upper;
	private Rectangle upperquer;
	private Rectangle lower;
	private Rectangle lowerquer;
	private Rectangle ground, sky;
	public int randomHeight;
	
	public Pipes() {
		// TODO Auto-generated constructor stub
		randomHeight = (int)(Math.random() * 360) + 20;
		upper = new Rectangle(900, 0, 50, randomHeight);
		lower = new Rectangle(900, randomHeight + Values.PIPE_GAP , 50, 503-randomHeight - Values.PIPE_GAP);
		upperquer = new Rectangle(895, randomHeight - 30, 60, 30);
		lowerquer = new Rectangle(895, randomHeight + Values.PIPE_GAP, 60, 30);
		ground = new Rectangle(0,503,900,2 );
		sky = new Rectangle ( 0,-2,900,1);
	}
	
	public Rectangle getUpper() {
		return upper;
	}
	
	public Rectangle getLower() {
		return lower;
	}
	
	public Rectangle getUpperquer(){
		return upperquer;
	}
	public Rectangle getLowerquer(){
		return lowerquer;
	}
	public Rectangle getGround(){
		return ground;
	}
	public Rectangle getSky(){
		return sky;
	}
}
