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

package me.willjake.hamlet.render.gfx;

import java.awt.Color;

/**
 * Created by will on 8/23/15 at 2:29 AM.
 */
public class NoLightSprite extends Sprite {
	
	public NoLightSprite(int size, Color color) {
		super(size, color);
		effectedByLight = false;
	}
	
	public NoLightSprite(int width, int height) {
		super(width, height);
		effectedByLight = false;
	}
	
	public NoLightSprite(int size, int x, int y, SpriteSheet sheet) {
		super(size, x, y, sheet);
		effectedByLight = false;
	}
	
}
