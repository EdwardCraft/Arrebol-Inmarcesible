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


public class Credits{
	
	private Font font;
	private boolean done[];
	private float timer;
	private float countUp;
	private Assets assets;



	public Credits(Assets assets){
		this.assets = assets;

		timer = 0;
		countUp = 0;

		done = new boolean[11];

		for(int i = 0; i < done.length; i++){
			done[i] = false;
		}

		try{ font = new Font("Arial", Font.PLAIN, 30); }catch(Exception e){
			e.printStackTrace();
		}




	}





	public void update(double delta){

		if(!done[10])timerCount();

	}
	


	public void render(Graphics g){

		g.setFont(font);
		g.setColor(new Color( 0, 0, 0));





		g.setColor(new Color(153,180,255));
		if(done[0]){
			g.drawString( " DIRECTORS ", (Constants.GAME_WINDOW_WIDTH / 2) - 125, (Constants.GAME_WINDOW_HEIGHT / 2) + 50);
			g.drawString( " DANIEL ALFONSO BAUTISTA ", (Constants.GAME_WINDOW_WIDTH / 2) - 125, (Constants.GAME_WINDOW_HEIGHT / 2) + 100);
			g.drawString( " MANUEL ALANIS CARRILLO ", (Constants.GAME_WINDOW_WIDTH / 2) - 125, (Constants.GAME_WINDOW_HEIGHT / 2) + 130);
			g.drawString( " FLORES GUZMAN PEDRO  ", (Constants.GAME_WINDOW_WIDTH / 2) - 125, (Constants.GAME_WINDOW_HEIGHT / 2) + 160);
		}
		
		g.setColor(new Color(153,255,255));

		if(done[1]){

			if(assets != null){
				g.drawImage(assets.playerFire[5], ((Constants.GAME_WINDOW_WIDTH / 2) - 500) + 350
					, (Constants.GAME_WINDOW_HEIGHT / 2) - 350 ,  -350,  450,  null);
				g.drawImage(assets.kioskIdle[2], ((Constants.GAME_WINDOW_WIDTH / 2) + 50) + 600
					, (Constants.GAME_WINDOW_HEIGHT / 2) - 350 ,  -600,  315,  null);


			}
			
			g.drawString( " BATTLE DESIGN ", (Constants.GAME_WINDOW_WIDTH / 2) - 125, (Constants.GAME_WINDOW_HEIGHT / 2) + 50);
			g.drawString( " DANIEL ALFONSO BAUTISTA ", (Constants.GAME_WINDOW_WIDTH / 2) - 125, (Constants.GAME_WINDOW_HEIGHT / 2) + 100);
			g.drawString( " MANUEL ALANIS CARRILLO ", (Constants.GAME_WINDOW_WIDTH / 2) - 125, (Constants.GAME_WINDOW_HEIGHT / 2) + 130);
			g.drawString( " FLORES GUZMAN PEDRO  ", (Constants.GAME_WINDOW_WIDTH / 2) - 125, (Constants.GAME_WINDOW_HEIGHT / 2) + 160);
		}
		
	

		g.setColor(new Color(255,153,153));
		if(done[2]){
			g.drawString( " MAIN PROGRAMMERS ", (Constants.GAME_WINDOW_WIDTH / 2) - 125, (Constants.GAME_WINDOW_HEIGHT / 2) + 50);
			g.drawString( " FLORES GUZMAN PEDRO ", (Constants.GAME_WINDOW_WIDTH / 2) - 125, (Constants.GAME_WINDOW_HEIGHT / 2) + 130);
			g.drawString( " MANUEL ALANIS CARRILLO  ", (Constants.GAME_WINDOW_WIDTH / 2) - 125, (Constants.GAME_WINDOW_HEIGHT / 2) + 160);

		}

		

		g.setColor(new Color(255,255,153));
		if(done[3]){
			if(assets != null){
				g.drawImage(assets.worksSpriteIdle[5], ((Constants.GAME_WINDOW_WIDTH / 2) - 200) + 320
					, (Constants.GAME_WINDOW_HEIGHT / 2) - 500 ,  -320,  500,  null);

			}
			g.drawString( " GRAPHIC COORDINATOR ", (Constants.GAME_WINDOW_WIDTH / 2) - 125, (Constants.GAME_WINDOW_HEIGHT / 2) + 50);
			g.drawString( " DANIEL ALFONSO BAUTISTA ", (Constants.GAME_WINDOW_WIDTH / 2) - 125, (Constants.GAME_WINDOW_HEIGHT / 2) + 130);
		}
		

		g.setColor(new Color(204,255,229));
		if(done[4]){
			if(assets != null){
				g.drawImage(assets.playerIdle[5], ((Constants.GAME_WINDOW_WIDTH / 2) - 200) + 250
					, (Constants.GAME_WINDOW_HEIGHT / 2) - 350 ,  -250,  400,  null);
			}
			g.drawString( " MAIN CHARACTER DESIGN ", (Constants.GAME_WINDOW_WIDTH / 2) - 125, (Constants.GAME_WINDOW_HEIGHT / 2) + 50);
			g.drawString( " FLORES GUZMAN PEDRO ", (Constants.GAME_WINDOW_WIDTH / 2) - 125, (Constants.GAME_WINDOW_HEIGHT / 2) + 130);
		}		
		
		g.setColor(new Color(102,255,178));
		if(done[5]){
			if(assets != null){
				g.drawImage(assets.enemySpriteWalking[5], ((Constants.GAME_WINDOW_WIDTH / 2) - 200) + 170
					, (Constants.GAME_WINDOW_HEIGHT / 2) - 200 ,  -170,  120,  null);
			}
			g.drawString( " MONSTER CHARACTER DESIGN  ", (Constants.GAME_WINDOW_WIDTH / 2) - 125, (Constants.GAME_WINDOW_HEIGHT / 2) + 50);
			g.drawString( " DANIEL ALFONSO BAUTISTA ", (Constants.GAME_WINDOW_WIDTH / 2) - 125, (Constants.GAME_WINDOW_HEIGHT / 2) + 130);
		}

		g.setColor(new Color(255,178,102));
		if(done[6]){
			g.drawString( " LEVEL DESIGN  ", (Constants.GAME_WINDOW_WIDTH / 2) - 125, (Constants.GAME_WINDOW_HEIGHT / 2) + 50);
			g.drawString( " DANIEL ALFONSO BAUTISTA ", (Constants.GAME_WINDOW_WIDTH / 2) - 125, (Constants.GAME_WINDOW_HEIGHT / 2) + 100);
			g.drawString( " MANUEL ALANIS CARRILLO ", (Constants.GAME_WINDOW_WIDTH / 2) - 125, (Constants.GAME_WINDOW_HEIGHT / 2) + 130);
			g.drawString( " FLORES GUZMAN PEDRO  ", (Constants.GAME_WINDOW_WIDTH / 2) - 125, (Constants.GAME_WINDOW_HEIGHT / 2) + 160);
		}

		

		g.setColor(new Color(255,150,102));
		if(done[7]){
			g.drawString( " MUSIC   ", (Constants.GAME_WINDOW_WIDTH / 2) - 125, (Constants.GAME_WINDOW_HEIGHT / 2) + 50);
			g.drawString( " -RAIN ON ME-  BY SAUL FLORES   ", (Constants.GAME_WINDOW_WIDTH / 2) - 125, (Constants.GAME_WINDOW_HEIGHT / 2) + 130);
			
		}


		g.setColor(new Color(80,150,202));
		g.drawString( "Preciona  SPACE para salir", (Constants.GAME_WINDOW_WIDTH / 2) - 125, 680);



	}




	public void timerCount(){

		if((int)countUp == 29){
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

		if((int)countUp == 0){
			if(done[0])return;
			done[0] = true;
		}

		if((int)countUp == 4){
			if(done[1])return;
			done[0] = false;
			done[1] = true;
		}

		if((int)countUp == 8){
			if(done[2])return;
			done[1] = false;
			done[2] = true;
		}

		if((int)countUp == 12){
			if(done[3])return;
			done[2] = false;
			done[3] = true;
		}

		if((int)countUp == 16){
			if(done[4])return;
			done[3] = false;
			done[4] = true;
		}
		if((int)countUp == 20){
			if(done[5])return;
			done[4] = false;
			done[5] = true;
		}
		if((int)countUp == 24){
			if(done[6])return;
			done[5] = false;
			done[6] = true;
		}
		if((int)countUp == 28){
			if(done[7])return;
			done[6] = false;
			done[7] = true;
		}
		if((int)countUp == 32){
			if(done[8])return;
			done[7] = false;
			done[8] = true;
		}
		if((int)countUp == 36){
			if(done[9])return;
			done[8] = false;
			done[9] = true;
		}



	}







}