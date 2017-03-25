package me.willjake.hamlet.game.tiles;

import me.willjake.hamlet.entity.Entity;
import me.willjake.hamlet.game.Sprites;
import me.willjake.hamlet.level.Tile;

/**
 * Created by will on 3/25/17 at 12:00 PM.
 *
 * @author Will "n9Mtq4" Bresnahan
 */
public class ColumnBottom extends Tile {
	
	public ColumnBottom() {
		super(Sprites.columnBottom);
	}
	
	@Override
	public boolean isSolid(Entity entity) {
		return true;
	}
	
}
