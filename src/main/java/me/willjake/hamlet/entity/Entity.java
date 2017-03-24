package me.willjake.hamlet.entity;

import me.willjake.hamlet.level.Level;
import me.willjake.hamlet.render.Display;
import me.willjake.hamlet.render.Screen;
import me.willjake.hamlet.render.gfx.Sprite;

/**
 * Created by will on 3/21/17 at 2:39 PM.
 *
 * @author Will "n9Mtq4" Bresnahan
 */
public class Entity {
	
	public int x;
	public int y;
	public boolean removed = false;
	public Level level;
	public Display display;
	protected Sprite sprite;
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public void init(Level level, Display display) {
		this.level = level;
		this.display = display;
	}
	
	public void render(Screen screen) {
		
	}
	
	public void renderSpriteRel(Screen screen, Sprite sprite) {
		screen.renderSpriteRel(x, y, x / Screen.ABS_TILE_SIZE, y / Screen.ABS_TILE_SIZE, sprite, level);
	}
	
	public void renderSpriteAbs(Screen screen, Sprite sprite) {
		screen.renderSpriteAbs(x, y, x / Screen.ABS_TILE_SIZE, y / Screen.ABS_TILE_SIZE, sprite, level);
	}
	
	public double getLightLevel() {
		return level.getLightValue(x / Screen.ABS_TILE_SIZE, y / Screen.ABS_TILE_SIZE);
	}
	
	public void tick() {
		
	}
	
	public void remove() {
		removed = true;
	}
	
	public boolean isRemoved() {
		return removed;
	}
	
}
