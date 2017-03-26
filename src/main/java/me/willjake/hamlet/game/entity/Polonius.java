package me.willjake.hamlet.game.entity;

import me.willjake.hamlet.entity.AnimatedMob;
import me.willjake.hamlet.game.Sprites;

/**
 * Created by will on 3/25/17 at 8:49 PM.
 *
 * @author Will "n9Mtq4" Bresnahan
 */
public class Polonius extends AnimatedMob {
	
	public Polonius(int x, int y) {
		
		super(x, y);
		
		this.backwards = Sprites.poloniusWalk;
		this.backwardStanding = Sprites.poloniusStand;
		
		doYourBestOnTheRest();
		
	}
	
}
