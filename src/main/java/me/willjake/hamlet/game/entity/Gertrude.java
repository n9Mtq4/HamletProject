package me.willjake.hamlet.game.entity;

import me.willjake.hamlet.entity.AnimatedMob;
import me.willjake.hamlet.game.Sprites;

/**
 * Created by will on 3/25/17 at 8:42 PM.
 *
 * @author Will "n9Mtq4" Bresnahan
 */
public class Gertrude extends AnimatedMob {
	
	public Gertrude(int x, int y) {
		super(x, y);
		this.backwards = Sprites.gertrudeForward;
		this.backwardStanding = Sprites.gertrudeStand;
		doYourBestOnTheRest();
	}
	
}
