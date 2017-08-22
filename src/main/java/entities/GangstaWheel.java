package entities;
import until.Enums.Facing;
import until.Enums.JumpState;
import until.Enums.ObjectId;
import java.awt.Graphics;
import java.awt.Rectangle;
import until.Enums.BinState;
import framework.GameObject;
import until.Assets;
import until.Animation;
import until.Constants;
import until.Enums.WalkState;
import screens.World;
import java.awt.Graphics2D;
import java.awt.Color;
import until.Enums.PlayMode;
import until.Enums.EnemySprite;
import java.util.Random;

public class GangstaWheel extends GameObject{

	private Assets aseets;
	private Animation wheelWalk;
	private Animation wheelDeathAnimation;
	private Animation wheelWalk2;
	
	private EnemySprite enemySprite;
	private World world;

	private int lemght;
	private int width;
	private int height;
	private int origin;
	private int rectWidth;
	private int rectHeight;
	private int offsetX;

	private int offsetY;
	private float velocityHitX;

	private Boolean hitWorks = false;
	

	private Boolean startAnimationBuild;
	private Boolean puaseMovement;
	private Random rand = new Random();
	private float xBug;


	public GangstaWheel(float x, float y, ObjectId id, Assets aseets, 
				World world, int lemght, int origin, EnemySprite enemySprite){
		super( x, y, id);
		this.aseets = aseets;
		this.world = world;
		this.origin = origin;
		this.enemySprite = enemySprite;
		falling = true;
		jumping = false;
		facing = Facing.LEFT;
		walkState = WalkState.WALKING;
		this.lemght = lemght;
		animacionIdle();
		offsetX = Constants.ENEMY_OFFSET_X;
		offsetY = Constants.ENEMY_OFFSET_Y;
		width = Constants.ENEMY_WIDTH;
		height = Constants.ENEMY_HEIGHT;
		rectWidth = width - offsetX;
		rectHeight = height -  offsetY;
		health = Constants.ENEMY_HEALTH;
		hit = false;
		death = false;
		velocityHitX = 0;

	}

	public GangstaWheel(float x, float y, ObjectId id, Assets aseets, World world, 
				int lemght,  int origin, int width , int height, EnemySprite enemySprite){
		super( x, y, id);
		this.aseets = aseets;
		this.world = world;
		this.width = width;
		this.height = height;
		this.origin =  origin;
		this.lemght = lemght;
		this.enemySprite = enemySprite;
		falling = true;
		jumping = false;
		facing = Facing.RIGHT;
		walkState = WalkState.WALKING;
		offsetX =  Constants.ENEMY_OFFSET_X + width /4;
		offsetY = Constants.ENEMY_OFFSET_Y;
		rectWidth = width - (offsetX );
		rectHeight = height -  (offsetY);
		animacionIdle();
		health = Constants.ENEMY_HEALTH;
		hit = false;
		death = false;
		velocityHitX = 0;
		hit = false;
	}


	public GangstaWheel(float x, float y, 
							ObjectId id, Assets aseets,  
							int width , int height, 
							EnemySprite enemySprite){
		super( x, y, id);
		this.aseets = aseets;
		this.width = width;
		this.height = height;
		this.enemySprite = enemySprite;
		facing = Facing.RIGHT;
		walkState = WalkState.NOT_WALKING;
		offsetX =  Constants.ENEMY_OFFSET_X + width /4;
		offsetY = Constants.ENEMY_OFFSET_Y;
		rectWidth = width - (offsetX );
		rectHeight = height -  (offsetY);
		startAnimationBuild = false;
		puaseMovement = false;
		health = Constants.ENEMY_HEALTH;
		velocityX = Constants.WHELL_FACTORY_MOVEMNET;
		this.xBug = x;
		
		factoryAssets();


	}


	private void animacionIdle(){

		if(enemySprite == EnemySprite.WHEEL){
			wheelWalk = new Animation(Constants.ENEMY_IDLE_SPEED,
			aseets.enemySpriteWalking[0], aseets.enemySpriteWalking[1], aseets.enemySpriteWalking[2],
			aseets.enemySpriteWalking[3], aseets.enemySpriteWalking[4], aseets.enemySpriteWalking[5],
			aseets.enemySpriteWalking[6], aseets.enemySpriteWalking[7], aseets.enemySpriteWalking[8],
			aseets.enemySpriteWalking[9], aseets.enemySpriteWalking[10], aseets.enemySpriteWalking[11],
			aseets.enemySpriteWalking[12], aseets.enemySpriteWalking[13], aseets.enemySpriteWalking[14],
			aseets.enemySpriteWalking[15], aseets.enemySpriteWalking[16], aseets.enemySpriteWalking[17],
			aseets.enemySpriteWalking[18], aseets.enemySpriteWalking[19], aseets.enemySpriteWalking[20],
			aseets.enemySpriteWalking[21], aseets.enemySpriteWalking[22], aseets.enemySpriteWalking[23],
			aseets.enemySpriteWalking[24], aseets.enemySpriteWalking[25], aseets.enemySpriteWalking[26],
			aseets.enemySpriteWalking[27], aseets.enemySpriteWalking[28], aseets.enemySpriteWalking[29],
			aseets.enemySpriteWalking[30], aseets.enemySpriteWalking[31], aseets.enemySpriteWalking[32],
			aseets.enemySpriteWalking[33], aseets.enemySpriteWalking[34]);
		}else if(enemySprite == EnemySprite.COMPUTER){
			wheelWalk2 = new Animation(Constants.ENEMY_IDLE_SPEED,
			aseets.wheelSpriteWalk2[0], aseets.wheelSpriteWalk2[1], aseets.wheelSpriteWalk2[2],
			aseets.wheelSpriteWalk2[3], aseets.wheelSpriteWalk2[4], aseets.wheelSpriteWalk2[5],
			aseets.wheelSpriteWalk2[6], aseets.wheelSpriteWalk2[7], aseets.wheelSpriteWalk2[8],
			aseets.wheelSpriteWalk2[9], aseets.wheelSpriteWalk2[10], aseets.wheelSpriteWalk2[11],
			aseets.wheelSpriteWalk2[12], aseets.wheelSpriteWalk2[13], aseets.wheelSpriteWalk2[14],
			aseets.wheelSpriteWalk2[15], aseets.wheelSpriteWalk2[16], aseets.wheelSpriteWalk2[17],
			aseets.wheelSpriteWalk2[18], aseets.wheelSpriteWalk2[19], aseets.wheelSpriteWalk2[20],
			aseets.wheelSpriteWalk2[21], aseets.wheelSpriteWalk2[22], aseets.wheelSpriteWalk2[23],
			aseets.wheelSpriteWalk2[24], aseets.wheelSpriteWalk2[25], aseets.wheelSpriteWalk2[26],
			aseets.wheelSpriteWalk2[27], aseets.wheelSpriteWalk2[28], aseets.wheelSpriteWalk2[29],
			aseets.wheelSpriteWalk2[30], aseets.wheelSpriteWalk2[31], aseets.wheelSpriteWalk2[32],
			aseets.wheelSpriteWalk2[33], aseets.wheelSpriteWalk2[34]);
		}

	

		

	    wheelDeathAnimation = new Animation(Constants.ENEMY_DEATH_ANIMATION_SPEED,
	    	aseets.wheelDeath[0], aseets.wheelDeath[1], aseets.wheelDeath[2],
	    	aseets.wheelDeath[3], aseets.wheelDeath[4], aseets.wheelDeath[5],
	    	aseets.wheelDeath[6], aseets.wheelDeath[7], aseets.wheelDeath[8],
	    	aseets.wheelDeath[9]);

	}

	private void factoryAssets(){
		
			wheelWalk = new Animation(Constants.ENEMY_IDLE_SPEED,
			aseets.enemySpriteWalking[0], aseets.enemySpriteWalking[1], aseets.enemySpriteWalking[2],
			aseets.enemySpriteWalking[3], aseets.enemySpriteWalking[4], aseets.enemySpriteWalking[5],
			aseets.enemySpriteWalking[6], aseets.enemySpriteWalking[7], aseets.enemySpriteWalking[8],
			aseets.enemySpriteWalking[9], aseets.enemySpriteWalking[10], aseets.enemySpriteWalking[11],
			aseets.enemySpriteWalking[12], aseets.enemySpriteWalking[13], aseets.enemySpriteWalking[14],
			aseets.enemySpriteWalking[15], aseets.enemySpriteWalking[16], aseets.enemySpriteWalking[17],
			aseets.enemySpriteWalking[18], aseets.enemySpriteWalking[19], aseets.enemySpriteWalking[20],
			aseets.enemySpriteWalking[21], aseets.enemySpriteWalking[22], aseets.enemySpriteWalking[23],
			aseets.enemySpriteWalking[24], aseets.enemySpriteWalking[25], aseets.enemySpriteWalking[26],
			aseets.enemySpriteWalking[27], aseets.enemySpriteWalking[28], aseets.enemySpriteWalking[29],
			aseets.enemySpriteWalking[30], aseets.enemySpriteWalking[31], aseets.enemySpriteWalking[32],
			aseets.enemySpriteWalking[33], aseets.enemySpriteWalking[34]);
		
			wheelWalk2 = new Animation(Constants.ENEMY_IDLE_SPEED,
			aseets.wheelSpriteWalk2[0], aseets.wheelSpriteWalk2[1], aseets.wheelSpriteWalk2[2],
			aseets.wheelSpriteWalk2[3], aseets.wheelSpriteWalk2[4], aseets.wheelSpriteWalk2[5],
			aseets.wheelSpriteWalk2[6], aseets.wheelSpriteWalk2[7], aseets.wheelSpriteWalk2[8],
			aseets.wheelSpriteWalk2[9], aseets.wheelSpriteWalk2[10], aseets.wheelSpriteWalk2[11],
			aseets.wheelSpriteWalk2[12], aseets.wheelSpriteWalk2[13], aseets.wheelSpriteWalk2[14],
			aseets.wheelSpriteWalk2[15], aseets.wheelSpriteWalk2[16], aseets.wheelSpriteWalk2[17],
			aseets.wheelSpriteWalk2[18], aseets.wheelSpriteWalk2[19], aseets.wheelSpriteWalk2[20],
			aseets.wheelSpriteWalk2[21], aseets.wheelSpriteWalk2[22], aseets.wheelSpriteWalk2[23],
			aseets.wheelSpriteWalk2[24], aseets.wheelSpriteWalk2[25], aseets.wheelSpriteWalk2[26],
			aseets.wheelSpriteWalk2[27], aseets.wheelSpriteWalk2[28], aseets.wheelSpriteWalk2[29],
			aseets.wheelSpriteWalk2[30], aseets.wheelSpriteWalk2[31], aseets.wheelSpriteWalk2[32],
			aseets.wheelSpriteWalk2[33], aseets.wheelSpriteWalk2[34]);
		

	    wheelDeathAnimation = new Animation(Constants.ENEMY_DEATH_ANIMATION_SPEED,
	    	aseets.wheelDeath[9], aseets.wheelDeath[8], aseets.wheelDeath[7],
	    	aseets.wheelDeath[6], aseets.wheelDeath[5], aseets.wheelDeath[4],
	    	aseets.wheelDeath[3], aseets.wheelDeath[2], aseets.wheelDeath[1],
	    	aseets.wheelDeath[0]);
	}




	public void update(double delta){

		x += velocityX * (float)delta;
		y += velocityY * (float)delta;

		if(hitWorks){
			x += velocityHitX * (float)delta;
		}


		if((falling || jumping)){
			velocityY += Constants.GRAVITY * (float)delta;
		}

		switch(enemySprite){
			case WHEEL: wheelWalk.runAnimation(PlayMode.LOOP); break;
			case COMPUTER: wheelWalk2.runAnimation(PlayMode.LOOP); break;
		}
		
		
		if(health <= 0){
			wheelDeathAnimation.runAnimation(PlayMode.NORMAL);
		}
		
		if(wheelDeathAnimation.isFinish()){
			death = true;
		}

	
	

		if(health > 0){
			movingLimits();
		}else {
			velocityX = 0;
		}
		
		collisionsPlatform();
		collisionBlast();
		collionWorks();


	}

	public void update(double delta, int x){

		animationFactory(delta);

	}


	private void animationFactory(double delta){


		
		if(!puaseMovement) xBug -= velocityX * (float)delta;

		if( (xBug + width /2) < (Constants.GAME_WINDOW_WIDTH / 2) 
				&& !startAnimationBuild ){
			startAnimationBuild = true;
			puaseMovement = true;
		}

		if(startAnimationBuild)wheelDeathAnimation.runAnimation(PlayMode.NORMAL);

		if( startAnimationBuild && wheelDeathAnimation.isFinish()){
			puaseMovement = false;
			walkState = WalkState.WALKING;
		}

		if(xBug < -50){
			xBug = Constants.GAME_WINDOW_WIDTH  + 300;
			enemyAssetsSelect();
			startAnimationBuild = false;
			wheelDeathAnimation.setCount(0);
			wheelDeathAnimation.setFinish(false);
			walkState = WalkState.NOT_WALKING;
		}

		if(walkState == WalkState.WALKING){
			switch(enemySprite){
				case WHEEL: wheelWalk.runAnimation(PlayMode.LOOP); break;
				case COMPUTER: wheelWalk2.runAnimation(PlayMode.LOOP); break;
			}
		}
		


	}



	public void render(Graphics g){


		/*g.drawImage(aseets.enemySpriteWalking[2], (int)x + (width), (int)y , 
					-(width), (height), null);*/

		if(enemySprite == EnemySprite.WHEEL){
			if(walkState == WalkState.WALKING && (health > 0 )){
				if(facing == Facing.RIGHT){
					wheelWalk.drawAnimation(g, (int)x + (width) , (int)y, 
					-(width),  (height));
				}else{
					wheelWalk.drawAnimation(g, (int)x, (int)y, 
					 width,  height );
				}
			}else{
				wheelDeathAnimation.drawAnimation(g , (int)x,  (int)y, width, height);
			}
		}else if(enemySprite == EnemySprite.COMPUTER){
			if(walkState == WalkState.WALKING && (health > 0 )){
				if(facing == Facing.RIGHT){
					wheelWalk2.drawAnimation(g, (int)x + (width) , (int)y, 
						-(width),  (height));
				}else{
					wheelWalk2.drawAnimation(g, (int)x, (int)y, 
						 width,  height );
				}
			}else{
				wheelDeathAnimation.drawAnimation(g , (int)x,  (int)y, width, height);
			}
		}
	
	}

	public void render(Graphics g, int x){

		if(enemySprite == EnemySprite.WHEEL){
			if(walkState == WalkState.WALKING ){
				if(facing == Facing.RIGHT){
					wheelWalk.drawAnimation(g, (int)xBug + (width) , (int)y, 
					-(width),  (height));
				}else{
					wheelWalk.drawAnimation(g, (int)xBug, (int)y, 
					 width,  height );
				}
			}else{
				if(!startAnimationBuild){
					g.drawImage(aseets.wheelDeath[9], 
								(int)xBug, (int)y,
	    						(int)width, (int)height, null);
				}else{
					wheelDeathAnimation.drawAnimation(g , 
						(int)xBug,  (int)y, width, height);
				}
			}
		}else if(enemySprite == EnemySprite.COMPUTER){
			if(walkState == WalkState.WALKING ){
				if(facing == Facing.RIGHT){
					wheelWalk2.drawAnimation(g, (int)xBug + (width) , (int)y, 
						-(width),  (height));
				}else{
					wheelWalk2.drawAnimation(g, (int)xBug, (int)y, 
						 width,  height );
				}
			}else{
				if(!startAnimationBuild){
					g.drawImage(aseets.wheelDeath[9], 
								(int)xBug,  (int)y,
	    						(int)width, (int)height, null);
				}else{
					wheelDeathAnimation.drawAnimation(g , (int)xBug,  (int)y, width, height);
				}
			}
		}
	
	}


	private void enemyAssetsSelect(){

		int select = rand.nextInt(2) + 1;
		switch (select) {
			case 1: enemySprite = EnemySprite.COMPUTER; break;
			case 2: enemySprite = EnemySprite.WHEEL; break;
			default: break;
		}

	}


	private void movingLimits(){
		if(walkState == WalkState.WALKING ){
			if(x >= lemght - (width + 50)){
				facing = Facing.LEFT;
				velocityX = -Constants.ENEMY_MOVEMENT_SPEED;
			}else if(x <= origin ){
				facing = Facing.RIGHT;
				velocityX = Constants.ENEMY_MOVEMENT_SPEED;
			}else{
				if(facing == Facing.LEFT){
					velocityX = -Constants.ENEMY_MOVEMENT_SPEED;
				}else{
					velocityX = Constants.ENEMY_MOVEMENT_SPEED;
				}
			}
		}
	}

	private void collisionBlast(){
		/*if(hit){
			hit = false;
		}*/
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
						falling = false;
						jumping = false;
						velocityY = 0;
						velocityHitX = 0;
						hitWorks = false;
						y = block.getY() - (height) ;
					}else
					{
						falling =true;
					}
				}
			}
		}
	}

	private void collionWorks(){
		if(world != null){
			if(world.getBlocks() != null){
				for(int i = 0; i < world.getBlocks().size(); i++){
					GameObject object = world.getBlocks().get(i);
					if(object.getObjectId() == ObjectId.Portal || object.getObjectId() == ObjectId.PortalB){
						if(getBounds().intersects(object.getBounds())){
							hitWorks = true;
							falling = true;
							jumping = true;
							velocityY = -(Constants.ENEMY_NOCKBACK_VELOCITY[1] );
							velocityHitX = -(Constants.ENEMY_NOCKBACK_VELOCITY[0] );
						}
					}
				}
			}
		}
	}



	public Rectangle getBounds(){
		return new Rectangle(
			(int)x + ((offsetX ) / 2) ,
			(int)y + (offsetY),
			rectWidth,
			rectHeight);
	}

	public Rectangle getBoundsTop(){return null;}
	public Rectangle getBoundsRight(){return null;}
	public Rectangle getBoundsLeft(){return null;}
	public Animation getWheelDeath(){ return wheelDeathAnimation;}


}






