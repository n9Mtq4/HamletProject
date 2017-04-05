package me.willjake.hamlet.ending;

import me.willjake.hamlet.render.Display;

import javax.imageio.ImageIO;
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
	
	// this thing should run for 80 seconds or 4800 ticks
	private static final int TICK_LIMIT = 4800;
	
	private Display display;
	private int time = 0;
	
	private BufferedImage[] frames = new BufferedImage[10]; // change this size to the actual size
	private int frame = 0;
	private int yOff = 0;
	
	public EndCutscene(Display display) {
		this.display = display;
	}
	
	public void init() {
		
		display.music = display.playSound("honorforall");
		loadImages();
		
	}
	
	private void loadImages() {
		
		frames[0] = upscaleImage(loadImage("rg_dead"), 5.7d);
		
	}
	
	public void tick() {
		
		if (time > 0 && time <= 60 * 10) {
			frame = 0;
		}
		
		yOff--;
		time++;
		if (time >= TICK_LIMIT) {
			System.out.println("Warning: End is past the desired length of end scene\nSwitching to credits");
			display.initCredits();
		}
		
	}
	
	public void render(Graphics g) {
		
		g.drawImage(frames[frame], 0, yOff, null);
		
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
