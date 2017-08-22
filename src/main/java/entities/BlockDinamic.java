package entities;
import framework.GameObject;
import until.Enums.ObjectId;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Graphics2D;
import until.Constants;
import entities.Player;
import until.Assets;
import until.Enums.Direction;

public class BlockDinamic extends GameObject{

	private int width;
	private int height;
	private Assets assets;
	private Direction direction;
	private float positionX;
	private float positionY;

	public BlockDinamic(float x, float y, ObjectId id, int width, int height, Assets assets, Direction direction){
		super(x , y, id);
		this.width = width;
		this.height = height;
		this.assets = assets;
		this.direction = direction;
		positionX = x;
		positionY = y;
		moving  = true;
	}

	public void update(double delta){

		x += velocityX * (float)delta;
		y += velocityY * (float)delta;

		if(direction == Direction.VETICAL || direction == Direction.HORIZONTAL){
			blockLimit();
		}
		

	}
	
	public void render(Graphics g){

		g.drawImage(assets.platformBlue, (int)x, (int)y, width, height, null);
		
	}

	public void blockLimit()
	{
		if(direction == Direction.VETICAL){
			if (y >= positionY) {
				velocityY = -5;	
			}
			if (y <= (positionY - 200)) {
			velocityY = 5;
			}
		}

		if(direction == Direction.HORIZONTAL){
			if(x >= (Constants.GAME_WINDOW_WIDTH * 9)){
				velocityX = -5;
			}else if(x <= ((Constants.GAME_WINDOW_WIDTH * 7) + 500)){
				velocityX = 5;
			}
		}

		
	}

	public Rectangle getBounds(){
		return new Rectangle(
			(int)x + 50, 
			(int)y + 40 /2 , 
			width - 80,
			height - 80);
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