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

package me.willjake.hamlet.game;

import me.willjake.hamlet.entity.Entity;
import me.willjake.hamlet.entity.Mob;
import me.willjake.hamlet.level.Level;
import me.willjake.hamlet.render.Screen;
import me.willjake.hamlet.render.gfx.Sprite;

import java.awt.Rectangle;

/**
 * Created by will on 8/21/15 at 9:29 PM.
 */
public class Tile {
	
	private final int TILE_SIDE = 10; //px
	
	private int levelX, levelY, realX, realY;
	
	private Rectangle boundingBox;
	private Sprite sprite;
	
	public Tile(int levelX, int levelY, int spritesheetNumber) {
		this.levelX = levelX;
		this.levelY = levelY;
		this.sprite = new Sprite(0, 0, spritesheetNumber); // TODO: we need a singleton containing the spritesheet
		
		this.realX = 0;
		this.realY = 0;
		this.boundingBox = new Rectangle(this.realX, this.realY, this.TILE_SIDE, this.TILE_SIDE);
	}
	
	public int getLevelX() {
		return this.levelX;
	}
	
	public int getLevelY() {
		return this.levelY;
	}
	
	public void render(int x, int y, Screen screen, Level level) {
		screen.renderTile(x << Screen.TILE_SIZE, y << Screen.TILE_SIZE, x, y, this, level);
	}
	
	public boolean mobIntersects(Mob mob) {
		return this.boundingBox.contains(mob.getX(), mob.getY());
	}
	
	public boolean contains(int x, int y) {
		return this.boundingBox.contains(x, y);
	}
	
	public boolean isSolid(Entity entity) {
		return false;
	}
	
	public double getSourceLight() {
		return 0.0d;
	}
	
	public Sprite getSprite() {
		return sprite;
	}
	
}
