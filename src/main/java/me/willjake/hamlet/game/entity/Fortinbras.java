package me.willjake.hamlet.game.entity;

import me.willjake.hamlet.entity.AnimatedMob;
import me.willjake.hamlet.game.Sprites;

/**
 * Created by will on 3/25/17 at 8:40 PM.
 *
 * @author Will "n9Mtq4" Bresnahan
 */
public class Fortinbras extends AnimatedMob {
	
	public Fortinbras(int x, int y) {
		super(x, y);
		this.backwards = Sprites.fortinbrasForward;
		this.backwardStanding = Sprites.fortinbrasStand;
		doYourBestOnTheRest();
	}
	
}
