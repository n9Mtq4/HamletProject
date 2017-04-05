package me.willjake.hamlet.ending;

import me.willjake.hamlet.render.Display;

import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by will on 4/2/17 at 10:15 PM.
 * 
 * Check in on the characters and see how they are doing.
 * 
 * @author Will "n9Mtq4" Bresnahan
 */
public class EndCutscene {
	
	// this thing should run for 81 seconds (1 min, 21 seconds)?
	private static final int TICK_LIMIT = 81 * 60;
	private static final int ANIMATION_SPEED = 3; // bigger = slower
	private static final int ANIMATION_SPEED_TICK = 1; // bigger = faster
	private static final int FADE_TIME = 4 * 60;
	private static final int FADE_OUT_POINT = TICK_LIMIT - FADE_TIME; // bug when fadeOutVal time > 255 ticks. int truncates to fadeSpeed = 0
	private static final int FADE_IN_STOP = FADE_TIME;
	
	private Display display;
	private int time = 0;
	
	private BufferedImage[] frames = new BufferedImage[10]; // change this size to the actual size
	private int frame = 0;
	private int yOff = 0;
	
	private boolean fadeIn = true;
	private int fadeInVal = 0xff;
	private boolean fadeOut = false;
	private int fadeOutVal = 0;
	private int fadeSpeed = 0xff / FADE_TIME;
	
	public EndCutscene(Display display) {
		this.display = display;
	}
	
	public void init() {
		
		if (display.music != null && display.music.isRunning()) {
			display.music.stop();
		}
		display.music = display.playSound("honorforall");
		loadImages();
		
	}
	
	private void loadImages() {
		
		frames[0] = upscaleImage(loadImage("rg_dead"), 5.7d);
		
	}
	
	public void tick() {
		
		if (time == FADE_IN_STOP) {
			fadeIn = false;
		}
		
		if (time < FADE_IN_STOP) {
			fadeInVal -= fadeSpeed;
			if (fadeInVal <= 0) fadeInVal = 0;
		}
		
		// first frame
		if (time == FADE_IN_STOP) {
			if (display.deadPeople.get("rg") != null) {
				if (display.deadPeople.get("rg")) frame = 0;
			}
			frame = 0; // TODO: this cause r & g can't live currently in this version. change it when adding r and g choice
		} else if (time == 60 * 10 + 1) {
			frame = 1;
			yOff = 0;
		}
		
		if (time == FADE_OUT_POINT) { // 79 * 60
			// two second fadeOutVal out
			fadeOut = true;
		}
		
		if (time > FADE_OUT_POINT) { // 79 * 60
			fadeOutVal += fadeSpeed;
			if (fadeOutVal > 255) fadeOutVal = 255;
		}
		
		if (time % ANIMATION_SPEED == 0) {
			yOff -= ANIMATION_SPEED_TICK;
		}
		
		time++;
		if (time >= TICK_LIMIT) {
			System.out.println("Warning: End is past the desired length of end scene\nSwitching to credits");
			display.initCredits();
		}
		
	}
	
	public void render(Graphics g) {
		
		final Color backupColor = g.getColor();
		
		if (fadeIn) {
			g.setColor(new Color(fadeInVal, fadeInVal, fadeInVal)); // slowly turn white
			g.fillRect(0, 0, Display.WIDTH * Display.SCALE, Display.HEIGHT * Display.SCALE);
		}
		
		if (!fadeIn) {
			g.drawImage(frames[frame], 0, yOff, null);
		}
		
		if (fadeOut) {
			g.setColor(new Color(0, 0, 0, fadeOutVal)); // slowly increase alpha
			g.fillRect(0, 0, Display.WIDTH * Display.SCALE, Display.HEIGHT * Display.SCALE);
		}
		
		g.setColor(backupColor);
		
	}
	
	private static BufferedImage loadImage(String name) {
		try {
			return ImageIO.read(EndCutscene.class.getResourceAsStream("/assets/art/" + name + ".png"));
		}catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	private static BufferedImage upscaleImage(BufferedImage before, double scale) {
		int w = before.getWidth();
		int h = before.getHeight();
		BufferedImage after = new BufferedImage((int) (w * scale), (int) (h * scale), BufferedImage.TYPE_INT_ARGB);
		AffineTransform at = new AffineTransform();
		at.scale(scale, scale);
		AffineTransformOp scaleOp = new AffineTransformOp(at, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
		after = scaleOp.filter(before, after);
		return after;
	}
	
}
