package entities;
import until.Enums.Facing;
import until.Enums.JumpState;
import until.Enums.ObjectId;
import java.awt.Graphics;
import java.awt.Rectangle;
import until.Enums.BinState;
import until.Enums.WalkState;
import until.Enums.JumpState;
import java.util.LinkedList;
import framework.GameObject;
import java.awt.Color;
import until.Constants;
import java.awt.Graphics2D;


public class PortalA extends GameObject{



	public PortalA(float x, float y, ObjectId id){
		super(x, y, id);
	}


	public void update(double delta){

	}

	public void render(Graphics g){
		Graphics2D g2d = (Graphics2D) g; 
		g.setColor(new Color(252, 85, 246));
		g2d.draw(getBounds());

	}

	public Rectangle getBounds(){
		return new Rectangle(
			(int)x + (Constants.PORAL_A_OFFSET_X / 2),
			(int)y + (Constants.PORAL_A_OFFSET_Y),
			Constants.PORAL_A_RECTANGLE_WIDHT,
			Constants.PORAL_A_RECTANGLE_HEIGHT
			);
	}
	public Rectangle getBoundsTop(){return null;}
	public Rectangle getBoundsRight(){return null;}
	public Rectangle getBoundsLeft(){return null;}





}