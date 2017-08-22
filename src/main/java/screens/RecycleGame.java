package screens;

import java.util.LinkedList;
import java.awt.Graphics;
import framework.GameObject;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import until.Constants;
import until.Enums.ObjectId;
import java.awt.Color;
import java.awt.Font;
import until.Enums.BinState;
import framework.Game;
import overlays.HubMiniGame;
import entities.ContainerCan;
import entities.Can;
import entities.ContainerFood;
import entities.ContainerPaper;
import entities.Food;
import entities.Paper;
import until.Assets;

public class RecycleGame{


	private LinkedList<GameObject> gameObjects;
	private LinkedList<GameObject> canObjects;
	private LinkedList<GameObject> tempCanObjects;
	private GameObject tempObject;
	private Font font; 
	private HubMiniGame hud;
	private int gameWidth;
	private int gameHeight;
	private Game game;
	private Assets assets;


	public RecycleGame( Game game, LinkedList<GameObject> tempCanObjects, Assets assets){
		this.game = game;
		this.assets = assets;
		this.tempCanObjects = tempCanObjects;
		gameObjects = new LinkedList<GameObject>();
		canObjects = new LinkedList<GameObject>();
		hud = new HubMiniGame( canObjects, game);
		debugLevel();
	}

	public void update(double delta){

		for(int i = 0; i < gameObjects.size(); i ++ ){
			tempObject = gameObjects.get(i);
			tempObject.update(delta);
		}

		if(canObjects != null){
			for(int j = 0; j < canObjects.size(); j++ ){
				canObjects.get(j).update(delta);
			}
		}

		hud.update(delta);

	}

	public void render(Graphics g ){
		
		g.drawImage(assets.levelOne[0], 0, 0, Constants.GAME_WINDOW_WIDTH + 10, Constants.GAME_WINDOW_HEIGHT + 10,null);

		for(GameObject gameObject : gameObjects){
			gameObject.render(g);
		}

		if(canObjects != null){
			for(GameObject can : canObjects){
				can.render(g);
			}
		}


		hud.render(g);

		if(hud.getCountDown() == 0){
			g.setColor(new Color(0f,0f,0f,.7f));
	    	g.fillRect(0, 0, gameWidth + 10, gameHeight + 10);
		}

	}	

	public void addObject(GameObject object, BinState state){
		if(state == BinState.BIN){
			gameObjects.add(object);
		}
		if((state == BinState.METAL) || (state == BinState.FOOD) || (state == BinState.PLASTIC)){
			canObjects.add(object);
		}
	
	}
	
	public void removeObject(GameObject object, BinState state){
		if(state == BinState.BIN){
			gameObjects.remove(object);
		}
		if((state == BinState.METAL) || (state == BinState.FOOD) || (state == BinState.PLASTIC)){
			canObjects.remove(object);
		}

	}

	public void debugLevel(){

		addObject(new ContainerCan(
			Constants.METAL_BIN_POSITION_X, 
			Constants.METAL_BIN_POSITION_Y , 
			ObjectId.metalBin,
			assets),
			BinState.BIN);

		addObject(new ContainerFood(
			Constants.FOOD_BIN_POSITION_X , 
			Constants.FOOD_BIN_POSITION_Y , 
			ObjectId.foodBin,
			assets),
			BinState.BIN
			);

		addObject(new ContainerPaper(
			Constants.PLASTIC_BIN_POSITION_X , 
			Constants.PLASTIC_BIN_POSITION_Y, 
			ObjectId.plasticBin,
			assets),
			BinState.BIN
			);

		int positionY;

		for(int i = 0; i < tempCanObjects.size(); i++){
			GameObject object = tempCanObjects.get(i);
			positionY = -(i * 100);

			if(object.getObjectId() == ObjectId.foodTrash){
				canObjects.add(new Food( (Constants.GAME_WINDOW_WIDTH / 2) - 50 , positionY, ObjectId.foodTrash, this, hud, 1, assets));
			}else if(object.getObjectId() == ObjectId.metalTrash){
				canObjects.add(new Can( (Constants.GAME_WINDOW_WIDTH / 2) - 50 , positionY, ObjectId.metalTrash, this, hud, 1, assets));
			}else if(object.getObjectId() == ObjectId.plasticTrash){
				canObjects.add(new Paper( (Constants.GAME_WINDOW_WIDTH / 2) - 50 , positionY, ObjectId.plasticTrash, this, hud, 1, assets));
			}
		}


	
	}

	public LinkedList<GameObject> getGameObjects(){
		return gameObjects;
	}

	public LinkedList<GameObject> getTrashObjects(){
		return canObjects;
	}

	public HubMiniGame getHud(){
		return hud;
	}

	public LinkedList<GameObject> getTempCanObjects(){return tempCanObjects;}


}