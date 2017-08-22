import until.*;
import framework.Game;
import framework.Window;

public class Start{

	public static void main(String[] args) {
		new	Window(
			Constants.GAME_WINDOW_WIDTH, 
			Constants.GAME_WINDOW_HEIGHT,
			"First Window",
			new Game()
			);
	}	
}