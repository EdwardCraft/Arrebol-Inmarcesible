package overlays;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import until.Constants;
import java.util.LinkedList;
import framework.GameObject;
import framework.Game;
import until.Enums.ScreenState;
//import screens.FinishGame;

public class HubMiniGame{

	private Font font; 
	private int score;
	private int thrash;
	private float timer;
	private float countDown;
	private int c;
	private LinkedList<GameObject> canObjects;
	private Game game;
	private boolean done;

 	public HubMiniGame(LinkedList<GameObject> canObjects, Game game){
 		this.game = game;
 		this.canObjects = canObjects;
 		done = false;

 		try{
			font = new Font("Bold", Font.PLAIN, 30);
		}catch(Exception e){
			e.printStackTrace();
		}

		score = 0;
		timer = 16000;
		countDown = 0f;
 	}

 	public void update(double delta){
 		if(!done){
 			timer =  timer - 10f;
 			countDown = timer * 0.0019f;
 		}

 	}


 	public void render(Graphics g){
 		
 		if(((int)countDown <= 0) && !done){
 			timer = 0;
 			countDown = 0;
 			game.setScreenState(ScreenState.WINER);
 			game.startScreens();
 			done = true;
 		}


 		g.setFont(font);		
 		g.setColor(Color.BLUE);
 		g.drawString( "Time "+  String.valueOf((int)countDown), 
 			Constants.GAME_WINDOW_WIDTH - 130, 30);

 		g.setColor(Color.RED);
		g.drawString(String.valueOf(score), Constants.GAME_WINDOW_WIDTH - 80, 70);
		g.drawString(" / ", Constants.GAME_WINDOW_WIDTH - 50, 70);
		g.drawString(String.valueOf(canObjects.size()), Constants.GAME_WINDOW_WIDTH - 30, 70);

 	}


 	public int getScore(){ 
 		return score;
 	}

 	public void setScore(int score){
 		this.score = score;
 	}

 	public int getCountDown(){
 		return (int)countDown;
 	}

 	public void setCans(LinkedList<GameObject> canObjects){ this.canObjects = canObjects;}


}