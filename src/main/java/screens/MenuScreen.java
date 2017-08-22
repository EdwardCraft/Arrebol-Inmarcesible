package screens;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import framework.Game;
import until.Constants;
import until.Enums.ScreenState;
import until.Assets;
import until.AssetsWorldOne;

public class MenuScreen{
	
	private Font font;
	private int currentChoice;
	private Game game;
	private AssetsWorldOne assets;

	private final String[] options = {
			"Start",
			"High Scores",
			"Credits",
			"Quit"
		};

	public MenuScreen(Game game, AssetsWorldOne assets){
		this.assets = assets;
		this.game = game;
		try{
			font = new Font("Arial", Font.PLAIN, 30);
		}catch(Exception e){
			e.printStackTrace();
		}

	}


	public void update(){

		
	}

	public void render(Graphics g){
		g.drawImage(assets.menuBackground, 0 , -1, Constants.GAME_WINDOW_WIDTH + 10, Constants.GAME_WINDOW_HEIGHT + 10, null);
		
		g.setFont(font);
		for(int i = 0; i < options.length; i++){
			if(i == currentChoice){
				g.setColor(Color.ORANGE);
			}else{
				g.setColor(Color.RED);
			}
			g.drawString(options[i], 
				(Constants.GAME_WINDOW_WIDTH / 2) - 30, 
				(Constants.GAME_WINDOW_HEIGHT - 130)  + i * 40);
		}
		g.dispose();
	}

	public void select(){
		if(currentChoice == 0){
			game.setScreenState(ScreenState.LOADING);
		}else if(currentChoice == 1){
			game.setScreenState(ScreenState.HIGHSCORE);
			game.startScreens();
		}else if(currentChoice == 2){
			game.setScreenState(ScreenState.CREDITS);
			game.startScreens();
		}else if(currentChoice == 3){
			System.exit(0);
		}
		
	}

	public int getCurrentChoise(){
		return currentChoice;
	}
	
	public void  setCurrentChoise(int currentChoice){
		this.currentChoice = currentChoice;
	}
	
	public String[] getOptions(){
		return options;
	}
	

}