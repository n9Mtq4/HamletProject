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

import me.willjake.hamlet.render.Render;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

/**
 * Created by will on 4/17/15.
 */
public class Texture {
	
	/**
	 * Takes a filePath and returns a Render with the pixels
	 *
	 * @param filePath The file location inside the jar
	 * @return a Render with the image
	 */
	private static Render loadBitmap(String filePath) {
		
		try {
			
			BufferedImage image = ImageIO.read(Texture.class.getResource(filePath));
			int width = image.getWidth();
			int height = image.getHeight();
			Render result = new Render(width, height);
			image.getRGB(0, 0, width, height, result.pixels, 0, width); // load the pixels into render
			return result;
			
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}
	
}
