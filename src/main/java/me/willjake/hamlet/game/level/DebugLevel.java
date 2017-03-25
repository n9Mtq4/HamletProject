package me.willjake.hamlet.game.level;

import me.willjake.hamlet.game.Tiles;
import me.willjake.hamlet.level.Level;
import me.willjake.hamlet.level.Tile;

/**
 * Created by will on 3/24/17 at 3:11 PM.
 *
 * @author Will "n9Mtq4" Bresnahan
 */
public class DebugLevel extends Level {
	
	private int test = 0;
	
	public DebugLevel() {
		super("/assets/world/debug.png", "/assets/world/debug.png");
	}
	
	@Override
	public Tile tileTranslator(int tile) {
		
		if (true) return Tiles.STONE_LIGHT;
		
		test++;
		test %= 10;
		
		switch(test) {
			case 0:
				return Tiles.STONE_BROWN;
			case 1:
				return Tiles.STONE_DARK;
			case 2:
				return Tiles.STONE_LIGHT;
			default:
				return Tiles.STONE_LIGHT;
		}
		
	}
	
}
