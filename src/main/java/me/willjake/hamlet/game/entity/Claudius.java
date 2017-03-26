package me.willjake.hamlet.game.entity;

import me.willjake.hamlet.entity.AnimatedMob;
import me.willjake.hamlet.game.Sprites;

/**
 * Created by will on 3/25/17 at 8:02 PM.
 *
 * @author Will "n9Mtq4" Bresnahan
 */
public class Claudius extends AnimatedMob {
	
	public Claudius(int x, int y) {
		
		super(x, y);
		
		this.forward = Sprites.kingForward;
		this.backwards = Sprites.kingBackward;
		this.left = Sprites.kingForward;
		this.right = Sprites.kingForward;
		
	}
	
}
