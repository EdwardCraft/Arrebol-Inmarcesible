package entities;
import framework.GameObject;
import until.Enums.ObjectId;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Graphics2D;
import java.awt.Color;
import until.Constants;
import entities.Lines;
import until.Enums.RectangleBounds;
import java.util.LinkedList;
import java.util.Random;
import until.Assets;

public class Ladder extends GameObject{

	private LinkedList<Lines> lines;
	private GameObject tempLines;
	private Random rand = new Random();
	private int randSelection;
	private int temp;
	private int offset;
	private int[] offsetArray;
	private Assets assets;

	public Ladder(float x, float y, ObjectId id, Assets assets){
		super(x, y, id);
		this.assets = assets;
		lines = new LinkedList<Lines>();
		offsetArray = new int[6];
        offset = 0;
        randSelection = 0;
        temp = 0;
        createLines();
	}




	public void update(double delta){
		

		if(lines != null){
			for(int i = 0; i < lines.size(); i++){
				lines.get(i).update(delta);
			}
		}

		

	}

	public void render(Graphics g){
		Graphics2D g2d = (Graphics2D) g; 
		

		for(int i = 0; i < Constants.GAME_WINDOW_HEIGHT ; i += 100){
			g.drawImage(assets.facoryLineOne, 
				(int)x + (Constants.GAME_WINDOW_WIDTH - 115), 
				i, 20, 100,null);
		}

		for(int i = 0; i < Constants.GAME_WINDOW_HEIGHT ; i += 100){
			g.drawImage(assets.facoryLineOne, 
				(int)x + (Constants.GAME_WINDOW_WIDTH / 2) - 5, 
				i, 20, 100,null);
		}

		for(int i = 0; i < Constants.GAME_WINDOW_HEIGHT ; i += 100){
			g.drawImage(assets.facoryLineOne, 
				(int)x + (Constants.GAME_WINDOW_WIDTH / 6) - 55, 
				i, 20, 100,null);
		}

		if(lines != null){
			for(int i = 0; i < lines.size(); i++){
				lines.get(i).render(g);
			}
		}


	}


	public void createLines(){

		for(int i = 0; i < 5; i++ ){
			temp = reLocation(randomLocation(), 0);
			offsetArray[i] = temp;
			randSelection = rand.nextInt( 2 ) + 1;
			if(randSelection == 1){
				addObject(
				new Lines(
					0, 0,
					ObjectId.Lines, this,
					RectangleBounds.Right, temp)
				);
			}else{
				addObject(
				new Lines(
					0, 0,
					ObjectId.Lines, this,
					RectangleBounds.Left, temp)
				);
			}

		}

	}


	public void addObject(Lines object){ 
		lines.add(object); 
	}

	public void removeObject(Lines object){ 
		lines.remove(object);
	}

	public void clearLines(){
		lines.clear();
		for(int  i = 0; i < offsetArray.length; i++){
			offsetArray[i] = 0;
		}

	}

	public int reLocation(int temp, int i){

		if( i == offsetArray.length){
			return temp;
		}
		if(temp == offsetArray[i]){
			return reLocation(randomLocation(),0);
		}else{
			return reLocation(temp, i+1);
		 }
		
	}



	public int randomLocation(){
		offset = 0;
		offset = offset + rand.nextInt((int)getBoundsRight().getHeight()) + 1;
		if(offset <= 95){
			return offset = 95;
		}else if(offset <= 190){
			return offset = 190;
		}else if(offset <= 285){
			return offset = 285;
		}else if(offset <= 380){
			return offset = 380;
		}else {
			return offset = 475;
		}
	}


	public Rectangle getBounds(){return null;}


	public Rectangle getBoundsTop(){ 
		return new Rectangle(
			(int)x + Constants.GAME_WINDOW_WIDTH / 2,
			(int)y + 30,
			10,
			Constants.GAME_WINDOW_HEIGHT - 50
			); 
	}

	public Rectangle getBoundsRight(){
	 return new Rectangle(
	 	(int)x + (Constants.GAME_WINDOW_WIDTH / 6) - 50,
	 	(int)y + 30,
	 	10,
	 	Constants.GAME_WINDOW_HEIGHT - 50
	 	);
	}

	public Rectangle getBoundsLeft(){ 
		return new Rectangle(
			(int)x + (Constants.GAME_WINDOW_WIDTH - 110),
			(int)y + 30,
			10,
			Constants.GAME_WINDOW_HEIGHT - 50
			); 
	}


	public LinkedList<Lines> getLines(){ return lines;}


}
