package entities;
import framework.GameObject;
import until.Enums.ObjectId;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Graphics2D;
import until.Constants;
import entities.Block;
import screens.World;
import until.Enums.JumpState;
import until.Enums.Facing;
import entities.BlockDinamic;
import until.Animation;
import until.Assets;
import until.Enums.WalkState;
import framework.Game;
import screens.LadderGame;
import until.Enums.ScreenState;
import until.Enums.PlayMode;
import until.Enums.WorksState;
import until.Enums.Direction;
import until.Enums.Movement;
import until.Enums.Direction;
import until.Audio;
import until.Enums.BinState;
import java.lang.Math;
import until.Enums.EnemySprite;

public class Player extends GameObject{

	private Animation playerIdle;
	private Animation jump;
	private Animation run;
	private Animation fire;

	private LadderGame ladderGame;
	private World world;
	private Assets assets;
	private Game game;

	private long jumpStartTime;
	private float[] initialPosition;
	private float velocityXMoving;
	private float timer;
	private float countDown;
	private float timerWarning;
	private float countWarning;
	private float timerHitBoss;
	private float countDownBoss;
	private float countRenderHit = 0;
	private float timerRenderHit = 0;
	private float timerEarthQuake;
	private float countDownEarthQuake;
	private float temp;

	private Boolean[] done;
	private Boolean done5;
	private Boolean bossHit;
	private Boolean renderFlag;
	private Boolean earthHit;
	private Boolean quakeFlag;
	private boolean createPortal;
	private boolean createPortalB;
	private boolean createBossMiddle;
	private boolean onDinamicBlock;
	private Boolean middleBossDead;
	private boolean faceTwo; 
	private Boolean createBlast;
	private Boolean fallOne;
	private Boolean bossDead;
	private Boolean shock;
	private Boolean shockRender;
	private Boolean[] doneWorks;

	private int flag = 0;
	private int tempY = 0;
	private float tempShockY;
	private int positionTrashY;

	public Player(float x, float y, ObjectId id, World world, Assets assets){
		super(x , y, id);
		this.assets = assets;
		this.world = world;
		this.game = game;
		hit = false;
		initialPosition = new float[2];
		doneWorks = new Boolean[4];
		// 0 the x coordinates
		// 1 the y coordinates 
		initialPosition[0] = x;
		initialPosition[1] = y;
		falling = true;
		jumping = false;
		velocityXMoving = 0;
		onDinamicBlock = false;
		temp = 0;
		facing = Facing.RIGHT;
		walkState = WalkState.NOT_WALKING;
		health = Constants.PLAYER_HEALTH;
		death = false;
		lives = 0;
		velocityHitX = 0;
		createPortal = false;
		createPortalB = false;
		createBossMiddle = false;
		timer = 0;
		countDown = 0;
		timerWarning = 0;
		countWarning = 0;
		done = new Boolean[10];
		done5 = false;
		bossHit = false;
		timerHitBoss = 0;
		countDownBoss = 0;
		countRenderHit = 0;
		timerRenderHit = 0;
		timerEarthQuake = 0;
		countDownEarthQuake = 0;
		renderFlag = false;
		earthHit = false;
		quakeFlag = false;
		middleBossDead = false;
		positionTrashY = 0;
		fireBlast = false;
		createBlast = false;
		fallOne = false;
		bossDead = false; 
		shock = false;
		tempShockY = 0;
		shockRender = false;
		faceTwo = false;
		for(int i = 0; i < done.length; i++){
				done[i] = false;
		}

		for(int i = 0; i < doneWorks.length; i++){
				doneWorks[i] = false;
		}


		animation();

	}

	public Player(float x, float y, ObjectId id, LadderGame ladderGame, Assets assets, Game game){
		super(x , y, id);
		this.assets = assets;
		this.game = game;
		this.ladderGame = ladderGame;
		hit = false;
		healthLadderGame = 3;
		velocityHitX = 0;
		initialPosition = new float[2];
		// 0 the x coordinates
		// 1 the y coordinates 
		initialPosition[0] = x;
		initialPosition[1] = y;
		doneWorks = new Boolean[4];
		falling = true;
		jumping = false;
		velocityXMoving = 0;
		onDinamicBlock = false;
		temp = 0;
		facing = Facing.RIGHT;
		walkState = WalkState.NOT_WALKING;
		death = false;
		health = Constants.PLAYER_HEALTH;
		lives = 0;
		createPortal = false;
		createPortalB = false;
		timer = 0;
		countDown = 0;
		timerWarning = 0;
		countWarning = 0;
		done = new Boolean[10];
		done5 = false;
		bossHit = false;
		timerHitBoss = 0;
		countDownBoss = 0;
		countRenderHit = 0;
		timerRenderHit = 0;
		timerEarthQuake = 0;
		countDownEarthQuake = 0;
		renderFlag = false;
		earthHit = false;
		quakeFlag = false;
		createBossMiddle = false;
		middleBossDead = false;
		positionTrashY = 0;
		fireBlast = false;
		createBlast = false;
		fallOne = false;
		bossDead = false; 
		shock = false; 
		tempShockY = 0;
		shockRender = false;
		faceTwo = false;
		for(int i = 0; i < done.length; i++){
			done[i] = false;
		}
		
		for(int i = 0; i < doneWorks.length; i++){
			doneWorks[i] = false;
		}

		
		animation();
	}






	private void animation(){

		playerIdle = new Animation(Constants.PLAYER_IDLE_ANIMATION_SPEED,
			assets.playerIdle[0], assets.playerIdle[1], assets.playerIdle[2], assets.playerIdle[3], 
			assets.playerIdle[4], assets.playerIdle[5], assets.playerIdle[6], assets.playerIdle[7],
			assets.playerIdle[8], assets.playerIdle[9]);


		jump = new Animation(Constants.PLAYER_JUMP_ANIMATION_SPEED,
			assets.playerJmp[0], assets.playerJmp[1], assets.playerJmp[2], assets.playerJmp[3], 
			assets.playerJmp[4]);

		run = new Animation(Constants.PLAYER_RUN_ANIMATION_SPEED,
			assets.playerRun[0], assets.playerRun[1], assets.playerRun[2], assets.playerRun[3], 
			assets.playerRun[4], assets.playerRun[5], assets.playerRun[6], assets.playerRun[7]
			);

		fire = new Animation(Constants.PLAYER_FIRE_ANIMATION_SPEED,
			assets.playerFire[0], assets.playerFire[1], assets.playerFire[2], assets.playerFire[3], 
			assets.playerFire[4], assets.playerFire[5], assets.playerFire[6], assets.playerFire[7],
			assets.playerFire[8]);

	}




	public void respawn()
	{
		x = initialPosition[0];
		y = initialPosition[1];
		velocityY = 0;
		velocityX = 0;
		velocityHitX = 0;
		lives += 1;
		falling = true;
		jumping = false;
		health = Constants.PLAYER_HEALTH;
		world.setScore(0);

		if((done[6]) && (done[7])){

			for(int i = 0; i < world.getBlocks().size(); i++){
				GameObject object = world.getBlocks().get(i);
				if(object.getObjectId() == ObjectId.MiddleBoss){
					if(object.getHealth() <= 0){
						middleBossDead = true;
					}else if(object.isFaceTwo()){
						faceTwo = true;
					}
				}
			}

			if(!middleBossDead && !faceTwo){
				world.getSawsMiddleBoss().clear();
				world.getBlocks().removeLast();
				world.getBlocksDinamics().removeLast();
				world.getBlocksDinamics().removeLast();
				createBossMiddle = false;
				for(int i = 0; i < done.length; i++){
					done[i] = false;
				}
				done5 = false;
			}

			if(faceTwo){
				world.getSawsMiddleBoss().clear();
				world.getBlocks().removeLast();
				createBossMiddle = false;
				for(int i = 0; i < done.length; i++){
					done[i] = false;
				}
				done5 = false;
			}
		}
		
	}



	public void update(double delta)
	{
		


		if(!earthHit || bossHit){
			x += velocityX * (float)delta;
			y += velocityY * (float)delta;
		}
	
			
		
		

	
	
		if(hit || bossHit){
			x += velocityHitX * (float)delta;
		}

		if(x <= 0 ){
			x = 0;
		}


		// kill plane 
		// if the player fall's below the GAME_WINDOW_HEIGHT + 100
		// the player will respawn
		if(y > (Constants.GAME_WINDOW_HEIGHT + 100)){
			death = true;
			respawn();
		}

		if(health <= 0){
			respawn();
			death = true;
		}


		if((falling || jumping )){
			velocityY += Constants.GRAVITY * (float)delta;
		}else{
			velocityY = 0;
		}


		if((int)(y ) > tempY){
			fallOne = true;
		}else{
			fallOne = false;
		}



		animationSelect();
		collisionsPlatform();
		collisionsBlockDinamic();
		createWorks();
		if(!done[6])collisionEnemies();
		if(!done[6])collisionEnemiesWorks();
		if(!done[6])collisionSaw();
		collisionTrash();
		if(!done[6])collisionPortal();
		if(!done[6])collisionPortalB();
		createMiddleBoss();
		if(done[7] && !bossDead){collisionsMiddleBoss();}
		if(done[6] && !bossDead)collisionSawBoss();
		if(bossDead)collisionPortalRecycle();
		if(bossHit)hitCountDown();
		if(quakeFlag) earthQuakeShock();
		
	}


	public void update(double delta , ScreenState screenState){

		y +=velocityY * (float)delta;
		x +=velocityX * (float)delta;
		
		if(hit){
			x += velocityHitX * (float)delta;
		}

		if(x <= 0 ){
			x = 0;
		}
		
		if(x >= Constants.GAME_WINDOW_WIDTH - 80){
			x = Constants.GAME_WINDOW_WIDTH - 80;
		}

		if((falling || jumping)){
			velocityY += Constants.GRAVITY * (float)delta;
		}else{
			falling = false;
			velocityY = 0;
			System.out.println(falling);
		}

		if(healthLadderGame <= 0){
			game.setScreenState(ScreenState.LEVEL1);
		}

		collisionsPlatform(screenState);
		if(!bossDead)collisionSpider();
		collisionPortalA();
		animationSelect(0);

	}




	public void render(Graphics g)
	{
		
		Graphics2D g2d = (Graphics2D) g; 
		g.setColor(Color.yellow);


		/*g.drawImage(assets.playerIdle[0], (int)x + Constants.PLAYER_SPRITE_WIDTH - (Constants.PLAYER_OFFET_X / 2), 
			(int)y - (Constants.PLAYER_OFFET_Y / 2), -Constants.PLAYER_SPRITE_WIDTH, Constants.PLAYER_SPRITE_HEIGHT, null);*/

		if(bossHit && !earthHit){
			if(renderFlag){
				spritesRender(g);
			}
		}else if(!bossHit && !earthHit){
			spritesRender(g);
		}

		if(earthHit){
			if(shockRender){
				if(facing == Facing.RIGHT){
					g.drawImage(assets.playerHit[0], (int)x + Constants.PLAYER_SPRITE_WIDTH - (Constants.PLAYER_OFFET_X / 2), 
						(int)y - (Constants.PLAYER_OFFET_Y / 2),  -Constants.PLAYER_SPRITE_WIDTH, Constants.PLAYER_SPRITE_HEIGHT, null);
				}else{
					g.drawImage(assets.playerHit[0], (int)x - (Constants.PLAYER_OFFET_X / 2), 
						(int)y - (Constants.PLAYER_OFFET_Y / 2),  Constants.PLAYER_SPRITE_WIDTH, Constants.PLAYER_SPRITE_HEIGHT, null);
				}
			}
		}


			

		




	}


	private void spritesRender(Graphics g){

			if(facing == Facing.RIGHT && jumping == true && hit == false){

				jump.drawAnimation(g, (int)x + Constants.PLAYER_SPRITE_WIDTH - (Constants.PLAYER_OFFET_X / 2), 
					(int)y - (Constants.PLAYER_OFFET_Y / 2), -Constants.PLAYER_SPRITE_WIDTH, Constants.PLAYER_SPRITE_HEIGHT);

			}else if(facing == Facing.RIGHT && jumping == true && hit == true ){

				g.drawImage(assets.playerHit[0], (int)x + Constants.PLAYER_SPRITE_WIDTH - (Constants.PLAYER_OFFET_X / 2), 
					(int)y - (Constants.PLAYER_OFFET_Y / 2),  -Constants.PLAYER_SPRITE_WIDTH, Constants.PLAYER_SPRITE_HEIGHT, null);

			}else if(facing == Facing.RIGHT && jumping == false && hit == false && fallOne == true){

				g.drawImage(assets.playerJmp[4], (int)x + Constants.PLAYER_SPRITE_WIDTH - (Constants.PLAYER_OFFET_X / 2), 
					(int)y - (Constants.PLAYER_OFFET_Y / 2),  -Constants.PLAYER_SPRITE_WIDTH, Constants.PLAYER_SPRITE_HEIGHT, null);

			}else if(facing == Facing.RIGHT && jumping == true && hit == false && fallOne == true){

				jump.drawAnimation(g, (int)x + Constants.PLAYER_SPRITE_WIDTH - (Constants.PLAYER_OFFET_X / 2), 
					(int)y - (Constants.PLAYER_OFFET_Y / 2), -Constants.PLAYER_SPRITE_WIDTH, Constants.PLAYER_SPRITE_HEIGHT);

			}else if(facing == Facing.RIGHT && walkState == WalkState.NOT_WALKING && jumping == false && fireBlast == false){

				playerIdle.drawAnimation(g, (int)x + Constants.PLAYER_SPRITE_WIDTH - (Constants.PLAYER_OFFET_X / 2), 
					(int)y - (Constants.PLAYER_OFFET_Y / 2), -Constants.PLAYER_SPRITE_WIDTH, Constants.PLAYER_SPRITE_HEIGHT);

			}else if(facing == Facing.RIGHT && walkState == WalkState.NOT_WALKING && jumping == false && fireBlast == true){

				fire.drawAnimation(g, (int)x + Constants.PLAYER_SPRITE_FIRE_WIDTH - (Constants.PLAYER_OFFET_X + 28), 
					(int)y - (Constants.PLAYER_OFFET_Y - 10), -Constants.PLAYER_SPRITE_FIRE_WIDTH, Constants.PLAYER_SPRITE_FIRE_HEIGHT);

			}else if(facing == Facing.RIGHT && walkState == WalkState.WALKING && jumping == false){

				run.drawAnimation(g, (int)x + Constants.PLAYER_SPRITE_RUN_WIDTH - (Constants.PLAYER_OFFET_X + 54), 
					(int)y - (Constants.PLAYER_OFFET_Y / 2), -Constants.PLAYER_SPRITE_RUN_WIDTH, Constants.PLAYER_SPRITE_RUN_HEIGHT);

			}else if(facing == Facing.LEFT &&  jumping == true && hit == false){

				jump.drawAnimation(g, (int)x - (Constants.PLAYER_OFFET_X / 2), (int)y - (Constants.PLAYER_OFFET_Y / 2), 
					Constants.PLAYER_SPRITE_WIDTH,Constants.PLAYER_SPRITE_HEIGHT);

			}else if(facing == Facing.LEFT &&  jumping == true && hit == true){

				g.drawImage(assets.playerHit[0], (int)x - (Constants.PLAYER_OFFET_X / 2), 
					(int)y - (Constants.PLAYER_OFFET_Y / 2),  Constants.PLAYER_SPRITE_WIDTH, Constants.PLAYER_SPRITE_HEIGHT, null);

			}else if(facing == Facing.LEFT &&  jumping == false && hit == false && fallOne == true){

				g.drawImage(assets.playerJmp[4], (int)x - (Constants.PLAYER_OFFET_X / 2), 
					(int)y - (Constants.PLAYER_OFFET_Y / 2),  Constants.PLAYER_SPRITE_WIDTH, Constants.PLAYER_SPRITE_HEIGHT, null);

			}else if(facing == Facing.LEFT &&  jumping == true && hit == false && fallOne == true){

				jump.drawAnimation(g, (int)x - (Constants.PLAYER_OFFET_X / 2), (int)y - (Constants.PLAYER_OFFET_Y / 2), 
					Constants.PLAYER_SPRITE_WIDTH,Constants.PLAYER_SPRITE_HEIGHT);

			}else if(facing == Facing.LEFT && walkState == WalkState.NOT_WALKING && jumping == false && fireBlast == false){

				playerIdle.drawAnimation(g, (int)x - (Constants.PLAYER_OFFET_X / 2), (int)y - (Constants.PLAYER_OFFET_Y / 2), 
					Constants.PLAYER_SPRITE_WIDTH,Constants.PLAYER_SPRITE_HEIGHT);

			}else if(facing == Facing.LEFT && walkState == WalkState.NOT_WALKING && jumping == false && fireBlast == true){

				fire.drawAnimation(g, (int)x - (Constants.PLAYER_OFFET_X + 13), (int)y - (Constants.PLAYER_OFFET_Y - 10), 
					Constants.PLAYER_SPRITE_FIRE_WIDTH, Constants.PLAYER_SPRITE_FIRE_HEIGHT );

			}else if(facing == Facing.LEFT && walkState == WalkState.WALKING && jumping == false){

				run.drawAnimation(g, (int)x - (Constants.PLAYER_OFFET_X + 10), (int)y - (Constants.PLAYER_OFFET_Y / 2), 
					Constants.PLAYER_SPRITE_RUN_WIDTH, Constants.PLAYER_SPRITE_RUN_HEIGHT);

			}
	
	}



	private void animationSelect(){
		if(!fireBlast){
			switch(walkState){
				case NOT_WALKING: playerIdle.runAnimation(PlayMode.LOOP); break;
				case WALKING:  run.runAnimation(PlayMode.LOOP); break;
			}

			if(jumping)jump.runAnimation(PlayMode.NORMAL);

		}else if(fireBlast){
			fire.runAnimation(PlayMode.NORMAL);

			if(!jumping){
				velocityX = 0;
				velocityY = 0;
			}

			if(fire.getCount() == 5)createBlast();
			if(fire.isFinish()){
				fire.setCount(0);
				fire.setFinish(false);
				fireBlast = false;
				createBlast = false;
			}	
		} 

	}


	private void createBlast(){
		if(fireBlast){
			if(!createBlast){
				Audio.play(Constants.PLAYER_LASER_GUN_ID);
				world.addBlasts(new Blast(
	   				x,
	   				y - 15,
	   				ObjectId.FireBall,
	   				facing,
	   				world,
	   				assets
	   				));
				createBlast = true;
			}
		}
	}


	private void createWorks(){
		if(((int)x >= (3679) || (int)x <= (3690)) && !doneWorks[0]){
			if(!doneWorks[0]){
				world.addObject(new Works(
					Constants.GAME_WINDOW_WIDTH * 5 - 50,
					(Constants.GAME_WINDOW_HEIGHT - 180) - Constants.WOKRS_HEIGHT,
					ObjectId.Portal,
					assets,
					world,
					1,
					(Constants.GAME_WINDOW_WIDTH * 3) + (Constants.GAME_WINDOW_WIDTH * 2) - Constants.DINAMIC_BLOCK_WIDTH,
					Constants.GAME_WINDOW_WIDTH * 3 
				));
				doneWorks[0] = true;
			}
		}else if(((int)x >= 6485 && (int)x <= 6500) && !doneWorks[2]){
			if(!doneWorks[2]){
				int positionOffset = 0;
				for ( int i = 0; i < 3; i++) {
					world.addEnemies(new GangstaWheel( 
						(Constants.GAME_WINDOW_WIDTH * 6 + 500) + positionOffset, 
						Constants.GAME_WINDOW_HEIGHT - Constants.ENEMY_RECTANGLE_HEIGHT - 50, 
						ObjectId.Wheel,
						assets,
						world,
						(Constants.GAME_WINDOW_WIDTH * 5 + 500) + Constants.GAME_WINDOW_WIDTH * 2,
						(Constants.GAME_WINDOW_WIDTH * 5 + 500),
						EnemySprite.WHEEL
						));
						positionOffset += 400;
				}	
				doneWorks[2] = true;
			}
		}else if( ((int)x >= 13310 && (int)x <= 13350) && !doneWorks[1]){
			if(!doneWorks[1]){
				world.addObject(new Works(
				Constants.GAME_WINDOW_WIDTH * 14 + 300,
				((Constants.GAME_WINDOW_HEIGHT / 2) + 100) - (Constants.WOKRS_HEIGHT - 30),
				ObjectId.PortalB,
				assets,
				world,
				1,
				(Constants.GAME_WINDOW_WIDTH * 11 +  500) + (Constants.GAME_WINDOW_WIDTH * 2 + Constants.GAME_WINDOW_WIDTH / 2 + 100),
				Constants.GAME_WINDOW_WIDTH * 11 +  500
				));
				doneWorks[1] = true;
			}
		}
		
	}

	private void animationSelect(int a){
		if(!fireBlast){
			switch(walkState){
				case NOT_WALKING: playerIdle.runAnimation(PlayMode.LOOP); break;
				case WALKING:  run.runAnimation(PlayMode.LOOP); break;
			}

			if(jumping)jump.runAnimation(PlayMode.NORMAL);

		}else if(fireBlast){
			fire.runAnimation(PlayMode.NORMAL);

			if(!jumping){
				velocityX = 0;
				velocityY = 0;
			}

			if(fire.getCount() == 5)createBlast(0);
			if(fire.isFinish()){
				fire.setCount(0);
				fire.setFinish(false);
				fireBlast = false;
				createBlast = false;
			}	
		} 

	}


	private void createBlast(int a){
		if(fireBlast){
			if(!createBlast){
				Audio.play(Constants.PLAYER_LASER_GUN_ID);
				ladderGame.addBlasts(new Blast(
	   				x,
	   				y,
	   				ObjectId.FireBall,
	   				facing,
	   				ladderGame,
	   				assets
	   				));
				createBlast = true;
			}
		}
	}



	private void hitCountDown(){

		if((int)countDownBoss >= 2){
			countDownBoss = 0;
			timerHitBoss = 0;
			bossHit = false;
			return;
		}

		renderHItBoss();

		timerHitBoss =  timerHitBoss + 10f;
 		countDownBoss = timerHitBoss * 0.0019f;

	}


	private void renderHItBoss(){

		if(!bossHit){
			return;
		}

		renderFlag = !renderFlag;

	}



	private void createMiddleBoss(){
		if((x >= (Constants.GAME_WINDOW_WIDTH * 14 + Constants.PLAYER_JUNP_LENGTH + 500)) && (!createBossMiddle)){
			velocityX = 0;
			velocityY = 0;
			int positionX = (Constants.GAME_WINDOW_WIDTH * 15 + 800);

			world.addObject(new KioskBoss(
				positionX,
				Constants.GAME_WINDOW_HEIGHT - (75 - Constants.BLOCK_HEIGHT) - Constants.KIOSK_HEIGHT,
				ObjectId.MiddleBoss,
				assets,
				world,
				Direction.STATIC
				));
			createBossMiddle = true;
		}else if((x >= (Constants.GAME_WINDOW_WIDTH * 14 + Constants.PLAYER_JUNP_LENGTH + 500)) && (!done[6])){
			velocityX = 0;
			velocityY = 0;
			createMiddleBossSaw();
		}else if((x >= (Constants.GAME_WINDOW_WIDTH * 15 + 700)) && (!done[7])){
			velocityX = 0;
			velocityY = 0;
			warningSing();
		}
	}

	private void createMiddleBossSaw(){

		if((int)countDown >= 6){
			countDown = 0;
			timer = 0;
			done5 = false;
			done[5] = done5;
			done[6] = true;
			return;
		}

		sawCreation();


		timer =  timer + 10f;
 		countDown = timer * 0.0019f;
 		done5 = true;
 		done[5] = done5;
	}


	private void sawCreation(){
		if((int)countDown == 1){
			if(done[0]){
				return;
			}
			world.getSawsMiddleBoss().add(
				new Saw((Constants.GAME_WINDOW_WIDTH * 14 + Constants.PLAYER_JUNP_LENGTH + 200) - Constants.SAW_WIDTH,
					Constants.GAME_WINDOW_HEIGHT - (Constants.SAW_HEIGHT),
					ObjectId.Spyke,
					assets,
					Movement.STATIC
					));
			world.getSawsMiddleBoss().add(
				new Saw((Constants.GAME_WINDOW_WIDTH * 14 + Constants.PLAYER_JUNP_LENGTH + 120) + (Constants.GAME_WINDOW_WIDTH * 2) + Constants.SAW_WIDTH,
					Constants.GAME_WINDOW_HEIGHT - (Constants.SAW_HEIGHT ),
					ObjectId.Spyke,
					assets,
					Movement.STATIC
					));
			done[0] = true;

		}else if((int)countDown == 2){
			if(done[1]){
				return;
			}
			world.getSawsMiddleBoss().add(
				new Saw((Constants.GAME_WINDOW_WIDTH * 14 + Constants.PLAYER_JUNP_LENGTH + 200) - Constants.SAW_WIDTH,
					Constants.GAME_WINDOW_HEIGHT - (Constants.SAW_HEIGHT * 2),
					ObjectId.Spyke,
					assets,
					Movement.STATIC
					));

			world.getSawsMiddleBoss().add(
				new Saw((Constants.GAME_WINDOW_WIDTH * 14 + Constants.PLAYER_JUNP_LENGTH + 120) + Constants.GAME_WINDOW_WIDTH * 2 + Constants.SAW_WIDTH,
					Constants.GAME_WINDOW_HEIGHT - (Constants.SAW_HEIGHT * 2),
					ObjectId.Spyke,
					assets,
					Movement.STATIC
					));

			done[1] = true;

		}else if((int)countDown == 3){
			if(done[2]){
				return;
			}
			world.getSawsMiddleBoss().add(
				new Saw((Constants.GAME_WINDOW_WIDTH * 14 + Constants.PLAYER_JUNP_LENGTH + 200) - Constants.SAW_WIDTH,
					Constants.GAME_WINDOW_HEIGHT - (Constants.SAW_HEIGHT * 3),
					ObjectId.Spyke,
					assets,
					Movement.STATIC
					));
			world.getSawsMiddleBoss().add(
				new Saw((Constants.GAME_WINDOW_WIDTH * 14 + Constants.PLAYER_JUNP_LENGTH + 120) + Constants.GAME_WINDOW_WIDTH * 2 + Constants.SAW_WIDTH,
					Constants.GAME_WINDOW_HEIGHT - (Constants.SAW_HEIGHT * 3),
					ObjectId.Spyke,
					assets,
					Movement.STATIC
					));
			done[2] = true;

		}else if((int)countDown == 4){
			if(done[3]){
				return;
			}
			world.getSawsMiddleBoss().add(
				new Saw((Constants.GAME_WINDOW_WIDTH * 14 + Constants.PLAYER_JUNP_LENGTH + 200) - Constants.SAW_WIDTH,
					Constants.GAME_WINDOW_HEIGHT - (Constants.SAW_HEIGHT * 4),
					ObjectId.Spyke,
					assets,
					Movement.STATIC
					));
			world.getSawsMiddleBoss().add(
				new Saw((Constants.GAME_WINDOW_WIDTH * 14 + Constants.PLAYER_JUNP_LENGTH + 120) + Constants.GAME_WINDOW_WIDTH * 2 + Constants.SAW_WIDTH,
					Constants.GAME_WINDOW_HEIGHT - (Constants.SAW_HEIGHT * 4),
					ObjectId.Spyke,
					assets,
					Movement.STATIC
					));
			done[3] = true;

		}else if((int)countDown == 5){
			if(done[4]){
				return;
			}
			world.getSawsMiddleBoss().add(
				new Saw((Constants.GAME_WINDOW_WIDTH * 14 + Constants.PLAYER_JUNP_LENGTH + 200)- Constants.SAW_WIDTH,
					Constants.GAME_WINDOW_HEIGHT - (Constants.SAW_HEIGHT * 5),
					ObjectId.Spyke,
					assets,
					Movement.STATIC
					));
			world.getSawsMiddleBoss().add(
				new Saw((Constants.GAME_WINDOW_WIDTH * 14 + Constants.PLAYER_JUNP_LENGTH + 120 + Constants.GAME_WINDOW_WIDTH * 2) + Constants.SAW_WIDTH,
					Constants.GAME_WINDOW_HEIGHT - (Constants.SAW_HEIGHT * 5),
					ObjectId.Spyke,
					assets,
					Movement.STATIC
					));

			world.addObjectDinamic(
				new BlockDinamic(
				((Constants.GAME_WINDOW_WIDTH * 14 + Constants.PLAYER_JUNP_LENGTH + 300)) + Constants.DINAMIC_BLOCK_WIDTH,
				(Constants.GAME_WINDOW_HEIGHT /2) + 50,
				ObjectId.BlockDinamic,
				Constants.DINAMIC_BLOCK_WIDTH,
				Constants.DINAMIC_BLOCK_HEIGTH,
				assets,
				Direction.STATIC
				));

			world.addObjectDinamic(
				new BlockDinamic(
				((Constants.GAME_WINDOW_WIDTH * 14 + Constants.PLAYER_JUNP_LENGTH ) + Constants.GAME_WINDOW_WIDTH * 2) - Constants.DINAMIC_BLOCK_WIDTH,
				(Constants.GAME_WINDOW_HEIGHT /2) + 50,
				ObjectId.BlockDinamic,
				Constants.DINAMIC_BLOCK_WIDTH,
				Constants.DINAMIC_BLOCK_HEIGTH,
				assets,
				Direction.STATIC
				));
			done[4] = true;
		}
	}

	private void warningSing(){
		if((int)countWarning >= 5){
			countWarning = 0;
			timerWarning = 0;
			Audio.stop(Constants.WARNING_SOUND_ID);
			world.getSawsMiddleBoss().removeLast();
			for(int i = 0; i < world.getBlocks().size(); i++){
				GameObject object = world.getBlocks().get(i);
				if(object.getObjectId() == ObjectId.MiddleBoss){
					object.setWalkState( WalkState.WALKING);
				}
			}
			done[7] = true;
			done5 = false;
			done[5] = done5;
			return;
		}

		createWarning();
	
		timerWarning =  timerWarning + 10f;
 		countWarning = timerWarning * 0.0019f;
 		done5 = true;
 		done[5] = done5;
	}

	private void createWarning(){
		if((int)countWarning == 0){
			if(done[8]){
				return;
			}
			
			Audio.play(Constants.WARNING_SOUND_ID);
			world.getSawsMiddleBoss().add(new Warning(
				world.getPlayer().getX() - 600,
				(Constants.GAME_WINDOW_HEIGHT / 2) - 125,
				ObjectId.WarningBoss,
				assets
				));
			for(int i = 0; i < world.getBlocks().size(); i++){
				GameObject object = world.getBlocks().get(i);
				if(object.getObjectId() == ObjectId.MiddleBoss){
					object.setDirection(Direction.HORIZONTAL);
				}
			}
			done[8] = true;
		}
	}


	private void collisionsPlatform(){
		

			for(int i = 0; i < world.getBlocks().size(); i++)
			{

				GameObject block = world.getBlocks().get(i);
				if(block.getObjectId() == ObjectId.Block){
					collisionCheck(block);
				}
			}
					
	}


	private void collisionCheck(GameObject block){

			if(getBounds().intersects(block.getBounds()))
					{
						hit = false;
						jumping = false;
						velocityHitX = 0;
						falling = false;
						velocityY = 0;
						y = block.getY() - Constants.PLAYER_RECTANGLE_HEIGHT;
						tempY = (int)y + 20;
						jump.setCount(0);
						flag = 1;
						earthQuakeCollision();
					
				}else {

					falling = true;
				}
				
	}



	private void collisionsMiddleBoss(){
		if(world != null){
			for(int i = 0; i < world.getBlocks().size(); i++)
			{
				GameObject object = world.getBlocks().get(i);
				if(object.getObjectId() == ObjectId.MiddleBoss){
					if(object.getHealth() != 0){
						if(!bossHit){
							if(getBoundsLeft().intersects(object.getBoundsTop())){
								bossHit = true;
								health -= 20;
								jumping = true;
								velocityHitX = (Constants.PLAYER_NOCKBACK_VELOCITY[0] + Constants.PLAYER_NOCKBACK_OFFSET);
								velocityY = -(Constants.PLAYER_NOCKBACK_VELOCITY[1] + Constants.PLAYER_NOCKBACK_OFFSET);
							}
						if(getBoundsRight().intersects(object.getBoundsTop())){
								bossHit = true;
								health -= 20;
								jumping = true;
								velocityHitX = -(Constants.PLAYER_NOCKBACK_VELOCITY[0] + Constants.PLAYER_NOCKBACK_OFFSET);
								velocityY = -(Constants.PLAYER_NOCKBACK_VELOCITY[1] + Constants.PLAYER_NOCKBACK_OFFSET);
							}
						}
					}else{
						bossDead = true;
					}
				}
			}
		}
	}


	private void earthQuakeCollision(){
		if(world != null){
			if(world.getBlocks() != null){
				for(int i = 0; i < world.getBlocks().size(); i++){
					GameObject boss = world.getBlocks().get(i);
					if(boss.getObjectId() == ObjectId.MiddleBoss){
						if((boss.gethitGround())){
							quakeFlag = true;
						}
					}
				}
			}
		}
	}


	private void earthQuakeShock(){
		if((int)countDownEarthQuake == 2){
			countDownEarthQuake = 0;
			timerEarthQuake = 0;
			earthHit = false;
			quakeFlag = false;
			return;
		}

	
		earthHit = true;
		velocityX = 0;

		shockRender = !shockRender;




		timerEarthQuake =  timerEarthQuake + 10f;
 		countDownEarthQuake = timerEarthQuake * 0.0019f;

	}






	
	private void collisionsPlatform(ScreenState screenState){
		for(int  i = 0; i < ladderGame.getGameObjects().size(); i++){
			GameObject object = ladderGame.getGameObjects().get(i);
			if(object.getObjectId() == ObjectId.Block){
				if(getBounds().intersects(object.getBounds())){
					hit = false;
					jumping = false;
					velocityHitX = 0;
					velocityY = 0;
					jump.setCount(0);
					y = object.getY() - Constants.PLAYER_RECTANGLE_HEIGHT;
				}
			}
		}	
	}

	private void collisionsBlockDinamic(){
		if(world != null){
			for(int i = 0; i < world.getBlocksDinamics().size(); i++)
			{
				GameObject blockDinamic = world.getBlocksDinamics().get(i);
				if(blockDinamic.getObjectId() == ObjectId.BlockDinamic){
					if(getBounds().intersects(blockDinamic.getBounds()))
					{
						hit = false;
						jumping = false;
						velocityHitX = 0;
						falling = false;
						velocityY = 0;
						y = blockDinamic.getY() - (Constants.PLAYER_RECTANGLE_HEIGHT - 20);
						tempY = (int)y + 20;
						jump.setCount(0);
			
					}else{
						falling = true;
					}
				}
			}
		}
	}

	private void collisionPortalRecycle(){
		if(world != null){
			for(int i = 0; i < world.getBlocks().size(); i++)
			{
				GameObject block = world.getBlocks().get(i);
				if(block.getObjectId() == ObjectId.PortalRecycle){
					if(getBoundsTop().intersects(block.getBounds()))
					{
						System.out.println("hola");
						world.getGame().setScreenState(ScreenState.RECYCLE);
						world.getGame().startScreens();
						x = x + 200;
						y = y - 200;
					}
				}
			}
		}
	}

	private void collisionPortal(){
		if(createPortal){
			return;
		}
		if(world != null){
			for(int i = 0; i < world.getBlocks().size(); i++)
			{
				GameObject block = world.getBlocks().get(i);
				if(block.getObjectId() == ObjectId.Portal){
					if(getBounds().intersects(block.getBounds()))
					{	
						velocityX = 0;
						velocityY = 0;
						velocityHitX  = 0;
						x = x - 600;
						y = 0;
						world.getGame().setScreenState(ScreenState.LADDERGAME);
						world.getGame().startScreens();
					}
				}
			}
		}
	}

	private void collisionPortalB(){
		if(createPortalB){
			return;
		}
		if(world != null){
			for(int i = 0; i < world.getBlocks().size(); i++)
			{
				GameObject block = world.getBlocks().get(i);
				if(block.getObjectId() == ObjectId.PortalB){
					if(getBounds().intersects(block.getBounds()))
					{	

						velocityX = 0;
						velocityY = 0;
						velocityHitX  = 0;
						x = x - 600;
						y = 0;
						world.getGame().setScreenState(ScreenState.LADDERGAME);
						world.getGame().startScreens();
					}
				}
			}
		}
	}



	private void collisionSpider(){
		for(int  i = 0; i < ladderGame.getGameObjects().size(); i++){
			GameObject object = ladderGame.getGameObjects().get(i);
			if(object.getObjectId() == ObjectId.Spider){
				if(object.getHealth() != 0){
					if(!hit){
						if(getBoundsLeft().intersects(object.getBoundsTop())){
							hit = true;
							healthLadderGame -= 1;
							jumping = true;
							velocityY = -(Constants.PLAYER_NOCKBACK_VELOCITY[1]  + 3);
							velocityHitX = (Constants.PLAYER_NOCKBACK_VELOCITY[0]  + 3);
						}
					if(getBoundsRight().intersects(object.getBoundsTop())){
							hit = true;
							healthLadderGame -= 1;
							jumping = true;
							velocityY = -(Constants.PLAYER_NOCKBACK_VELOCITY[1]  + 3);
							velocityHitX = -(Constants.PLAYER_NOCKBACK_VELOCITY[0] + 3);
						}
					}
			    }else if(object.getHealth() == 0){
			    	if(createPortal){
			    		break;
			    	}else{
			    		ladderGame.addObject(
			    		new PortalA(
			    			(Constants.GAME_WINDOW_WIDTH /2) - 80,
			    			(Constants.GAME_WINDOW_HEIGHT / 2) - 80,
			    			ObjectId.PortalA
			    			)
			    		 );
			    		createPortal = true;
			    		bossDead = true;
			    	}
			    }
			}
		}
	}


	private void collisionEnemies(){
		if(world != null){
			if(world.getEnemies().size() != 0){
				for(int i = 0; i < world.getEnemies().size(); i++){
					GameObject object = world.getEnemies().get(i);
					if(object.getObjectId() == ObjectId.Wheel){
						if(!hit){
							if((object.getHealth() != 0) && hit == false){
								if(getBoundsRight().intersects(object.getBounds())){
									health -= 10;
									hit = true;
									jumping = true;
									velocityHitX = -(Constants.PLAYER_NOCKBACK_VELOCITY[0] + Constants.PLAYER_NOCKBACK_OFFSET);
									velocityY = -(Constants.PLAYER_NOCKBACK_VELOCITY[1] + Constants.PLAYER_NOCKBACK_OFFSET);
								}else if(getBoundsLeft().intersects(object.getBounds())){
									health -= 10;
									hit = true;
									jumping = true;
									velocityHitX = (Constants.PLAYER_NOCKBACK_VELOCITY[0] + Constants.PLAYER_NOCKBACK_OFFSET);
									velocityY = -(Constants.PLAYER_NOCKBACK_VELOCITY[1] + Constants.PLAYER_NOCKBACK_OFFSET);
								}
							}
						}
					}
				}
			}
		}
	}

	private void collisionEnemiesWorks(){
		if(world != null){
			if(world.getBlocks().size() != 0){
				for(int i = 0; i < world.getBlocks().size(); i++){
					GameObject object = world.getBlocks().get(i);
					if(object.getObjectId() == ObjectId.Portal || object.getObjectId() == ObjectId.PortalB){
						if(object.getEnemiesWorks() != null){
							for(int j = 0; j < object.getEnemiesWorks().size(); j++){
								GameObject enemy = object.getEnemiesWorks().get(j);
								if((enemy.getHealth() != 0) && hit == false){
									if(getBoundsRight().intersects(enemy.getBounds())){
										health -= 10;
										hit = true;
										jumping = true;
										velocityHitX = -(Constants.PLAYER_NOCKBACK_VELOCITY[0] + Constants.PLAYER_NOCKBACK_OFFSET);
										velocityY = -(Constants.PLAYER_NOCKBACK_VELOCITY[1] + Constants.PLAYER_NOCKBACK_OFFSET);
									}else if(getBoundsLeft().intersects(enemy.getBounds())){
										health -= 10;
										hit = true;
										jumping = true;
										velocityHitX = (Constants.PLAYER_NOCKBACK_VELOCITY[0] + Constants.PLAYER_NOCKBACK_OFFSET);
										velocityY = -(Constants.PLAYER_NOCKBACK_VELOCITY[1] + Constants.PLAYER_NOCKBACK_OFFSET);
									}
								}
							}	
						}
					}
				}
			}
		}
	}

	private void collisionSaw(){
		if(world != null){
			if(world.getSaws().size() != 0){
				for(int i = 0; i < world.getSaws().size(); i++){
					GameObject object = world.getSaws().get(i);
					if(object.getObjectId() == ObjectId.Spyke){
						if(!hit){
							if(getBoundsRight().intersects(object.getBounds())){
								health -= 10;
								hit = true;
								jumping = true;
								velocityHitX = -(Constants.PLAYER_NOCKBACK_VELOCITY[0] + Constants.PLAYER_NOCKBACK_OFFSET);
								velocityY = -(Constants.PLAYER_NOCKBACK_VELOCITY[1] + Constants.PLAYER_NOCKBACK_OFFSET);
							}else if(getBoundsLeft().intersects(object.getBounds())){
								health -= 10;
								hit = true;
								jumping = true;
								velocityHitX = (Constants.PLAYER_NOCKBACK_VELOCITY[0] + Constants.PLAYER_NOCKBACK_OFFSET);
								velocityY = -(Constants.PLAYER_NOCKBACK_VELOCITY[1] + Constants.PLAYER_NOCKBACK_OFFSET);
							}
						}
					}
				}
			}
		}
	}

	private void collisionSawBoss(){
		if(world != null){
			if(world.getSawsMiddleBoss().size() != 0){
				for(int i = 0; i < world.getSawsMiddleBoss().size(); i++){
					GameObject object = world.getSawsMiddleBoss().get(i);
					if(object.getObjectId() == ObjectId.Spyke){
						if(!hit){
							if(getBoundsRight().intersects(object.getBounds())){
								hit = true;
								health -= 50;
								jumping = true;
								velocityHitX = -(Constants.PLAYER_NOCKBACK_VELOCITY[0] + Constants.PLAYER_NOCKBACK_OFFSET);
								velocityY = -(Constants.PLAYER_NOCKBACK_VELOCITY[1] + Constants.PLAYER_NOCKBACK_OFFSET);
							}else if(getBoundsLeft().intersects(object.getBounds())){
								hit = true;
								health -= 50;
								jumping = true;
								velocityHitX = (Constants.PLAYER_NOCKBACK_VELOCITY[0] + Constants.PLAYER_NOCKBACK_OFFSET);
								velocityY = -(Constants.PLAYER_NOCKBACK_VELOCITY[1] + Constants.PLAYER_NOCKBACK_OFFSET);
							}
						}
					}
				}
			}
		}
	}


	private void collisionTrash(){
		if(world != null){
			if(world.getTrashObjects().size() != 0){
				for(int i = 0; i < world.getTrashObjects().size(); i++){
					GameObject object = world.getTrashObjects().get(i);
						if(getBoundsRight().intersects(object.getBounds())){
							removeTrash(object);
							world.setScore(world.getScore() + 50);
						}else if(getBoundsLeft().intersects(object.getBounds())){
							removeTrash(object);
							world.setScore(world.getScore() + 50);
					}
					
				}
			}
		}
	}


	private void collisionPortalA(){
		if(ladderGame!= null){
			for(int  i = 0; i < ladderGame.getGameObjects().size(); i++){
			GameObject object = ladderGame.getGameObjects().get(i);
				if(object.getObjectId() == ObjectId.PortalA){
					if(getBoundsLeft().intersects(object.getBounds())
						|| getBoundsRight().intersects(object.getBounds()) ){
						game.setScreenState(ScreenState.LEVEL1);
						game.getWorld().getPlayer().setVelocityX(0);
						game.getWorld().getPlayer().setVelocityY(0);
						game.getWorld().getPlayer().setVelocityHitX(0);
						game.getWorld().getPlayer().setX(game.getWorld().getPlayer().getX() + 650);
						game.getWorld().getPlayer().setY(0);

						if(!game.getWorld().getPlayer().isCreatePortal()){
							for(int j = 0; j < game.getWorld().getBlocks().size(); j++){
								GameObject works = game.getWorld().getBlocks().get(j);
								if(works.getObjectId() == ObjectId.Portal){
									works.setWorksState(WorksState.INACTIVE);
									game.getWorld().getPlayer().setrespawnX(works.getX() + 50);
									game.getWorld().getPlayer().setrespawnY(works.getY() - 50);
								}
							}
							game.getWorld().getPlayer().setCreatePortal(true);
							return;
						}

						if(game.getWorld().getPlayer().isCreatePortal()){
							for(int j = 0; j < game.getWorld().getBlocks().size(); j++){
								GameObject works = game.getWorld().getBlocks().get(j);
								if(works.getObjectId() == ObjectId.PortalB){
									works.setWorksState(WorksState.INACTIVE);
									game.getWorld().getPlayer().setrespawnX(works.getX() + 50);
									game.getWorld().getPlayer().setrespawnY(works.getY() - 50);
								}
							}
							game.getWorld().getPlayer().setCreatePortalB(true);
						}	
					}
			    }
		 	}	
		}
	}


	private void removeTrash(GameObject object){

		world.getTrashObjects().remove(object);
		world.getTrashsList().add(object);
		
	}



	public Rectangle getBounds(){

		return new Rectangle(
			(int)((int)x + (Constants.PLAYER_RECTANGLE_WIDTH / 4)),
			(int)((int)y +  (Constants.PLAYER_RECTANGLE_HEIGHT / 2)),
			(int)Constants.PLAYER_RECTANGLE_WIDTH / 2,
			(int)Constants.PLAYER_RECTANGLE_HEIGHT / 2
			);
	}

	public Rectangle getBoundsTop(){

		return new Rectangle(
			(int)((int)x + (Constants.PLAYER_RECTANGLE_WIDTH / 4)),
			(int)y ,
			(int)Constants.PLAYER_RECTANGLE_WIDTH / 2,
			(int)Constants.PLAYER_RECTANGLE_HEIGHT / 2
			);
	}

	public Rectangle getBoundsRight(){

		return new Rectangle(
			(int)((int)x + (Constants.PLAYER_RECTANGLE_WIDTH - 5)),
			(int)y + 5,
			(int)5.0,
			(int)Constants.PLAYER_RECTANGLE_HEIGHT - 10
			);
	}

	public Rectangle getBoundsLeft(){

		return new Rectangle(
			(int)x,
			(int)y + 5,
			(int)5.0,
			(int)Constants.PLAYER_RECTANGLE_HEIGHT - 10
			);
	}



	public boolean isCreatePortal(){return createPortal;}
	public void setCreatePortal(boolean createPortal){this.createPortal = createPortal;}
	public boolean isCreatePortalB(){return createPortalB;}
	public void setCreatePortalB(boolean createPortalB){this.createPortalB = createPortalB;}
	public Boolean[] getDone(){ return done;}
	public void setDome5(Boolean done5){ 
		this.done5 = done5;
		done[5] = done5;
	}

	public Boolean isEarthQuare(){ return earthHit;}
	public void setrespawnX(float xR){ initialPosition[0] = xR;}
	public void setrespawnY(float yR){ initialPosition[1] = yR;}


}
