package entities;
import until.Enums.Facing;
import until.Enums.JumpState;
import until.Enums.ObjectId;
import java.awt.Graphics;
import java.awt.Rectangle;
import until.Enums.BinState;
import until.Enums.WalkState;
import until.Enums.JumpState;
import screens.World;
import framework.GameObject;
import until.Constants;
import java.awt.Graphics2D;
import java.awt.Color;
import screens.LadderGame;
import until.Enums.PlayMode;
import until.Assets;
import until.Animation;

public class Blast extends GameObject{


	private Facing facing;
	private World world;
	private LadderGame ladderGame;
	private Animation idle;
	private Assets assets;

	public Blast(float x, float y, ObjectId id, Facing facing, World  world,  Assets assets){
		super(x, y, id);
		this.facing = facing;
		this.world = world;
		this.assets = assets;
		hit = false;
		loadSpriteBlast();

	}

	public Blast(float x, float y, ObjectId id, Facing facing, LadderGame ladderGame,  Assets assets){
		super(x, y, id);
		this.facing = facing;	
		this.ladderGame = ladderGame;
		this.assets = assets;
		hit = false;
		loadSpriteBlast();

	}

	private void loadSpriteBlast(){
		idle = new Animation(5, 
			assets.blastIdle[0], assets.blastIdle[1], assets.blastIdle[2]
			);
	}




	public void update(double delta){

		if(facing == Facing.LEFT){
			x -= Constants.BLAST_BALL_VELOCITY;
		}else if(facing == Facing.RIGHT){
			x += Constants.BLAST_BALL_VELOCITY;
		}
		
		collisionEnemy();
		collisionEnemyWorks();
		collisionSpider();
		idle.runAnimation(PlayMode.NORMAL);

	}

	public void render(Graphics g){

		if(facing == Facing.RIGHT){
			idle.drawAnimation(g, (int)x , (int)y , 
					100, 100);
			/*g.drawImage(assets.blastIdle[2], (int)x , (int)y , 
					100, 100, null);*/
		}else if(facing == Facing.LEFT){
			idle.drawAnimation(g, (int)x + 100 , (int)y , -100, 100);

			/*g.drawImage(assets.blastIdle[2], (int)x + 100, (int)y , 
					-100, 100, null);*/
		}


	}

	private void collisionSpider(){
		if(ladderGame != null){
			for(int i = 0; i < ladderGame.getGameObjects().size(); i++){
				GameObject spider = ladderGame.getGameObjects().get(i);
				if(spider.getObjectId() == ObjectId.Spider){
					if(getBoundsRight().intersects(spider.getBoundsTop())
						|| getBoundsLeft().intersects(spider.getBoundsTop())){
						spider.setHealth(spider.getHealth() - 1);
						removeBlast();
						return;
					}
				}
			}
		}
	}


	private void collisionEnemy(){
		if(world != null){
			for(int i = 0; i <  world.getEnemies().size(); i++ ){
				GameObject enemy = world.getEnemies().get(i);
				if(!enemy.isHit() && (enemy.getHealth() > 0)){
					if(getBoundsRight().intersects(enemy.getBounds())
						|| getBoundsLeft().intersects(enemy.getBounds()) ){
						enemy.setHealth(enemy.getHealth() - 1);
						enemy.setHit(true);
						hit = true;
						return;
					}
				}
			}
		}
	}

	private void collisionEnemyWorks(){
		if(world != null){
			for(int j = 0; j < world.getBlocks().size(); j++ ){
				GameObject object = world.getBlocks().get(j);
				if(object.getObjectId() == ObjectId.Portal || object.getObjectId() == ObjectId.PortalB){
					if(object.getEnemiesWorks().size() != 0){
						for(int i = 0; i <  object.getEnemiesWorks().size(); i++ ){
							GameObject enemy = object.getEnemiesWorks().get(i);
							if(enemy.getObjectId() == ObjectId.Wheel){
								if(!enemy.isHit() && (enemy.getHealth() > 0)){
									if(getBoundsRight().intersects(enemy.getBounds())
										|| getBoundsLeft().intersects(enemy.getBounds()) ){
										enemy.setHealth(enemy.getHealth() - 1);
										enemy.setHit(true);
										hit = true;
										return;
									}
								}
							}
						}
					}
				}
			}
		}
	}

	private void removeBlast(){
		 ladderGame.removeBlasts(this);
	}


	public Rectangle getBounds(){return null;}
	public Rectangle getBoundsTop(){return null;}

	public Rectangle getBoundsRight(){
		return new Rectangle(
			(int)x + Constants.BLAST_OFFSET_X / 2,
			(int)y + Constants.BLAST_OFFSET_Y,
			Constants.BLAST_RECTANGLE_WIDTH,
			Constants.BLAST_RECTANGLE_HEIGHT
			);
	}
	public Rectangle getBoundsLeft(){
		return new Rectangle(
			(int)x - Constants.BLAST_OFFSET_X / 2,
			(int)y + Constants.BLAST_OFFSET_Y,
			Constants.BLAST_RECTANGLE_WIDTH,
			Constants.BLAST_RECTANGLE_HEIGHT
			);
	}




}