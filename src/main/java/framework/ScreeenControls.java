package framework;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import until.Enums.ScreenState;
import until.Enums.ObjectId;
import until.Constants;
import until.Enums.BinState;
import until.Enums.WalkState;
import until.Enums.Facing;
import entities.*;
import until.Audio;

public class ScreeenControls implements MouseListener{

	private Game game;
	private GameObject gameObject;
 	private GameObject bin;
    private Boolean fireBlast;

	public ScreeenControls(Game game){
		this.game = game;
        fireBlast = false;
	}


	@Override
    public void mouseClicked(MouseEvent me) {
   
       
    }

    @Override
    public void mousePressed(MouseEvent e) {
    	int mx = e.getX();
		int my = e.getY();
        System.out.println("x->"+mx);
        System.out.println("Y->"+my);
		recycleControls( mx, my);
		worldControls(mx, my);
        menuControls(mx, my);
       
    }

  	@Override
    public void mouseReleased(MouseEvent me) {
    	if(game.getScreenStates() == ScreenState.LEVEL1){
    		if(game.getWorld() != null){
    			game.getWorld().getPlayer().setWalkState(WalkState.NOT_WALKING);
    			game.getWorld().getPlayer().setVelocityX(0);
                fireBlast = false;
    		}
    	}

    }

    @Override
    public void mouseEntered(MouseEvent me) {
  
    }

    @Override
    public void mouseExited(MouseEvent me) {
 
    }

    private void menuControls(int mx, int my){

        if(game.getScreenStates() == ScreenState.MENU){
            if(game.getMenuScreen() != null){
                if(mx >= 575 && mx <= 633 ){
                    if(my >= 548 && my <= 569){
                        game.setScreenState(ScreenState.LOADING);
                    }
                }

                if(mx >= 575 && mx <= 728 ){
                    if(my >= 588 && my <= 610){
                        game.setScreenState(ScreenState.HIGHSCORE);
                        game.startScreens();
                    }
                }

                if(mx >= 575 && mx <= 661 ){
                    if(my >= 630 && my <= 649){
                        game.setScreenState(ScreenState.CREDITS);
                        game.startScreens();
                    }
                }

                 if(mx >= 575 && mx <= 670 ){
                    if(my >= 671 && my <= 690){
                        System.exit(0);
                    }
                }


            }
        }

        if(game.getScreenStates() == ScreenState.CREDITS || game.getScreenStates() == ScreenState.HIGHSCORE){
             if(game.getCredits() != null || game.getHighScores() != null){
                if(mx >= 452 && mx <= 814 ){
                    if(my >= 657 && my <= 683){
                        game.setScreenState(ScreenState.MENU);
                    }
                }
             }

        }





    }



    private void recycleControls(int mx, int my){
    	if(game.getScreenStates() == ScreenState.RECYCLE){
			if(game.getRecycleGame() != null){
				if(game.getRecycleGame().getTrashObjects().peekFirst() != null){
					gameObject = game.getRecycleGame().getTrashObjects().element();
					if(gameObject.getY() > 5){
						if(!gameObject.isHit()){
							if(mx >= (Constants.METAL_BIN_POSITION_X)
								&& mx <= (Constants.METAL_BIN_POSITION_X + Constants.BIN_RECTANGLE_WIDHT)){
								if(my >= (Constants.METAL_BIN_POSITION_Y)
									&&  my <= (Constants.METAL_BIN_POSITION_Y + Constants.BIN_RECTANGLE_HEIGHT)){
									gameObject.setBinState(BinState.METAL);
	   								gameObject.setHit(true);
								}
							}
							if(mx >= (Constants.FOOD_BIN_POSITION_X)
								&& mx <= (Constants.FOOD_BIN_POSITION_X + Constants.BIN_RECTANGLE_WIDHT)){
								if(my >= (Constants.FOOD_BIN_POSITION_Y)
									&&  my <= (Constants.FOOD_BIN_POSITION_Y + Constants.BIN_RECTANGLE_HEIGHT)){
									gameObject.setBinState(BinState.FOOD);
	   								gameObject.setHit(true);
								}
							}
							if(mx >= (Constants.PLASTIC_BIN_POSITION_X)
								&& mx <= (Constants.PLASTIC_BIN_POSITION_X + Constants.BIN_RECTANGLE_WIDHT)){
								if(my >= (Constants.PLASTIC_BIN_POSITION_Y)
									&&  my <= (Constants.PLASTIC_BIN_POSITION_Y + Constants.BIN_RECTANGLE_HEIGHT)){
									gameObject.setBinState(BinState.PLASTIC);
	   								gameObject.setHit(true);	
								}
							}
						}
					}
				}
			}
		}
    }



    private void worldControls(int mx, int my){
    	if(game.getScreenStates() == ScreenState.LEVEL1){
    		if(game.getWorld() != null){
    			if(mx >= Constants.ON_SCREEN_CONTROLS_LEFT_POSITION_X
    					&& mx <= (Constants.ON_SCREEN_CONTROLS_LEFT_POSITION_X + Constants.ON_SCREEN_CONTROLS_WIDTH)){
    				if(my >= Constants.ON_SCREEN_CONTROLS_LEFT_POSITION_Y
    						&& my <= (Constants.ON_SCREEN_CONTROLS_LEFT_POSITION_Y + Constants.ON_SCREEN_CONTROLS_HEIGTH)){
    					game.getWorld().getPlayer().setWalkState(WalkState.WALKING);
    					game.getWorld().getPlayer().setFacing(Facing.LEFT);
    					game.getWorld().getPlayer().setVelocityX(-Constants.PLAYER_MOVEMENT_SPEED);
                        System.out.println("hola");
    				}
    			}
    			if(mx >= Constants.ON_SCREEN_CONTROLS_RIGHT_POSITION_X
    					&& mx <= (Constants.ON_SCREEN_CONTROLS_RIGHT_POSITION_X + Constants.ON_SCREEN_CONTROLS_WIDTH)){
    				if(my >= Constants.ON_SCREEN_CONTROLS_RIGHT_POSITION_Y
    						&& my <= (Constants.ON_SCREEN_CONTROLS_RIGHT_POSITION_Y + Constants.ON_SCREEN_CONTROLS_HEIGTH)){
    					game.getWorld().getPlayer().setWalkState(WalkState.WALKING);
    					game.getWorld().getPlayer().setFacing(Facing.RIGHT);
    					game.getWorld().getPlayer().setVelocityX(Constants.PLAYER_MOVEMENT_SPEED);
    				}
    			}
    			if(mx >= Constants.ON_SCREEN_CONTROLS_UP_POSITION_X
    					&& mx <= (Constants.ON_SCREEN_CONTROLS_UP_POSITION_X + Constants.ON_SCREEN_CONTROLS_WIDTH)){
    				if(my >= Constants.ON_SCREEN_CONTROLS_UP_POSITION_Y
    						&& my <= (Constants.ON_SCREEN_CONTROLS_UP_POSITION_Y + Constants.ON_SCREEN_CONTROLS_HEIGTH)){
    					game.getWorld().getPlayer().setJumping(true);
    					game.getWorld().getPlayer().setVelocityY(-Constants.PLAYER_JUMP_SPEED);
    				}
    			}
                if(mx >= Constants.ON_SCREEN_CONTROLS_FIRE_POSITION_X
                        && mx <= (Constants.ON_SCREEN_CONTROLS_FIRE_POSITION_X + Constants.ON_SCREEN_CONTROLS_WIDTH)){
                    if(my >= Constants.ON_SCREEN_CONTROLS_FIRE_POSITION_Y
                            && my <= (Constants.ON_SCREEN_CONTROLS_FIRE_POSITION_Y + Constants.ON_SCREEN_CONTROLS_HEIGTH)){
                        if((!fireBlast)  && (game.getPlayerHud().getPlayerBlastcount() <= 4) && (!game.getPlayerHud().isFlag())){
                             game.getPlayerHud().setPlayerBlastcount(game.getPlayerHud().getPlayerBlastcount() + 1);
                             Audio.play(Constants.PLAYER_LASER_GUN_ID);
                             game.getWorld().getPlayer().setWalkState(WalkState.NOT_WALKING);
                             game.getPlayerHud().setPlayerBlastcount(game.getPlayerHud().getPlayerBlastcount() + 1);
                             game.getWorld().getPlayer().setFireBlast(true);
                             fireBlast = true;
                             //hola
                        }
                    }
                }
    		}
    	}
    }


}

