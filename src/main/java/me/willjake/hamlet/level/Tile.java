/*
 * NOTE: This is added by intellij IDE. Disregard this copyright if there is another copyright later in the file.
 * Copyright (C) 2015  Will (n9Mtq4) Bresnahan
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package me.willjake.hamlet.level;

import me.willjake.hamlet.entity.Entity;
import me.willjake.hamlet.entity.Mob;
import me.willjake.hamlet.render.Screen;
import me.willjake.hamlet.render.gfx.Sprite;

/**
 * Created by will on 8/21/15 at 9:29 PM.
 */
public class Tile {
	
//	public int x;
//	public int y;
	
	private boolean solid = false;
	public Sprite sprite;
	
	public Tile(Sprite sprite) {
		this.sprite = sprite;
	}
	
	public void render(int x, int y, Screen screen, Level level) {
		screen.renderTile(x << Screen.TILE_SIZE, y << Screen.TILE_SIZE, x, y, this, level);
	}
	
	public Entity newSpawn(int x, int y) {
		return null;
	}
	
	public void mobIn(Mob mob) {
		
	}
	
	public boolean isSolid(Entity entity) {
		return solid;
	}
	
	public double getSourceLight() {
		return 0.0d;
	}
	
	public Tile solid() {
		solid = true;
		return this;
	}
	
}
