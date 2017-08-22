package entities;

import framework.GameObject;
import until.Enums.ObjectId;
import java.awt.Graphics;
import java.awt.Rectangle;
import until.Enums.RectangleBounds;
import until.Constants;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.awt.Graphics2D;
import java.awt.Color;
import until.Enums.BinState;
import screens.RecycleGame;
import java.lang.Math;
import java.util.Random;
import overlays.HubMiniGame;
import until.Assets;

public class Can extends GameObject{


	private float tempVelocity;
	private RecycleGame game;
	private GameObject gameObject;
	private Boolean knockback;
	private Boolean falling;
	private int maxVelocity;
	private Random rand = new Random();
	private int direction;
	private HubMiniGame hud;
	private float speed;
	private int select;
	private Assets assets;

	public Can(float x, float y, ObjectId id, Assets assets ,int select){
		super(x, y , id);
		this.game = game;
		this.hud = hud;
		this.select = select;
		this.assets = assets;
		knockback = false;
		falling = true;
		maxVelocity = 10;
		direction = 1;
		hit = false;
		speed = 1;
		binState = BinState.BIN;

		
	}



	public Can(float x, float y, ObjectId id, RecycleGame game, HubMiniGame hud, int select, Assets assets){
		super(x, y , id);
		this.game = game;
		this.hud = hud;
		this.select = select;
		this.assets = assets;
		knockback = false;
		falling = true;
		maxVelocity = 10;
		direction = 1;
		hit = false;
		speed = 1;
		binState = BinState.BIN;
	
	}


	public void update(double delta){


		if(select == 0){
			return;
		}

		if(hud != null){
			if(hud.getCountDown() == 20){
				speed = 1.5f;
			}
		}
	
		if(hud != null){
			if(hud.getCountDown() == 10){
				speed = 3f;
			}
		}
	

		if(velocityY < maxVelocity){
			y = y + (velocityY * (float)delta) + speed ;
		}else{
			y = y + (maxVelocity * (float)delta) + speed ;
		}

		if(binState == BinState.METAL && knockback == false){

			if(x > ( (Constants.GAME_WINDOW_WIDTH / 8))){
				x = x - (float)delta * (15 * speed);
				velocityY = 20 * speed;
			}

		}else if(binState == BinState.METAL && knockback == true){

			x -= (velocityX * (float)delta) * speed;

		}else if(binState == BinState.PLASTIC && knockback == false){

			if(x < (Constants.GAME_WINDOW_WIDTH - 250)){
				x = x + (float)delta * (15 * speed);
				velocityY = 20 * speed;
			}

		}else if(binState == BinState.PLASTIC && knockback == true){
			if(x > (Constants.GAME_WINDOW_WIDTH + 100)){
				removeAnAdObject();
			}else{
				x += (velocityX * (float)delta) * speed;	
			}
				
		}else if(binState == BinState.FOOD){
			velocityY += 1f * speed;
			if(direction == 1){
				if(x > -(200)){
					x -= (velocityX * (float)delta) ;
				}else{
					removeAnAdObject();
				}	
			}else{
				if(x < (Constants.GAME_WINDOW_WIDTH + 200)){
					x += (velocityX * (float)delta);
				}else{
					removeAnAdObject();
				}	
			}
		}else if(binState == BinState.BIN && knockback == true){
			velocityY += 1f * speed;
			if(direction == 1){
				if(x > -(200)){
					x -= (velocityX * (float)delta) ;
				}else{
					removeAnAdObject();
				}	
			}else{
				if(x < (Constants.GAME_WINDOW_WIDTH + 200)){
					x += (velocityX * (float)delta);
				}else{
					removeAnAdObject();
				}	
			}

		}





		if(falling && knockback){
			velocityY += 0.5f * speed;
		}

		if(y > Constants.GAME_WINDOW_HEIGHT){
			removeAnAdObject();
		}

	

		collisionMetalBin();
		collisionFoodBin();
		collisionPlasticBin();

	}


	public void render(Graphics g){

		g.drawImage(assets.can, (int)x, (int)y, null);

	}

	private void removeAnAdObject(){
		game.removeObject(this, BinState.METAL);
		hit = false;
	}


	private void collisionMetalBin(){
		for(int i = 0; i < game.getGameObjects().size(); i++){
			gameObject = game.getGameObjects().get(i);
			if(gameObject.getObjectId() == ObjectId.metalBin){
				if(getBounds().intersects(gameObject.getBounds())){
					hud.setScore(hud.getScore() + 1);
					removeAnAdObject();
				}
			}
		}
	}

	private void collisionFoodBin(){
		for(int i = 0; i < game.getGameObjects().size(); i++){
			gameObject = game.getGameObjects().get(i);
			if(gameObject.getObjectId() == ObjectId.foodBin){
				if(getBounds().intersects(gameObject.getBounds())){
					direction = rand.nextInt(2) + 1;
					knockback = true;
					velocityX = (Constants.TRASH_NOCKBACK_VELOCITY[0] );
					velocityY = -(Constants.TRASH_NOCKBACK_VELOCITY[1] + (speed * 10));
				}
			}
		}
	}

	private void collisionPlasticBin(){
		for(int i = 0; i < game.getGameObjects().size(); i++){
			gameObject = game.getGameObjects().get(i);
			if(gameObject.getObjectId() == ObjectId.plasticBin){
				if(getBounds().intersects(gameObject.getBounds())){
					knockback = true;
					velocityX = (Constants.TRASH_NOCKBACK_VELOCITY[0] );
					velocityY = -(Constants.TRASH_NOCKBACK_VELOCITY[1] + (speed * 10));
				}
			}
		}
	}

	public Rectangle getBounds(){
		return new Rectangle(
				(int)x + (Constants.TRASH_OFFSET_X / 2) ,
				(int)y + (Constants.TRASH_OFFSET_Y) ,
				Constants.TRASH_RECTANGLE_WIDTH,
				Constants.TRASH_RECTANGLE_HEIGHT
			);
	}

	public Rectangle getBoundsTop(){ return null; }
	public Rectangle getBoundsRight(){ return null;}
	public Rectangle getBoundsLeft(){ return null;}
	public float getSpeed(){ return speed;}
	public void setSpeed(float speed) { this.speed = speed;}


}