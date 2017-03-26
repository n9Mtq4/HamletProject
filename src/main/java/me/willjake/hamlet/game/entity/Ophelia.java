package me.willjake.hamlet.game.entity;

import me.willjake.hamlet.entity.AnimatedMob;
import me.willjake.hamlet.game.Sprites;

/**
 * Created by will on 3/25/17 at 8:47 PM.
 *
 * @author Will "n9Mtq4" Bresnahan
 */
public class Ophelia extends AnimatedMob {
	
	public Ophelia(int x, int y) {
		
		super(x, y);
		
		this.backwards = Sprites.opheliaForward;
		this.backwardStanding = Sprites.opheliaStand;
		
		doYourBestOnTheRest();
		
	}
	
}
