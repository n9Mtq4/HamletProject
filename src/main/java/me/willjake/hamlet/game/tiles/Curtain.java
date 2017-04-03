package me.willjake.hamlet.game.tiles;

import me.willjake.hamlet.entity.Entity;
import me.willjake.hamlet.game.Sprites;
import me.willjake.hamlet.level.Tile;

/**
 * Created by will on 4/3/17 at 2:15 AM.
 *
 * @author Will "n9Mtq4" Bresnahan
 */
public class Curtain extends Tile {
	
	public Curtain() {
		super(Sprites.curtain);
	}
	
	@Override
	public boolean isSolid(Entity entity) {
		return true;
	}
	
}
