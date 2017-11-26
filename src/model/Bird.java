package model;

import java.awt.Rectangle;
import java.util.ArrayList;

public class Bird {

	private int velocity;
	private Rectangle rect;
	private int score;
	
	public Bird() {
		rect = new Rectangle(100, 300, 30, 30);
		
	}
	
	
	public void fallDown (){
		this.velocity += 1;
		rect.y += velocity;
		if ( velocity >= 10){
			velocity=10;
		}
	}
	
	
	public void jump () {
		this.velocity -= 10;
		if ( velocity <= -15){
			velocity = -15;
		}
	}
	
	public void increaseScore () {
		score = score + 1;
			}
	
	public int getScore() {
		return score;
	}
	
	
	
		public Rectangle getBird() {
		return rect;

	}
		public int getVelocity(){
			return velocity;
		}
}
