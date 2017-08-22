package overlays;
import until.Assets;
import screens.World;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import until.Constants;
import framework.GameObject;
import until.Animation;
import until.Enums.PlayMode;
import framework.Game;
import until.Enums.ObjectId;
import until.Enums.WalkState;
import until.Enums.Direction;
import until.AssetsWorldOne;

public class PlayerHud{
	
	private AssetsWorldOne assets;	
	private Game game;
	private Animation hudHealth;
	private float timer;
	private float countDown;
	private float timerBlast;
	private float countDownBlast;
	private float minute;
	private Font font; 
	private int score;
	private Boolean flag;
	private int playerBlastcount;
	private Boolean[] done;
	private Boolean chargeBuster;
	private int countWeapon;
	private float timerWeapon;
	private float countDownWeapon;
	private Boolean middleBoss;
	private int middleBossH;

	public PlayerHud( Game game, AssetsWorldOne assets){
		this.game = game;
		this.assets = assets;
		timer = 0;
		countDown = 0;
		score = 0; 
		minute = 0;
		timerBlast = 0;
		countDownBlast = 0;
		flag = false;
        playerBlastcount = 0;
        done = new Boolean[5];
        chargeBuster = false;
        countWeapon  = 0;
        timerWeapon = 0;
		countDownWeapon = 0;
		middleBoss = false;
		middleBossH = 0;
		for(int i = 0; i < done.length; i++){
			done[i] = false;
		}


		try{
			font = new Font("Bold", Font.HANGING_BASELINE, 30);
		}catch(Exception e){
			e.printStackTrace();
		}

		hudHealth = new Animation(Constants.HUD_ANIMATION_SPEED,
			assets.whudSpriteHealth[0], assets.whudSpriteHealth[1], assets.whudSpriteHealth[2],
			assets.whudSpriteHealth[3], assets.whudSpriteHealth[4], assets.whudSpriteHealth[5],
			assets.whudSpriteHealth[6], assets.whudSpriteHealth[7], assets.whudSpriteHealth[8],
			assets.whudSpriteHealth[9], assets.whudSpriteHealth[10], assets.whudSpriteHealth[11],
			assets.whudSpriteHealth[12], assets.whudSpriteHealth[13], assets.whudSpriteHealth[14],
			assets.whudSpriteHealth[15], assets.whudSpriteHealth[16], assets.whudSpriteHealth[17],
			assets.whudSpriteHealth[18], assets.whudSpriteHealth[19], assets.whudSpriteHealth[20],
			assets.whudSpriteHealth[21], assets.whudSpriteHealth[22], assets.whudSpriteHealth[23],
			assets.whudSpriteHealth[24], assets.whudSpriteHealth[25], assets.whudSpriteHealth[26],
			assets.whudSpriteHealth[27], assets.whudSpriteHealth[28], assets.whudSpriteHealth[29]
			);

	}

	public void update(double delta){

		timer();


		hudHealth.runAnimation(PlayMode.LOOP);

		chargeTheWeapon();
		middleBossHealth();

	}

	private void timer(){
		if((int)countDown >= 60){
			countDown = 0;
			timer = 0;
			minute +=1;
		}
		timer =  timer + 10f;
 		countDown = timer * 0.0019f;	
	}



	public void render(Graphics g){
		g.setFont(font);		
 		g.setColor(new Color(255,255,153));
 		g.drawString("Time  " + String.valueOf((int)minute) + " : " + String.valueOf((int)countDown), 
 			(Constants.GAME_WINDOW_WIDTH / 2) - 40, 50);

		g.setColor(new Color(255,153,153));
		if(game.getWorld() != null){
			g.drawString( "Score: "+String.valueOf(game.getWorld().getScore()), Constants.GAME_WINDOW_WIDTH - 150, 50);

			g.setColor(new Color(128,255,128));
			g.drawString( "Trash: "+String.valueOf(game.getWorld().getTrashsList().size()), Constants.GAME_WINDOW_WIDTH - 150, 75);



			g.setColor(new Color(122,253,251));
			g.drawImage(assets.hud, 100, 20, Constants.HUD_HEALTH_BAR_SPRITE_WIDTH, Constants.HUD_HEALTH_BAR_SPRITE_HEIGHT, null);
			g.fillRect( 112,32, game.getWorld().getPlayer().getHealth(),Constants.HUD_HEALTH_BAR_SPRITE_HEIGHT - 23); 


			g.drawString( "SPACE (to jump)", 30 , Constants.GAME_WINDOW_HEIGHT - 50);
			g.drawString( "A (to charge)", 30 , Constants.GAME_WINDOW_HEIGHT - 100);
			g.drawString( "Z (to fire)", 30 , Constants.GAME_WINDOW_HEIGHT - 150);

		}


	
		if(middleBoss){
			g.setColor(new Color(247,153,44));
			g.fillRect( (Constants.GAME_WINDOW_WIDTH / 2) - 300,
				(Constants.GAME_WINDOW_HEIGHT - 25), (middleBossH * 100), 25);
		}


		switch(playerBlastcount){
			case 0:  
			g.drawImage(assets.powerBar[0], 100, Constants.HUD_HEALTH_BAR_SPRITE_HEIGHT + 13, 
				Constants.HUD_HEALTH_BAR_SPRITE_WIDTH + 2, Constants.HUD_HEALTH_BAR_SPRITE_HEIGHT + 5, null);
			break;
			case 1:  
			g.drawImage(assets.powerBar[1], 100, Constants.HUD_HEALTH_BAR_SPRITE_HEIGHT + 13, 
				Constants.HUD_HEALTH_BAR_SPRITE_WIDTH + 2, Constants.HUD_HEALTH_BAR_SPRITE_HEIGHT + 5, null);
			break;
			case 2:  
			g.drawImage(assets.powerBar[2], 100, Constants.HUD_HEALTH_BAR_SPRITE_HEIGHT + 13, 
				Constants.HUD_HEALTH_BAR_SPRITE_WIDTH + 2, Constants.HUD_HEALTH_BAR_SPRITE_HEIGHT + 5, null);
			break;
			case 3:  
			g.drawImage(assets.powerBar[3], 100, Constants.HUD_HEALTH_BAR_SPRITE_HEIGHT + 13, 
				Constants.HUD_HEALTH_BAR_SPRITE_WIDTH + 2, Constants.HUD_HEALTH_BAR_SPRITE_HEIGHT + 5, null);
			break;
			case 4:  
			g.drawImage(assets.powerBar[4], 100, Constants.HUD_HEALTH_BAR_SPRITE_HEIGHT + 13, 
				Constants.HUD_HEALTH_BAR_SPRITE_WIDTH + 2, Constants.HUD_HEALTH_BAR_SPRITE_HEIGHT + 5, null);
			break;
			case 5:  
			g.drawImage(assets.powerBar[5], 100, Constants.HUD_HEALTH_BAR_SPRITE_HEIGHT + 13, 
				Constants.HUD_HEALTH_BAR_SPRITE_WIDTH + 2, Constants.HUD_HEALTH_BAR_SPRITE_HEIGHT + 5, null);
			break;
			default: 
			g.drawImage(assets.powerBar[5], 100, Constants.HUD_HEALTH_BAR_SPRITE_HEIGHT + 13, 
				Constants.HUD_HEALTH_BAR_SPRITE_WIDTH + 2, Constants.HUD_HEALTH_BAR_SPRITE_HEIGHT + 5, null);

			break;
		}

		


		hudHealth.drawAnimation(g, 0, 0,Constants.HUD_HEALTH_SPRITE_WIDTH, Constants.HUD_HEALTH_SPRITE_HEIGHT);
		//g.drawImage(assets.whudSpriteHealth[0], 0, 0, Constants.HUD_HEALTH_SPRITE_WIDTH, Constants.HUD_HEALTH_SPRITE_HEIGHT, null);

	}


	private void chargeTheWeapon(){

		if( (playerBlastcount != 0)&&(chargeBuster)){
			timerCharge();
		}else{
			timerWeapon = 0;
			countDownWeapon = 0;
			done[0] = false;
		}


	}

	private void timerCharge(){
		setBlast();

		if((int)countDownWeapon == 1){
			timerWeapon = 0;
			countDownWeapon = 0;
			done[0] = false; 
		}else{
			timerWeapon =  timerWeapon + 15f;
 			countDownWeapon = timerWeapon * 0.0019f;	
		}

	}


	private void setBlast(){
		if((int)countDownWeapon == 1){
			if(done[0]){
				return;
			}
			playerBlastcount -= 1;
			done[0] = true;
		}

	}

	private void middleBossHealth(){
		if(game.getWorld() != null){
			if(game.getWorld().getBlocks() != null){
				for(int i = 0; i < game.getWorld().getBlocks().size(); i++){
					GameObject boss = game.getWorld().getBlocks().get(i);
					if(boss.getObjectId() == ObjectId.MiddleBoss){
						if( boss.getDirection() != Direction.STATIC){
							middleBoss = true;
							middleBossH = boss.getHealth();
							return;	
						}
					}
					middleBoss = false;
				}
			}
		}
	}




	public int getPlayerBlastcount(){ return  playerBlastcount;}
	public void setPlayerBlastcount(int playerBlastcount){ this.playerBlastcount = playerBlastcount;}
	public Boolean isFlag(){return flag;}
	public Boolean isChargeBuster(){ return chargeBuster;}
	public void setChargeBuster(Boolean chargeBuster){this.chargeBuster = chargeBuster;}
	public float getCountDown(){ return countDown;}
	public float getMinute(){ return minute;}

}