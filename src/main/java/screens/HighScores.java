package screens;

import java.awt.Graphics;
import until.Constants;
import java.awt.Graphics2D;
import java.awt.Color;
import until.Assets;
import java.awt.Color;
import java.awt.Font;
import until.HighscoreManager;
import until.Score;
import java.util.*;

public class HighScores{
	
	private Font font;
	private HighscoreManager hm;
	private String[] players;
	private boolean done[];
	private float timer;
	private float countUp;
	private int max;
	private ArrayList<Score> scores;
	private int i;
	private int listLenght;

	public HighScores(HighscoreManager hm){
		this.hm = hm;
		timer = 0;
		countUp = 0;
		max = 10;
		done = new boolean[11];
		scores = hm.getScores();
		i = 0;
		listLenght = scores.size();

		for(int i = 0; i < done.length; i++){
			done[i] = false;
		}

		try{ font = new Font("Arial", Font.PLAIN, 30); }catch(Exception e){
			e.printStackTrace();
		}

		if(listLenght >  max){
			listLenght = max;
		}


	}





	public void update(double delta){

		if(!done[10])timerCount();

	}
	


	public void render(Graphics g){

		g.setFont(font);
		g.setColor(new Color( 0, 0, 0));


		g.setColor(new Color(153,180,180));
		g.drawString(  " HIGH SCORES "  , (Constants.GAME_WINDOW_WIDTH / 2) - 50 , 50);


		g.setColor(new Color(153,180,255));
		if(done[0]){
			g.drawString( String.valueOf(1) + ".\t" + scores.get(0).getName(), (Constants.GAME_WINDOW_WIDTH / 2) - 150, 100);
			g.drawString( String.valueOf((int)scores.get(0).getScore()), (Constants.GAME_WINDOW_WIDTH / 2) + 200, 100);
		}
		
		g.setColor(new Color(153,255,255));

		if(done[1]){
			g.drawString( String.valueOf(2) + ".\t" +scores.get(1).getName(), (Constants.GAME_WINDOW_WIDTH / 2) - 150, 150);
			g.drawString( String.valueOf((int)scores.get(1).getScore()), (Constants.GAME_WINDOW_WIDTH / 2) + 200, 150);
		}
		
	

		g.setColor(new Color(255,153,153));
		if(done[2]){
			g.drawString( String.valueOf(3) + ".\t" +scores.get(2).getName(), (Constants.GAME_WINDOW_WIDTH / 2) - 150, 200);
			g.drawString( String.valueOf((int)scores.get(2).getScore()), (Constants.GAME_WINDOW_WIDTH / 2) + 200, 200);
		}

		

		g.setColor(new Color(255,255,153));
		if(done[3]){
			g.drawString( String.valueOf(4) + ".\t" +scores.get(3).getName(), (Constants.GAME_WINDOW_WIDTH / 2) - 150, 250);
			g.drawString( String.valueOf((int)scores.get(3).getScore()), (Constants.GAME_WINDOW_WIDTH / 2) + 200, 250);
		}
		

		g.setColor(new Color(204,255,229));
		if(done[4]){
			g.drawString(String.valueOf(5) + ".\t" + scores.get(4).getName(), (Constants.GAME_WINDOW_WIDTH / 2) - 150, 300);
			g.drawString( String.valueOf((int)scores.get(4).getScore()), (Constants.GAME_WINDOW_WIDTH / 2) + 200, 300);
		}		
		
		g.setColor(new Color(102,255,178));
		if(done[5]){
			g.drawString( String.valueOf(6) + ".\t" +scores.get(5).getName(), (Constants.GAME_WINDOW_WIDTH / 2) - 150, 350);
			g.drawString( String.valueOf((int)scores.get(5).getScore()), (Constants.GAME_WINDOW_WIDTH / 2) + 200, 350);
		}

		g.setColor(new Color(255,178,102));
		if(done[6]){
			g.drawString( String.valueOf(7) + ".\t" +scores.get(6).getName(), (Constants.GAME_WINDOW_WIDTH / 2) - 150, 400);
			g.drawString( String.valueOf((int)scores.get(6).getScore()), (Constants.GAME_WINDOW_WIDTH / 2) + 200, 400);
		}

		

		g.setColor(new Color(255,150,102));
		if(done[7]){
			g.drawString( String.valueOf(8) + ".\t" +scores.get(7).getName(), (Constants.GAME_WINDOW_WIDTH / 2) - 150, 450);
			g.drawString( String.valueOf((int)scores.get(7).getScore()), (Constants.GAME_WINDOW_WIDTH / 2) + 200, 450);
		}

		g.setColor(new Color(150,150,102));
		if(done[8]){
			g.drawString( String.valueOf(9) + ".\t" +scores.get(8).getName(), (Constants.GAME_WINDOW_WIDTH / 2) - 150, 500);
			g.drawString( String.valueOf((int)scores.get(8).getScore()), (Constants.GAME_WINDOW_WIDTH / 2) + 200, 500);
		}

		g.setColor(new Color(150,150,102));
		if(done[9]){
			g.drawString( String.valueOf(10) + ".\t" +scores.get(9).getName(), (Constants.GAME_WINDOW_WIDTH / 2) - 150, 550);
			g.drawString( String.valueOf((int)scores.get(9).getScore()), (Constants.GAME_WINDOW_WIDTH / 2) + 200, 550);
		}

		g.setColor(new Color(80,150,202));
		g.drawString( "Preciona  SPACE para salir", (Constants.GAME_WINDOW_WIDTH / 2) - 150, 680);



	}




	public void timerCount(){

		if((int)countUp == listLenght + 1){
			countUp = 0;
			timer = 0;
			done[10] = true;
			return;
		}

		setDoneTimers();

		timer =  timer + 10f;
 		countUp = timer * 0.0019f;

	}



	private void setDoneTimers(){

		if((int)countUp == 1){
			if(done[0])return;
			done[0] = true;
		}

		if((int)countUp == 2){
			if(done[1])return;
			done[1] = true;
		}

		if((int)countUp == 3){
			if(done[2])return;
			done[2] = true;
		}

		if((int)countUp == 4){
			if(done[3])return;
			done[3] = true;
		}

		if((int)countUp == 5){
			if(done[4])return;
			done[4] = true;
		}
		if((int)countUp == 6){
			if(done[5])return;
			done[5] = true;
		}
		if((int)countUp == 7){
			if(done[6])return;
			done[6] = true;
		}
		if((int)countUp == 8){
			if(done[7])return;
			done[7] = true;
		}
		if((int)countUp == 9){
			if(done[8])return;
			done[8] = true;
		}
		if((int)countUp == 9){
			if(done[9])return;
			done[9] = true;
		}



	}







}