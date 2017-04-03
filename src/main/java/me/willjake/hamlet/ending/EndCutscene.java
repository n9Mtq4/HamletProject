package me.willjake.hamlet.ending;

import me.willjake.hamlet.render.Display;

import java.awt.Graphics;

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
	
	public EndCutscene(Display display) {
		this.display = display;
	}
	
	public void init() {
		
		display.music = display.playSound("honorforall");
		
	}
	
	public void tick() {
		
		time++;
		
		if (time >= TICK_LIMIT) {
			System.out.println("Warning: End is past the desired length of end scene\nSwitching to credits");
			display.initCredits();
		}
		
	}
	
	public void render(Graphics graphics) {
		
		
		
	}
	
}
