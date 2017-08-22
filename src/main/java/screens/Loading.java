package screens;
import until.Assets;
import screens.World;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import until.Constants;
import until.Animation;
import until.Enums.PlayMode;
import framework.Game;
import until.Enums.ObjectId;
import until.AssetsWorldOne;

public class Loading{
	
	private AssetsWorldOne assets;	
	private Animation loading;

	public Loading(AssetsWorldOne assets){
		this.assets = assets;
	
		loading = new Animation(4, 
			assets.loadScreen[0], assets.loadScreen[1], assets.loadScreen[2], assets.loadScreen[3]);

	}


	public void update(double delta){

		loading.runAnimation(PlayMode.LOOP);

	}


	public void render(Graphics g){


		loading.drawAnimation(g, Constants.GAME_WINDOW_WIDTH - 500, Constants.GAME_WINDOW_HEIGHT - 100);


	}



}