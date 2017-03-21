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

package me.willjake.hamlet.render;

import me.willjake.hamlet.game.Tile;
import me.willjake.hamlet.level.Level;
import me.willjake.hamlet.render.gfx.Sprite;

/**
 * Created by will on 8/21/15 at 9:14 PM.
 */
public class Screen {
	
	public static final int TILE_SIZE = 5; // 2^TILE_SIZE = pixels
	public static final int ABS_TILE_SIZE = 1 << TILE_SIZE;
	private static final int LEVEL_WIDTH = 64; //TODO: change later
	private static final int LEVEL_HEIGHT = 64; //TODO: change later
	
	public int width;
	public int height;
	public int[] pixels;
	public int[] tiles;
	
	public int xOff;
	public int yOff;
	
	public Screen(int width, int height) {
		this.width = width;
		this.height = height;
		this.pixels = new int[width * height];
		this.tiles = new int[LEVEL_WIDTH * LEVEL_HEIGHT];
	}
	
	public void renderSpriteAbs(int xp, int yp, int x1, int y1, Sprite spriteSource, Level level) {
		Sprite sprite = spriteSource.getSpriteForRender();
		for (int y = 0; y < sprite.SIZE; y++) {
			int ya = y + yp;
			for (int x = 0; x < sprite.SIZE; x++) {
				int xa = x + xp;
				if (xa < -sprite.SIZE || xa >= width || ya < 0 || ya >= height) break;
				if (xa < 0) xa = 0;
				int col = sprite.pixels[x + y * sprite.SIZE];
				if (col != Render.TRANSPARENT_COLOR) {
					if (sprite.effectedByLight) {
						double lightValue = level.getLightValue(x1, y1);
						int r = (int) (((col >> 16) & 0xff) * lightValue);
						int g = (int) (((col >> 8) & 0xff) * lightValue);
						int b = (int) (((col) & 0xff) * lightValue);
						pixels[xa + ya * width] = (r << 16) | (g << 8) | b;
					}else {
						pixels[xa + ya * width] = col;
					}
				}
			}
		}
	}
	
	public void renderSpriteRel(int xp, int yp, int x1, int y1, Sprite spriteSource, Level level) {
		Sprite sprite = spriteSource.getSpriteForRender();
		yp -= yOff;
		xp -= xOff;
		for (int y = 0; y < sprite.SIZE; y++) {
			int ya = y + yp;
			for (int x = 0; x < sprite.SIZE; x++) {
				int xa = x + xp;
				if (xa < -sprite.SIZE || xa >= width || ya < 0 || ya >= height) break;
				if (xa < 0) xa = 0;
				int col = sprite.pixels[x + y * sprite.SIZE];
				if (col != Render.TRANSPARENT_COLOR) {
					if (sprite.effectedByLight) {
						double lightValue = level.getLightValue(x1, y1);
						int r = (int) (((col >> 16) & 0xff) * lightValue);
						int g = (int) (((col >> 8) & 0xff) * lightValue);
						int b = (int) (((col) & 0xff) * lightValue);
						pixels[xa + ya * width] = (r << 16) | (g << 8) | b;
					}else {
						pixels[xa + ya * width] = col;
					}
				}
			}
		}
	}
	
	public void renderTile(int xp, int yp, int x1, int y1, Tile tile, Level level) {
		Sprite sprite = tile.getSprite().getSpriteForRender();
		yp -= yOff;
		xp -= xOff;
		for (int y = 0; y < sprite.SIZE; y++) {
			int ya = y + yp;
			for (int x = 0; x < sprite.SIZE; x++) {
				int xa = x + xp;
				if (xa < -sprite.SIZE || xa >= width || ya < 0 || ya >= height) break;
				if (xa < 0) xa = 0;
				int spriteColor = sprite.pixels[x + y * sprite.SIZE];
				if (spriteColor != Render.TRANSPARENT_COLOR) {
					double lightValue = level.getLightValue(x1, y1);
					int r = (int) (((spriteColor >> 16) & 0xff) * lightValue);
					int g = (int) (((spriteColor >> 8) & 0xff) * lightValue);
					int b = (int) (((spriteColor) & 0xff) * lightValue);
					pixels[xa + ya * width] = (r << 16) | (g << 8) | b;
//					pixels[xa + ya * width] = spriteColor;
				}
			}
		}
	}
	
	public void clear() {
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = 0x000000; //black
		}
	}
	
	public void setOffSet(int xOff, int yOff) {
		this.xOff = xOff;
		this.yOff = yOff;
	}
	
}
