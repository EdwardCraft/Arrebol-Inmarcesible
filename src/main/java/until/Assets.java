package until;

import java.awt.image.BufferedImage;


public class Assets{
	private int index;

	private BufferedImageLoader load;
	private SpriteSheet wheelIdle;
	private BufferedImage wheelI;
	private SpriteSheet wheelWalk;
	private BufferedImage wheelW;
	private SpriteSheet worksIdle;
	private BufferedImage worksI;
	private SpriteSheet wheelWalk2;
	private BufferedImage wheelW2;
	private SpriteSheet hudHealth;
	private BufferedImage hudH;
	private SpriteSheet spriteBar;
	private BufferedImage imageBar;


	public BufferedImage blockSprite;
	public BufferedImage benchSprite;
	public BufferedImage benchSprite1;
	public BufferedImage platformBlue;
	public BufferedImage platformGreen;
	public BufferedImage binSprite;
	public BufferedImage saw1;
	public BufferedImage saw2;
	public BufferedImage saw3;
	public BufferedImage saw1Pole;
	public BufferedImage saw1PoleBase;
	public BufferedImage worldtest;
	public BufferedImage worksTest;
	public BufferedImage hud;
	public BufferedImage can;
	public BufferedImage food;
	public BufferedImage plastic;
	public BufferedImage canBin;
	public BufferedImage foodBin;
	public BufferedImage plasticBin;
	public BufferedImage factoryBock;
	public BufferedImage facoryLineOne;
	public BufferedImage factoryFace;

	public BufferedImage[] levelOne;

	public BufferedImage[] enemySpriteIdle;
	public BufferedImage[] enemySpriteWalking;
	public BufferedImage[] worksSpriteIdle;
	public BufferedImage[] wheelDeath;
	public BufferedImage[] wheelSpriteWalk2;
	public BufferedImage[] whudSpriteHealth;
	public BufferedImage[] powerBar;
	public BufferedImage[] kioskWakeUp;
	public BufferedImage[] kioskIdle;
	public BufferedImage[] kioskWalk;
	public BufferedImage[] kioskJump;
	public BufferedImage[] warning;
	public BufferedImage[] middleBossDead;
	public BufferedImage[] playerIdle;
	public BufferedImage[] playerJmp;
	public BufferedImage[] playerRun;
	public BufferedImage[] playerFire;
	public BufferedImage[] playerHit;
	public BufferedImage[] blastIdle;

	public Assets(){
		index = 0;
		load = new BufferedImageLoader();
		enemySpriteIdle = new BufferedImage[12];
		enemySpriteWalking = new BufferedImage[35];
		worksSpriteIdle = new BufferedImage[31];
		wheelDeath = new BufferedImage[10];
		levelOne = new BufferedImage[4];
		wheelSpriteWalk2 = new  BufferedImage[35];
		whudSpriteHealth = new BufferedImage[30];
		powerBar = new BufferedImage[6];
		kioskWakeUp =  new BufferedImage[30];
		kioskIdle = new BufferedImage[30];
		kioskWalk = new BufferedImage[30];
		kioskJump = new BufferedImage[30];
		warning = new BufferedImage[5];
		middleBossDead = new BufferedImage[18];
		playerIdle = new BufferedImage[10];
		playerJmp = new BufferedImage[5];
		playerRun = new BufferedImage[8];
		playerFire = new BufferedImage[9];
		playerHit = new BufferedImage[1]; 
		blastIdle = new BufferedImage[3];

		audioAssets();

		try{
			wheelI = load.loadImage(Constants.ENEMY_STAND_BY_SPRITE);
			blockSprite = load.loadImage(Constants.BLOCK_SPRITE);
			wheelW = load.loadImage(Constants.ENEMY_WALKING_SPRITE);
			platformBlue = load.loadImage(Constants.PLATFORM_DYNAMIC_BLUE);
			benchSprite = load.loadImage(Constants.BENCH_SPRITE_1);
			benchSprite1 = load.loadImage(Constants.BENCH_SPRITE_2);
			binSprite = load.loadImage(Constants.BIN_SPRITE);
			saw1 = load.loadImage(Constants.SAW_SPITE_WIDTH);
			saw2 = load.loadImage(Constants.SAW_SPITE_1);
			saw3 = load.loadImage(Constants.SAW_SPITE_2);
			saw1Pole = load.loadImage(Constants.SAW_SPITE_POLE);
			saw1PoleBase = load.loadImage(Constants.SAW_SPITE_POLE_BASE);
			hud = load.loadImage(Constants.HUD_LIFE_BAR);
			wheelW2 = load.loadImage(Constants.ENEMY_WALKING_SPRITE_1);
			hudH = load.loadImage(Constants.HUD_SPRITE_IMAGE);
			imageBar = load.loadImage(Constants.HUD_POWER_BAR);
			can = load.loadImage(Constants.CAN_IMAGE);
			food = load.loadImage(Constants.FOOD_IMAGE);
			plastic = load.loadImage(Constants.PLASTIC_IMAGE);
			platformGreen = load.loadImage(Constants.PLATFORM_DYNAMIC_GREEN);
			canBin = load.loadImage(Constants.CAN_IMAGE_BIN);
			foodBin = load.loadImage(Constants.FOOD_IMAGE_BIN);
			plasticBin = load.loadImage(Constants.PLASTIC_IMAGE_BIN);
			factoryBock = load.loadImage("/Recycle/factoryBlock.png");
			facoryLineOne = load.loadImage("/Recycle/lineOne.png");
			factoryFace = load.loadImage("/Recycle/face.png");
			
			levelOne[0] = load.loadImage(Constants.LEVEL_1_BACKGROUND);
			levelOne[1] = load.loadImage(Constants.LEVEL_1_BACKGROUND_1);
			levelOne[2] = load.loadImage(Constants.LEVEL_1_BACKGROUND_2);
			levelOne[3] = load.loadImage(Constants.LEVEL_1_BACKGROUND_3);

			blastIdle[0] = load.loadImage(Constants.BLAST_1);
			blastIdle[1] = load.loadImage(Constants.BLAST_2);
			blastIdle[2] = load.loadImage(Constants.BLAST_3);

			loadWorks();
			enemyWhell();
			kioskWakeUpLod();
			kioskIdleLoad();
			kioskWalkLoad();
			kioskJumpLoad();
			warningLoad();
			kioskJumpDead();
			playerSprites();

		}catch(Exception e)
		{
			e.printStackTrace();
		}

		wheelIdle = new SpriteSheet(wheelI);
		wheelWalk = new SpriteSheet(wheelW);
		wheelWalk2 = new SpriteSheet(wheelW2);
		hudHealth = new SpriteSheet(hudH);
		spriteBar = new SpriteSheet(imageBar);
		//worksIdle = new SpriteSheet(worksI);
		getAssets();


	}
	

	private void enemyWhell(){
		wheelDeath[0] = load.loadImage(Constants.ENEMY_DEATH_1);
		wheelDeath[1] = load.loadImage(Constants.ENEMY_DEATH_2);
		wheelDeath[2] = load.loadImage(Constants.ENEMY_DEATH_3);
		wheelDeath[3] = load.loadImage(Constants.ENEMY_DEATH_4);
		wheelDeath[4] = load.loadImage(Constants.ENEMY_DEATH_5);
		wheelDeath[5] = load.loadImage(Constants.ENEMY_DEATH_6);
		wheelDeath[6] = load.loadImage(Constants.ENEMY_DEATH_7);
		wheelDeath[7] = load.loadImage(Constants.ENEMY_DEATH_8);
		wheelDeath[8] = load.loadImage(Constants.ENEMY_DEATH_9);
		wheelDeath[9] = load.loadImage(Constants.ENEMY_DEATH_10);
	}

	private void warningLoad(){
		warning[0] = load.loadImage(Constants.WARNING_SPRITE_1);
		warning[1] = load.loadImage(Constants.WARNING_SPRITE_2);
		warning[2] = load.loadImage(Constants.WARNING_SPRITE_3);
		warning[3] = load.loadImage(Constants.WARNING_SPRITE_4);
		warning[4] = load.loadImage(Constants.WARNING_SPRITE_5);
	}


	private void loadWorks(){
		worksSpriteIdle[0] = load.loadImage(Constants.WORKS_SPRITE_START_1);
		worksSpriteIdle[1] = load.loadImage(Constants.WORKS_SPRITE_START_2);
		worksSpriteIdle[2] = load.loadImage(Constants.WORKS_SPRITE_START_3);
		worksSpriteIdle[3] = load.loadImage(Constants.WORKS_SPRITE_START_4);
		worksSpriteIdle[4] = load.loadImage(Constants.WORKS_SPRITE_START_5);
		worksSpriteIdle[5] = load.loadImage(Constants.WORKS_SPRITE_START_6);
		worksSpriteIdle[6] = load.loadImage(Constants.WORKS_SPRITE_START_7);
		worksSpriteIdle[7] = load.loadImage(Constants.WORKS_SPRITE_START_8);
		worksSpriteIdle[8] = load.loadImage(Constants.WORKS_SPRITE_START_9);
		worksSpriteIdle[9] = load.loadImage(Constants.WORKS_SPRITE_START_10);
		worksSpriteIdle[10] = load.loadImage(Constants.WORKS_SPRITE_START_11);
		worksSpriteIdle[11] = load.loadImage(Constants.WORKS_SPRITE_START_12);
		worksSpriteIdle[12] = load.loadImage(Constants.WORKS_SPRITE_START_13);
		worksSpriteIdle[13] = load.loadImage(Constants.WORKS_SPRITE_START_14);
		worksSpriteIdle[14] = load.loadImage(Constants.WORKS_SPRITE_START_15);
		worksSpriteIdle[15] = load.loadImage(Constants.WORKS_SPRITE_START_16);
		worksSpriteIdle[16] = load.loadImage(Constants.WORKS_SPRITE_START_17);
		worksSpriteIdle[17] = load.loadImage(Constants.WORKS_SPRITE_START_18);
		worksSpriteIdle[18] = load.loadImage(Constants.WORKS_SPRITE_START_19);
		worksSpriteIdle[19] = load.loadImage(Constants.WORKS_SPRITE_START_20);
		worksSpriteIdle[20] = load.loadImage(Constants.WORKS_SPRITE_START_21);
		worksSpriteIdle[21] = load.loadImage(Constants.WORKS_SPRITE_START_22);
		worksSpriteIdle[22] = load.loadImage(Constants.WORKS_SPRITE_START_23);
		worksSpriteIdle[23] = load.loadImage(Constants.WORKS_SPRITE_START_24);
		worksSpriteIdle[24] = load.loadImage(Constants.WORKS_SPRITE_START_25);
		worksSpriteIdle[25] = load.loadImage(Constants.WORKS_SPRITE_START_26);
		worksSpriteIdle[26] = load.loadImage(Constants.WORKS_SPRITE_START_27);
		worksSpriteIdle[27] = load.loadImage(Constants.WORKS_SPRITE_START_28);
		worksSpriteIdle[28] = load.loadImage(Constants.WORKS_SPRITE_START_29);
		worksSpriteIdle[29] = load.loadImage(Constants.WORKS_SPRITE_START_30);
		worksSpriteIdle[30] = load.loadImage(Constants.WORKS_SPRITE_START_31);


	}
	
	private void getAssets(){

		
		for(int i = 0; i < 7; i++){
			for(int j = 0; j < 5; j++){
				enemySpriteWalking[index++] = wheelWalk.grabImage((j + 1), (i + 1), 250, 200);
			}
		}

		index = 0;
		for(int i = 0; i < 7; i++){
			for(int j = 0; j < 5; j++){
				wheelSpriteWalk2[index++] = wheelWalk2.grabImage((j + 1), (i + 1), 250, 200);
			}
		}

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

	private void kioskWakeUpLod(){
		kioskWakeUp[0] = load.loadImage(Constants.KIOSK_WAKE_UP_1);
		kioskWakeUp[1] = load.loadImage(Constants.KIOSK_WAKE_UP_2);
		kioskWakeUp[2] = load.loadImage(Constants.KIOSK_WAKE_UP_3);
		kioskWakeUp[3] = load.loadImage(Constants.KIOSK_WAKE_UP_4);
		kioskWakeUp[4] = load.loadImage(Constants.KIOSK_WAKE_UP_5);
		kioskWakeUp[5] = load.loadImage(Constants.KIOSK_WAKE_UP_6);
		kioskWakeUp[6] = load.loadImage(Constants.KIOSK_WAKE_UP_7);
		kioskWakeUp[7] = load.loadImage(Constants.KIOSK_WAKE_UP_8);
		kioskWakeUp[8] = load.loadImage(Constants.KIOSK_WAKE_UP_9);
		kioskWakeUp[9] = load.loadImage(Constants.KIOSK_WAKE_UP_10);
		kioskWakeUp[10] = load.loadImage(Constants.KIOSK_WAKE_UP_11);
		kioskWakeUp[11] = load.loadImage(Constants.KIOSK_WAKE_UP_12);
		kioskWakeUp[12] = load.loadImage(Constants.KIOSK_WAKE_UP_13);
		kioskWakeUp[13] = load.loadImage(Constants.KIOSK_WAKE_UP_14);
		kioskWakeUp[14] = load.loadImage(Constants.KIOSK_WAKE_UP_15);
		kioskWakeUp[15] = load.loadImage(Constants.KIOSK_WAKE_UP_16);
		kioskWakeUp[16] = load.loadImage(Constants.KIOSK_WAKE_UP_17);
		kioskWakeUp[17] = load.loadImage(Constants.KIOSK_WAKE_UP_18);
		kioskWakeUp[18] = load.loadImage(Constants.KIOSK_WAKE_UP_19);
		kioskWakeUp[19] = load.loadImage(Constants.KIOSK_WAKE_UP_20);
		kioskWakeUp[20] = load.loadImage(Constants.KIOSK_WAKE_UP_21);
		kioskWakeUp[21] = load.loadImage(Constants.KIOSK_WAKE_UP_22);
		kioskWakeUp[22] = load.loadImage(Constants.KIOSK_WAKE_UP_23);
		kioskWakeUp[23] = load.loadImage(Constants.KIOSK_WAKE_UP_24);
		kioskWakeUp[24] = load.loadImage(Constants.KIOSK_WAKE_UP_25);
		kioskWakeUp[25] = load.loadImage(Constants.KIOSK_WAKE_UP_26);
		kioskWakeUp[26] = load.loadImage(Constants.KIOSK_WAKE_UP_27);
		kioskWakeUp[21] = load.loadImage(Constants.KIOSK_WAKE_UP_22);
		kioskWakeUp[22] = load.loadImage(Constants.KIOSK_WAKE_UP_23);
		kioskWakeUp[23] = load.loadImage(Constants.KIOSK_WAKE_UP_24);
		kioskWakeUp[24] = load.loadImage(Constants.KIOSK_WAKE_UP_25);
		kioskWakeUp[25] = load.loadImage(Constants.KIOSK_WAKE_UP_26);
		kioskWakeUp[26] = load.loadImage(Constants.KIOSK_WAKE_UP_27);
		kioskWakeUp[27] = load.loadImage(Constants.KIOSK_WAKE_UP_28);
		kioskWakeUp[28] = load.loadImage(Constants.KIOSK_WAKE_UP_29);
		kioskWakeUp[29] = load.loadImage(Constants.KIOSK_WAKE_UP_30);






	}

	private void kioskIdleLoad(){

		kioskIdle[0] = load.loadImage(Constants.KIOSK_IDLE_1);
		kioskIdle[1] = load.loadImage(Constants.KIOSK_IDLE_2);
		kioskIdle[2] = load.loadImage(Constants.KIOSK_IDLE_3);
		kioskIdle[3] = load.loadImage(Constants.KIOSK_IDLE_4);
		kioskIdle[4] = load.loadImage(Constants.KIOSK_IDLE_5);
		kioskIdle[5] = load.loadImage(Constants.KIOSK_IDLE_6);
		kioskIdle[6] = load.loadImage(Constants.KIOSK_IDLE_7);
		kioskIdle[7] = load.loadImage(Constants.KIOSK_IDLE_8);
		kioskIdle[8] = load.loadImage(Constants.KIOSK_IDLE_9);
		kioskIdle[9] = load.loadImage(Constants.KIOSK_IDLE_10);
		kioskIdle[10] = load.loadImage(Constants.KIOSK_IDLE_11);
		kioskIdle[11] = load.loadImage(Constants.KIOSK_IDLE_12);
		kioskIdle[12] = load.loadImage(Constants.KIOSK_IDLE_13);
		kioskIdle[13] = load.loadImage(Constants.KIOSK_IDLE_14);
		kioskIdle[14] = load.loadImage(Constants.KIOSK_IDLE_15);
		kioskIdle[15] = load.loadImage(Constants.KIOSK_IDLE_16);
		kioskIdle[16] = load.loadImage(Constants.KIOSK_IDLE_17);
		kioskIdle[17] = load.loadImage(Constants.KIOSK_IDLE_18);
		kioskIdle[18] = load.loadImage(Constants.KIOSK_IDLE_19);
		kioskIdle[19] = load.loadImage(Constants.KIOSK_IDLE_20);
		kioskIdle[20] = load.loadImage(Constants.KIOSK_IDLE_21);
		kioskIdle[21] = load.loadImage(Constants.KIOSK_IDLE_22);
		kioskIdle[22] = load.loadImage(Constants.KIOSK_IDLE_23);
		kioskIdle[23] = load.loadImage(Constants.KIOSK_IDLE_24);
		kioskIdle[24] = load.loadImage(Constants.KIOSK_IDLE_25);
		kioskIdle[25] = load.loadImage(Constants.KIOSK_IDLE_26);
		kioskIdle[26] = load.loadImage(Constants.KIOSK_IDLE_27);
		kioskIdle[21] = load.loadImage(Constants.KIOSK_IDLE_22);
		kioskIdle[22] = load.loadImage(Constants.KIOSK_IDLE_23);
		kioskIdle[23] = load.loadImage(Constants.KIOSK_IDLE_24);
		kioskIdle[24] = load.loadImage(Constants.KIOSK_IDLE_25);
		kioskIdle[25] = load.loadImage(Constants.KIOSK_IDLE_26);
		kioskIdle[26] = load.loadImage(Constants.KIOSK_IDLE_27);
		kioskIdle[27] = load.loadImage(Constants.KIOSK_IDLE_28);
		kioskIdle[28] = load.loadImage(Constants.KIOSK_IDLE_29);
		kioskIdle[29] = load.loadImage(Constants.KIOSK_IDLE_30);


	}

	private void kioskWalkLoad(){

		kioskWalk[0] = load.loadImage(Constants.KIOSK_WALK_1);
		kioskWalk[1] = load.loadImage(Constants.KIOSK_WALK_2);
		kioskWalk[2] = load.loadImage(Constants.KIOSK_WALK_3);
		kioskWalk[3] = load.loadImage(Constants.KIOSK_WALK_4);
		kioskWalk[4] = load.loadImage(Constants.KIOSK_WALK_5);
		kioskWalk[5] = load.loadImage(Constants.KIOSK_WALK_6);
		kioskWalk[6] = load.loadImage(Constants.KIOSK_WALK_7);
		kioskWalk[7] = load.loadImage(Constants.KIOSK_WALK_8);
		kioskWalk[8] = load.loadImage(Constants.KIOSK_WALK_9);
		kioskWalk[9] = load.loadImage(Constants.KIOSK_WALK_10);
		kioskWalk[10] = load.loadImage(Constants.KIOSK_WALK_11);
		kioskWalk[11] = load.loadImage(Constants.KIOSK_WALK_12);
		kioskWalk[12] = load.loadImage(Constants.KIOSK_WALK_13);
		kioskWalk[13] = load.loadImage(Constants.KIOSK_WALK_14);
		kioskWalk[14] = load.loadImage(Constants.KIOSK_WALK_15);
		kioskWalk[15] = load.loadImage(Constants.KIOSK_WALK_16);
		kioskWalk[16] = load.loadImage(Constants.KIOSK_WALK_17);
		kioskWalk[17] = load.loadImage(Constants.KIOSK_WALK_18);
		kioskWalk[18] = load.loadImage(Constants.KIOSK_WALK_19);
		kioskWalk[19] = load.loadImage(Constants.KIOSK_WALK_20);
		kioskWalk[20] = load.loadImage(Constants.KIOSK_WALK_21);
		kioskWalk[21] = load.loadImage(Constants.KIOSK_WALK_22);
		kioskWalk[22] = load.loadImage(Constants.KIOSK_WALK_23);
		kioskWalk[23] = load.loadImage(Constants.KIOSK_WALK_24);
		kioskWalk[24] = load.loadImage(Constants.KIOSK_WALK_25);
		kioskWalk[25] = load.loadImage(Constants.KIOSK_WALK_26);
		kioskWalk[26] = load.loadImage(Constants.KIOSK_WALK_27);
		kioskWalk[21] = load.loadImage(Constants.KIOSK_WALK_22);
		kioskWalk[22] = load.loadImage(Constants.KIOSK_WALK_23);
		kioskWalk[23] = load.loadImage(Constants.KIOSK_WALK_24);
		kioskWalk[24] = load.loadImage(Constants.KIOSK_WALK_25);
		kioskWalk[25] = load.loadImage(Constants.KIOSK_WALK_26);
		kioskWalk[26] = load.loadImage(Constants.KIOSK_WALK_27);
		kioskWalk[27] = load.loadImage(Constants.KIOSK_WALK_28);
		kioskWalk[28] = load.loadImage(Constants.KIOSK_WALK_29);
		kioskWalk[29] = load.loadImage(Constants.KIOSK_WALK_30);


	}


	private void kioskJumpLoad(){

		kioskJump[0] = load.loadImage(Constants.KIOSK_JUMP_1);
		kioskJump[1] = load.loadImage(Constants.KIOSK_JUMP_2);
		kioskJump[2] = load.loadImage(Constants.KIOSK_JUMP_3);
		kioskJump[3] = load.loadImage(Constants.KIOSK_JUMP_4);
		kioskJump[4] = load.loadImage(Constants.KIOSK_JUMP_5);
		kioskJump[5] = load.loadImage(Constants.KIOSK_JUMP_6);
		kioskJump[6] = load.loadImage(Constants.KIOSK_JUMP_7);
		kioskJump[7] = load.loadImage(Constants.KIOSK_JUMP_8);
		kioskJump[8] = load.loadImage(Constants.KIOSK_JUMP_9);
		kioskJump[9] = load.loadImage(Constants.KIOSK_JUMP_10);
		kioskJump[10] = load.loadImage(Constants.KIOSK_JUMP_11);
		kioskJump[11] = load.loadImage(Constants.KIOSK_JUMP_12);
		kioskJump[12] = load.loadImage(Constants.KIOSK_JUMP_13);
		kioskJump[13] = load.loadImage(Constants.KIOSK_JUMP_14);
		kioskJump[14] = load.loadImage(Constants.KIOSK_JUMP_15);
		kioskJump[15] = load.loadImage(Constants.KIOSK_JUMP_16);
		kioskJump[16] = load.loadImage(Constants.KIOSK_JUMP_17);
		kioskJump[17] = load.loadImage(Constants.KIOSK_JUMP_18);
		kioskJump[18] = load.loadImage(Constants.KIOSK_JUMP_19);
		kioskJump[19] = load.loadImage(Constants.KIOSK_JUMP_20);
		kioskJump[20] = load.loadImage(Constants.KIOSK_JUMP_21);
		kioskJump[21] = load.loadImage(Constants.KIOSK_JUMP_22);
		kioskJump[22] = load.loadImage(Constants.KIOSK_JUMP_23);
		kioskJump[23] = load.loadImage(Constants.KIOSK_JUMP_24);
		kioskJump[24] = load.loadImage(Constants.KIOSK_JUMP_25);
		kioskJump[25] = load.loadImage(Constants.KIOSK_JUMP_26);
		kioskJump[26] = load.loadImage(Constants.KIOSK_JUMP_27);
		kioskJump[21] = load.loadImage(Constants.KIOSK_JUMP_22);
		kioskJump[22] = load.loadImage(Constants.KIOSK_JUMP_23);
		kioskJump[23] = load.loadImage(Constants.KIOSK_JUMP_24);
		kioskJump[24] = load.loadImage(Constants.KIOSK_JUMP_25);
		kioskJump[25] = load.loadImage(Constants.KIOSK_JUMP_26);
		kioskJump[26] = load.loadImage(Constants.KIOSK_JUMP_27);
		kioskJump[27] = load.loadImage(Constants.KIOSK_JUMP_28);
		kioskJump[28] = load.loadImage(Constants.KIOSK_JUMP_29);
		kioskJump[29] = load.loadImage(Constants.KIOSK_JUMP_30);
		


	}


		private void kioskJumpDead(){

		middleBossDead[0] = load.loadImage(Constants.KIOSK_DEAD_1);
		middleBossDead[1] = load.loadImage(Constants.KIOSK_DEAD_2);
		middleBossDead[2] = load.loadImage(Constants.KIOSK_DEAD_3);
		middleBossDead[3] = load.loadImage(Constants.KIOSK_DEAD_4);
		middleBossDead[4] = load.loadImage(Constants.KIOSK_DEAD_5);
		middleBossDead[5] = load.loadImage(Constants.KIOSK_DEAD_6);
		middleBossDead[6] = load.loadImage(Constants.KIOSK_DEAD_7);
		middleBossDead[7] = load.loadImage(Constants.KIOSK_DEAD_8);
		middleBossDead[8] = load.loadImage(Constants.KIOSK_DEAD_9);
		middleBossDead[9] = load.loadImage(Constants.KIOSK_DEAD_10);
		middleBossDead[10] = load.loadImage(Constants.KIOSK_DEAD_11);
		middleBossDead[11] = load.loadImage(Constants.KIOSK_DEAD_12);
		middleBossDead[12] = load.loadImage(Constants.KIOSK_DEAD_13);
		middleBossDead[13] = load.loadImage(Constants.KIOSK_DEAD_14);
		middleBossDead[14] = load.loadImage(Constants.KIOSK_DEAD_15);
		middleBossDead[15] = load.loadImage(Constants.KIOSK_DEAD_16);
		middleBossDead[16] = load.loadImage(Constants.KIOSK_DEAD_17);
		middleBossDead[17] = load.loadImage(Constants.KIOSK_DEAD_18);

		


	}


	private void playerSprites(){
		playerIdle[0] = load.loadImage(Constants.PLAYER_IDLE_1);
		playerIdle[1] = load.loadImage(Constants.PLAYER_IDLE_2);
		playerIdle[2] = load.loadImage(Constants.PLAYER_IDLE_3);
		playerIdle[3] = load.loadImage(Constants.PLAYER_IDLE_4);
		playerIdle[4] = load.loadImage(Constants.PLAYER_IDLE_5);
		playerIdle[5] = load.loadImage(Constants.PLAYER_IDLE_6);
		playerIdle[6] = load.loadImage(Constants.PLAYER_IDLE_7);
		playerIdle[7] = load.loadImage(Constants.PLAYER_IDLE_8);
		playerIdle[8] = load.loadImage(Constants.PLAYER_IDLE_9);
		playerIdle[9] = load.loadImage(Constants.PLAYER_IDLE_10);

		playerJmp[0] = load.loadImage(Constants.PLAYER_JMP_1);
		playerJmp[1] = load.loadImage(Constants.PLAYER_JMP_2);
		playerJmp[2] = load.loadImage(Constants.PLAYER_JMP_3);
		playerJmp[3] = load.loadImage(Constants.PLAYER_JMP_4);
		playerJmp[4] = load.loadImage(Constants.PLAYER_JMP_5);

		playerRun[0] = load.loadImage(Constants.PLAYER_RUN_1);
		playerRun[1] = load.loadImage(Constants.PLAYER_RUN_2);
		playerRun[2] = load.loadImage(Constants.PLAYER_RUN_3);
		playerRun[3] = load.loadImage(Constants.PLAYER_RUN_4);
		playerRun[4] = load.loadImage(Constants.PLAYER_RUN_5);
		playerRun[5] = load.loadImage(Constants.PLAYER_RUN_6);
		playerRun[6] = load.loadImage(Constants.PLAYER_RUN_7);
		playerRun[7] = load.loadImage(Constants.PLAYER_RUN_8);

		playerFire[0] = load.loadImage(Constants.PLAYER_FIRE_1);
		playerFire[1] = load.loadImage(Constants.PLAYER_FIRE_2);
		playerFire[2] = load.loadImage(Constants.PLAYER_FIRE_3);
		playerFire[3] = load.loadImage(Constants.PLAYER_FIRE_4);
		playerFire[4] = load.loadImage(Constants.PLAYER_FIRE_5);
		playerFire[5] = load.loadImage(Constants.PLAYER_FIRE_6);
		playerFire[6] = load.loadImage(Constants.PLAYER_FIRE_7);
		playerFire[7] = load.loadImage(Constants.PLAYER_FIRE_8);
		playerFire[8] = load.loadImage(Constants.PLAYER_FIRE_9);

		playerHit[0] = load.loadImage(Constants.PLAYER_HIT_1);

	}



	private void audioAssets(){
		Audio.init();
		Audio.load(Constants.PLAYER_LASER_GUN,Constants.PLAYER_LASER_GUN_ID);
		Audio.load(Constants.PAUSE_SOUND, Constants.PAUSE_SOUND_ID);
		Audio.load(Constants.WARNING_SOUND, Constants.WARNING_SOUND_ID);
		Audio.load(Constants.LEVEL_1_BACKGROUND_MUSIC, Constants.LEVEL_1_BACKGROUND_MUSIC_ID);
		//Audio.load(Constants.LEVEL_BOSS_BACKGROUND_MUSIC, Constants.LEVEL_BOSS_BACKGROUND_MUSIC_ID);
	}


}