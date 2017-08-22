package framework;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.Color;
import entities.Player;
import until.Enums.ObjectId;
import entities.Block;
import until.Constants;
import until.Enums.ScreenState;
import java.awt.Font;
import until.Assets;
import until.AssetsWorldOne;
import screens.*;
import java.lang.Math;
import overlays.PlayerHud;
import overlays.VictoryOverlay;
import until.HighscoreManager;



public class Game extends Canvas implements Runnable{
	
	private boolean running; 
	private static Thread thread;
	private Graphics graphics;
	private BufferStrategy bufferStrategy;
	private HighscoreManager hm;
	private World world;
	private PlayerHud playerHud;
	private ScreenState screenState;
	private MenuScreen menuScreen;
	private KeyInput keyInput;
	private LadderGame ladderGame;
	private RecycleGame  recycleGame;
	private ScreeenControls screenControls;
	private VictoryOverlay victoryOverlay;
	private Loading loadScreen;
	private HighScores highScores;
	private Credits credits;

	private AssetsWorldOne assetWorldOne;
	private Assets assets;


	private float timer;
	private float movingTimer;
	private boolean start;
	private int updates;
	private boolean done;

	private long lastFpsTime;
	private int fps;



	public Game(){
		running = false;
	}




	public void init(){

		timer = 0;
		movingTimer = 0;
		assetWorldOne = new AssetsWorldOne();
		hm = new HighscoreManager();
		loadScreen = new Loading(assetWorldOne);
		screenState = ScreenState.MENU;
		menuScreen = new MenuScreen(this, assetWorldOne);
		keyInput = new KeyInput( world , menuScreen, this);
		screenControls = new ScreeenControls(this);
		start = false;
		done = false;
	    this.addKeyListener(keyInput);
	   	this.addMouseListener(screenControls);

	}

	public synchronized void start(){

		if (running) {
			return ;
		}else{
			running = true;
			thread = new Thread(this);
			thread.start();
		}
	}

	// The Thread
	public void run(){
		init();
		this.requestFocus();
		gameLoop();
	}

	public void gameLoop()
	{
  		 long lastLoopTime = System.nanoTime();
   		 final int TARGET_FPS = 60;
   		 final long OPTIMAL_TIME = 1000000000 / TARGET_FPS;   
  		 while (running)
   		{

     	 long now = System.nanoTime();
     	 long updateLength = now - lastLoopTime;
     	 lastLoopTime = now;
     	 double delta = Math.min(Math.round(updateLength / ((double)OPTIMAL_TIME)), 1);
     	 lastFpsTime += updateLength;
     	 fps++;
      
     	 if (lastFpsTime >= 1000000000)
     	 {
        	 lastFpsTime = 0;
        	 fps = 0;
      	 }
      
     		 update(delta);
      		 render();
    
     	 try{
     	 	Thread.sleep( (lastLoopTime-System.nanoTime() + OPTIMAL_TIME)/1000000 );
     	 }catch(Exception e){
		
			}
   		}

	}


	public void update(double delta){

		if(screenState == ScreenState.PAUSE) return;
		if(screenState == ScreenState.LOADING) loading(delta);
		if(screenState == ScreenState.MENU)menuScreen.update();
		if(screenState == ScreenState.LEVEL1 ){if(world != null) world.update(delta);} 
		if(screenState == ScreenState.LADDERGAME){if(ladderGame != null)ladderGame.update(delta);}
		if(screenState == ScreenState.RECYCLE){if(recycleGame != null)recycleGame.update(delta);}
		if((screenState == ScreenState.LEVEL1) || (screenState == ScreenState.LADDERGAME)){if(playerHud != null){playerHud.update(delta);} }
		if(screenState == ScreenState.WINER) {if(victoryOverlay != null) victoryOverlay.update(delta);}
		if(screenState == ScreenState.HIGHSCORE){if(highScores != null) highScores.update(delta);}
		if(screenState == ScreenState.CREDITS){if(credits != null)credits.update(delta);}
	}

	public void render(){
		bufferStrategy = this.getBufferStrategy();
		if(bufferStrategy == null){
			this.createBufferStrategy(2);
			return;
		}

		graphics = bufferStrategy.getDrawGraphics();
		bufferStrategy.show();

		graphics.setColor(new Color( 0, 0, 0));
	    graphics.fillRect(0, 0, getWidth(), getHeight());
	    // draw
	    if(screenState == ScreenState.MENU) menuScreen.render(graphics);
	    if(screenState == ScreenState.LOADING) loadScreen.render(graphics); 
	    if(screenState == ScreenState.LEVEL1 || screenState == ScreenState.PAUSE){if(world != null) world.render(graphics);} 
	    if(screenState == ScreenState.LADDERGAME){if(ladderGame != null) ladderGame.render(graphics);}
	    if(screenState == ScreenState.RECYCLE || screenState == ScreenState.WINER){if(recycleGame != null)recycleGame.render(graphics);}
	    if((screenState == ScreenState.LEVEL1) || (screenState == ScreenState.LADDERGAME)){if(playerHud != null)playerHud.render(graphics); }
	    if(screenState == ScreenState.WINER){if(victoryOverlay != null) victoryOverlay.render(graphics);}
	    if(screenState == ScreenState.HIGHSCORE){if(highScores != null) highScores.render(graphics);}
	    if(screenState == ScreenState.CREDITS){if(credits != null) credits.render(graphics);}
	   
	   
		graphics.dispose();


	}

	public void startScreens(){
		if((screenState == ScreenState.LEVEL1)){

				world = new World(assets, this);
				keyInput.setWorld(world);

		}else if(screenState == ScreenState.LADDERGAME){

			ladderGame = new LadderGame( assets, this);
			keyInput.setLadderGame(ladderGame);

		}else if(screenState == ScreenState.RECYCLE){

			recycleGame = new RecycleGame(this, getWorld().getTrashsList(), assets);

		}else if(screenState == ScreenState.WINER){

			victoryOverlay = new VictoryOverlay(this, assets, hm);			

		}else if(screenState == ScreenState.HIGHSCORE){

			highScores = new HighScores(hm);

		}else if(screenState == ScreenState.CREDITS){
			credits = new Credits(assets);
		}



	}

	private void loading(double delta){
		if( (movingTimer < 5) && start == false){
	    		timer = timer + 30f;
	    		movingTimer = timer * 0.0019f;
	

	    		if((int)movingTimer == 1){
	    			if(!done){
						assets = new Assets();
						playerHud = new PlayerHud(this, assetWorldOne);
						done = true;
						movingTimer = 4;
					}
	    		}
	    
				loadScreen.update(delta);


	    	}else{
	    		screenState = ScreenState.LEVEL1;
	    		startScreens();
	    		movingTimer = 0;
	    		timer = 0;
	    		start = true;
	    }
	}

	
	public void setWorldOne(World world){ this.world = world;}
	public ScreenState getScreenStates(){return screenState; }
	public void setScreenState(ScreenState screenState) { this.screenState = screenState;} 
	public void setLadderGame(LadderGame ladderGame){this.ladderGame = ladderGame;}
	public World getWorld(){ return world;}
	public RecycleGame getRecycleGame(){ return recycleGame;}
	public PlayerHud getPlayerHud(){ return playerHud;}
	public MenuScreen getMenuScreen(){return menuScreen;}
	public Credits getCredits(){return credits;}
	public HighScores  getHighScores(){return highScores;}
}