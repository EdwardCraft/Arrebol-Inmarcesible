package until;

import java.awt.image.BufferedImage;


public class AssetsWorldOne{
	private int index;

	private BufferedImageLoader load;
	private SpriteSheet hudHealth;
	private BufferedImage hudH;
	private SpriteSheet spriteBar;
	private BufferedImage imageBar;
	public BufferedImage menuBackground;
	public BufferedImage hud;
	public BufferedImage[] whudSpriteHealth;
	public BufferedImage[] powerBar;
	public BufferedImage[] loadScreen;


	public AssetsWorldOne(){
		index = 0;
		load = new BufferedImageLoader();
		whudSpriteHealth = new BufferedImage[30];
		powerBar = new BufferedImage[6];
		loadScreen = new BufferedImage[4];
	

		try{
			menuBackground = load.loadImage(Constants.MENU_SCREEN_BACKGROUND);
			hud = load.loadImage(Constants.HUD_LIFE_BAR);
			hudH = load.loadImage(Constants.HUD_SPRITE_IMAGE);
			imageBar = load.loadImage(Constants.HUD_POWER_BAR);

			loadScreen[0] = load.loadImage(Constants.LOADING_SPRITE_1);
			loadScreen[1] = load.loadImage(Constants.LOADING_SPRITE_2);
			loadScreen[2] = load.loadImage(Constants.LOADING_SPRITE_3);
			loadScreen[3] = load.loadImage(Constants.LOADING_SPRITE_4);

		}catch(Exception e)
		{
			e.printStackTrace();
		}

		hudHealth = new SpriteSheet(hudH);
		spriteBar = new SpriteSheet(imageBar);
		getAssets();


	}
	

	
	private void getAssets(){

		
		index = 0;
		for(int i = 0; i < 6; i++){
			for(int j = 0; j < 5; j++){
				whudSpriteHealth[index++] = hudHealth.grabImage((j + 1), (i + 1), 340, 160);
			}
		}

		index = 0;
		for(int i = 0; i < 2; i++){
			for(int j = 0; j < 3; j++){
				powerBar[index++] = spriteBar.grabImage((j + 1), (i + 1), 230, 40);
			}
		}

	}


}