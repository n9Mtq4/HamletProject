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

package me.willjake.hamlet.input;

import me.willjake.hamlet.render.Display;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by will on 8/21/15 at 11:12 PM.
 */
public class KeyBoard implements KeyListener {
	
	public boolean up, down, left, right, ability, change;
	private boolean[] keys = new boolean[180]; // 128 keys
	private Display display;
	
	public KeyBoard(Display display) {
		this.display = display;
	}
	
	public boolean hasKeyBeenPressed(int keyCode) {
		return keys[keyCode];
	}
	
	public void update() {
		
		up = keys[KeyEvent.VK_UP] || keys[KeyEvent.VK_W];
		down = keys[KeyEvent.VK_DOWN] || keys[KeyEvent.VK_S];
		left = keys[KeyEvent.VK_LEFT] || keys[KeyEvent.VK_A];
		right = keys[KeyEvent.VK_RIGHT] || keys[KeyEvent.VK_D];
		
//		TODO: add keys in here
		
	}
	
	@Override
	public void keyTyped(KeyEvent keyEvent) {
	}
	
	@Override
	public void keyPressed(KeyEvent keyEvent) {
		display.keyPress(keyEvent);
		keys[keyEvent.getKeyCode()] = true;
	}
	
	@Override
	public void keyReleased(KeyEvent keyEvent) {
		keys[keyEvent.getKeyCode()] = false;
	}
	
}
