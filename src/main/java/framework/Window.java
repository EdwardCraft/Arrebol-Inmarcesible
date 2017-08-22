package framework;
import java.awt.Dimension;
import javax.swing.JFrame;
import java.awt.DisplayMode;


public class Window{
	
	private JFrame frame;

	public Window(int width, int height, String name, Game game)
	{
		game.setPreferredSize(new Dimension( width, height));
		game.setMaximumSize(new Dimension( width, height));
		game.setMinimumSize(new Dimension(width, height));

		frame = new JFrame(name);
		frame.add(game, DisplayMode.REFRESH_RATE_UNKNOWN);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		game.start();
	}
}