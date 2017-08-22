package entities;

import framework.GameObject;
import until.Enums.ObjectId;
import java.awt.Graphics;
import java.awt.Rectangle;
import until.Enums.RectangleBounds;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import until.Constants;
import java.awt.Graphics2D;
import java.awt.Color;
import until.Assets;


public class ContainerCan extends GameObject{

	private Assets assets;

	public ContainerCan(float x, float y, ObjectId id, Assets assets){
		super(x, y, id);
		this.assets = assets;

	}


	public void update(double delta){

	}


	public void render(Graphics g){
		g.drawImage(assets.canBin, (int)x , (int)y , null);
	}





	public Rectangle getBounds(){
		return new Rectangle(
				(int)x ,
				(int)y ,
				Constants.BIN_RECTANGLE_WIDHT,
				Constants.BIN_RECTANGLE_HEIGHT
			);
	}

	public Rectangle getBoundsTop(){
		return null;
	}
	public Rectangle getBoundsRight(){
		return null;
	}
	public Rectangle getBoundsLeft(){
		return null;
	}



}