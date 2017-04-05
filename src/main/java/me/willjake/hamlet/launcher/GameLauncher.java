package me.willjake.hamlet.launcher;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
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
		
		new GameLauncher();
		
	}
	
	public GameLauncher() {
		
		frame = new JFrame("Will and Jake Hamlet");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		game = new Display(frame.getRootPane(), frame, this);
		
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
	
	public void showGource() {
		
		System.out.println("Called!");
		
		game.setVisible(false);
//		game.stop();
		frame.remove(game);
		
		final JFXPanel fxPanel = new JFXPanel();
		
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				initFx(fxPanel);
			}
		});
		
		frame.add(fxPanel);
		
	}
	
	public void initFx(JFXPanel fxPanel) {
		final Scene scene = createScene();
		fxPanel.setScene(scene);
		System.out.println("Video playing");
	}
	
	private static Scene createScene() {
		Group root = new Group();
		Scene scene = new Scene(root, Color.ALICEBLUE);
		
//		Media media = new Media(GameLauncher.class.gxetResource("/assets/video/gource.flv").toString());
		// TODO: update the url to a final flv of the gource timelapse thing
		// video is about 1 minute and 55 seconds long
//		Media media = new Media("http://download.oracle.com/otndocs/products/javafx/oow2010-2.flv");
		Media media = new Media("http://n9mtq4.com/img/gource.flv");
		MediaPlayer mediaPlayer = new MediaPlayer(media);
		mediaPlayer.setAutoPlay(true);
		MediaView mediaView = new MediaView(mediaPlayer);
		
		root.getChildren().add(mediaView);
		
		return (scene);
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
