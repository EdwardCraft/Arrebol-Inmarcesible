package framework;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import screens.World;
import until.Constants;
import until.Enums.JumpState;
import screens.MenuScreen;
import framework.Game;
import until.Enums.ScreenState;
import until.Enums.WalkState;
import until.Enums.Facing;
import screens.LadderGame;
import entities.*;
import until.Enums.Facing;
import until.Enums.ObjectId;
import until.Audio;

public class KeyInput extends KeyAdapter{

	private World world;
	private MenuScreen menuScreen;
	private Game game;
	private LadderGame ladderGame;
	private Boolean fireBlast;


	public KeyInput( World world, MenuScreen menuScreen, Game game ){
		this.world = world;
		this.menuScreen = menuScreen;
		this.game = game;
		fireBlast = false;
	}

	@SuppressWarnings("deprecation")
	public void keyPressed(KeyEvent e){
			
		int  key  = e.getKeyCode();	 

		playerKeys(key);
		menuKeys(key);

	   	if(key == KeyEvent.VK_ESCAPE){
		   	System.exit(1);
	   	}

	}

	private void playerKeys(int  key){
		if(game.getScreenStates() == ScreenState.LEVEL1 || game.getScreenStates() == ScreenState.PAUSE){
			if((!world.getPlayer().isHit() &&  (!world.getPlayer().getDone()[5]))){
				if(!world.getPlayer().isFireBlast()){
					if(key == KeyEvent.VK_RIGHT){
					world.getPlayer().setWalkState(WalkState.WALKING);
					world.getPlayer().setFacing(Facing.RIGHT);
					world.getPlayer().setVelocityX(Constants.PLAYER_MOVEMENT_SPEED);
	   			}

	   			if(key == KeyEvent.VK_LEFT){
	   				world.getPlayer().setWalkState(WalkState.WALKING);
	   				world.getPlayer().setFacing(Facing.LEFT);
					world.getPlayer().setVelocityX(-Constants.PLAYER_MOVEMENT_SPEED);
			
	   			}
				if( (key == KeyEvent.VK_SPACE) && !world.getPlayer().isJumping() ){
					world.getPlayer().setJumping(true);
					world.getPlayer().setVelocityY(-Constants.PLAYER_JUMP_SPEED_1);

	   			}

	   			if(key == KeyEvent.VK_Z){
	   				if((!fireBlast)  && (game.getPlayerHud().getPlayerBlastcount() <= 4) && (!game.getPlayerHud().isFlag())
	   					&& !world.getPlayer().isEarthQuare()){
	   					world.getPlayer().setWalkState(WalkState.NOT_WALKING);
	   					game.getPlayerHud().setPlayerBlastcount(game.getPlayerHud().getPlayerBlastcount() + 1);
	   					world.getPlayer().setFireBlast(true);
	   					fireBlast = true;
	   				}
	   		    }

	   		    if(key == KeyEvent.VK_A){
	   		    	game.getPlayerHud().setChargeBuster(true);
	   		    }

				}
			}
	

	   		if(key == KeyEvent.VK_ENTER){
	   			Audio.play(Constants.PAUSE_SOUND_ID);
	   			if(game.getScreenStates() != ScreenState.PAUSE){
					game.setScreenState(ScreenState.PAUSE);
				}else{
					game.setScreenState(ScreenState.LEVEL1);
				}
	   		}

		}

		if(game.getScreenStates() == ScreenState.LADDERGAME){
			if(key == KeyEvent.VK_RIGHT){
				ladderGame.getPlayer().setWalkState(WalkState.WALKING);
				ladderGame.getPlayer().setFacing(Facing.RIGHT);
				ladderGame.getPlayer().setVelocityX(Constants.PLAYER_MOVEMENT_SPEED);
	   		}
	   		if(key == KeyEvent.VK_LEFT){
	   			ladderGame.getPlayer().setFacing(Facing.LEFT);
	   			ladderGame.getPlayer().setWalkState(WalkState.WALKING);
				ladderGame.getPlayer().setVelocityX(-Constants.PLAYER_MOVEMENT_SPEED);
			
	   		}
			if( (key == KeyEvent.VK_SPACE) && !ladderGame.getPlayer().isJumping()){
				ladderGame.getPlayer().setJumping(true);
				ladderGame.getPlayer().setVelocityY(-Constants.PLAYER_JUMP_SPEED);
	   		}

	   		if(key == KeyEvent.VK_Z){
	   			if((!fireBlast)  && (game.getPlayerHud().getPlayerBlastcount() <= 4) && (!game.getPlayerHud().isFlag())){
	   				ladderGame.getPlayer().setWalkState(WalkState.NOT_WALKING);
	   				game.getPlayerHud().setPlayerBlastcount(game.getPlayerHud().getPlayerBlastcount() + 1);
	   				ladderGame.getPlayer().setFireBlast(true);
	   				fireBlast = true;
	   			}
	   		}

	   		if(key == KeyEvent.VK_A){
	   		    	game.getPlayerHud().setChargeBuster(true);
	   		    }

		}

		if(game.getScreenStates() == ScreenState.WINER){
			if(key == KeyEvent.VK_SPACE){
				game.setScreenState(ScreenState.MENU);
			}
		}

		if(game.getScreenStates() == ScreenState.HIGHSCORE){

			if(key == KeyEvent.VK_SPACE){
				game.setScreenState(ScreenState.MENU);
			}
		}

		if(game.getScreenStates() == ScreenState.CREDITS){
			if(key == KeyEvent.VK_SPACE){
				game.setScreenState(ScreenState.MENU);
			}
		}



	}

	private void menuKeys(int  key){
		if(game.getScreenStates() == ScreenState.MENU){
			if(key == KeyEvent.VK_ENTER){
				menuScreen.select();
			}

			if(key == KeyEvent.VK_UP){
				menuScreen.setCurrentChoise(menuScreen.getCurrentChoise()-1);
				if(menuScreen.getCurrentChoise() == -1){
					menuScreen.setCurrentChoise(menuScreen.getOptions().length-1);
				}
			}
			if(key == KeyEvent.VK_DOWN){
				menuScreen.setCurrentChoise(menuScreen.getCurrentChoise()+1);
				if(menuScreen.getCurrentChoise() == menuScreen.getOptions().length){
					menuScreen.setCurrentChoise(0);
				}
			}
		}
	}

	public void keyReleased(KeyEvent e){
		int  key  = e.getKeyCode();
		if(game.getScreenStates() == ScreenState.LEVEL1 ){
			if(key == KeyEvent.VK_RIGHT){
				world.getPlayer().setWalkState(WalkState.NOT_WALKING);
				world.getPlayer().setVelocityX(0);
	   		}
	   		if(key == KeyEvent.VK_LEFT){
	   			world.getPlayer().setWalkState(WalkState.NOT_WALKING);
				world.getPlayer().setVelocityX(0);
	   		}

	   		if(key == KeyEvent.VK_Z){
				fireBlast = false;
	   		}

	   		if(key == KeyEvent.VK_A){
	   		    game.getPlayerHud().setChargeBuster(false);
	   		}
		}

		if(game.getScreenStates() == ScreenState.LADDERGAME){
			if(key == KeyEvent.VK_RIGHT){
				ladderGame.getPlayer().setWalkState(WalkState.NOT_WALKING);
				ladderGame.getPlayer().setVelocityX(0);
	   		}
	   		if(key == KeyEvent.VK_LEFT){
	   			ladderGame.getPlayer().setWalkState(WalkState.NOT_WALKING);
				ladderGame.getPlayer().setVelocityX(0);
	   		}

	   		if(key == KeyEvent.VK_Z){
				fireBlast = false;
	   		}
		}


	}

	public void setWorld(World world){ this.world = world; }
	public void setLadderGame(LadderGame ladderGame){this.ladderGame = ladderGame;}

}