package me.willjake.hamlet.level;

import me.willjake.hamlet.game.Tile;

/**
 * Created by jakekinsella on 3/21/17.
 */
public class Level {
	
	private int width;
	private int height;
	
	public Level(String levelFile) {
		this.setup(levelFile);
	}
	
	private void setup(String levelFile) {
		
	}
	
	public void tick() {
		
	}
	
	public void render() {
		
	}
	
	public Tile getTile(int x, int y) {
		return null; // jake implement this
	}
	
	public double getLightValue(int x, int y) {
		// TODO: NYI may not use
		return 1.0D;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
}
