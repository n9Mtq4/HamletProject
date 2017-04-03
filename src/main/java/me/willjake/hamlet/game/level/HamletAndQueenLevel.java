package me.willjake.hamlet.game.level;

import me.willjake.hamlet.level.Level;
import me.willjake.hamlet.level.Tile;

/**
 * Created by will on 4/3/17 at 1:47 AM.
 *
 * @author Will "n9Mtq4" Bresnahan
 */
public class HamletAndQueenLevel extends Level {
	
	public HamletAndQueenLevel() {
		//TODO: it can't load the first image WWWWHHHHYYYY???
		super("/assets/world/bedroom_back.png", "/assets/world/bedroom_front.png");
		
		
		
	}
	
	@Override
	public Tile tileTranslator(int tile) {
		return TileTranslator.tileTranslator(tile);
	}
	
}
