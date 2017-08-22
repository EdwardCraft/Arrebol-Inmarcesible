package until;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import entities.Player;
import screens.World;
import framework.GameObject;
import until.Enums.ObjectId;


public class ChaseCam{

	private float positionX;
	private float positionY;
	private Boolean createKiosk;
	private World world;
	private Boolean shake;

	public ChaseCam(float positionX, float positionY, World world){
		//  receive the coordinates of the player
		this.positionX = positionX;
		this.positionY = positionY;
		this.world = world;
		shake = false;
		createKiosk = false;

	}

	public void update(Player player){
		// set the position of the x coordinate of the chase cam
		// to the position of the x coordinate of the  player
		// we add to the player getX() an offset 
		// equal to the game width divide by a number 
		// The number will determinate the position on where the camera
		// is going to be located around the player
		positionX = -player.getX() + ((Constants.GAME_WINDOW_WIDTH / 2) - 50);
		positionY = 0;
		/*if(player.getX()  >= (Constants.GAME_WINDOW_WIDTH * 14 + Constants.PLAYER_JUNP_LENGTH)){
		positionY = -(int)player.getY() + (Constants.GAME_WINDOW_HEIGHT - (Constants.PLAYER_HEIGHT + 50));
		}	*/
		earthquake(player);

	}

	private void earthquake(Player player){
		if(world != null){
			if(world.getBlocks() != null){
				for(int i = 0; i < world.getBlocks().size(); i++){
					GameObject boss = world.getBlocks().get(i);
					if(boss.getObjectId() == ObjectId.MiddleBoss){
						if(boss.gethitGround()){
							shake = !shake;
							if(shake){
								positionY = -10;
							}else{
								positionY = 10;
							}
						}
					}
				}
			}
		}
	}



	public void render(Graphics g){
	

	}






	public Rectangle cameraBounds(){
		return new Rectangle(
			-(int)positionX,
			(int)0,
			(int) Constants.GAME_WINDOW_WIDTH + 5,
			(int) Constants.GAME_WINDOW_HEIGHT + 7
			);
	}

	public float getPositionX(){ return positionX; }
	public void setPositionX(float positionX){ this.positionX = positionX; }
	public float getPositionY(){ return positionY; }
	public void setPositionY(float positionY){ this.positionY = positionY; }

}