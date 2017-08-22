package entities;
import framework.GameObject;
import until.Enums.ObjectId;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Graphics2D;
import until.Constants;
import entities.Player;
import until.Assets;
import until.Enums.Bench;
import until.Enums.Bin;
import java.util.Random;


public class Block extends GameObject{

	private int width;
	private int height;
	private Assets assets;
	private Bench bench;
	private Bin bin;
	private Random rand = new Random();
	private int location;
	private int binLocation;

	public Block(float x, float y, ObjectId id, int width, int height, Assets assets, 
					Bench bench, Bin bin){
		super(x , y, id);
		this.width = width;
		this.height = height;
		this.assets = assets;
		this.bench = bench;
		this.bin = bin;
		location = rand.nextInt(3) + 1;
		binLocation = rand.nextInt(3) + 1;

	}

	public void update(double delta){

	}
	
	public void render(Graphics g){


		if(bin == Bin.BIN){
			setBin(g);
		}else if(bin == Bin.NO_BIN){

		}

		if(bench == Bench.BENCH1){
			setBench1(g);
		}else if(bench == Bench.BENCH2){
			setBench2(g);
		}else if(bench == Bench.NO_BENCH){

		}

		for(int i = 0; i < width ; i+= Constants.BLOCK_SPRITE_WIDTH){
			g.drawImage(assets.blockSprite, ((int)x - 10) + i, (int)y - Constants.BLOCK_HEIGHT, null);
		}


	}

	private void setBench1(Graphics g){
		switch(location){
				case 1: 
					g.drawImage(assets.benchSprite, 
						(int)x, ((int)y) - Constants.BENCH_SPRITE_HEIGTH, 
							Constants.BENCH_SPRITE_WIDTH, Constants.BENCH_SPRITE_HEIGTH, null);
				break;
				case 2: 
					g.drawImage(assets.benchSprite, 
						(int)x + width /2, ((int)y) - Constants.BENCH_SPRITE_HEIGTH, 
							Constants.BENCH_SPRITE_WIDTH, Constants.BENCH_SPRITE_HEIGTH, null);
				break;
				case 3: 
					g.drawImage(assets.benchSprite, 
						(int)x + (width - Constants.BENCH_SPRITE_WIDTH), ((int)y) - Constants.BENCH_SPRITE_HEIGTH, 
							Constants.BENCH_SPRITE_WIDTH, Constants.BENCH_SPRITE_HEIGTH, null);
				break;
			}
	}

	private void setBench2(Graphics g){
		switch(location){
				case 1: 
					g.drawImage(assets.benchSprite1, 
						(int)x, ((int)y) - Constants.BENCH_SPRITE_HEIGTH, 
							Constants.BENCH_SPRITE_WIDTH, Constants.BENCH_SPRITE_HEIGTH, null);
				break;
				case 2: 
					g.drawImage(assets.benchSprite1, 
						(int)x + width /2, ((int)y) - Constants.BENCH_SPRITE_HEIGTH, 
							Constants.BENCH_SPRITE_WIDTH, Constants.BENCH_SPRITE_HEIGTH, null);
				break;
				case 3: 
					g.drawImage(assets.benchSprite1, 
						(int)x + (width - Constants.BENCH_SPRITE_WIDTH), ((int)y) - Constants.BENCH_SPRITE_HEIGTH, 
							Constants.BENCH_SPRITE_WIDTH, Constants.BENCH_SPRITE_HEIGTH, null);
				break;
			}
	}


	private void setBin(Graphics g){
		switch(binLocation){
				case 1: 
					g.drawImage(assets.binSprite, 
						(int)x, ((int)y) - Constants.BIN_SPITE_HEIGTH, 
							Constants.BIN_SPITE_WIDTH, Constants.BIN_SPITE_HEIGTH, null);
				break;
				case 2: 
					g.drawImage(assets.binSprite, 
						(int)x + width /2, ((int)y) - Constants.BIN_SPITE_HEIGTH, 
							Constants.BIN_SPITE_WIDTH, Constants.BIN_SPITE_HEIGTH, null);
				break;
				case 3: 
					g.drawImage(assets.binSprite, 
						(int)x + (width - Constants.BIN_SPITE_WIDTH), ((int)y) - Constants.BIN_SPITE_HEIGTH, 
							Constants.BIN_SPITE_WIDTH, Constants.BIN_SPITE_HEIGTH, null);
				break;
			}


	}

	public Rectangle getBounds(){
		return new Rectangle((int)x, (int)y, width,height);
	}

	public Rectangle getBoundsTop(){
		return null;
	}
	public Rectangle getBoundsRight(){
		return null;
	}
	public Rectangle getBoundsLeft(){
		return null;
	}

}