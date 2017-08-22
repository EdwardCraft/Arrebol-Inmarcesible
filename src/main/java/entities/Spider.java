package entities;

import framework.GameObject;
import until.Enums.ObjectId;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Graphics2D;
import java.awt.Color;
import until.Constants;
import until.Enums.RectangleBounds;
import java.util.Random;
import until.Assets;

public class Spider extends GameObject{

	private Ladder ladder;
	private Random rand = new Random();
	private int temp;
	private Boolean hit;
	private int offset;
	private RectangleBounds rectangle;
	private RectangleBounds direction;
	private int temp2;
	private Assets assets;

	public Spider(float x, float y, ObjectId id, Ladder ladder, Assets assets){
		super(x, y, id);
		this.ladder = ladder;
		this.assets = assets;
		offset = 0;
		temp = 0;
		hit = false;
		health = 2;
		velocityY = Constants.SPIDER_VELOCITY_Y;
		velocityX = Constants.SPIDER_VELOCITY_X;
		temp2 = Constants.SPIDER_OFFSET_TEMP;
		randPosition();
		rectangle = RectangleBounds.Botton;
		direction = RectangleBounds.N;
	}



	public void update(double delta){
		
		if(health == 0){
			return;
		}else if(health == 1){
			velocityY = Constants.SPIDER_VELOCITY_Y + 5;
			velocityX = Constants.SPIDER_VELOCITY_X + 5;  
		}
			
			
		if(direction == RectangleBounds.N){
			collisionLadder(delta);
			collisionRL(delta);
			if(direction == RectangleBounds.N){
				if(rectangle == RectangleBounds.Right){
					y += velocityY * (float)delta;
				}else if(rectangle == RectangleBounds.Top){
					y += velocityY  * (float)delta;
				}else if(rectangle == RectangleBounds.Left){
					y += velocityY  * (float)delta;
				}
			}
		}

		if(direction == RectangleBounds.L){
			collisionLeft(delta);
			if(direction == RectangleBounds.L){
				x -= velocityX  * (float)delta;
			}
		
		}

		if(direction == RectangleBounds.R){
			collisionRight(delta);
			if(direction == RectangleBounds.R){
				x += velocityX  * (float)delta;
			}
  	
		}


		if(y >= ladder.getBoundsRight().getHeight()){
			randPosition();
			y = y - (int)ladder.getBoundsRight().getHeight();
			ladder.clearLines();
			ladder.createLines();
		}

			
		

	}



	public void render(Graphics g){

		Graphics2D g2d = (Graphics2D) g; 
		if(health != 0){
			/*g.setColor(new Color(142, 255, 219));
			g2d.draw(getBounds());
			g2d.draw(getBoundsRight());
			g2d.draw(getBoundsLeft());
			g2d.draw(getBoundsTop());*/

			g.drawImage(assets.factoryFace, 
			(int)x + (Constants.SPIDER_RECTANGLE_HIT_SIZE - 100) - 25 ,
			(int)y - (Constants.SPIDER_RECTANGLE_HIT_SIZE / 4) - 20,
			Constants.SPIDER_RECTANGLE_HIT_SIZE + 50,
			Constants.SPIDER_RECTANGLE_HIT_SIZE , null);

		}

		
		


	}


	public void collisionLadder(double delta){

		if(getBounds().intersects(ladder.getBoundsRight())){
			rectangle = RectangleBounds.Right;
		}

		if(getBounds().intersects(ladder.getBoundsTop())){
			rectangle = RectangleBounds.Top;
		}	

		if(getBounds().intersects(ladder.getBoundsLeft())){
			rectangle = RectangleBounds.Left;
		}

		
	}

	public void collisionRL(double delta){
		for(int  i = 0; i < ladder.getLines().size(); i++){
			Lines line = ladder.getLines().get(i);
				if(getBoundsLeft().intersects(line.getBounds())){
					direction = RectangleBounds.L;
					hit = true;
					return;
				}else if(getBoundsRight().intersects(line.getBounds())){
					hit = true;
					direction = RectangleBounds.R;
					return;
				}
		}

	}


	public void collisionLeft(double delta){
		if(direction == RectangleBounds.R){
			return;
		}

		for(int  i = 0; i < ladder.getLines().size(); i++){
			Lines line = ladder.getLines().get(i);
				if(getBoundsLeft().intersects(line.getBounds())){
					direction = RectangleBounds.L;
					hit = true;
					return;
				}
		}
		



		if(hit){
			x -= temp2 * (float)delta;
			y += 19 * (float)delta;
			hit = false;
		}
		direction = RectangleBounds.N;

	}

	public void collisionRight(double delta){
		if(direction == RectangleBounds.L){
			return;
		}

		for(int  i = 0; i < ladder.getLines().size(); i++){
			Lines line = ladder.getLines().get(i);
				if(getBoundsRight().intersects(line.getBounds())){
					hit = true;
					direction = RectangleBounds.R;
					return;
				}
		}


		if(hit){
            x += temp2 * (float)delta;
			y += 19 * (float)delta;
			hit = false;
		}
		direction = RectangleBounds.N;
	}


	public void randPosition(){
		temp = rand.nextInt(3) + 1;
		//if(temp == 1){
			offset = (int)ladder.getBoundsRight().getX() + Constants.SPIDER_RECTANGLE_WIDTH - 5;
			//System.out.println(offset);
		/*}else if(temp == 2){
			offset = (int)ladder.getBoundsTop().getX() + Constants.SPIDER_RECTANGLE_WIDTH - 5;
			//System.out.println(offset);
		}else{
			offset = (int)ladder.getBoundsLeft().getX() + Constants.SPIDER_RECTANGLE_WIDTH - 5;
			//System.out.println(offset);
		}*/

	}


	// big square
    public Rectangle getBounds(){

		return new Rectangle(
			(int)((int)x + (Constants.SPIDER_RECTANGLE_WIDTH / 4)) + offset - 30,
			(int)((int)y + (Constants.SPIDER_RECTANGLE_HEIGHT / 4)),
			(int)Constants.SPIDER_RECTANGLE_WIDTH + 10,
			(int)Constants.SPIDER_RECTANGLE_HEIGHT + 10
			);
	}

	// midel square
	public Rectangle getBoundsTop(){
		return new Rectangle(
			(int)x + (Constants.SPIDER_RECTANGLE_HIT_SIZE - 100) ,
			(int)y - (Constants.SPIDER_RECTANGLE_HIT_SIZE / 4) - 20,
			Constants.SPIDER_RECTANGLE_HIT_SIZE,
			Constants.SPIDER_RECTANGLE_HIT_SIZE
			);
	}


	public Rectangle getBoundsRight(){

		return new Rectangle(
			(int)((int)x + (Constants.SPIDER_RECTANGLE_WIDTH - 5)) + offset - 10,
			(int)y + 15,
			(int)Constants.SPIDER_RECTANGLE_WIDTH - 15,
			(int)Constants.SPIDER_RECTANGLE_HEIGHT - 10
			);
	}

	public Rectangle getBoundsLeft(){

		return new Rectangle(
			(int)x + offset - 30,
			(int)y + 15,
			(int)Constants.SPIDER_RECTANGLE_WIDTH - 15,
			(int)Constants.SPIDER_RECTANGLE_HEIGHT - 10
			);
	}






}