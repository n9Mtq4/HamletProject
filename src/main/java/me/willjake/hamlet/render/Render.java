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

/**
 * Created by will on 8/21/15 at 9:07 PM.
 */
public class Render {
	
	public static final int TRANSPARENT_COLOR = 0xffff00ff;
	
	public int width;
	public int height;
	public int[] pixels;
	
	public Render(int width, int height) {
		this.width = width;
		this.height = height;
		this.pixels = new int[width * height];
	}
	
	public void draw(Render render, int xOff, int yOff) {
		
		for (int y = 0; y < render.height; y++) {
			int yPx = y + yOff;
			if ((yPx < 0) || (yPx >= height)) continue;
			
			for (int x = 0; x < render.width; x++) {
				int xPx = x + xOff;
				if ((xPx < 0) || (xPx >= width)) continue;
				
				int pixelColor = render.pixels[x + y * render.width];
				if (pixelColor > 0 || pixelColor == TRANSPARENT_COLOR) pixels[xPx + yPx * width] = pixelColor;
				
			}
			
		}
		
	}
	
}
