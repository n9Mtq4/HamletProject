package me.willjake.hamlet.game.tiles;

import me.willjake.hamlet.entity.Mob;
import me.willjake.hamlet.game.Sprites;
import me.willjake.hamlet.level.Tile;

/**
 * Created by will on 3/25/17 at 12:01 PM.
 *
 * @author Will "n9Mtq4" Bresnahan
 */
public class Chest extends Tile {
	
	public Chest() {
		super(Sprites.chest);
	}
	
	@Override
	public void mobIn(Mob mob) {
		// TODO: open up an inventory screen????
		super.mobIn(mob);
	}
	
}
