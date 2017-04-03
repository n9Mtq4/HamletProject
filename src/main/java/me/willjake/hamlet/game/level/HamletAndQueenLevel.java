package me.willjake.hamlet.game.level;

import me.willjake.hamlet.entity.Player;
import me.willjake.hamlet.level.Level;
import me.willjake.hamlet.level.Tile;
import me.willjake.hamlet.render.Screen;

/**
 * Created by will on 4/3/17 at 1:47 AM.
 *
 * @author Will "n9Mtq4" Bresnahan
 */
public class HamletAndQueenLevel extends Level {
	
	public HamletAndQueenLevel() {
		
		super("/assets/world/bedroom_back.png", "/assets/world/bedroom_front.png");
		
	}
	
	@Override
	public Player playerInit(Player player) {
		
		player.x = 10 * Screen.ABS_TILE_SIZE;
		player.y = 10 * Screen.ABS_TILE_SIZE;
		
		return player;
		
	}
	
	@Override
	public Tile tileTranslator(int tile) {
		return TileTranslator.tileTranslator(tile);
	}
	
}
