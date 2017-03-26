package me.willjake.hamlet.game.entity;

import me.willjake.hamlet.entity.AnimatedMob;
import me.willjake.hamlet.game.Sprites;

/**
 * Created by will on 3/25/17 at 8:45 PM.
 *
 * @author Will "n9Mtq4" Bresnahan
 */
public class Laertes extends AnimatedMob {
	
	public Laertes(int x, int y) {
		
		super(x, y);
		
		this.backwards = Sprites.laertesForward;
		this.backwardStanding = Sprites.laertesStand;
		
		doYourBestOnTheRest();
		
	}
	
}
