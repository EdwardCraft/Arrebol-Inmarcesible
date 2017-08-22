package framework;
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
import until.Enums.Direction;
import overlays.HubMiniGame;
import screens.RecycleGame;


public abstract class GameObject{

	protected float x;
	protected float y;
	protected float velocityX;
	protected float velocityY;
	protected float gravity;
	protected Facing facing;
	protected JumpState jumpState;
	protected ObjectId id;
	protected Boolean moving;
	protected Boolean hit;
	protected int healthLadderGame;
	protected BinState binState;
	protected boolean falling;
	protected boolean jumping;
	protected WalkState walkState;
	protected int health;
	protected Boolean death;
	protected LinkedList<GameObject> enemiesWorks;
	protected int lives;
	protected int velocityHitX;
	protected WorksState worksState;
	protected Direction direction;
	protected Boolean hitGround;
	protected HubMiniGame hud;
	protected int select;
	protected RecycleGame game;
	protected boolean fireBlast;
	protected Boolean faceTwo;


	public GameObject(float x, float y, ObjectId id){
		this.x = x;
		this.y = y;
		this.id = id;
	}

	public abstract void update(double delta);
	public abstract void render(Graphics g);
	public abstract Rectangle getBounds();
	public abstract Rectangle getBoundsTop();
	public abstract Rectangle getBoundsRight();
	public abstract Rectangle getBoundsLeft();	

	public float getX(){return x;}
	public float getY(){return y;}
	public void setX(float x){this.x = x;}
	public void setY(float y){this.y = y;}
	public float getVelocityX(){return velocityX;}
	public float getVelocityY(){return velocityY;}
	public void setVelocityX(float velocityX){this.velocityX = velocityX;}
	public void setVelocityY(float velocityY){this.velocityY = velocityY;}
	public ObjectId getObjectId(){ return id; }
	public Boolean isMoving(){ return moving;}
	public void setMoving(Boolean moving){ this.moving = moving;}
	public Boolean isHit(){ return hit;}
	public void setHit(Boolean hit){ this.hit = hit;}
	public int getHealthLadderGame(){ return healthLadderGame;}
	public void setHealthLadderGame(int healthLadderGame){ this.healthLadderGame = healthLadderGame;}
	public BinState getBinState(){ return binState; }
	public void setBinState(BinState binState ){ this.binState = binState; }
	public boolean isFalling() { return falling; }
	public void setFalling(boolean falling) { this.falling = falling; }
	public boolean isJumping() { return jumping; }
	public void setJumping(boolean jumping) { this.jumping = jumping;}
	public Facing getFacing(){ return facing;}
	public void setFacing( Facing facing){this.facing = facing;}
	public WalkState getWalkState(){ return walkState;}
	public void setWalkState(WalkState walkState){ this.walkState = walkState;}
	public JumpState getJumpState(){ return jumpState; }
	public void setJumpState(JumpState jumpState){ this.jumpState = jumpState; }
	public int getHealth(){return health;}
	public void setHealth(int health){ this.health = health;}
	public Boolean idDeath(){return death;}
	public void setDeath(Boolean death){ this.death = death;}
	public void addEnemiesWorks(GameObject object){ enemiesWorks.add(object);}
	public void removeEnemiesWorks(GameObject object){ enemiesWorks.remove(object);}
	public LinkedList<GameObject> getEnemiesWorks(){ return enemiesWorks;}
	public int getLives(){return lives;}
	public void setLives(int lives){this.lives = lives;}
	public int getVelocityHitX(){return velocityHitX;}
	public void setVelocityHitX(int velocityHitX){this.velocityHitX = velocityHitX;}
	public WorksState getWorksState(){return worksState;}
	public void setWorksState(WorksState worksState){this.worksState = worksState;}
	public Direction getDirection(){ return direction;}
	public void setDirection(Direction direction){this.direction = direction;}
	public Boolean gethitGround(){ return hitGround;}
	public void setHitGround(Boolean hitGround){ this.hitGround = hitGround;}
	public HubMiniGame getHudMiniGame(){ return hud;}
	public void setHudMiniGame(HubMiniGame hud){this.hud = hud;}
	public int getSelect(){ return select;}
	public void setSelect(int select){this.select = select;}
	public RecycleGame getRecycleGame(){ return game;}
	public void setRecycleGame(RecycleGame game){ this.game = game;}
	public Boolean isFireBlast(){return  fireBlast;}
	public void setFireBlast(boolean fireBlast){ this.fireBlast = fireBlast;}
	public Boolean isFaceTwo(){return faceTwo;}
	


}