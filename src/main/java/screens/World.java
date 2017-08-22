package screens;
import java.awt.Graphics;
import until.Enums.ObjectId;
import java.util.LinkedList;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import until.Constants;
import java.awt.Color;
import java.awt.Font;
import framework.GameObject;
import until.Audio;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import until.ChaseCam;
import java.awt.Graphics2D;
import java.awt.Color;
import until.Assets;
import framework.Game;
import screens.LadderGame;
import until.Enums.Direction;
import until.Enums.Bench;
import until.Enums.Bin;
import entities.*;
import until.Enums.Movement;
import overlays.PlayerHud;
import java.util.Random;
import until.Enums.EnemySprite;



public class World{
	
	private LinkedList<GameObject> blocks;
	private LinkedList<GameObject> blocksDinamics;
	private LinkedList<GameObject> enemies;
	private LinkedList<GameObject> saws;
	private LinkedList<GameObject> blasts;
	private LinkedList<GameObject> trashObjects;
	private LinkedList<GameObject> trashsList;
	private LinkedList<GameObject> sawsMiddleBoss;

	private Player player;
	private BufferedImage worldSprite;
	private ChaseCam camera;
	private Assets assets;
	private LadderGame ladderGame;	
	private Game game;
	private GangstaWheel wheel;
	private Works works;
	private Random rand = new Random();
	private int randSelection;
	private int randTrash;
	private int score;


	public World(Assets assets, Game game){
		this.assets = assets;
		this.game = game;
		init();
	}
	
	public void	update(double delta)
	{

		if(player != null) player.update(delta);
		if(camera !=null) camera.update(player);

		//Static blocks
		if(blocks != null){
			for(int  i = 0; i < blocks.size(); i++){
				blocks.get(i).update(delta);
			}
		}

		// dinamic blocks
		if(blocksDinamics != null){
			for(int  i = 0; i < blocksDinamics.size(); i++){
				blocksDinamics.get(i).update(delta);
			}
		}

		// enemies
		if(enemies != null){
			for(int i = 0; i < enemies.size(); i++){
				enemies.get(i).update(delta);
				if(enemies.get(i).idDeath()){
					randTrash = rand.nextInt( 4 ) + 1;
					switch(randTrash){
						case 1:trashObjects.add(new Can(enemies.get(i).getX(), 
							enemies.get(i).getY(), ObjectId.metalTrash, assets, 0)); break;
						case 2: trashObjects.add(new Food(enemies.get(i).getX(), 
							enemies.get(i).getY(), ObjectId.foodTrash, assets, 0)); break;
						case 3: trashObjects.add(new Paper(enemies.get(i).getX(), 
							enemies.get(i).getY(), ObjectId.plasticTrash, assets, 0)); break;
						case 4:  break;
					}
					removeEnemie(enemies.get(i));
					score += 200;
					return;
				}
			}
		}

		//killer Saws
		if(saws != null){
			for(int i = 0; i < saws.size(); i++){
				saws.get(i).update(delta);
			}
		}

		// S{aws boss
		if(sawsMiddleBoss != null){
			for(int i = 0; i < sawsMiddleBoss.size(); i++){
				sawsMiddleBoss.get(i).update(delta);
			}
		}


		//Killer BLast
		if(blasts != null){
			for(int i = 0; i < blasts.size(); i++){
				blasts.get(i).update(delta);
				if(!camera.cameraBounds().contains(blasts.get(i).getBoundsRight()) ||
						!camera.cameraBounds().contains(blasts.get(i).getBoundsLeft()) ||
						   blasts.get(i).isHit()){
					removeBlasts(blasts.get(i));
					return;
				}
			}
		}

		if(trashObjects != null){
			for(int i = 0;  i < trashObjects.size();  i++){
				GameObject trash = trashObjects.get(i);
				trash.update(delta);
			}
		}




	}



	public void	render(Graphics g){

		Graphics2D g2d = (Graphics2D) g; 
		
		if(player.idDeath()){
			player.setDeath(false);
			randSelection = rand.nextInt( 3 ) + 1;
		}

		switch(randSelection){
				case 1: g.drawImage(assets.levelOne[0], 0, 0, Constants.GAME_WINDOW_WIDTH + 10, Constants.GAME_WINDOW_HEIGHT + 10,null); break;
				case 2: g.drawImage(assets.levelOne[1], 0, 0, Constants.GAME_WINDOW_WIDTH + 10, Constants.GAME_WINDOW_HEIGHT + 10,null); break;
				case 3: g.drawImage(assets.levelOne[2], 0, 0, Constants.GAME_WINDOW_WIDTH + 10, Constants.GAME_WINDOW_HEIGHT + 10,null); break;
		}

		//informacion de como funciona el metodo translate
		//https://docs.oracle.com/javase/7/docs/api/java/awt/Graphics2D.html#translate(double,%20double)
		if(camera.getPositionX() < 0){
				g2d.translate( camera.getPositionX(), camera.getPositionY());
		}else{
			g2d.translate( 0, 0);
		}

		// Everything that is between this lines 
		// if going to be affected by the camera
		// position 

		// <------------------------

		for (GameObject blockDinamic : blocksDinamics ){
			blockDinamic.render(g);
		}


	

		for (GameObject block : blocks ){
			block.render(g);
		}


		for(GameObject saw : saws){
			saw.render(g);

		}	

		for(GameObject enemie : enemies){
			enemie.render(g);
		}
		

		if(sawsMiddleBoss != null){
			for(GameObject sawBoss : sawsMiddleBoss){
				sawBoss.render(g);
			}	
		}



		if(blasts != null){
			for(GameObject blast: blasts){
				blast.render(g);
				
			}	
		}
	
		if(trashObjects != null){
			for(GameObject trash: trashObjects){
				trash.render(g);
			}
		}

		player.render(g);
		camera.render(g);

		// <------------------------
		g2d.translate( -camera.getPositionX(), 0);

	



	}	




	private void init(){
		blocks = new LinkedList<GameObject>();
		blocksDinamics = new LinkedList<GameObject>();
		enemies = new LinkedList<GameObject>();
		saws = new LinkedList<GameObject>();
		blasts = new LinkedList<GameObject>();
		trashObjects =  new LinkedList<GameObject>();
		trashsList = new LinkedList<GameObject>();
		sawsMiddleBoss = new LinkedList<GameObject>();

		player = new Player( 0, 0, ObjectId.Player, this, assets);
		camera = new ChaseCam(0, 0, this);
		randSelection = 1;
		score = 0;


		addObject(new Block(
			0,
			Constants.GAME_WINDOW_HEIGHT - (75 - Constants.BLOCK_HEIGHT),
			ObjectId.Block,
			Constants.GAME_WINDOW_WIDTH,
			Constants.BLOCK_HEIGHT, 
			assets,
			Bench.BENCH1,
			Bin.BIN)
		);

		trashObjects.add(new Can(
			800, 
			Constants.GAME_WINDOW_HEIGHT - (75 - Constants.BLOCK_HEIGHT) - 100, 
			ObjectId.metalTrash, 
			assets, 
			0));


		addObjectDinamic(new BlockDinamic(
			0,
			Constants.GAME_WINDOW_HEIGHT / 2,
			ObjectId.BlockDinamic,
			Constants.DINAMIC_BLOCK_WIDTH,
			Constants.DINAMIC_BLOCK_HEIGTH,
			assets,
			Direction.STATIC
			));

		addEnemies(new GangstaWheel( 
			Constants.GAME_WINDOW_WIDTH, 
			Constants.GAME_WINDOW_HEIGHT - Constants.ENEMY_RECTANGLE_HEIGHT - 50, 
			ObjectId.Wheel,assets,
			this,
			Constants.GAME_WINDOW_WIDTH ,
			0,
			EnemySprite.WHEEL
			));

		addObject(new Block(
			Constants.GAME_WINDOW_WIDTH + 500,
			Constants.GAME_WINDOW_HEIGHT - (75 - Constants.BLOCK_HEIGHT),
			ObjectId.Block,
			Constants.GAME_WINDOW_WIDTH - 500,
			Constants.BLOCK_HEIGHT, 
			assets,
			Bench.NO_BENCH,
			Bin.NO_BIN)
		);

		trashObjects.add(new Can(
			Constants.GAME_WINDOW_WIDTH + 600, 
			Constants.GAME_WINDOW_HEIGHT - (75 - Constants.BLOCK_HEIGHT) - 100, 
			ObjectId.metalTrash, 
			assets, 
			0));

		trashObjects.add(new Food(
			Constants.GAME_WINDOW_WIDTH + 700, 
			Constants.GAME_WINDOW_HEIGHT - (75 - Constants.BLOCK_HEIGHT) - 100, 
			ObjectId.foodTrash, 
			assets, 
			0));

		trashObjects.add(new Paper(
			Constants.GAME_WINDOW_WIDTH + 800, 
			Constants.GAME_WINDOW_HEIGHT - (75 - Constants.BLOCK_HEIGHT) - 100, 
			ObjectId.plasticTrash, 
			assets, 
			0));



		int positionTemp = ((Constants.GAME_WINDOW_WIDTH + 500) - Constants.DINAMIC_BLOCK_WIDTH) + (Constants.GAME_WINDOW_WIDTH - 500);

		addObjectDinamic(new BlockDinamic( 
			positionTemp + 100,
			Constants.GAME_WINDOW_HEIGHT / 2,
			ObjectId.BlockDinamic,
			Constants.DINAMIC_BLOCK_WIDTH,
			Constants.DINAMIC_BLOCK_HEIGTH,
			assets,
			Direction.STATIC));

		addObjectDinamic(new BlockDinamic( 
			positionTemp + Constants.PLAYER_JUNP_LENGTH,
			Constants.GAME_WINDOW_HEIGHT / 4,
			ObjectId.BlockDinamic,
			Constants.DINAMIC_BLOCK_WIDTH,
			Constants.DINAMIC_BLOCK_HEIGTH,
			assets,
			Direction.STATIC));

		addObjectDinamic(new BlockDinamic( 
			(positionTemp + (Constants.PLAYER_JUNP_LENGTH * 2)) - 100,
			Constants.GAME_WINDOW_HEIGHT / 2,
			ObjectId.BlockDinamic,
			Constants.DINAMIC_BLOCK_WIDTH,
			Constants.DINAMIC_BLOCK_HEIGTH,
			assets,
			Direction.STATIC));

		addObject(new Block(
			Constants.GAME_WINDOW_WIDTH * 3 ,
			Constants.GAME_WINDOW_HEIGHT - (75 - Constants.BLOCK_HEIGHT),
			ObjectId.Block,
			(Constants.GAME_WINDOW_WIDTH * 2) - Constants.DINAMIC_BLOCK_WIDTH ,
			Constants.BLOCK_HEIGHT, 
			assets,
			Bench.BENCH2,
			Bin.BIN)
		);

		trashObjects.add(new Can(
			(Constants.GAME_WINDOW_WIDTH * 3) + 200, 
			Constants.GAME_WINDOW_HEIGHT - (75 - Constants.BLOCK_HEIGHT) - 100, 
			ObjectId.metalTrash, 
			assets, 
			0));

		trashObjects.add(new Food(
			(Constants.GAME_WINDOW_WIDTH * 3) + 400, 
			Constants.GAME_WINDOW_HEIGHT - (75 - Constants.BLOCK_HEIGHT) - 100, 
			ObjectId.foodTrash, 
			assets, 
			0));

		trashObjects.add(new Paper(
			(Constants.GAME_WINDOW_WIDTH * 3) + 600, 
			Constants.GAME_WINDOW_HEIGHT - (75 - Constants.BLOCK_HEIGHT) - 100, 
			ObjectId.plasticTrash, 
			assets, 
			0));

		trashObjects.add(new Food(
			(Constants.GAME_WINDOW_WIDTH * 3) + 800, 
			Constants.GAME_WINDOW_HEIGHT - (75 - Constants.BLOCK_HEIGHT) - 100, 
			ObjectId.foodTrash, 
			assets, 
			0));

		trashObjects.add(new Can(
			(Constants.GAME_WINDOW_WIDTH * 3) + 1000, 
			Constants.GAME_WINDOW_HEIGHT - (75 - Constants.BLOCK_HEIGHT) - 100, 
			ObjectId.metalTrash, 
			assets, 
			0));

		trashObjects.add(new Paper(
			(Constants.GAME_WINDOW_WIDTH * 3) + 1200, 
			Constants.GAME_WINDOW_HEIGHT - (75 - Constants.BLOCK_HEIGHT) - 100, 
			ObjectId.plasticTrash, 
			assets, 
			0));

		trashObjects.add(new Can(
			(Constants.GAME_WINDOW_WIDTH * 4) + 200, 
			Constants.GAME_WINDOW_HEIGHT - (75 - Constants.BLOCK_HEIGHT) - 100, 
			ObjectId.metalTrash, 
			assets, 
			0));

		trashObjects.add(new Food(
			(Constants.GAME_WINDOW_WIDTH * 4) + 400, 
			Constants.GAME_WINDOW_HEIGHT - (75 - Constants.BLOCK_HEIGHT) - 100, 
			ObjectId.foodTrash, 
			assets, 
			0));

		trashObjects.add(new Paper(
			(Constants.GAME_WINDOW_WIDTH * 4) + 600, 
			Constants.GAME_WINDOW_HEIGHT - (75 - Constants.BLOCK_HEIGHT) - 100, 
			ObjectId.plasticTrash, 
			assets, 
			0));




		addSaws(new Saw( 
			Constants.GAME_WINDOW_WIDTH * 3 + 900, 
			Constants.GAME_WINDOW_HEIGHT - (Constants.SAW_RADIUS / 2 ), 
			ObjectId.Spyke, 
			assets, 
			Movement.M180,
			Constants.SAW_RADIUS + 100)
		);


		addObjectDinamic(new BlockDinamic( 
			Constants.GAME_WINDOW_WIDTH * 5 - 50,
			Constants.GAME_WINDOW_HEIGHT - 200,
			ObjectId.BlockDinamic,
			Constants.DINAMIC_BLOCK_WIDTH,
			Constants.DINAMIC_BLOCK_HEIGTH,
			assets,
			Direction.STATIC));


		addObject(new Block(
			Constants.GAME_WINDOW_WIDTH * 5 + 500,
			Constants.GAME_WINDOW_HEIGHT - (75 - Constants.BLOCK_HEIGHT),
			ObjectId.Block,
			Constants.GAME_WINDOW_WIDTH * 2 + 50,
			Constants.BLOCK_HEIGHT, 
			assets,
			Bench.BENCH2,
			Bin.BIN)
		);


		addSaws(new Saw( 
			(Constants.GAME_WINDOW_WIDTH * 6) + 400, 
			(Constants.GAME_WINDOW_HEIGHT / 2) - 100, 
			ObjectId.Spyke, 
			assets, 
			Movement.CIRCULAR,
			Constants.SAW_RADIUS + 100)
		);

		addSaws(new Saw( 
			(Constants.GAME_WINDOW_WIDTH * 6) + 400, 
			Constants.GAME_WINDOW_HEIGHT - Constants.SAW_HEIGHT + 5, 
			ObjectId.Spyke, 
			assets, 
			Movement.M180,
			Constants.SAW_RADIUS + 150)
		);

		addObjectDinamic(new BlockDinamic( 
			Constants.GAME_WINDOW_WIDTH * 7 + 700,
			Constants.GAME_WINDOW_HEIGHT - 250,
			ObjectId.BlockDinamic,
			Constants.DINAMIC_BLOCK_WIDTH ,
			Constants.DINAMIC_BLOCK_HEIGTH ,
			assets,
			Direction.VETICAL));

		addObjectDinamic(new BlockDinamic( 
			Constants.GAME_WINDOW_WIDTH * 8 + 100,
			(Constants.GAME_WINDOW_HEIGHT  / 2) ,
			ObjectId.BlockDinamic,
			Constants.DINAMIC_BLOCK_WIDTH ,
			Constants.DINAMIC_BLOCK_HEIGTH , 
			assets,
			Direction.STATIC));

		addSaws(new Saw(
			Constants.GAME_WINDOW_WIDTH * 8 + 190,
			Constants.GAME_WINDOW_HEIGHT /2,
			ObjectId.Spyke,
			assets,
			Movement.CIRCULAR,
			Constants.SAW_RADIUS + 100
			));




		addObjectDinamic(new BlockDinamic( 
			Constants.GAME_WINDOW_WIDTH * 8 + Constants.PLAYER_JUNP_LENGTH + 100,
			Constants.GAME_WINDOW_HEIGHT - 250,
			ObjectId.BlockDinamic,
			Constants.DINAMIC_BLOCK_WIDTH ,
			Constants.DINAMIC_BLOCK_HEIGTH ,
			assets,
			Direction.VETICAL));

		addObjectDinamic(new BlockDinamic( 
			Constants.GAME_WINDOW_WIDTH * 9 + 100,
			Constants.GAME_WINDOW_HEIGHT - 150,
			ObjectId.BlockDinamic,
			Constants.DINAMIC_BLOCK_WIDTH ,
			Constants.DINAMIC_BLOCK_HEIGTH ,
			assets,
			Direction.STATIC));

		addObjectDinamic(new BlockDinamic( 
			Constants.GAME_WINDOW_WIDTH * 9 + Constants.PLAYER_JUNP_LENGTH,
			Constants.GAME_WINDOW_HEIGHT /2,
			ObjectId.BlockDinamic,
			Constants.DINAMIC_BLOCK_WIDTH,
			Constants.DINAMIC_BLOCK_HEIGTH,
			assets,
			Direction.STATIC));

		addSaws(new Saw(
			Constants.GAME_WINDOW_WIDTH * 9 + Constants.PLAYER_JUNP_LENGTH + 80,
			Constants.GAME_WINDOW_HEIGHT /2,
			ObjectId.Spyke,
			assets,
			Movement.CIRCULAR,
			Constants.SAW_RADIUS + 50
			));

		addObjectDinamic(new BlockDinamic( 
			Constants.GAME_WINDOW_WIDTH * 10 ,
			Constants.GAME_WINDOW_HEIGHT /2,
			ObjectId.BlockDinamic,
			Constants.DINAMIC_BLOCK_WIDTH,
			Constants.DINAMIC_BLOCK_HEIGTH,
			assets,
			Direction.STATIC));

		addObjectDinamic(new BlockDinamic( 
			Constants.GAME_WINDOW_WIDTH * 10 + 600 ,
			Constants.GAME_WINDOW_HEIGHT /2,
			ObjectId.BlockDinamic,
			Constants.DINAMIC_BLOCK_WIDTH,
			Constants.DINAMIC_BLOCK_HEIGTH,
			assets,
			Direction.STATIC));

		addObjectDinamic(new BlockDinamic( 
			Constants.GAME_WINDOW_WIDTH * 11 ,
			Constants.GAME_WINDOW_HEIGHT /2,
			ObjectId.BlockDinamic,
			Constants.DINAMIC_BLOCK_WIDTH,
			Constants.DINAMIC_BLOCK_HEIGTH,
			assets,
			Direction.STATIC));



		addObject(new Block(
			Constants.GAME_WINDOW_WIDTH * 11 + 500,
			Constants.GAME_WINDOW_HEIGHT - (75 - Constants.BLOCK_HEIGHT),
			ObjectId.Block,
			Constants.GAME_WINDOW_WIDTH * 2 + Constants.GAME_WINDOW_WIDTH / 2 + 150,
			Constants.BLOCK_HEIGHT, 
			assets,
			Bench.BENCH1,
			Bin.BIN)
		);

		addSaws(new Saw(
			Constants.GAME_WINDOW_WIDTH * 12 - 480,
			Constants.GAME_WINDOW_HEIGHT - Constants.SAW_HEIGHT + 5 ,
			ObjectId.Spyke,
			assets,
			Movement.HORIZONTAL,
			10f
		));

		addSaws(new Saw(
			Constants.GAME_WINDOW_WIDTH * 12 + 400,
			Constants.GAME_WINDOW_HEIGHT - Constants.SAW_HEIGHT + 5,
			ObjectId.Spyke,
			assets,
			Movement.VETICAL,
			10f
			));

		addSaws(new Saw(
			Constants.GAME_WINDOW_WIDTH * 13 + 200,
			Constants.GAME_WINDOW_HEIGHT /2 - 50,
			ObjectId.Spyke,
			assets,
			Movement.CIRCULAR,
			200,
			0.1f
			));

		addSaws(new Saw(
			Constants.GAME_WINDOW_WIDTH * 13 + 200,
			Constants.GAME_WINDOW_HEIGHT /2 - 50,
			ObjectId.Spyke,
			assets,
			Movement.CIRCULAR,
			200,
			0.1f
			));

		addObjectDinamic(new BlockDinamic( 
			Constants.GAME_WINDOW_WIDTH * 14 + 300,
			(Constants.GAME_WINDOW_HEIGHT /2 ) + 100,
			ObjectId.BlockDinamic,
			Constants.DINAMIC_BLOCK_WIDTH,
			Constants.DINAMIC_BLOCK_HEIGTH,
			assets,
			Direction.STATIC));



		addObject(new Block(
			Constants.GAME_WINDOW_WIDTH * 14 + Constants.PLAYER_JUNP_LENGTH + 200,
			Constants.GAME_WINDOW_HEIGHT - (75 - Constants.BLOCK_HEIGHT),
			ObjectId.Block,
			Constants.GAME_WINDOW_WIDTH * 2,
			Constants.BLOCK_HEIGHT , 
			assets,
			Bench.BENCH1,
			Bin.BIN)
		);

	
		Audio.loop(Constants.LEVEL_1_BACKGROUND_MUSIC_ID);


	}


	public void addObjectDinamic(GameObject object){ blocksDinamics.add(object); }
	public void removeObjectDinamic(GameObject object){ blocksDinamics.remove(object);}
	public void addObject(GameObject object){ blocks.add(object); }
	public void removeObject(GameObject object){ blocks.remove(object);}
	public void addEnemies(GameObject enemie){ enemies.add(enemie);}
	public void removeEnemie(GameObject enemie){enemies.remove(enemie);}
	public void addSaws(GameObject saw){ saws.add(saw);}
	public void removeSaws(GameObject saw){saws.remove(saw);}
	public void addBlasts(GameObject blast){ blasts.add(blast);}
	public void removeBlasts(GameObject blast){ blasts.remove(blast);}



	public Player getPlayer(){ return player;}
	public Game getGame(){ return game;}
	public LinkedList<GameObject> getBlocks(){	return blocks; }
	public LinkedList<GameObject> getBlocksDinamics(){	return blocksDinamics; }
	public LinkedList<GameObject> getEnemies(){ return enemies;}
	public LinkedList<GameObject> getSaws(){ return saws;}
	public LinkedList<GameObject> getBlast(){return blasts;}
	public LinkedList<GameObject> getTrashObjects(){ return trashObjects;}
	public LinkedList<GameObject> getTrashsList(){ return trashsList;}
	public LinkedList<GameObject> getSawsMiddleBoss(){ return sawsMiddleBoss;}

	public int getScore(){return score;}
	public void setScore(int score){ this.score = score;}

}