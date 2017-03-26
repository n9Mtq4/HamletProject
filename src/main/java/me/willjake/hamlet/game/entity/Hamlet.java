package me.willjake.hamlet.game.entity;

import me.willjake.hamlet.entity.AnimatedMob;
import me.willjake.hamlet.game.Sprites;

/**
 * Created by will on 3/25/17 at 8:42 PM.
 *
 * @author Will "n9Mtq4" Bresnahan
 */
public class Hamlet extends AnimatedMob {
	
	public Hamlet(int x, int y) {
		
		super(x, y);
		
		this.backwards = Sprites.hamletForward;
		this.forward = Sprites.hamletBackward;
		this.left = Sprites.hamletLeft;
		this.backwardStanding = Sprites.hamletForwardStand;
		this.forwardStanding = Sprites.hamletBackwardStand;
		this.leftStanding = Sprites.hamletLeftStand;
		
		doYourBestOnTheRest();
		
	}
	
}
