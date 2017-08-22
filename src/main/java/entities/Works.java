package entities;
import until.Enums.Facing;
import until.Enums.JumpState;
import until.Enums.ObjectId;
import java.awt.Graphics;
import java.awt.Rectangle;
import until.Enums.BinState;
import until.Enums.WalkState;
import framework.GameObject;
import until.Assets;
import until.Animation;
import until.Constants;
import java.awt.Graphics2D;
import java.awt.Color;
import until.Enums.PlayMode;
import screens.World;
import until.Enums.EnemySprite;
import java.util.LinkedList;
import java.util.Random;
import until.Enums.WorksState;

public class Works extends GameObject{

	

	private Assets assets;
	private Animation worksAnimationidle;
	private World world;
	private int create;
	private float timer;
	private float countDown;
	private Boolean control1 = false;
	private Boolean control2 = false;
	private Boolean control3 = false;
	private Boolean isWheel = false;
	private int deathCount = 3;
	private int create1;
	private int length;
	private int origin;
	private Random rand = new Random();
	private int randTrash;
	private Boolean work;

	public Works(float x, float y, ObjectId id, Assets assets, World world){
		super( x, y, id);
		enemiesWorks = new LinkedList<GameObject>();
		this.assets = assets;
		this.world = world;
		create1 = 0;
		create = 0;
		timer = 0;
		countDown = 0;
		worksState = WorksState.ACTVE;
		work = false;
		animationWorks();
	}

	public Works(float x, float y, ObjectId id, Assets assets, World world, int create, int length, int origin){
		super( x, y, id);
		enemiesWorks = new LinkedList<GameObject>();
		this.assets = assets;
		this.world = world;
		this.create = create;
		this.length = length;
		this.origin = origin;
		create1 = 1;
		timer = 0;
		countDown = 0;
		worksState = WorksState.ACTVE;
		work = false;
		animationWorks();

	}

	private void animationWorks(){
		worksAnimationidle = new Animation(Constants.WOKRS_ANIMATION_SPEED,
			assets.worksSpriteIdle[0], assets.worksSpriteIdle[1], assets.worksSpriteIdle[2], 
			assets.worksSpriteIdle[3], assets.worksSpriteIdle[4], assets.worksSpriteIdle[5],
			assets.worksSpriteIdle[6], assets.worksSpriteIdle[7], assets.worksSpriteIdle[8],
			assets.worksSpriteIdle[9], assets.worksSpriteIdle[10], assets.worksSpriteIdle[11],
			assets.worksSpriteIdle[12], assets.worksSpriteIdle[13], assets.worksSpriteIdle[14],
			assets.worksSpriteIdle[15], assets.worksSpriteIdle[16], assets.worksSpriteIdle[17],
			assets.worksSpriteIdle[18], assets.worksSpriteIdle[19], assets.worksSpriteIdle[20],
			assets.worksSpriteIdle[21], assets.worksSpriteIdle[22], assets.worksSpriteIdle[23],
			assets.worksSpriteIdle[24], assets.worksSpriteIdle[25], assets.worksSpriteIdle[26],
			assets.worksSpriteIdle[27], assets.worksSpriteIdle[28], assets.worksSpriteIdle[29]);
	}


	public void update(double delta){
		if(work){
			return;
		}

		if(worksState == WorksState.ACTVE){
			if(enemiesWorks != null){
				for(int i = 0; i < enemiesWorks.size(); i++){
					enemiesWorks.get(i).update(delta);
					if(enemiesWorks.get(i).idDeath()){
						randTrash = rand.nextInt( 4 ) + 1;
						switch(randTrash){
							case 1: world.getTrashObjects().add(new Can(enemiesWorks.get(i).getX(), 
								enemiesWorks.get(i).getY(), ObjectId.metalTrash, assets, 0)); break;
							case 2: world.getTrashObjects().add(new Food(enemiesWorks.get(i).getX(), 
								enemiesWorks.get(i).getY(), ObjectId.foodTrash, assets, 0)); break;
								case 3: world.getTrashObjects().add(new Paper(enemiesWorks.get(i).getX(), 
							enemiesWorks.get(i).getY(), ObjectId.plasticTrash, assets, 0)); break;
							case 4:  break;
						}
						removeEnemiesWorks(enemiesWorks.get(i));
						world.setScore(world.getScore() + Constants.PLAYER_ENEMY_KILL_SCORE);
						return;
					}
				}
			}
			
			worksAnimationidle.runAnimation(PlayMode.LOOP);
			createWhells();
		}

		if(worksState == WorksState.INACTIVE){
			enemiesWorks.clear();
			work = true;
		}
	


	}

	public void render(Graphics g){
		Graphics2D g2d = (Graphics2D) g; 
		g.setColor(Color.red);
		worksAnimationidle.drawAnimation(g, (int)x , (int)y,
			Constants.WOKRS_WIDTH, Constants.WOKRS_HEIGHT);
		/*g.drawImage(assets.worksSpriteIdle[5], (int)x , (int)y , 
					Constants.WOKRS_WIDTH, Constants.WOKRS_HEIGHT, null);*/
		g2d.draw(getBounds());

		if(enemiesWorks != null){
			for(GameObject worksEnemies: enemiesWorks){
				worksEnemies.render(g);
			}	
		}


	}




	private void createWhells(){
		if(create1 == 0){
			return;
		}

		if(create == 0 ){
			if(enemiesWorks.size() == 0){
				create = 1;
			} 
			return;
		}

		timer = timer + 10f;
		countDown = timer * 0.0019f;
		if((int)countDown == 3 ){
			if(control1){
				return;
			}
			addEnemiesWorks(new GangstaWheel(
				x + Constants.WORKS_OFFSET_X / 2 - 23, 
				y + Constants.WORKS_OFFSET_Y,
				ObjectId.Wheel, assets,
				world, 
				length,
				origin,
				EnemySprite.COMPUTER
				));
			deathCount -=1;
			control1 = true;

		}else if((int)countDown == 6){
			if(control2){
				return;
			}
			addEnemiesWorks(new GangstaWheel(
				x + Constants.WORKS_OFFSET_X / 2 - 23, 
				y + Constants.WORKS_OFFSET_Y,
				ObjectId.Wheel, assets,
				world, 
				length,
				origin,
				EnemySprite.COMPUTER
				));
			deathCount -=1;
			control2 = true;
		}else if((int)countDown == 9){
			if(control3){
				return;
			}
			addEnemiesWorks(new GangstaWheel(
				x + Constants.WORKS_OFFSET_X / 2 - 23, 
				y + Constants.WORKS_OFFSET_Y,
				ObjectId.Wheel, assets,
				world, 
				length,
				origin,
				EnemySprite.COMPUTER
				));
			deathCount -=1;
			control3 = true;
		}else if((int)countDown == 12){
			create = 0;
			timer = 0;
			countDown = 0;
			control1 = false;
			control2 = false;
			control3 = false;
		}



	}


	public Rectangle getBounds(){
	 return new Rectangle(
	 	(int)x + Constants.WORKS_OFFSET_X / 2 - 23,
	 	(int)y + Constants.WORKS_OFFSET_Y ,
	 	Constants.WOKRS_RECTANGLE_WIDTH,
	 	Constants.WOKRS_RECTANGLE_HEIGHT
	 	);
	}
	public Rectangle getBoundsTop(){ return null;}
	public Rectangle getBoundsRight(){ return null;}
	public Rectangle getBoundsLeft(){ return null;}	



}			