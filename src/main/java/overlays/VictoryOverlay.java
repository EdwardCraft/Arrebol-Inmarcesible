package overlays;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import framework.Game;
import until.Constants;
import until.Enums.ScreenState;
import until.Assets;
import until.Enums.PlayMode;
import until.Animation;
import java.util.Random;
import until.HighscoreManager;

public class VictoryOverlay{
	
	private Font font;
	private Game game;
	private Assets assets;
	private float timer;
	private float countUp;
	private boolean done[];
	private Animation idle;
	private int scoreFinal;
	private Random rand = new Random();
	private int nameTipe;
	private HighscoreManager hm;

	private final String[] leaderboard = {
			"Tiempo ................... ",
			"Puntaje................... ",
			"Muertes................... ",
			"Basura juntada........ ",
			"Aciertos ................. ",
			"de ....................... "

		};

	private final String[] nickNames = {
		 " Donut ",
		 " Eclair ",
		 " Froyo ",
		 " Gingerbread ",
		 " Honeycomb ",
		 " Ice Cream Sandwich ",
		 " Jelly Bean",
		 " KitKat "
	};


	public VictoryOverlay(Game game, Assets assets, HighscoreManager hm){
		this.assets = assets;
		this.game = game;
		this.hm = hm;
		timer = 0;
		countUp = 0;
		done = new boolean[10];
		scoreFinal = 0;
		nameTipe = 0;
		for(int i = 0; i < done.length; i++){
			done[i] = false;
		}

		try{ font = new Font("Arial", Font.PLAIN, 30); }catch(Exception e){
			e.printStackTrace();
		}

		idle = new Animation(Constants.PLAYER_IDLE_ANIMATION_SPEED,
			assets.playerIdle[0], assets.playerIdle[1], assets.playerIdle[2], assets.playerIdle[3], 
			assets.playerIdle[4], assets.playerIdle[5], assets.playerIdle[6], assets.playerIdle[7],
			assets.playerIdle[8], assets.playerIdle[9]);

		scoreFinal += (int)game.getWorld().getScore() * 100;
		scoreFinal -= (game.getWorld().getPlayer().getLives()) * 10;
		scoreFinal += (int)game.getRecycleGame().getHud().getScore() * 100;
		selectName();

	}


	private void selectName(){
		nameTipe = rand.nextInt(7) + 0;
		 hm.addScore(nickNames[nameTipe], scoreFinal); 



	}


	public void update(double delta){

 		if(!done[0])timerCount();
 		idle.runAnimation(PlayMode.LOOP);
	}


	public void render(Graphics g){

		g.setColor(new Color(0f,0f,0f,.7f));
	    g.fillRect(0, 0, Constants.GAME_WINDOW_WIDTH + 10, Constants.GAME_WINDOW_HEIGHT + 10);
		
	    idle.drawAnimation(g, (int)150 + Constants.PLAYER_SPRITE_WIN_WIDTH , 
					(int)200 , -Constants.PLAYER_SPRITE_WIN_WIDTH, Constants.PLAYER_SPRITE_WIN_HEIGHT);




		g.setFont(font);
		g.setColor(new Color(255,102,102));	
		if(done[1]){
			g.drawString( leaderboard[0], (Constants.GAME_WINDOW_WIDTH / 2) - 150, 100);
			g.drawString( String.valueOf((int)game.getPlayerHud().getMinute()), (Constants.GAME_WINDOW_WIDTH / 2) + 150, 100);
			g.drawString( " : ", (Constants.GAME_WINDOW_WIDTH / 2) + 170, 100);
			g.drawString( String.valueOf((int)game.getPlayerHud().getCountDown()), (Constants.GAME_WINDOW_WIDTH / 2) + 200, 100);
		}
		
		g.setColor(new Color(153,255,255));

		if(done[2]){
			g.drawString( leaderboard[1], (Constants.GAME_WINDOW_WIDTH / 2) - 150, 150);
			g.drawString( String.valueOf((int)game.getWorld().getScore()), (Constants.GAME_WINDOW_WIDTH / 2) + 200, 150);
		}
		
	

		g.setColor(new Color(255,153,153));
		if(done[3]){
			g.drawString( leaderboard[2], (Constants.GAME_WINDOW_WIDTH / 2) - 150, 200);
			g.drawString( String.valueOf(game.getWorld().getPlayer().getLives()), (Constants.GAME_WINDOW_WIDTH / 2) + 200, 200);
		}

		

		g.setColor(new Color(255,255,153));
		if(done[4]){
			g.drawString( leaderboard[3], (Constants.GAME_WINDOW_WIDTH / 2) - 150, 250);
			g.drawString( String.valueOf(game.getRecycleGame().getTempCanObjects().size()), (Constants.GAME_WINDOW_WIDTH / 2) + 200, 250);
		}
		

		g.setColor(new Color(204,255,229));
		if(done[5]){
			g.drawString( "Recycle Game ", (Constants.GAME_WINDOW_WIDTH / 2) - 50, 300);
		}		
		
		g.setColor(new Color(102,255,178));
		if(done[6]){
			g.drawString( leaderboard[4], (Constants.GAME_WINDOW_WIDTH / 2) - 150, 350);
			g.drawString( String.valueOf(game.getRecycleGame().getHud().getScore()), (Constants.GAME_WINDOW_WIDTH / 2) + 200, 350);
		}

		g.setColor(new Color(255,178,102));
		if(done[7]){
			g.drawString( leaderboard[5], (Constants.GAME_WINDOW_WIDTH / 2) - 150, 400);
			g.drawString( String.valueOf(game.getRecycleGame().getTempCanObjects().size()), (Constants.GAME_WINDOW_WIDTH / 2) + 200, 400);
		}

		g.setColor(new Color(255,150,102));
		if(done[8]){
			g.drawString( "Puntaje Final", (Constants.GAME_WINDOW_WIDTH / 2) - 150, 550);
			g.drawString( String.valueOf(scoreFinal), (Constants.GAME_WINDOW_WIDTH / 2) + 200, 550);
		}

		g.setColor(new Color(150,150,102));
		if(done[9]){
			g.drawString( "Apodo", (Constants.GAME_WINDOW_WIDTH / 2) - 150, 600);
			g.drawString( nickNames[nameTipe], (Constants.GAME_WINDOW_WIDTH / 2) + 200, 600);

			g.setColor(new Color(80,150,202));
			g.drawString( "Preciona  SPACE para salir", (Constants.GAME_WINDOW_WIDTH / 2) - 150, 680);
		}


		

	
	}


	public void timerCount(){

		if((int)countUp == 10){
			countUp = 0;
			timer = 0;
			done[0] = true;
			return;
		}

		setDoneTimers();

		timer =  timer + 10f;
 		countUp = timer * 0.0019f;

	}


	private void setDoneTimers(){

		if((int)countUp == 1){
			if(done[1])return;
			done[1] = true;
		}

		if((int)countUp == 2){
			if(done[2])return;
			done[2] = true;
		}

		if((int)countUp == 3){
			if(done[3])return;
			done[3] = true;
		}

		if((int)countUp == 4){
			if(done[4])return;
			done[4] = true;
		}

		if((int)countUp == 5){
			if(done[5])return;
			done[5] = true;
		}
		if((int)countUp == 6){
			if(done[6])return;
			done[6] = true;
		}
		if((int)countUp == 7){
			if(done[7])return;
			done[7] = true;
		}
		if((int)countUp == 8){
			if(done[8])return;
			done[8] = true;
		}
		if((int)countUp == 9){
			if(done[9])return;
			done[9] = true;
		}


	}




}
