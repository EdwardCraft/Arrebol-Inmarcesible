package screens;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Graphics2D;
import until.Constants;
import entities.Ladder;
import until.Enums.ObjectId;
import framework.GameObject;
import java.util.LinkedList;
import entities.Spider;
import entities.Block;
import entities.Player;
import until.Assets;
import framework.Game;
import screens.World;
import until.Enums.ScreenState;
import until.Enums.Bench;
import until.Enums.Bin;
import until.Enums.EnemySprite;
import entities.GangstaWheel;

public class LadderGame{

	private Ladder ladder;
	private LinkedList<GameObject> gameObjects;
	private LinkedList<GameObject> blasts;

	private Player player;
	private Assets assets;
	private int gametWidth;
	private int gameHeight;
	private Game game;
	private GangstaWheel gangstaWheel;
	private GangstaWheel gangstaWheelTwo;
	private GangstaWheel gangstaWheelThree;
	private boolean stop;

	public LadderGame( Assets assets, Game game){
		this.assets = assets;
		this.game = game;
		ladder = new Ladder(0, 0, ObjectId.LadderMaster, assets);
		gameObjects = new LinkedList<GameObject>();
		blasts = new LinkedList<GameObject>();
		stop = false;
		debugObjects();

	}


	public void update(double delta){

		ladder.update(delta);
		if(!stop){
			gangstaWheel.update(delta, 0);
			gangstaWheelTwo.update(delta, 0);
			gangstaWheelThree.update(delta, 0);
		}
		

		if(player != null){ player.update(delta, ScreenState.LADDERGAME);}

		if(gameObjects != null){
	    	for(int  i = 0; i < gameObjects.size(); i++){
                gameObjects.get(i).update(delta);
	        }	
	    }

	    	//Killer BLast
		if(blasts != null){
			for(int i = 0; i < blasts.size(); i++){
				blasts.get(i).update(delta);
			}
		}

		
		endEnemys();
	}



	public void render(Graphics g){
		g.setColor(new Color(0, 0, 0));
	    g.fillRect(0, 0, Constants.GAME_WINDOW_WIDTH + 10, Constants.GAME_WINDOW_HEIGHT + 10);

	    gangstaWheel.render(g, 0);
	    gangstaWheelTwo.render(g, 0);
	    gangstaWheelThree.render(g, 0);

	 	for(int i = 0; i < Constants.GAME_WINDOW_WIDTH ; i += 150){
			g.drawImage(assets.factoryBock, i, 540, 150, 150,null);
		}

	   
	    ladder.render(g);
	    if(player != null){ player.render(g);}
	    if(gameObjects != null){
	    	for(int  i = 0; i < gameObjects.size(); i++){
                gameObjects.get(i).render(g);
	        }	
	    }


	    if(blasts != null){
			for(GameObject blast: blasts){
				blast.render(g);
				
			}	
		}




	}


	private void endEnemys(){
		 
		 if(gameObjects != null){
	    	for(int  i = 0; i < gameObjects.size(); i++){
                if(gameObjects.get(i).getObjectId() == ObjectId.Spider){
                	if(gameObjects.get(i).getHealth() == 0){
                		stop = true;
                	}		
                }
	        }	
	    }
	}

	public void debugObjects(){

		gangstaWheel = new GangstaWheel(
			Constants.GAME_WINDOW_WIDTH , 450, 
			ObjectId.Wheel, assets,  
			150 , 150, EnemySprite.WHEEL);

		gangstaWheelTwo = new GangstaWheel(
			Constants.GAME_WINDOW_WIDTH  + 500, 450, 
			ObjectId.Wheel, assets,  
			150 , 150, EnemySprite.WHEEL);

		gangstaWheelThree = new GangstaWheel(
			Constants.GAME_WINDOW_WIDTH  + 1000, 450, 
			ObjectId.Wheel, assets,  
			150 , 150, EnemySprite.WHEEL);



		player = new Player(
			100, Constants.GAME_WINDOW_HEIGHT - Constants.PLAYER_RECTANGLE_HEIGHT - 50, 
			ObjectId.Player,
			this,
			assets,
			game);

		addObject(new Spider(0, 0, 
			ObjectId.Spider, ladder, assets));

		addObject(new Block( 
			0,
			Constants.GAME_WINDOW_HEIGHT - Constants.BLOCK_HEIGHT + 10,
			ObjectId.Block,
			Constants.GAME_WINDOW_WIDTH ,
			Constants.BLOCK_HEIGHT,
			assets,
			Bench.NO_BENCH,
			Bin.NO_BIN));

	

	}


	public void addObject(GameObject object){gameObjects.add(object); }
	public void removeObject(GameObject object){ gameObjects.remove(object);}
	public LinkedList<GameObject> getGameObjects(){ return gameObjects;}
	public void addBlasts(GameObject blast){ blasts.add(blast);}
	public void removeBlasts(GameObject blast){ blasts.remove(blast);}

	public Player getPlayer(){return player;}
	public Game getGame(){return game;}

}