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

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by will on 8/21/15 at 9:20 PM.
 */
public class SpriteSheet {
	
	public int size;
	public int width;
	@Deprecated
	public int height;
	public int[] pixels;
	private String path;
	
	public SpriteSheet(String path, int width, int height) {
		this.path = path;
		this.width = width;
		this.height = height;
		this.size = width;
		pixels = new int[width * height];
		load();
	}
	
	public SpriteSheet(String path, int size) {
		this.path = path;
		this.size = size;
		this.width = size;
		pixels = new int[size * size];
		load();
	}
	
	private void load() {
		
		try {
			
			BufferedImage image = ImageIO.read(SpriteSheet.class.getResource(path));
			int w = image.getWidth();
			int h = image.getHeight();
			image.getRGB(0, 0, w, h, pixels, 0, w);
			
		}catch (IOException e) {
			System.err.println("Error reading sprite sheet from " + path);
			e.printStackTrace();
		}
		
	}
	
}
