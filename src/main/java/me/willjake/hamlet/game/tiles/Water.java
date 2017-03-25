package me.willjake.hamlet.game.tiles;

import me.willjake.hamlet.entity.Entity;
import me.willjake.hamlet.level.Tile;
import me.willjake.hamlet.render.gfx.Sprite;

/**
 * Created by will on 3/25/17 at 12:02 PM.
 *
 * @author Will "n9Mtq4" Bresnahan
 */
public class Water extends Tile {
	
	public Water(Sprite sprite) {
		super(sprite);
	}
	
	@Override
	public boolean isSolid(Entity entity) {
		return true; // TODO: change if we have swimming
	}
	
}
