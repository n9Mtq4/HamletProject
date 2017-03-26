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

package me.willjake.hamlet.hud;

import me.willjake.hamlet.render.Display;
import me.willjake.hamlet.render.Screen;

import java.awt.Graphics;

/**
 * Created by will on 8/21/15 at 9:55 PM.
 */
public class Hud {
	
	protected Display display;
	
	public Hud(Display display) {
		this.display = display;
	}
	
	public void tick() {
	}
	
	public void render(Screen screen) {
	}
	
	public void render(Graphics graphics) {
		
	}
	
}
