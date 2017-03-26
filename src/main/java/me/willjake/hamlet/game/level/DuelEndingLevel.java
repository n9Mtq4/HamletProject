package me.willjake.hamlet.game.level;

import me.willjake.hamlet.game.Tiles;
import me.willjake.hamlet.level.Level;
import me.willjake.hamlet.level.Tile;

/**
 * Created by will on 3/26/17 at 6:35 PM.
 *
 * @author Will "n9Mtq4" Bresnahan
 */
public class DuelEndingLevel extends Level {
	
	public DuelEndingLevel() {
		super("/assets/world/greathall.png", "/assets/world/greathallfront.png");
	}
	
	@Override
	public Tile tileTranslator(int tile) {
		
		if (tile == 0xffff00ff) return null;
		
		if (tile == 0xffffffff) return Tiles.TILED_FLOOR;
		if (tile == 0xffba00ba) return Tiles.THRONE_BOTTOM;
		if (tile == 0xffba00bb) return Tiles.THRONE_TOP;
		if (tile == 0xffa0a0a0) return Tiles.STONE_LIGHT;
		if (tile == 0xff000000) return Tiles.STONE_DARK;
		if (tile == 0xff0fff02) return Tiles.COLUMN_TOP;
		if (tile == 0xff0fff01) return Tiles.COLUMN_MID;
		if (tile == 0xff0fff00) return Tiles.COLUMN_BOTTOM;
		if (tile == 0xff00ff00) return Tiles.GRASS;
		if (tile == 0xffff0000) return Tiles.SOLID_TILE;
		
		System.out.println("Tile: " + tile + " is unknown");
		return Tiles.voidTile;
		
	}
	
	
}
