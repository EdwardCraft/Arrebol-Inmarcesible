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
import java.awt.Graphics2D;
import until.Constants;
import java.awt.Color;
import java.lang.Math;
import until.Enums.Movement;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import until.Animation;
import until.Enums.PlayMode;

public class Saw extends GameObject{

	private Assets assets;
	private float basex;   
	private float basey;
	private float angle;
	private Movement move;
	private float speed;
	private int radius;
	private AffineTransformOp op;
    private AffineTransform tx;
    private float speedRotation;
    private float anglePole = 280;
    private float sawSpeedX;
    private Animation death;
    private int lenght;


	public Saw(float x, float y, ObjectId id, Assets assets, Movement move){
		super(x ,y, id);
		this.assets = assets;
		this.move = move;
		basex = x;
		basey = y;
		speed = 0;
		radius = 100;
		angle = 0;
		speedRotation = 0;
		animationDeath();
	}



	public Saw(float x, float y, ObjectId id, Assets assets, Movement move, float sawSpeedX){
		super(x ,y, id);
		this.assets = assets;
		this.move = move;
		this.sawSpeedX = sawSpeedX;
		basex = x;
		basey = y;
		speed = 0;
		radius = 100;
		angle = 0;
		speedRotation = 0;
		lenght = 0;
		animationDeath();
	}



	public Saw(float x, float y, ObjectId id, Assets assets, Movement move, int radius){
		super(x ,y, id);
		this.assets = assets;
		this.move = move;
		this.radius = radius;
		basex = x;
		basey = y;
		speed = 0.07f;
		speedRotation = 0;
		lenght = 0;
		animationDeath();
	}

	public Saw(float x, float y, ObjectId id, Assets assets, Movement move, int radius, float speed){
		super(x ,y, id);
		this.assets = assets;
		this.move = move;
		this.radius = radius;
		this.angle = angle;
		basex = x;
		basey = y;
		this.speed = speed;
		lenght = 0;
		speedRotation = 0;
		animationDeath();
	}


	private void animationDeath(){
		death = new Animation(Constants.SAW_ANIMATION_SPEED,
			assets.saw1, assets.saw2, assets.saw3);
	}


	public void update(double delta){
		 movement(delta);
		 death.runAnimation(PlayMode.LOOP);
	}

	private void movement(double delta){
		switch(move){
			case CIRCULAR:
			  	if(angle >= 8){	
					angle = 1.8f;
				}else{
					angle += speed;
   					x = ((int)(basex + radius*Math.cos(angle))) * (float)delta;
    				y = ((int)(basey - radius*Math.sin(angle))) * (float)delta;	
				}
			break;
			case M180:
				if(angle >= 3){
					speed  = -0.07f;
				}else if(angle <= 0.15){
					speed  = 0.07f;
				}

				angle += speed;
				int rotatex = ((int)(basex + radius*Math.cos(angle)));
				int rotatey = ((int)(basey - radius*Math.sin(angle)));

				x = rotatex * (float)delta;
    			y = rotatey * (float)delta;
			break;
			case HORIZONTAL: 
				if (x >= basex + 500) {
					velocityX = - sawSpeedX;	
				}
				if (x <= basex) {
					velocityX =  sawSpeedX;
				}
				x += velocityX * (float)delta; 
			break;
			case VETICAL:
				if (y >= basey) {
					velocityY = -sawSpeedX;	
				}
				if (y <= basey - 500) {
					velocityY = sawSpeedX;
				}
				y += velocityY * (float)delta; 
			break;
			case STATIC: 

			break;
		}

	

	}


	public void render(Graphics g){
		/*Graphics2D g2d = (Graphics2D) g; 
		g.setColor(Color.orange);
		g2d.draw(getBounds());*/
		death.drawAnimation(g, (int)x, (int)y, Constants.SAW_WIDTH, Constants.SAW_HEIGHT);
		//g.drawImage(assets.saw1, (int)x, (int)y, Constants.SAW_WIDTH, Constants.SAW_HEIGHT, null);
		if(move != Movement.STATIC){
			g.drawImage(assets.saw1PoleBase, (int)basex - 50, (int)basey, 
				Constants.SAW_BASE_WIDTH, Constants.SAW_BASE_HEIGHT, null);
		}

	}

	public Rectangle getBounds(){
		return new Rectangle(
			(int)x + Constants.SAW_OFFSET_X / 2,
			(int)y + Constants.SAW_OFFSET_Y / 2,
			Constants.SAW_RECTANGLE_WIDTH,
			Constants.SAW_RECTANGLE_HEIGHT
			);
	}
	public Rectangle getBoundsTop(){return null;}
	public Rectangle getBoundsRight(){return null;}
	public Rectangle getBoundsLeft(){return null;}






}