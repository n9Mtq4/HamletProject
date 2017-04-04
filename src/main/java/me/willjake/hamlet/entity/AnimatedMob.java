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
import me.willjake.hamlet.render.gfx.AnimatedSprite;
import me.willjake.hamlet.render.gfx.Sprite;

/**
 * Created by will on 8/22/15 at 4:16 PM.
 */
public class AnimatedMob extends Mob {
	
	public AnimatedSprite forward;
	public AnimatedSprite backwards;
	public AnimatedSprite left;
	public AnimatedSprite right;
	public Sprite forwardStanding;
	public Sprite backwardStanding;
	public Sprite leftStanding;
	public Sprite rightStanding;
	
	public AnimatedMob(int x, int y) {
		super(x, y);
	}
	
	@Override
	public void render(Screen screen) {

		if (this.hidden) return;

		try {
			if (!moving) {
				
				if (Direction.FORWARD.equals(dir)) {
					renderSpriteRel(screen, forwardStanding);
				}else if (Direction.RIGHT.equals(dir)) {
					renderSpriteRel(screen, rightStanding);
				}else if (Direction.BACKWARDS.equals(dir)) {
					renderSpriteRel(screen, backwardStanding);
				}else if (Direction.LEFT.equals(dir)) {
					renderSpriteRel(screen, leftStanding);
				}
				
			}else {
				if (Direction.FORWARD.equals(dir)) {
					renderSpriteRel(screen, forward);
				}else if (Direction.RIGHT.equals(dir)) {
					renderSpriteRel(screen, right);
				}else if (Direction.BACKWARDS.equals(dir)) {
					renderSpriteRel(screen, backwards);
				}else if (Direction.LEFT.equals(dir)) {
					renderSpriteRel(screen, left);
				}
			}
		}catch (NullPointerException e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void tick() {
		super.tick();
		if (!moving) return;
		forward.tick();
		backwards.tick();
		left.tick();
		right.tick();
	}
	
	public void doYourBestOnTheRest() {
		
		if (right == null && left != null) {
			right = left.clone();
			right.flipY();
		}
		
		if (left == null && right != null) {
			left = right.clone();
			left.flipY();
		}
		
		if (forward == null && backwards != null) {
			forward = backwards;
		}
		
		if (backwards == null && forward != null) {
			backwards = forward;
		}
		
		if (left == null && right == null && backwards != null) {
			left = backwards;
			right = backwards;
		}
		
		if (forwardStanding == null) {
			forwardStanding = forward;
		}
		
		if (backwardStanding == null) {
			backwardStanding = backwards;
		}
		
		if (leftStanding == null && rightStanding == null) {
			leftStanding = backwardStanding;
		}
		
		if (rightStanding == null && leftStanding != null) {
			rightStanding = leftStanding.clone();
			rightStanding.flipY();
		}
		
		if (leftStanding == null && rightStanding != null) {
			leftStanding = rightStanding.clone();
			leftStanding.flipY();
		}
		
	}
	
}
