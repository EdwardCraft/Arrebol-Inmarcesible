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
import until.Enums.Direction;
import framework.GameObject;
import until.Assets;
import until.Animation;
import until.Constants;
import until.Enums.PlayMode;

public class Warning extends GameObject{

	private Assets assets;
	private Animation animation;

	public Warning( float x, float y, ObjectId id , Assets assets){
		super(x, y, id);
		this.assets = assets;
		animation = new Animation(Constants.WARNING_ANIMATION_SPEED,
			assets.warning[0],assets.warning[1],assets.warning[2],
			assets.warning[3],assets.warning[4]
		);
	}



	public void update(double delta){
		animation.runAnimation(PlayMode.LOOP);
	}

	public void render(Graphics g){
		animation.drawAnimation(g, (int)x, (int)y, Constants.WARNING_WIDTH, Constants.WARNING_HEIGHT);
	}

	public Rectangle getBounds(){return null;}
	public Rectangle getBoundsTop(){return null;}
	public Rectangle getBoundsRight(){return null;}
	public Rectangle getBoundsLeft(){return null;}
	






}