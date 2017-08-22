package entities;
import until.Enums.Facing;
import until.Enums.JumpState;
import until.Enums.ObjectId;
import java.awt.Graphics;
import java.awt.Rectangle;
import until.Enums.BinState;
import until.Enums.WalkState;
import until.Enums.JumpState;
import java.util.LinkedList;
import until.Enums.WorksState;
import framework.GameObject;
import until.Assets;
import until.Constants;
import java.awt.Graphics2D;
import java.awt.Color;
import until.Animation;
import until.Enums.PlayMode;
import screens.World;
import until.Enums.Direction;
import until.Audio;

public class KioskBoss extends GameObject{

	private Assets assets;
	private World world;

	private Animation wakeUp;
	private Animation idle;
	private Animation walk;
	private Animation jump;
	private Animation dead;

	private float velocityXMoving;
	private float timerHit;
	private float countHit;
	private float timerRemoveBlocks;
	private float countRemoveBlocks;
	private float timerCrash;
	private float countCrash;
	private float speedY;
	private float xPlayer;
	private float yPlayer;
	private float timerEarthquake;
	private float countEarthquake;
	private float offsetX;
	private float offsetY;
	private float timerBossSpeed;
	private float tempX;
	private float countDownBoss ;
	private float timerHitBoss ;
	


	private int lenght;
	private int origin;
	private int speed;
	private int cont;
	private int second;


	private Boolean[] check;
	private Boolean hitSaw;
	private Boolean earthQ;
	private Boolean end;
	private Boolean bossHit;
	private Boolean renderFlag;




	public KioskBoss(float x, float y, ObjectId id, Assets assets, World world, Direction direction){
		super(x, y, id);
		tempX = x;
		this.assets = assets;
		this.world = world;
		this.direction = direction;
		animationPreparation();
		facing = Facing.LEFT;
		hit = false;
		falling = true;
		jumping = false;
		velocityXMoving = 0;
		walkState = WalkState.WAKEUP;
		death = false;
		velocityHitX = 0;
		lenght = (Constants.GAME_WINDOW_WIDTH * 14 + Constants.PLAYER_JUNP_LENGTH + 200) + Constants.GAME_WINDOW_WIDTH * 2;
		origin = Constants.GAME_WINDOW_WIDTH * 14 + Constants.PLAYER_JUNP_LENGTH + 200;
		check = new Boolean[20];
		for(int  i = 0; i < check.length; i++){
			check[i] = false;
		}

		timerHit = 0;
		countHit = 0;
		health = 7;
		velocityHitX = 0;
		hitSaw = false;
		speed = 0;
		timerRemoveBlocks = 0;
		countRemoveBlocks = 0;
		timerCrash = 0;
		countCrash = 0;
		timerEarthquake = 0;
		countEarthquake = 0;
		xPlayer = 0;
		yPlayer = 0;
		faceTwo = false;
		hitGround = false;
		cont = 1;
		earthQ = false;
		speedY = 0;
		offsetX = 0;
		offsetY = 0;
		timerBossSpeed = 12f;
		second = 0;
		end = false;
		countDownBoss = 0;
		timerHitBoss = 0;
		bossHit = false; 
		renderFlag = false;

	}


	private void animationPreparation(){

		idle = new Animation(Constants.KIOSK_IDLE_ANIMATION_SPEED,
			assets.kioskIdle[0], assets.kioskIdle[1], assets.kioskIdle[2], 
			assets.kioskIdle[3], assets.kioskIdle[4], assets.kioskIdle[5],
			assets.kioskIdle[6], assets.kioskIdle[7], assets.kioskIdle[8],
			assets.kioskIdle[9], assets.kioskIdle[10], assets.kioskIdle[11],
			assets.kioskIdle[12], assets.kioskIdle[13], assets.kioskIdle[14],
			assets.kioskIdle[15], assets.kioskIdle[16], assets.kioskIdle[17],
			assets.kioskIdle[18], assets.kioskIdle[19], assets.kioskIdle[20],
			assets.kioskIdle[21], assets.kioskIdle[22], assets.kioskIdle[23],
			assets.kioskIdle[24], assets.kioskIdle[25], assets.kioskIdle[26],
			assets.kioskIdle[27], assets.kioskIdle[28], assets.kioskIdle[29]
			);



		wakeUp = new Animation(Constants.KIOSK_WAKE_UP_ANIMATION_SPEED,
			assets.kioskWakeUp[0], assets.kioskWakeUp[1], assets.kioskWakeUp[2], 
			assets.kioskWakeUp[3], assets.kioskWakeUp[4], assets.kioskWakeUp[5],
			assets.kioskWakeUp[6], assets.kioskWakeUp[7], assets.kioskWakeUp[8],
			assets.kioskWakeUp[9], assets.kioskWakeUp[10], assets.kioskWakeUp[11],
			assets.kioskWakeUp[12], assets.kioskWakeUp[13], assets.kioskWakeUp[14],
			assets.kioskWakeUp[15], assets.kioskWakeUp[16], assets.kioskWakeUp[17],
			assets.kioskWakeUp[18], assets.kioskWakeUp[19], assets.kioskWakeUp[20],
			assets.kioskWakeUp[21], assets.kioskWakeUp[22], assets.kioskWakeUp[23],
			assets.kioskWakeUp[24], assets.kioskWakeUp[25], assets.kioskWakeUp[26],
			assets.kioskWakeUp[27], assets.kioskWakeUp[28], assets.kioskWakeUp[29]
			);

		walk = new Animation(Constants.KIOSK_WALK_ANIMATION_SPEED,
			assets.kioskWalk[0], assets.kioskWalk[1], assets.kioskWalk[2], 
			assets.kioskWalk[3], assets.kioskWalk[4], assets.kioskWalk[5],
			assets.kioskWalk[6], assets.kioskWalk[7], assets.kioskWalk[8],
			assets.kioskWalk[9], assets.kioskWalk[10], assets.kioskWalk[11],
			assets.kioskWalk[12], assets.kioskWalk[13], assets.kioskWalk[14],
			assets.kioskWalk[15], assets.kioskWalk[16], assets.kioskWalk[17],
			assets.kioskWalk[18], assets.kioskWalk[19], assets.kioskWalk[20],
			assets.kioskWalk[21], assets.kioskWalk[22], assets.kioskWalk[23],
			assets.kioskWalk[24], assets.kioskWalk[25], assets.kioskWalk[26],
			assets.kioskWalk[27], assets.kioskWalk[28], assets.kioskWalk[29]
			);

		jump = new Animation(Constants.KIOSK_JUMP_ANIMATION_SPEED,
			assets.kioskJump[0], assets.kioskJump[1], assets.kioskJump[2], 
			assets.kioskJump[3], assets.kioskJump[4], assets.kioskJump[5],
			assets.kioskJump[6], assets.kioskJump[7], assets.kioskJump[8],
			assets.kioskJump[9], assets.kioskJump[10], assets.kioskJump[11],
			assets.kioskJump[12], assets.kioskJump[13], assets.kioskJump[14],
			assets.kioskJump[15], assets.kioskJump[16], assets.kioskJump[17],
			assets.kioskJump[18], assets.kioskJump[19], assets.kioskJump[20],
			assets.kioskJump[21], assets.kioskJump[22], assets.kioskJump[23],
			assets.kioskJump[24], assets.kioskJump[25], assets.kioskJump[26],
			assets.kioskJump[27], assets.kioskJump[28], assets.kioskJump[29]
			);
		
		dead = new Animation(Constants.KIOSK_DEAD_ANIMATION_SPEED,
			assets.middleBossDead[0], assets.middleBossDead[1], assets.middleBossDead[2], 
			assets.middleBossDead[3], assets.middleBossDead[4], assets.middleBossDead[5],
			assets.middleBossDead[6], assets.middleBossDead[7], assets.middleBossDead[8],
			assets.middleBossDead[9], assets.middleBossDead[10], assets.middleBossDead[11],
			assets.middleBossDead[12], assets.middleBossDead[13], assets.middleBossDead[14],
			assets.middleBossDead[15], assets.middleBossDead[16], assets.middleBossDead[17]
			);


	}


	public void update(double delta){

		if(!faceTwo){
			if(direction == Direction.STATIC){
				return;
			}


			x += velocityX * (float)delta;
			y += velocityY * (float)delta;
		

			if(hit){
				x += velocityHitX * (float)delta;
			}

			if((falling || jumping)){
				velocityY += Constants.KIOSK_GRAVITY * (float)delta;
				jump.runAnimation(PlayMode.NORMAL);
			}



		}else{

			x += velocityX * (float)delta;
			y += velocityY * (float)delta;
			
			if((check[13])){
				if(xPlayer < getBoundsTop().getX()){
					x += velocityHitX * (float)delta;
				}else{
					velocityX = 0;
					velocityY += offsetY;
				}

				
			}

			if((check[14])){
				if(xPlayer > getBoundsTop().getX()){
					x += velocityHitX * (float)delta;
				}else{
					velocityX = 0;
					velocityY += offsetY;
				}
				
			}


			if((falling || jumping)){
				velocityY += (Constants.KIOSK_GRAVITY) * (float)delta;
				jump.runAnimation(PlayMode.NORMAL);
			}	



			updateSpeed();
	
		}




		


		if(!wakeUp.isFinish()){
			wakeUp.runAnimation(PlayMode.NORMAL);
		}else if(walkState != WalkState.WALKING){
			walkState = WalkState.NOT_WALKING;
			idle.runAnimation(PlayMode.LOOP);
		}else if(walkState == WalkState.WALKING){
			walk.runAnimation(PlayMode.LOOP);
		}
		


		bossMovement();			
		collisionsPlatform();
		collisionSawBoss();
		checkHealth();
		if(bossHit)hitCountDown();


	}




	public void render(Graphics g){

	
		if(direction == Direction.STATIC){
			g.drawImage(assets.kioskWakeUp[0], (int)x, (int)y, null);
		}


		if(health != 0){
			if(bossHit){
				if(renderFlag){
					graphicsMiddleBoss(g);
				}
			}else{
				    graphicsMiddleBoss(g);
			}
		}else{
			if(facing == Facing.RIGHT){
				dead.drawAnimation(g, (int)x + Constants.KIOSK_WIDTH, 
				(int)y, -Constants.KIOSK_WIDTH, Constants.KIOSK_HEIGHT);
			}else if(facing == Facing.LEFT){
				dead.drawAnimation(g, (int)x, (int)y);
			}

		}

	}

	private void graphicsMiddleBoss(Graphics g){
		if(facing == Facing.RIGHT && jumping == true ){
				jump.drawAnimation(g, (int)x + Constants.KIOSK_WIDTH, 
				(int)y, -Constants.KIOSK_WIDTH, Constants.KIOSK_HEIGHT);
			}else if(facing == Facing.RIGHT && walkState == WalkState.WAKEUP && jumping == false){
				wakeUp.drawAnimation(g, (int)x + Constants.KIOSK_WIDTH, 
				(int)y, -Constants.KIOSK_WIDTH, Constants.KIOSK_HEIGHT);
			}else if(facing == Facing.RIGHT && walkState == WalkState.NOT_WALKING && jumping == false){
				idle.drawAnimation(g, (int)x + Constants.KIOSK_WIDTH, 
				(int)y, -Constants.KIOSK_WIDTH, Constants.KIOSK_HEIGHT);
			}else if(facing == Facing.RIGHT && walkState == WalkState.WALKING && jumping == false){
				walk.drawAnimation(g, (int)x + Constants.KIOSK_WIDTH, 
				(int)y, -Constants.KIOSK_WIDTH, Constants.KIOSK_HEIGHT);
			}else if(facing == Facing.LEFT && jumping == true ){
				jump.drawAnimation(g, (int)x, (int)y);
			}else if(facing == Facing.LEFT && walkState == WalkState.WAKEUP && jumping == false){
				wakeUp.drawAnimation(g, (int)x, (int)y);
			}else if(facing == Facing.LEFT && walkState == WalkState.NOT_WALKING && jumping == false){
				idle.drawAnimation(g, (int)x, (int)y);
			}else if(facing == Facing.LEFT && walkState == WalkState.WALKING && jumping == false){
				walk.drawAnimation(g, (int)x, (int)y);
			}
	}



	private void isOverBoss(){
		if(end == true){
			return;
		}else{
			world.getSawsMiddleBoss().clear();
			world.getBlocks().add(new Portal(x + Constants.KIOSK_WIDTH / 2, y - 50, ObjectId.PortalRecycle));
			end = true;
		}


	}



	private void moveTotheSides(){



		if(walkState == WalkState.WALKING && (!hitSaw)){
			if(x >= lenght - (Constants.KIOSK_WIDTH - 150)){
			facing = Facing.LEFT;
			check[0] = true;
			velocityX = -(Constants.KIOSK_MOVEMENT_SPEED + speed);
		}else if(x <= (origin - 100) ){
			facing = Facing.RIGHT;
			check[1] = true;
			velocityX = (Constants.KIOSK_MOVEMENT_SPEED + speed);
		}else{
			if(facing == Facing.RIGHT){
				velocityX = (Constants.KIOSK_MOVEMENT_SPEED + speed);
			}else{
				velocityX = -(Constants.KIOSK_MOVEMENT_SPEED + speed);
			}
			}
		}


	}

	private void bossMovement(){
		if(!faceTwo){
			moveTotheSides();
			if(check[0] && check[1]){
				standMode();
			}
		}else if((faceTwo) && (!jumping) && (health !=0 )){
			crashMovement();
		}else{
			if(health == 0){
				isOverBoss();
				dead.runAnimation(PlayMode.NORMAL);
			}
	
		}



	}

	private void standMode(){
		if((int)countHit >= 3){
			countHit = 0;
			timerHit = 0;
			check[0] = false;
			check[1] = false;
			check[2] = false;
			walkState = WalkState.WALKING;
			return;
		}
		
		if(!check[2]){
			velocityX = 0;
			velocityY = 0;
			check[2] = true;
		}


		walkState = WalkState.NOT_WALKING;

		collsionBlast();
		accelerateMovement();

		timerHit =  timerHit + 10f;
 		countHit = timerHit * 0.0019f;

	}

	private void accelerateMovement(){
		if(health == 7){
			if(check[3]){
				return;
			}
			speed = 2;
			check[3] = true;
		}else if(health == 6){
			if(check[4]){
				return;
			}
			speed = 4;
			check[4] = true;
		}else if(health == 5){
			if(check[5]){
				return;
			}
			speed = 6;
			check[5] = true;
		}

	}

	private void checkHealth(){
		if((health == 4)  && (!jumping) && !check[8]){
			removeBLocks();
		}

	}

	private void removeBLocks(){
		if((int)countRemoveBlocks == 5){
			countRemoveBlocks = 0;
			timerRemoveBlocks = 0;
			Audio.stop(Constants.WARNING_SOUND_ID);
			world.getSawsMiddleBoss().removeLast();
			world.getPlayer().setDome5(false);
			faceTwo = true;
			check[8] = true;
			return;
		}

		timerToRemoveBlocks();

		walkState = WalkState.NOT_WALKING;
		timerRemoveBlocks =  timerRemoveBlocks + 10f;
 		countRemoveBlocks = timerRemoveBlocks * 0.0019f;
	}

	private void timerToRemoveBlocks(){

		if((int)countRemoveBlocks == 1){
			if(check[6]){
				return;
			}
			world.getPlayer().setDome5(true);
			world.getPlayer().setVelocityX(0);
			world.getPlayer().setVelocityY(0);
			Audio.play(Constants.WARNING_SOUND_ID);
			world.getSawsMiddleBoss().add(new Warning(
				world.getPlayer().getX() - 600,
				(Constants.GAME_WINDOW_HEIGHT / 2) - 125,
				ObjectId.WarningBoss,
				assets
			));
			idle.setSpeed(0.05f);
			world.getBlocksDinamics().removeLast();
			check[6] = true;
		}

		if((int)countRemoveBlocks == 2){
			if(check[7]){
				return;
			}
			world.getBlocksDinamics().removeLast();
			check[7] = true;
		}

	}

	private void crashMovement(){
		if((int)countCrash == (2 + second)){
			countCrash = 0;
			timerCrash = 0;
			check[11] = false;
			check[12] = false;
			return;
		}

		preparejump();
		if(check[11]){jumpToPlayer();}



		timerCrash =  timerCrash + timerBossSpeed;
 		countCrash = timerCrash * 0.0019f;

	}


	private void preparejump(){
			if(check[11]){
				hitGround = false;
				return;
			}

			xPlayer = world.getPlayer().getX();
			yPlayer = world.getPlayer().getY();
			check[11] = true;
	}

	private void jumpToPlayer(){
		if(xPlayer < getBoundsTop().getX()){
			if(check[12]){
				return;
			}
			falling = true;
			jumping = true;
			velocityHitX = -(Constants.KIOSK_NOCKBACK_VELOCITY[0] + (int)offsetX);
			velocityY = -(Constants.KIOSK_NOCKBACK_VELOCITY[1] + 10 - (int)offsetY);
			check[12] = true;
			check[13] = true;
			count();
			earthQ = false;
		}

		if(xPlayer > getBoundsTop().getX()){
		
			if(check[12]){
				return;
			}
			falling = true;
			jumping = true;
			velocityHitX = (Constants.KIOSK_NOCKBACK_VELOCITY[0] + (int)offsetX);
			velocityY = -(Constants.KIOSK_NOCKBACK_VELOCITY[1] + 10 - (int)offsetY);
			check[12] = true;
			check[14] = true;
			count();
			earthQ = false;
		}


	}


	private void updateSpeed(){
		switch(health){
				case 4:  
					offsetX = 0;
					offsetY = 0;
				break;
				case 3:  
					offsetX = 2;
					offsetY = 2;
				break;
				case 2:  
					offsetX = 3;
					offsetY = 3;
				break;
				case 1:  
					offsetX = 4;
					offsetY = 4;
				break;
				case 0:

				break;
			}
	}




	private void earthquakeTime(){
		if((int)countEarthquake == 1){
			timerEarthquake = 0;
			countEarthquake = 0;
			hitGround = false;
			earthQ = true;
			return;
		}

		hitGround = true;


		timerEarthquake =  timerEarthquake + 70f;
 		countEarthquake = timerEarthquake * 0.0019f;

	}


	private void collisionsPlatform(){
		if(world != null){
			for(int i = 0; i < world.getBlocks().size(); i++)
			{
				GameObject block = world.getBlocks().get(i);
				if(block.getObjectId() == ObjectId.Block){
					if(getBounds().intersects(block.getBounds()))
					{
						hit = false;
						hitSaw = false;
						falling = false;
						jumping = false;
						velocityHitX = 0;
						velocityY = 0;
						if(faceTwo){
							check[13] = false;
							check[14] = false;
							if((cont == 2) && (!earthQ)){
								earthquakeTime();
							}
							collsionBlast();

						}

						y = block.getY() - Constants.KIOSK_HEIGHT;

					}else
					{
						falling =true;
					}
				}
			}
		}
	}

	private void count(){
		if(check[19]){
			return;
			
		}else{
			cont += 1;
			check[19] = true;
		}

	}


	private void collsionBlast(){
		if(world.getBlast() != null){
			if(!bossHit){
				for(int i = 0; i < world.getBlast().size(); i++){
					GameObject blast = world.getBlast().get(i);
					if(blast.getObjectId() == ObjectId.FireBall){
						if(health != 0){
							if(getBoundsLeft().intersects(blast.getBoundsRight())){
								if(faceTwo){
									health -= 1;
								}
								hit = true;
								jumping = true;
								bossHit = true;
								velocityHitX = -Constants.KIOSK_NOCKBACK_VELOCITY[0];
								velocityY = -Constants.KIOSK_NOCKBACK_VELOCITY[1];
								removeBlast(blast);
							}else if(getBoundsRight().intersects(blast.getBoundsLeft())){
								if(faceTwo){
									health -= 1;
								}
								hit = true;
								jumping = true;
								bossHit = true;
								velocityHitX = Constants.KIOSK_NOCKBACK_VELOCITY[0];
								velocityY = -Constants.KIOSK_NOCKBACK_VELOCITY[1];
								removeBlast(blast);
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
						if(!hitSaw){
							if(getBoundsRight().intersects(object.getBounds())){
								health -= 1;
								hitSaw = true;
								jumping = true;
								velocityHitX = Constants.KIOSK_NOCKBACK_VELOCITY[0];
								velocityY = -Constants.KIOSK_NOCKBACK_VELOCITY[1];
							}else if(getBoundsLeft().intersects(object.getBounds())){
								health -= 1;
								hitSaw = true;
								jumping = true;
								velocityHitX = -Constants.KIOSK_NOCKBACK_VELOCITY[0];
								velocityY = -Constants.KIOSK_NOCKBACK_VELOCITY[1];
							}
						}
					}
				}
			}
		}
	}


	private void hitCountDown(){

		if((int)countDownBoss >= 3){
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



	private void removeBlast(GameObject object){
		world.getBlast().remove(object);
	}


	public Rectangle getBounds(){
		return new Rectangle(
			(int)x + (Constants.KIOSK_OFFSET_X / 2),
			(int)y + (Constants.KIOSK_OFFSET_Y ),
			Constants.KIOSK_RECTANGLE_WIDTH,
			Constants.KIOSK_RECTANGLE_HEIGHT
			);
	}

	public Rectangle getBoundsTop(){
		return new Rectangle(
			(int)x + 220,
			(int)y + 90,
			150,
			160
			);
	}

	public Rectangle getBoundsRight(){
		return new Rectangle(
			(int)x + 200,
			(int)y + 90,
			20,
			160
			);
	}

	public Rectangle getBoundsLeft(){
		return new Rectangle(
			(int)x + (Constants.KIOSK_WIDTH / 2) + 70,
			(int)y + 90,
			20,
			160
			);
	}	









}