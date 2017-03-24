package me.willjake.hamlet.level;

import me.willjake.hamlet.game.Tile;

import java.util.ArrayList;

/**
 * Created by jakekinsella on 3/21/17.
 */
public class Level {
	
	private int width, height;
	private ArrayList<Tile> tileMap = new ArrayList<Tile>();
	
	public Level(String levelFile) {
		this.setup(levelFile);
	}
	
	public void tick() {
		
	}
	
	public void render() {
		
	}
	
	public Tile getTile(int x, int y) {
		for (Tile tile : this.tileMap) {
			if (tile.contains(x, y)) {
				return tile;
			}
		}
		
		return null;
	}
	
	public double getLightValue(int x, int y) {
		// TODO: Lets avoid light for now
		return 1.0D;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	private void setup(String levelFile) {
		LevelParser levelParser = new LevelParser(levelFile);
		
		this.width = levelParser.getWidth();
		this.height = levelParser.getHeight();
		this.tileMap = levelParser.getTiles();
	}
}
