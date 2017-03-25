package me.willjake.hamlet.game.tiles;

import me.willjake.hamlet.entity.Entity;
import me.willjake.hamlet.game.Sprites;
import me.willjake.hamlet.level.Tile;

/**
 * Created by will on 3/25/17 at 11:57 AM.
 * 
 * Its the floor tiles
 * 
 * @author Will "n9Mtq4" Bresnahan
 */
public class StoneBrown extends Tile {
	
	public StoneBrown() {
		super(Sprites.stoneBrown);
	}
	
	@Override
	public boolean isSolid(Entity entity) {
		return false;
	}
	
}
