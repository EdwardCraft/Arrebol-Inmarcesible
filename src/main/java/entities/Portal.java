package entities;
import until.Enums.ObjectId;
import framework.GameObject;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Graphics2D;
import until.Constants;


public class Portal extends GameObject{


	public Portal(float x, float y, ObjectId id){
		super( x, y, id);
	}


	public void update(double delta){

	}


	public void render(Graphics g){
		Graphics2D g2d = (Graphics2D) g; 
		g.setColor(Color.BLUE);
		g2d.draw(getBounds());
	}


	public Rectangle getBounds(){ 
		return new Rectangle(
			(int)x,
			(int)y,
			Constants.PORTAL_RECTANGLE_WIDTH,
			Constants.PORTAL_RECTANGLE_HEIGHT
			);
	}
	public Rectangle getBoundsTop(){return null;}
	public Rectangle getBoundsRight(){return null;}
	public Rectangle getBoundsLeft(){return null;}








}