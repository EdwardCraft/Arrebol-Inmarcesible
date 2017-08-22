package until;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import until.Enums.PlayMode;

public class Animation {
	
	private float speed;
	private int frames;
	private float index =0;//what we are current at
	private int count =0;//where we need to be 
	private BufferedImage[] images;
	private BufferedImage currentImg;
	private Boolean finish;

	public Animation(float speed, BufferedImage... args){
		this.speed = speed;
		images = new BufferedImage[args.length];
		finish = false;
		for(int i = 0; i < args.length; i++)
		{
			images[i] = args[i];
			
		}
		frames = args.length;
	}


	public void runAnimation(PlayMode playmode){
		
		index ++;
		if(index > speed)
		{
			index = 0;
			switch(playmode){
				case  LOOP:  nextFrame();	 break;
				case  NORMAL:  normal(); break;
			}
						
		}

	}

	private void nextFrame(){
		 if(count >= frames){
         	count = 0;
         	finish = true;
         }
		 currentImg = images[count % frames];
         count++;
  

	}

	private void normal(){
		if(count >= frames){
         	finish = true;
         	return;
         }
		 currentImg = images[count % frames];
         count++;
	}

	public void drawAnimation(Graphics g, int x, int y){

		g.drawImage(currentImg, x, y, null);

	}

	public void drawAnimation(Graphics g, int x, int y,int scaleX, int scaleY){

		g.drawImage(currentImg, x, y, scaleX, scaleY, null);
			
	}
	
	public int getCount(){ return  count;}
	public void setCount(int count){this.count = count;}
	public int getFrames(){ return frames;}
	public Boolean isFinish(){return finish;}
	public void setFinish(Boolean finish){this.finish = finish;}
	public void setSpeed(float speed){this.speed =  speed;}


}