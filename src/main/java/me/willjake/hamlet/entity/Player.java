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

package me.willjake.hamlet.entity;

import me.willjake.hamlet.game.GameState;
import me.willjake.hamlet.input.KeyBoard;

/**
 * Created by will on 8/21/15 at 9:55 PM.
 */
public class Player extends AnimatedMob {
	
	protected int speed = 2;
	
	protected KeyBoard keyBoard;
	
	public Player(int x, int y, KeyBoard keyBoard) {
		super(x, y);
		this.keyBoard = keyBoard;
	}
	
	@Override
	public void tick() {
		super.tick();
		if (display.gameState == GameState.IN_GAME) {
			if (keyBoard.up) move(0, -speed);
			if (keyBoard.down) move(0, speed);
			if (keyBoard.left) move(-speed, 0);
			if (keyBoard.right) move(speed, 0);
		}
	}
	
	public void setSpawn(int x, int y) {
		
		this.x = x;
		this.y = y;
		this.spawnX = x;
		this.spawnY = y;
		
	}
	
}
