package me.willjake.hamlet.game.entity;

import me.willjake.hamlet.entity.Mob;
import me.willjake.hamlet.game.Sprites;

/**
 * Created by will on 3/25/17 at 8:46 PM.
 *
 * @author Will "n9Mtq4" Bresnahan
 */
public class Guard extends Mob {
	
	public Guard(int x, int y) {
		
		super(x, y);
		
		this.sprite = Sprites.guard;
		
	}
	
}
