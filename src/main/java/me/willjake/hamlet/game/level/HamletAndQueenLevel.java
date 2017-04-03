package me.willjake.hamlet.game.level;

import me.willjake.hamlet.entity.Player;
import me.willjake.hamlet.game.entity.Gertrude;
import me.willjake.hamlet.game.entity.Hamlet;
import me.willjake.hamlet.game.entity.Polonius;
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
		
		final Polonius polonius = new Polonius(8, 8);
		final Gertrude gertrude = new Gertrude(8, 8);
		final Hamlet hamlet = new Hamlet(8, 8);
		
		add(polonius);
		add(gertrude);
		add(hamlet);
		
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
