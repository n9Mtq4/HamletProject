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

import me.willjake.hamlet.render.Screen;

/**
 * Created by will on 8/21/15 at 9:32 PM.
 */
public class Mob extends Entity {
	
	public Direction dir = Direction.FORWARD;
	public boolean moving = false;
	public int movingLife = 0;
	public int spawnX;
	public int spawnY;
	protected int xd;
	protected int yd;
	protected int time;
	private Player player;
	
	public int playX;
	public int playY;
	public boolean isAnimationDone = true;
	private static final int CUTSCENE_SPEED = 1; // TODO: this better only be a 1, delta must be multiple of this, may fix later if issue
	
	public Mob(int x, int y) {
		this.spawnX = x;
		this.spawnY = y;
		this.x = x * Screen.ABS_TILE_SIZE;
		this.y = y * Screen.ABS_TILE_SIZE;
	}
	
	@Override
	public void render(Screen screen) {
		renderSpriteRel(screen, sprite);
	}
	
	public void tick() {
		
		time++;
		level.getTileBack((x) >> Screen.TILE_SIZE, (y) >> Screen.TILE_SIZE).mobIn(this);
		if (isOutSideLevel()) {
			x = spawnX;
			y = spawnY;
		}
		
		if (movingLife > 0) movingLife--;
		else moving = false;
		
		// cut scene playing
		if (playX != 0) {
			if (playX > 0) {
				// positive
				move(CUTSCENE_SPEED, 0);
				playX -= CUTSCENE_SPEED;
			}else {
				// negative
				move(-CUTSCENE_SPEED, 0);
				playX += CUTSCENE_SPEED;
			}
		}
		
		if (playY != 0) {
			if (playY > 0) {
				// positive
				move(0, CUTSCENE_SPEED);
				playY -= CUTSCENE_SPEED;
			}else {
				// negative
				move(0, -CUTSCENE_SPEED);
				playY += CUTSCENE_SPEED;
			}
		}
		
		if (playX == 0 && playY == 0) isAnimationDone = true;
		
	}
	
	protected boolean isOutSideLevel() {
		return (x < 0 || y < 0 || x > (level.getWidth() << Screen.TILE_SIZE) || y > (level.getHeight() << Screen.TILE_SIZE));
	}
	
	/**
	 * Sticks the movement on
	 * */
	public void cutsceneMove(int xd, int yd) {
		// TODO: play animation out
		
		if (playX != 0 || playY != 0) System.err.println("Overwriting movement animation! " + this.getClass().getName());
		
		playX = xd;
		playY = yd;
		isAnimationDone = false;
		
	}
	
	public void move(int xd, int yd) {
		
		if (xd != 0 && yd != 0) {
			move(0, yd);
			move(xd, 0);
			return;
		}
		
		moving = true;
		movingLife = 20;
		if (xd > 0) dir = Direction.RIGHT;
		if (xd < 0) dir = Direction.LEFT;
		if (yd > 0) dir = Direction.BACKWARDS;
		if (yd < 0) dir = Direction.FORWARD;
		
		if (!collision(xd, yd)) {
			x += xd;
			y += yd;
		}
		
	}
	
	public boolean collision(int xd, int yd) {
		
		for (int c = 0; c < 4; c++) {
			int xt = ((x + xd) + c % 2 * (Screen.TILE_SIZE * 5)) >> Screen.TILE_SIZE;
			int yt = ((y + yd) + c / 2 * (Screen.TILE_SIZE * 5)) >> Screen.TILE_SIZE;
			if (level.getTileBack(xt, yt).isSolid(this)) return true;
		}
		
		return false;
		
	}
	
	protected int getDistance(Entity e1, Entity e2) {
		return getDistance(e1.x / Screen.ABS_TILE_SIZE, e1.y / Screen.ABS_TILE_SIZE, e2.x / Screen.ABS_TILE_SIZE, e2.y / Screen.ABS_TILE_SIZE);
	}
	
	protected int getDistance(int x1, int y1, int x2, int y2) {
		return (int) Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
	}
	
}
