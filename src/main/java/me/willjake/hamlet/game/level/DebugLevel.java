package me.willjake.hamlet.game.level;

import me.willjake.hamlet.level.Level;
import me.willjake.hamlet.level.Tile;

/**
 * Created by will on 3/24/17 at 3:11 PM.
 *
 * @author Will "n9Mtq4" Bresnahan
 */
public class DebugLevel extends Level {
	
	public DebugLevel() {
		super("/assets/world/greathall.png", "/assets/world/greathallfront.png");
	}
	
	@Override
	public Tile tileTranslator(int tile) {
		
		return TileTranslator.tileTranslator(tile);
		
	}
	
}
