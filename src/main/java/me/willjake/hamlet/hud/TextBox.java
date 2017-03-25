package me.willjake.hamlet.hud;

import me.willjake.hamlet.entity.Entity;
import me.willjake.hamlet.render.Display;
import me.willjake.hamlet.render.Screen;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Created by will on 3/25/17 at 6:50 PM.
 *
 * @author Will "n9Mtq4" Bresnahan
 */
public class TextBox {
	
	private static final int BORDERX = 10;
	private static final int BORDERY = 50;
	private static final int DEFAULT_LIFE = 60 * 10; // 10 seconds
	
	public boolean show = false;
	public int life = 0;
	public String text = "textbox";
	public Entity lock = null;
	
	public int xOff = 0;
	public int yOff = 0;
	
	public void render(Screen screen) {
		xOff = screen.xOff; // TODO: very bad
		yOff = screen.yOff;
	}
	
	public void render(Graphics graphics) {
		
		if (!show) return;
		
		graphics.setColor(Color.WHITE);
		
		graphics.fillRoundRect(BORDERX, BORDERY, Display.WIDTH * Display.SCALE - BORDERX * 2, 40, BORDERX * 2, BORDERX * 2);
		
		// TODO: this doesn't work. fix it
		if (lock != null) {
			graphics.drawPolygon(new int[]{BORDERX, BORDERX + 60, lock.x - xOff}, new int[]{BORDERY + 40, BORDERY + 40, lock.y - yOff}, 3);
		}
		
		graphics.setColor(Color.BLACK);
		
		graphics.drawString(text, BORDERX * 2, BORDERX + 60);
		
	}
	
	public void tick() {
		
		life--;
		
		if (life <= 0) {
			show = false;
		}
		
	}
	
	public void go(String text, Entity entity) {
		show = true;
		this.text = text;
		this.life = DEFAULT_LIFE; // TODO: calculate based on the length of the text?
		this.lock = entity;
	}
	
}
