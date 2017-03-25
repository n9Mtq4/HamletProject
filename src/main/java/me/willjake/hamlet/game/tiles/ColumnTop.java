package me.willjake.hamlet.game.tiles;

import me.willjake.hamlet.entity.Entity;
import me.willjake.hamlet.game.Sprites;
import me.willjake.hamlet.level.Tile;

/**
 * Created by will on 3/25/17 at 11:59 AM.
 *
 * @author Will "n9Mtq4" Bresnahan
 */
public class ColumnTop extends Tile {
	
	public ColumnTop() {
		super(Sprites.columnTop);
	}
	
	@Override
	public boolean isSolid(Entity entity) {
		return true;
	}
	
}
