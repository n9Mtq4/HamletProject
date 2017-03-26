package me.willjake.hamlet.launcher;

import me.willjake.hamlet.cutscene.Cutscene;
import me.willjake.hamlet.render.Display;

import javax.swing.JFrame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * Created by will on 3/15/17 at 11:12 AM.
 *
 * @author Will "n9Mtq4" Bresnahan
 */
public class GameLauncher {

	private JFrame frame;
	private Display game;

	public static void main(String[] args) {
		System.out.println("The game has been launched.");

		Cutscene test = new Cutscene("test_scene");

		new GameLauncher();
		
	}
	
	public GameLauncher() {
		frame = new JFrame("Will and Jake Hamlet");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		game = new Display(frame.getRootPane());
		
		frame.add(game);
		
		frame.setResizable(false);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		frame.addWindowListener(new WinListener());
		game.start();
		
	}
	
	public void dispose() {
		game.stop();
	}
	
	public class WinListener implements WindowListener {
		
		@Override
		public void windowOpened(WindowEvent e) {
			
		}
		
		@Override
		public void windowClosing(WindowEvent e) {
			
		}
		
		@Override
		public void windowClosed(WindowEvent e) {
			dispose();
		}
		
		@Override
		public void windowIconified(WindowEvent e) {
			
		}
		
		@Override
		public void windowDeiconified(WindowEvent e) {
			
		}
		
		@Override
		public void windowActivated(WindowEvent e) {
			
		}
		
		@Override
		public void windowDeactivated(WindowEvent e) {
			
		}
	}
	
}
