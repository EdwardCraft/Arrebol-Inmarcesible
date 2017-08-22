package until;

public class Constants{

	// Game World
	public static final int GAME_WINDOW_WIDTH = 1200;
	public static final int GAME_WINDOW_HEIGHT =  700;
	public static final String GAME_NAME = "Sexy Social Game";
	public static final float GRAVITY = 0.6f;
	public static final int FPS = 60;
	public static final float NANO_TO_SECONDS = 1000000000f;
	public static final double AMOUNT_OF_TICKS = 60.0f;
	public static final double NANO_SECONDS = 1000000000 / AMOUNT_OF_TICKS;

	// Acantilado NIVEL 1
	public static final int ACANTILADO = 450;

	 // The name of the file where the highscores will be saved
    public static final String HIGHSCORE_FILE = "scores.dat";

	//Player
	public static final int PLAYER_WIDTH = 100;
	public static final int PLAYER_HEIGHT = 130;
	public static final int PLAYER_MOVEMENT_SPEED = 13;
	public static final float PLAYER_JUMP_SPEED = 12f;
	public static final float PLAYER_JUMP_SPEED_1 = 15f;
	public static final float PLAYER_IDLE_ANIMATION_SPEED = 3;
	public static final float PLAYER_JUMP_ANIMATION_SPEED = 4;
	public static final float PLAYER_FIRE_ANIMATION_SPEED = 3;
	public static final float PLAYER_RUN_ANIMATION_SPEED  = 3;

	public static final int PLAYER_SPRITE_WIDTH = 130;
	public static final int PLAYER_SPRITE_HEIGHT = 200;

	public static final int PLAYER_SPRITE_RUN_WIDTH = 225;
	public static final int PLAYER_SPRITE_RUN_HEIGHT = 225;

	public static final int PLAYER_SPRITE_FIRE_WIDTH = 200;
	public static final int PLAYER_SPRITE_FIRE_HEIGHT = 225;
	
	public static final int PLAYER_SPRITE_WIN_WIDTH = 250 ;
	public static final int PLAYER_SPRITE_WIN_HEIGHT = 400 ;


	public static final int PLAYER_OFFET_X = 30;
	public static final int PLAYER_OFFET_Y = 50;
	public static final int PLAYER_RECTANGLE_WIDTH = PLAYER_SPRITE_WIDTH - PLAYER_OFFET_X;
	public static final int PLAYER_RECTANGLE_HEIGHT = PLAYER_SPRITE_HEIGHT - PLAYER_OFFET_Y;
	// PLAYER_VELOCITY[0] is for the X coordinate 
	//PLAYER_VELOCITY[1] is for the Y coordinate
	public static final int[] PLAYER_NOCKBACK_VELOCITY = { 5, 5};
	public static final int PLAYER_NOCKBACK_OFFSET = 3;
	public static final int PLAYER_JUNP_LENGTH = ((int)PLAYER_JUMP_SPEED * (int)PLAYER_MOVEMENT_SPEED * 4);
	public static final int PLAYER_HEALTH = 170;
	public static final int PLAYER_ENEMY_KILL_SCORE = 25;
	public static final int PLAYER_LIVES = 3;

	//Spider 
	public static final float SPIDER_VELOCITY_X = 5f;
	public static final float SPIDER_VELOCITY_Y = 5f;
	public static final int SPIDER_OFFSET_TEMP = 25;
	public static final int SPIDER_RECTANGLE_WIDTH = 20;
	public static final int SPIDER_RECTANGLE_HEIGHT = 20;
	public static final int SPIDER_RECTANGLE_HIT_SIZE = 150;

	//KioskBoss
	public static final int KIOSK_WAKE_UP_ANIMATION_SPEED = 2;
	public static final int KIOSK_IDLE_ANIMATION_SPEED = 1;
	public static final int KIOSK_WALK_ANIMATION_SPEED = 1;
	public static final int KIOSK_JUMP_ANIMATION_SPEED = 1;
	public static final int KIOSK_DEAD_ANIMATION_SPEED = 1;
		// PLAYER_VELOCITY[0] is for the X coordinate
	//PLAYER_VELOCITY[1] is for the Y coordinate
	public static final int[] KIOSK_NOCKBACK_VELOCITY = { 7, 7};

	public static final int KIOSK_MOVEMENT_SPEED = 8;
	public static final int KIOSK_JUMP_SPEED = 20;
	public static final float KIOSK_GRAVITY = 0.3f;


	public static final int KIOSK_OFFSET_X = 0;
	public static final int KIOSK_OFFSET_Y = 0;
	public static final int KIOSK_WIDTH = 600;
	public static final int KIOSK_HEIGHT = 315;
	public static final int KIOSK_RECTANGLE_WIDTH =  KIOSK_WIDTH - KIOSK_OFFSET_X;
	public static final int KIOSK_RECTANGLE_HEIGHT = KIOSK_HEIGHT - KIOSK_OFFSET_Y;

	// Warning
	public static final int WARNING_ANIMATION_SPEED = 2;
	public static final int WARNING_WIDTH = 1300;
	public static final int WARNING_HEIGHT = 223;


	//Portal
	public static final int PORTAL_RECTANGLE_WIDTH = 100;
	public static final int PORTAL_RECTANGLE_HEIGHT = 100;

	//Recycle Game
	public static final int TRASH_OFFSET_X = 0;
	public static final int TRASH_OFFSET_Y = 0;
	public static final int TRASH_IMGAME_WIDTH = 80;
	public static final int TRASH_IMGAME_HEIGHT = 78;
	public static final int TRASH_RECTANGLE_WIDTH =  TRASH_IMGAME_HEIGHT - TRASH_OFFSET_X;
	public static final int TRASH_RECTANGLE_HEIGHT =  TRASH_IMGAME_WIDTH - TRASH_OFFSET_Y;

	public static final int BIN_RECTANGLE_WIDHT = 100;
	public static final int BIN_RECTANGLE_HEIGHT = 152;
	// TRASH_VELOCITY[0] is for the X coordinate
	//TRASH_VELOCITY[1] is for the Y coordinate
	public static final float[] TRASH_NOCKBACK_VELOCITY = { 24f, 24f};
	public static final int METAL_BIN_POSITION_X = (GAME_WINDOW_WIDTH  / 8 ) + 2;
	public static final int METAL_BIN_POSITION_Y = (GAME_WINDOW_HEIGHT - BIN_RECTANGLE_HEIGHT) + 6;
	public static final int FOOD_BIN_POSITION_X = (GAME_WINDOW_WIDTH / 2 ) - 48;
	public static final int FOOD_BIN_POSITION_Y = (GAME_WINDOW_HEIGHT - BIN_RECTANGLE_HEIGHT) + 6;
	public static final int PLASTIC_BIN_POSITION_X = (GAME_WINDOW_WIDTH - (BIN_RECTANGLE_HEIGHT + 100)) + 2;
	public static final int PLASTIC_BIN_POSITION_Y = (GAME_WINDOW_HEIGHT - BIN_RECTANGLE_HEIGHT) + 6;


	// Portal A
	public static final int PORAL_A_OFFSET_Y = 0;
	public static final int PORAL_A_OFFSET_X = 0;
	public static final int PORTAL_A_WIDTH = 170;
	public static final int PORTAL_A_HEIGHT =  170;
	public static final int PORAL_A_RECTANGLE_WIDHT = PORTAL_A_WIDTH - PORAL_A_OFFSET_X;
	public static final int PORAL_A_RECTANGLE_HEIGHT = PORTAL_A_HEIGHT - PORAL_A_OFFSET_Y;

	// Enemy 
	public static final int ENEMY_OFFSET_Y = 50;
	public static final int ENEMY_OFFSET_X = 30;
	public static final int ENEMY_RECTANGLE_WIDHT = 170 - ENEMY_OFFSET_X;
	public static final int ENEMY_RECTANGLE_HEIGHT = 120 - ENEMY_OFFSET_Y;
	public static final int ENEMY_WIDTH = 170;
	public static final int ENEMY_HEIGHT = 120;
	public static final int ENEMY_IDLE_SPEED = 2;
	public static final float ENEMY_MOVEMENT_SPEED = 4f;
	public static final float ENEMY_WALK_SPEED = 1f;
	public static final int ENEMY_HEALTH = 1;
	public static final int ENEMY_DEATH_ANIMATION_SPEED = 2;
	//ENEMY_WORKS_VELOCITY[0] is for the X coordinate
	//ENEMY_WORKS_VELOCITY[1] is for the Y coordinate
	public static final float[] ENEMY_NOCKBACK_VELOCITY = { 10f, 10f};

	//Blast
	public static final int BLAST_OFFSET_X = 0;
	public static final int BLAST_OFFSET_Y = 0;
	public static final int BLAST_WIDTH = 100;
	public static final int BLAST_HEIGHT = 100;
	public static final int BLAST_RECTANGLE_WIDTH = BLAST_WIDTH - BLAST_OFFSET_X;
	public static final int BLAST_RECTANGLE_HEIGHT = BLAST_HEIGHT - BLAST_OFFSET_Y;
	public static final int BLAST_BALL_VELOCITY = 15;

	// Saw
	public static final int SAW_OFFSET_X = 45;
	public static final int SAW_OFFSET_Y = 45;
	public static final int SAW_RECTANGLE_WIDTH = 139 - SAW_OFFSET_X;
	public static final int SAW_RECTANGLE_HEIGHT = 123 - SAW_OFFSET_Y;
	public static final int SAW_WIDTH = 139 ;
	public static final int SAW_HEIGHT = 123 ;
	public static final int SAW_RADIUS = 250;

	public static final int SAW_POLE_OFFSET_X = 0;
	public static final int SAW_POLE_OFFSET_Y = 0;
	public static final int SAW_POLE_RECTANGLE_WIDTH =  15 - SAW_POLE_OFFSET_X;
	public static final int SAW_POLE_RECTANGLE_HEIGHT = 239 - SAW_POLE_OFFSET_Y;
	public static final int SAW_POLE_WIDTH =  15;
	public static final int SAW_POLE_HEIGHT = 239;

	public static final int SAW_BASE_WIDTH = 254;
	public static final int SAW_BASE_HEIGHT = 161;

	public static final int SAW_ANIMATION_SPEED = 1;

	// Enemy Works
	public static final float WOKRS_ANIMATION_SPEED = 2f;
	public static final int WORKS_OFFSET_X = 200;
	public static final int WORKS_OFFSET_Y = 380;
	public static final int WOKRS_RECTANGLE_WIDTH = 320 - WORKS_OFFSET_X;
	public static final int WOKRS_RECTANGLE_HEIGHT = 500 - WORKS_OFFSET_Y;
	public static final int WOKRS_WIDTH = 320;
	public static final int WOKRS_HEIGHT = 500;
	public static final float WHELL_FACTORY_MOVEMNET = 2f;


	//Static block
	public static final int BLOCK_WIDTH = 20;
	public static final int BLOCK_HEIGHT = 20;
	public static final int BLOCK_RECTANGLE_WIDTH = 10;
	public static final int BLOCK_RECTANGLE_HEIGTH = 10;
	public static final int BLOCK_SPRITE_WIDTH = 178;
	public static final int BLOCK_SPRITE_HEIGTH = 173;
	public static final int BENCH_SPRITE_WIDTH = 479 - 100;
	public static final int BENCH_SPRITE_HEIGTH = 191 - 80;
	public static final int BIN_SPITE_WIDTH = 432 - 170;
	public static final int BIN_SPITE_HEIGTH = 209 - 100;


	// Player hud
	public static final int HUH_OFFSET_X = 40;
	public static final int HUH_OFFSET_Y = 20;
	public static final int HUD_HEALTH_SPRITE_WIDTH = 340 - HUH_OFFSET_X;
	public static final int HUD_HEALTH_SPRITE_HEIGHT = 160 - HUH_OFFSET_Y;
	public static final int HUD_ANIMATION_SPEED = 1;
	public static final int HUD_OFFSET_X = 30;
	public static final int HUD_OFFSET_Y = 5;
	public static final int HUD_HEALTH_BAR_SPRITE_WIDTH = 237 - HUD_OFFSET_X;
	public static final int HUD_HEALTH_BAR_SPRITE_HEIGHT = 37 - HUD_OFFSET_Y;

	// Dinamic block 
	public static final int DINAMIC_BLOCK_WIDTH  = 300;
	public static final int DINAMIC_BLOCK_HEIGTH = 100;

	//Music
	public static final String LEVEL_1_BACKGROUND_MUSIC = "/Music/levelOne.mp3";
	public static final String LEVEL_1_BACKGROUND_MUSIC_ID = "mugen";	

	public static final String LEVEL_BOSS_BACKGROUND_MUSIC = "/Music/boss.mp3";
	public static final String LEVEL_BOSS_BACKGROUND_MUSIC_ID = "Boss";	

	//level 1 
	public static final String LEVEL_1_BACKGROUND = "/WorldOne/fondo1.png";
	public static final String LEVEL_1_BACKGROUND_1 = "/WorldOne/fondo2.png";
	public static final String LEVEL_1_BACKGROUND_2 = "/WorldOne/fondo3.png";
	public static final String LEVEL_1_BACKGROUND_3 = "/WorldOne/fondo1.png";

	//Loading sprites
	public static final String LOADING_SPRITE_1 = "/load/load-1.png";
	public static final String LOADING_SPRITE_2 = "/load/load-2.png";
	public static final String LOADING_SPRITE_3 = "/load/load-3.png";
	public static final String LOADING_SPRITE_4 = "/load/load-4.png";

	// Oncreen Controls
	public static final int ON_SCREEN_CONTROLS_WIDTH = 88;
	public static final int ON_SCREEN_CONTROLS_HEIGTH = 84;
	public static final int ON_SCREEN_CONTROLS_LEFT_POSITION_X = GAME_WINDOW_WIDTH -(GAME_WINDOW_WIDTH - 20);
	public static final int ON_SCREEN_CONTROLS_LEFT_POSITION_Y = GAME_WINDOW_HEIGHT - ON_SCREEN_CONTROLS_HEIGTH;
	public static final int ON_SCREEN_CONTROLS_RIGHT_POSITION_X = GAME_WINDOW_WIDTH -(GAME_WINDOW_WIDTH - 130);
	public static final int ON_SCREEN_CONTROLS_RIGHT_POSITION_Y = GAME_WINDOW_HEIGHT - ON_SCREEN_CONTROLS_HEIGTH;
	public static final int ON_SCREEN_CONTROLS_UP_POSITION_X = GAME_WINDOW_WIDTH - 250;
	public static final int ON_SCREEN_CONTROLS_UP_POSITION_Y = GAME_WINDOW_HEIGHT - ON_SCREEN_CONTROLS_HEIGTH;
	public static final int ON_SCREEN_CONTROLS_FIRE_POSITION_X = GAME_WINDOW_WIDTH - 120;
	public static final int ON_SCREEN_CONTROLS_FIRE_POSITION_Y = GAME_WINDOW_HEIGHT - ON_SCREEN_CONTROLS_HEIGTH;


	//blast sprites
	public static final String BLAST_1 = "/Player/blast/blast-1.png";
	public static final String BLAST_2 = "/Player/blast/blast-2.png"; 
 	public static final String BLAST_3 = "/Player/blast/blast-3.png";



	//Player Sprites
	public static final String PLAYER_IDLE_1 = "/Player/idle/idle-1.png";
	public static final String PLAYER_IDLE_2 = "/Player/idle/idle-2.png"; 
 	public static final String PLAYER_IDLE_3 = "/Player/idle/idle-3.png";
 	public static final String PLAYER_IDLE_4 = "/Player/idle/idle-4.png";
 	public static final String PLAYER_IDLE_5 = "/Player/idle/idle-5.png";
 	public static final String PLAYER_IDLE_6 = "/Player/idle/idle-6.png";
 	public static final String PLAYER_IDLE_7 = "/Player/idle/idle-7.png";
 	public static final String PLAYER_IDLE_8 = "/Player/idle/idle-8.png";
 	public static final String PLAYER_IDLE_9 = "/Player/idle/idle-9.png";
 	public static final String PLAYER_IDLE_10 = "/Player/idle/idle-10.png";

 	//player jump
 	public static final String PLAYER_JMP_1 = "/Player/jmp/jump-1.png";
 	public static final String PLAYER_JMP_2 = "/Player/jmp/jump-2.png";
 	public static final String PLAYER_JMP_3 = "/Player/jmp/jump-3.png";
 	public static final String PLAYER_JMP_4 = "/Player/jmp/jump-4.png";
 	public static final String PLAYER_JMP_5 = "/Player/jmp/jump-5.png";

 	//palyer run 
 	public static final String PLAYER_RUN_1 = "/Player/run/run-1.png";
	public static final String PLAYER_RUN_2 = "/Player/run/run-2.png"; 
 	public static final String PLAYER_RUN_3 = "/Player/run/run-3.png";
 	public static final String PLAYER_RUN_4 = "/Player/run/run-4.png";
 	public static final String PLAYER_RUN_5 = "/Player/run/run-5.png";
 	public static final String PLAYER_RUN_6 = "/Player/run/run-6.png";
 	public static final String PLAYER_RUN_7 = "/Player/run/run-7.png";
 	public static final String PLAYER_RUN_8 = "/Player/run/run-8.png";
 	
 	// player fire
 	public static final String PLAYER_FIRE_1 = "/Player/fire/fire-1.png";
	public static final String PLAYER_FIRE_2 = "/Player/fire/fire-2.png"; 
 	public static final String PLAYER_FIRE_3 = "/Player/fire/fire-3.png";
 	public static final String PLAYER_FIRE_4 = "/Player/fire/fire-4.png";
 	public static final String PLAYER_FIRE_5 = "/Player/fire/fire-5.png";
 	public static final String PLAYER_FIRE_6 = "/Player/fire/fire-6.png";
 	public static final String PLAYER_FIRE_7 = "/Player/fire/fire-7.png";
 	public static final String PLAYER_FIRE_8 = "/Player/fire/fire-8.png";
 	public static final String PLAYER_FIRE_9 = "/Player/fire/fire-9.png";


 	// player hit
	public static final String PLAYER_HIT_1 = "/Player/hit/hit-1.png"; 	




	//Warning
	public static final String WARNING_SPRITE_1 = "/WorldOne/middleBoss/warning/peligor1.png";
	public static final String WARNING_SPRITE_2 = "/WorldOne/middleBoss/warning/peligor2.png";
	public static final String WARNING_SPRITE_3 = "/WorldOne/middleBoss/warning/peligor3.png";
	public static final String WARNING_SPRITE_4 = "/WorldOne/middleBoss/warning/peligor4.png";
	public static final String WARNING_SPRITE_5 = "/WorldOne/middleBoss/warning/peligor5.png";

	public static final String WARNING_SOUND = "/Sounds/alert/alert.mp3";
	public static final String WARNING_SOUND_ID = "Alert";


	// Oncreen Controls sprites
	public static final String ON_SCREEN_CONTROLS = "/ScreenControls/ScreenControls.png";
	public static final String ON_SCREEN_CONTROLS_LEFT = "/ScreenControls/left.png";
	public static final String ON_SCREEN_CONTROLS_RIGHT = "/ScreenControls/right.png";
	public static final String ON_SCREEN_CONTROLS_UP = "/ScreenControls/up.png";
	public static final String ON_SCREEN_CONTROLS_FIRE = "/ScreenControls/fire.png";

	//Menu Screen sprites
	public static final String MENU_SCREEN_BACKGROUND = "/Menu/arrebol.png";


	//Enemy Wheel Sprites
	public static final String ENEMY_STAND_BY_SPRITE = "/Enemies/Wheel/Wheel.png";
	public static final String ENEMY_WALKING_SPRITE = "/Enemies/Wheel/WheelWalking.png";
	public static final String ENEMY_WALKING_SPRITE_1 = "/Enemies/Wheel/WheelWalking2.png";
	public static final String ENEMY_DEATH_1 = "/Enemies/Wheel/Death/death-1.png";
	public static final String ENEMY_DEATH_2 = "/Enemies/Wheel/Death/death-2.png";
	public static final String ENEMY_DEATH_3 = "/Enemies/Wheel/Death/death-3.png";
	public static final String ENEMY_DEATH_4 = "/Enemies/Wheel/Death/death-4.png";
	public static final String ENEMY_DEATH_5 = "/Enemies/Wheel/Death/death-5.png";
	public static final String ENEMY_DEATH_6 = "/Enemies/Wheel/Death/death-6.png";
	public static final String ENEMY_DEATH_7 = "/Enemies/Wheel/Death/death-7.png";
	public static final String ENEMY_DEATH_8 = "/Enemies/Wheel/Death/death-8.png";
	public static final String ENEMY_DEATH_9 = "/Enemies/Wheel/Death/death-9.png";
	public static final String ENEMY_DEATH_10 = "/Enemies/Wheel/Death/death-10.png";

	// platform sprites
	public static final String PLATFORM_DYNAMIC_BLUE = "/WorldOne/plataformas/plataformaAzul.png";
	public static final String PLATFORM_DYNAMIC_GREEN = "/WorldOne/plataformas/plataformaverde.png";
	public static final String BLOCK_SPRITE = "/WorldOne/plataformas/tile04.png";
	public static final String BENCH_SPRITE_1 = "/WorldOne/plataformas/banca2.png";
	public static final String BENCH_SPRITE_2 = "/WorldOne/plataformas/banca.png";
	public static final String BIN_SPRITE = "/WorldOne/plataformas/botesbasura.png";

	// Works sprites sheet
	public static final String WORKS_SPRITE_TEST = "/Enemies/Works/works.png";
	public static final String WORKS_SPRITE_IDLE = "/Enemies/Works/worksIdle.png";
	public static final String WORKS_SPRITE_START_1 = "/Enemies/Works/ShowE/fabrikOut_00000.png";
	public static final String WORKS_SPRITE_START_2 = "/Enemies/Works/ShowE/fabrikOut_00001.png";
	public static final String WORKS_SPRITE_START_3 = "/Enemies/Works/ShowE/fabrikOut_00002.png";
	public static final String WORKS_SPRITE_START_4 = "/Enemies/Works/ShowE/fabrikOut_00003.png";
	public static final String WORKS_SPRITE_START_5 = "/Enemies/Works/ShowE/fabrikOut_00004.png";
	public static final String WORKS_SPRITE_START_6 = "/Enemies/Works/ShowE/fabrikOut_00005.png";
	public static final String WORKS_SPRITE_START_7 = "/Enemies/Works/ShowE/fabrikOut_00006.png";
	public static final String WORKS_SPRITE_START_8 = "/Enemies/Works/ShowE/fabrikOut_00007.png";
	public static final String WORKS_SPRITE_START_9 = "/Enemies/Works/ShowE/fabrikOut_00008.png";
	public static final String WORKS_SPRITE_START_10 = "/Enemies/Works/ShowE/fabrikOut_00009.png";
	public static final String WORKS_SPRITE_START_11 = "/Enemies/Works/ShowE/fabrikOut_00010.png";
	public static final String WORKS_SPRITE_START_12 = "/Enemies/Works/ShowE/fabrikOut_00011.png";
	public static final String WORKS_SPRITE_START_13 = "/Enemies/Works/ShowE/fabrikOut_00012.png";
	public static final String WORKS_SPRITE_START_14 = "/Enemies/Works/ShowE/fabrikOut_00013.png";
	public static final String WORKS_SPRITE_START_15 = "/Enemies/Works/ShowE/fabrikOut_00014.png";
	public static final String WORKS_SPRITE_START_16 = "/Enemies/Works/ShowE/fabrikOut_00015.png";
	public static final String WORKS_SPRITE_START_17 = "/Enemies/Works/ShowE/fabrikOut_00016.png";
	public static final String WORKS_SPRITE_START_18 = "/Enemies/Works/ShowE/fabrikOut_00017.png";
	public static final String WORKS_SPRITE_START_19 = "/Enemies/Works/ShowE/fabrikOut_00018.png";
	public static final String WORKS_SPRITE_START_20 = "/Enemies/Works/ShowE/fabrikOut_00019.png";
	public static final String WORKS_SPRITE_START_21 = "/Enemies/Works/ShowE/fabrikOut_00020.png";
	public static final String WORKS_SPRITE_START_22 = "/Enemies/Works/ShowE/fabrikOut_00021.png";
	public static final String WORKS_SPRITE_START_23 = "/Enemies/Works/ShowE/fabrikOut_00022.png";
	public static final String WORKS_SPRITE_START_24 = "/Enemies/Works/ShowE/fabrikOut_00023.png";
	public static final String WORKS_SPRITE_START_25 = "/Enemies/Works/ShowE/fabrikOut_00024.png";
	public static final String WORKS_SPRITE_START_26 = "/Enemies/Works/ShowE/fabrikOut_00025.png";
	public static final String WORKS_SPRITE_START_27 = "/Enemies/Works/ShowE/fabrikOut_00026.png";
	public static final String WORKS_SPRITE_START_28 = "/Enemies/Works/ShowE/fabrikOut_00027.png";
	public static final String WORKS_SPRITE_START_29 = "/Enemies/Works/ShowE/fabrikOut_00028.png";
	public static final String WORKS_SPRITE_START_30 = "/Enemies/Works/ShowE/fabrikOut_00029.png";
	public static final String WORKS_SPRITE_START_31 = "/Enemies/Works/ShowE/fabrikOut_00030.png";

	// Saw sprites
	public static final String SAW_SPITE_WIDTH = "/WorldOne/obstacles/llanta01/llantamalo.png";
	public static final String SAW_SPITE_POLE = "/WorldOne/obstacles/llanta01/paloMalo.png";
	public static final String SAW_SPITE_POLE_BASE = "/WorldOne/obstacles/llanta01/BaseMalo.png";
	public static final String SAW_SPITE_1 = "/WorldOne/obstacles/llanta01/llantamalo1.png";
	public static final String SAW_SPITE_2 = "/WorldOne/obstacles/llanta01/llantamalo2.png";

	//hud 
	public static final String HUD_SPRITE_IMAGE = "/WorldOne/Health.png";
	public static final String HUD_LIFE_BAR = "/WorldOne/liefBar.png";
	public static final String HUD_POWER_BAR = "/WorldOne/powerBar.png";

	//Sounds 
	public static final String PLAYER_LASER_GUN = "/Sounds/Player/laser.mp3";
	public static final String PLAYER_LASER_GUN_ID = "Laser";
	public static final String PLAYER_JUMP_SOUND = "/Sounds/Player/jump.mp3";
	public static final String PLAYER_JUMP_SOUND_ID = "Jump";
	public static final String PAUSE_SOUND = "/Sounds/Player/pause.mp3";
	public static final String PAUSE_SOUND_ID = "Pause";


	// Recycle game Sprites

	public static final String CAN_IMAGE = "/Recycle/can.png";
	public static final String FOOD_IMAGE = "/Recycle/food.png";
	public static final String PLASTIC_IMAGE = "/Recycle/paperBin.png";
	public static final String CAN_IMAGE_BIN = "/Recycle/metalBin.png";
	public static final String FOOD_IMAGE_BIN = "/Recycle/foodBin.png";
	public static final String PLASTIC_IMAGE_BIN = "/Recycle/paperBin(2).png";

	// Middle Boss Sprites
	public static final String KIOSK_WAKE_UP_1 = "/WorldOne/middleBoss/wakeup/wake_00000.png";
	public static final String KIOSK_WAKE_UP_2 = "/WorldOne/middleBoss/wakeup/wake_00001.png";
	public static final String KIOSK_WAKE_UP_3 = "/WorldOne/middleBoss/wakeup/wake_00002.png";
	public static final String KIOSK_WAKE_UP_4 = "/WorldOne/middleBoss/wakeup/wake_00003.png";
	public static final String KIOSK_WAKE_UP_5 = "/WorldOne/middleBoss/wakeup/wake_00004.png";
	public static final String KIOSK_WAKE_UP_6 = "/WorldOne/middleBoss/wakeup/wake_00005.png";
	public static final String KIOSK_WAKE_UP_7 = "/WorldOne/middleBoss/wakeup/wake_00006.png";
	public static final String KIOSK_WAKE_UP_8 = "/WorldOne/middleBoss/wakeup/wake_00007.png";
	public static final String KIOSK_WAKE_UP_9 = "/WorldOne/middleBoss/wakeup/wake_00008.png";
	public static final String KIOSK_WAKE_UP_10 = "/WorldOne/middleBoss/wakeup/wake_00009.png";
	public static final String KIOSK_WAKE_UP_11 = "/WorldOne/middleBoss/wakeup/wake_00010.png";
	public static final String KIOSK_WAKE_UP_12 = "/WorldOne/middleBoss/wakeup/wake_00011.png";
	public static final String KIOSK_WAKE_UP_13 = "/WorldOne/middleBoss/wakeup/wake_00012.png";
	public static final String KIOSK_WAKE_UP_14 = "/WorldOne/middleBoss/wakeup/wake_00013.png";
	public static final String KIOSK_WAKE_UP_15 = "/WorldOne/middleBoss/wakeup/wake_00014.png";
	public static final String KIOSK_WAKE_UP_16 = "/WorldOne/middleBoss/wakeup/wake_00015.png";
	public static final String KIOSK_WAKE_UP_17 = "/WorldOne/middleBoss/wakeup/wake_00016.png";
	public static final String KIOSK_WAKE_UP_18 = "/WorldOne/middleBoss/wakeup/wake_00017.png";
	public static final String KIOSK_WAKE_UP_19 = "/WorldOne/middleBoss/wakeup/wake_00018.png";
	public static final String KIOSK_WAKE_UP_20 = "/WorldOne/middleBoss/wakeup/wake_00019.png";
	public static final String KIOSK_WAKE_UP_21 = "/WorldOne/middleBoss/wakeup/wake_00020.png";
	public static final String KIOSK_WAKE_UP_22 = "/WorldOne/middleBoss/wakeup/wake_00021.png";
	public static final String KIOSK_WAKE_UP_23 = "/WorldOne/middleBoss/wakeup/wake_00022.png";
	public static final String KIOSK_WAKE_UP_24 = "/WorldOne/middleBoss/wakeup/wake_00023.png";
	public static final String KIOSK_WAKE_UP_25 = "/WorldOne/middleBoss/wakeup/wake_00024.png";
	public static final String KIOSK_WAKE_UP_26 = "/WorldOne/middleBoss/wakeup/wake_00025.png";
	public static final String KIOSK_WAKE_UP_27 = "/WorldOne/middleBoss/wakeup/wake_00026.png";
	public static final String KIOSK_WAKE_UP_28 = "/WorldOne/middleBoss/wakeup/wake_00027.png";	
	public static final String KIOSK_WAKE_UP_29 = "/WorldOne/middleBoss/wakeup/wake_00028.png";
	public static final String KIOSK_WAKE_UP_30 = "/WorldOne/middleBoss/wakeup/wake_00029.png";

	public static final String KIOSK_IDLE_1 = "/WorldOne/middleBoss/standby/Standby_00030.png";
	public static final String KIOSK_IDLE_2 = "/WorldOne/middleBoss/standby/Standby_00031.png";
	public static final String KIOSK_IDLE_3 = "/WorldOne/middleBoss/standby/Standby_00032.png";
	public static final String KIOSK_IDLE_4 = "/WorldOne/middleBoss/standby/Standby_00033.png";
	public static final String KIOSK_IDLE_5 = "/WorldOne/middleBoss/standby/Standby_00034.png";
	public static final String KIOSK_IDLE_6 = "/WorldOne/middleBoss/standby/Standby_00035.png";
	public static final String KIOSK_IDLE_7 = "/WorldOne/middleBoss/standby/Standby_00036.png";
	public static final String KIOSK_IDLE_8 = "/WorldOne/middleBoss/standby/Standby_00037.png";
	public static final String KIOSK_IDLE_9 = "/WorldOne/middleBoss/standby/Standby_00038.png";
	public static final String KIOSK_IDLE_10 = "/WorldOne/middleBoss/standby/Standby_00039.png";
	public static final String KIOSK_IDLE_11 = "/WorldOne/middleBoss/standby/Standby_00040.png";
	public static final String KIOSK_IDLE_12 = "/WorldOne/middleBoss/standby/Standby_00041.png";
	public static final String KIOSK_IDLE_13 = "/WorldOne/middleBoss/standby/Standby_00042.png";
	public static final String KIOSK_IDLE_14 = "/WorldOne/middleBoss/standby/Standby_00043.png";
	public static final String KIOSK_IDLE_15 = "/WorldOne/middleBoss/standby/Standby_00044.png";
	public static final String KIOSK_IDLE_16 = "/WorldOne/middleBoss/standby/Standby_00045.png";
	public static final String KIOSK_IDLE_17 = "/WorldOne/middleBoss/standby/Standby_00046.png";
	public static final String KIOSK_IDLE_18 = "/WorldOne/middleBoss/standby/Standby_00047.png";
	public static final String KIOSK_IDLE_19 = "/WorldOne/middleBoss/standby/Standby_00048.png";
	public static final String KIOSK_IDLE_20 = "/WorldOne/middleBoss/standby/Standby_00049.png";
	public static final String KIOSK_IDLE_21 = "/WorldOne/middleBoss/standby/Standby_00050.png";
	public static final String KIOSK_IDLE_22 = "/WorldOne/middleBoss/standby/Standby_00051.png";
	public static final String KIOSK_IDLE_23 = "/WorldOne/middleBoss/standby/Standby_00052.png";
	public static final String KIOSK_IDLE_24 = "/WorldOne/middleBoss/standby/Standby_00053.png";
	public static final String KIOSK_IDLE_25 = "/WorldOne/middleBoss/standby/Standby_00054.png";
	public static final String KIOSK_IDLE_26 = "/WorldOne/middleBoss/standby/Standby_00055.png";
	public static final String KIOSK_IDLE_27 = "/WorldOne/middleBoss/standby/Standby_00056.png";
	public static final String KIOSK_IDLE_28 = "/WorldOne/middleBoss/standby/Standby_00057.png";	
	public static final String KIOSK_IDLE_29 = "/WorldOne/middleBoss/standby/Standby_00058.png";
	public static final String KIOSK_IDLE_30 = "/WorldOne/middleBoss/standby/Standby_00059.png";


	public static final String KIOSK_WALK_1 = "/WorldOne/middleBoss/walkcycle/walk_00120.png";
	public static final String KIOSK_WALK_2 = "/WorldOne/middleBoss/walkcycle/walk_00121.png";
	public static final String KIOSK_WALK_3 = "/WorldOne/middleBoss/walkcycle/walk_00122.png";
	public static final String KIOSK_WALK_4 = "/WorldOne/middleBoss/walkcycle/walk_00123.png";
	public static final String KIOSK_WALK_5 = "/WorldOne/middleBoss/walkcycle/walk_00124.png";
	public static final String KIOSK_WALK_6 = "/WorldOne/middleBoss/walkcycle/walk_00125.png";
	public static final String KIOSK_WALK_7 = "/WorldOne/middleBoss/walkcycle/walk_00126.png";
	public static final String KIOSK_WALK_8 = "/WorldOne/middleBoss/walkcycle/walk_00127.png";
	public static final String KIOSK_WALK_9 = "/WorldOne/middleBoss/walkcycle/walk_00128.png";
	public static final String KIOSK_WALK_10 = "/WorldOne/middleBoss/walkcycle/walk_00129.png";
	public static final String KIOSK_WALK_11 = "/WorldOne/middleBoss/walkcycle/walk_00130.png";
	public static final String KIOSK_WALK_12 = "/WorldOne/middleBoss/walkcycle/walk_00131.png";
	public static final String KIOSK_WALK_13 = "/WorldOne/middleBoss/walkcycle/walk_00132.png";
	public static final String KIOSK_WALK_14 = "/WorldOne/middleBoss/walkcycle/walk_00133.png";
	public static final String KIOSK_WALK_15 = "/WorldOne/middleBoss/walkcycle/walk_00134.png";
	public static final String KIOSK_WALK_16 = "/WorldOne/middleBoss/walkcycle/walk_00135.png";
	public static final String KIOSK_WALK_17 = "/WorldOne/middleBoss/walkcycle/walk_00136.png";
	public static final String KIOSK_WALK_18 = "/WorldOne/middleBoss/walkcycle/walk_00137.png";
	public static final String KIOSK_WALK_19 = "/WorldOne/middleBoss/walkcycle/walk_00138.png";
	public static final String KIOSK_WALK_20 = "/WorldOne/middleBoss/walkcycle/walk_00139.png";
	public static final String KIOSK_WALK_21 = "/WorldOne/middleBoss/walkcycle/walk_00140.png";
	public static final String KIOSK_WALK_22 = "/WorldOne/middleBoss/walkcycle/walk_00141.png";
	public static final String KIOSK_WALK_23 = "/WorldOne/middleBoss/walkcycle/walk_00142.png";
	public static final String KIOSK_WALK_24 = "/WorldOne/middleBoss/walkcycle/walk_00143.png";
	public static final String KIOSK_WALK_25 = "/WorldOne/middleBoss/walkcycle/walk_00144.png";
	public static final String KIOSK_WALK_26 = "/WorldOne/middleBoss/walkcycle/walk_00145.png";
	public static final String KIOSK_WALK_27 = "/WorldOne/middleBoss/walkcycle/walk_00146.png";
	public static final String KIOSK_WALK_28 = "/WorldOne/middleBoss/walkcycle/walk_00147.png";	
	public static final String KIOSK_WALK_29 = "/WorldOne/middleBoss/walkcycle/walk_00148.png";
	public static final String KIOSK_WALK_30 = "/WorldOne/middleBoss/walkcycle/walk_00149.png";



	public static final String KIOSK_JUMP_1 = "/WorldOne/middleBoss/jump/Jump_00060.png";
	public static final String KIOSK_JUMP_2 = "/WorldOne/middleBoss/jump/Jump_00061.png";
	public static final String KIOSK_JUMP_3 = "/WorldOne/middleBoss/jump/Jump_00062.png";
	public static final String KIOSK_JUMP_4 = "/WorldOne/middleBoss/jump/Jump_00063.png";
	public static final String KIOSK_JUMP_5 = "/WorldOne/middleBoss/jump/Jump_00064.png";
	public static final String KIOSK_JUMP_6 = "/WorldOne/middleBoss/jump/Jump_00065.png";
	public static final String KIOSK_JUMP_7 = "/WorldOne/middleBoss/jump/Jump_00066.png";
	public static final String KIOSK_JUMP_8 = "/WorldOne/middleBoss/jump/Jump_00067.png";
	public static final String KIOSK_JUMP_9 = "/WorldOne/middleBoss/jump/Jump_00068.png";
	public static final String KIOSK_JUMP_10 = "/WorldOne/middleBoss/jump/Jump_00069.png";
	public static final String KIOSK_JUMP_11 = "/WorldOne/middleBoss/jump/Jump_00070.png";
	public static final String KIOSK_JUMP_12 = "/WorldOne/middleBoss/jump/Jump_00071.png";
	public static final String KIOSK_JUMP_13 = "/WorldOne/middleBoss/jump/Jump_00072.png";
	public static final String KIOSK_JUMP_14 = "/WorldOne/middleBoss/jump/Jump_00073.png";
	public static final String KIOSK_JUMP_15 = "/WorldOne/middleBoss/jump/Jump_00074.png";
	public static final String KIOSK_JUMP_16 = "/WorldOne/middleBoss/jump/Jump_00075.png";
	public static final String KIOSK_JUMP_17 = "/WorldOne/middleBoss/jump/Jump_00076.png";
	public static final String KIOSK_JUMP_18 = "/WorldOne/middleBoss/jump/Jump_00077.png";
	public static final String KIOSK_JUMP_19 = "/WorldOne/middleBoss/jump/Jump_00078.png";
	public static final String KIOSK_JUMP_20 = "/WorldOne/middleBoss/jump/Jump_00079.png";
	public static final String KIOSK_JUMP_21 = "/WorldOne/middleBoss/jump/Jump_00080.png";
	public static final String KIOSK_JUMP_22 = "/WorldOne/middleBoss/jump/Jump_00081.png";
	public static final String KIOSK_JUMP_23 = "/WorldOne/middleBoss/jump/Jump_00082.png";
	public static final String KIOSK_JUMP_24 = "/WorldOne/middleBoss/jump/Jump_00083.png";
	public static final String KIOSK_JUMP_25 = "/WorldOne/middleBoss/jump/Jump_00084.png";
	public static final String KIOSK_JUMP_26 = "/WorldOne/middleBoss/jump/Jump_00085.png";
	public static final String KIOSK_JUMP_27 = "/WorldOne/middleBoss/jump/Jump_00086.png";
	public static final String KIOSK_JUMP_28 = "/WorldOne/middleBoss/jump/Jump_00087.png";	
	public static final String KIOSK_JUMP_29 = "/WorldOne/middleBoss/jump/Jump_00088.png";
	public static final String KIOSK_JUMP_30 = "/WorldOne/middleBoss/jump/Jump_00089.png";

	public static final String KIOSK_DEAD_1 = "/WorldOne/middleBoss/crash/Dead_00149.png";
	public static final String KIOSK_DEAD_2 = "/WorldOne/middleBoss/crash/Dead_00150.png";
	public static final String KIOSK_DEAD_3 = "/WorldOne/middleBoss/crash/Dead_00151.png";
	public static final String KIOSK_DEAD_4 = "/WorldOne/middleBoss/crash/Dead_00152.png";
	public static final String KIOSK_DEAD_5 = "/WorldOne/middleBoss/crash/Dead_00153.png";
	public static final String KIOSK_DEAD_6 = "/WorldOne/middleBoss/crash/Dead_00154.png";
	public static final String KIOSK_DEAD_7 = "/WorldOne/middleBoss/crash/Dead_00155.png";
	public static final String KIOSK_DEAD_8 = "/WorldOne/middleBoss/crash/Dead_00156.png";
	public static final String KIOSK_DEAD_9 = "/WorldOne/middleBoss/crash/Dead_00157.png";
	public static final String KIOSK_DEAD_10 = "/WorldOne/middleBoss/crash/Dead_00158.png";
	public static final String KIOSK_DEAD_11 = "/WorldOne/middleBoss/crash/Dead_00159.png";
	public static final String KIOSK_DEAD_12 = "/WorldOne/middleBoss/crash/Dead_00160.png";
	public static final String KIOSK_DEAD_13 = "/WorldOne/middleBoss/crash/Dead_00161.png";
	public static final String KIOSK_DEAD_14 = "/WorldOne/middleBoss/crash/Dead_00162.png";
	public static final String KIOSK_DEAD_15 = "/WorldOne/middleBoss/crash/Dead_00163.png";
	public static final String KIOSK_DEAD_16 = "/WorldOne/middleBoss/crash/Dead_00164.png";
	public static final String KIOSK_DEAD_17 = "/WorldOne/middleBoss/crash/Dead_00165.png";
	public static final String KIOSK_DEAD_18 = "/WorldOne/middleBoss/crash/Dead_00166.png";




















}	