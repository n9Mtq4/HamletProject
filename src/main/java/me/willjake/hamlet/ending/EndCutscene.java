package me.willjake.hamlet.ending;

import me.willjake.hamlet.render.Display;

import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.Font;
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
	private static final int ANIMATION_SPEED = 2; // bigger = slower
	private static final int ANIMATION_SPEED_TICK = 1; // bigger = faster
	private static final int FADE_TIME = 2 * 60;
	
	private static final int FADE_IN_DEFAULT_VALUE = 0x00;
	private static final int FADE_OUT_DEFAULT_VALUE = 0x0;
	
	private static final int TICKS_PER_IMAGE = (int) (((((228 * 5.7) * ANIMATION_SPEED) / ANIMATION_SPEED_TICK)) - (228 * 5.7));
	private static final int TICKS_PER_IMAGE_FADE = TICKS_PER_IMAGE + 2 * FADE_TIME; // gives us 3 images is ANIMATION_SPEED = 2, FADE_TIME = 2 * 60;
	
	private static final Font DRAW_FONT = new Font(Font.SANS_SERIF, Font.BOLD, 20);
	private static final String[][] text = new String[][] {
			{"I don't know about you but I've had a lovely time."," Intrigue and mystery, butchery and betrayal.", "The death throes of a country!"},
			{"It's just as well, the country was dying already. Hamlet was right,", "Denmark was completely rotten. All it took was the right", "person to knock it over the edge."},
			{"I wonder, was all this worth it?"}};
	
	private Display display;
	private int time = 0;
	
	private BufferedImage[] frames = new BufferedImage[10]; // change this size to the actual size
	private int frame = 0;
	private int yOff = 0;
	private int textIndex = 0;
	
	private boolean fadeIn = true;
	private int fadeInVal = FADE_IN_DEFAULT_VALUE;
	private int fadeInTime = 0;
	private boolean badWorkaround = false;
	
	private boolean fadeOut = false;
	private int fadeOutVal = FADE_OUT_DEFAULT_VALUE;
	private int fadeOutTime = 0;
	private boolean badWorkaround1 = false;
	
	private int fadeSpeed = 1;
	
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
		frames[1] = upscaleImage(loadImage("just_ghost"), 5.7d);
		frames[2] = upscaleImage(loadImage("hamlet_dead_queen_alive"), 5.7d);
		frames[3] = upscaleImage(loadImage("hamlet_queen_alive"), 5.7d);
		frames[4] = upscaleImage(loadImage("both_dead"), 5.7d);
//		frames[5] = upscaleImage(loadImage(""), 5.7d);
		
	}
	
	public void tick() {
		
		// stop the fade in?
		if (fadeInTime == FADE_TIME) {
			fadeInTime = 0;
			fadeIn = false;
			fadeInVal = FADE_IN_DEFAULT_VALUE;
		}
		
		// stop the fade out?
		if (fadeOutTime == FADE_TIME) {
			fadeOutTime = 0;
			fadeOut = false;
			fadeOutVal = FADE_OUT_DEFAULT_VALUE;
		}
		
		// fade in going logic
		if (fadeIn) {
			fadeInTime++;
			fadeInVal += fadeSpeed;
			if (fadeInVal <= 0) fadeInVal = 0;
		}
		
		// fade out going logic
		if (fadeOut) {
			fadeOutTime++;
			fadeOutVal += fadeSpeed;
			if (fadeOutVal >= 255) fadeOutVal = 255;
		}
		
		// frame transition times
		// fade out
		if ((time - (FADE_TIME)) % TICKS_PER_IMAGE_FADE == 0) {
			if (badWorkaround){
				fadeOut = true;
			}else badWorkaround = true;
		}
		// fade in
		if ((time - (FADE_TIME)) % TICKS_PER_IMAGE_FADE == FADE_TIME) {
			if (badWorkaround1){
				fadeIn = true;
			}else badWorkaround1 = true;
		}
		
		// the different points for things to happen:
		if (time == 0) {
			// first fade in
			fadeIn = true;
		}else if (time == FADE_TIME) {
			// first frame
			if (display.deadPeople.get("rg") != null) {
				if (display.deadPeople.get("rg")) frame = 0;
			}
			frame = 0; // TODO: this cause r & g can't live currently in this version. change it when adding r and g choice
			yOff = 0;
			textIndex = 0;
		}else if (time == (FADE_TIME + (1 * TICKS_PER_IMAGE_FADE))) {
			// second frame
			frame = 1;
			yOff = 0;
			textIndex = 1;
		}else if (time == (FADE_TIME + (2 * TICKS_PER_IMAGE_FADE))) {
			// third frame
			if (display.isDead("hamlet") && !display.isDead("gertude")) {
				// hamlet's dead frame, gertude alive
				frame = 2;
			}else if (display.isDead("hamlet") && display.isDead("gertrude")) {
				// hamlet and gertrude dead
				frame = 4;
			}else {
				// no one is dead
				frame = 3;
			}
			frame = 3;
			yOff = 0;
			textIndex = 2;
		}
		
		// last, fade out
		if (time == TICK_LIMIT - FADE_TIME) {
			fadeOut = true;
		}
		
		// tick the animation of scrolling images
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
		
		for (int i = 0; i < text[textIndex].length; i++) {
			g.setColor(Color.RED);
			g.setFont(DRAW_FONT);
			g.drawString(text[textIndex][i], 0, (i + 1) * 40);
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
