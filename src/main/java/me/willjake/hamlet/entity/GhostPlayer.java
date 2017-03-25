package me.willjake.hamlet.entity;

import me.willjake.hamlet.game.Sprites;
import me.willjake.hamlet.input.KeyBoard;

/**
 * Created by will on 3/24/17 at 3:08 PM.
 *
 * @author Will "n9Mtq4" Bresnahan
 */
public class GhostPlayer extends Player {
	
	public GhostPlayer(int x, int y, KeyBoard keyBoard) {
		super(x, y, keyBoard);
		this.forward = Sprites.ghostForward;
		this.backwards = Sprites.ghostBackward;
		this.left = Sprites.ghostLeft;
		this.right = Sprites.ghostLeft; // TODO: flip this 
//		this.right = Sprites.ghostLeft.clone();
//		this.right.flipY();
	}
	
	@Override
	public void tick() {
		super.tick();
	}
	
}
