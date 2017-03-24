package me.willjake.hamlet.entity;

import me.willjake.hamlet.game.Sprites;
import me.willjake.hamlet.input.KeyBoard;

/**
 * Created by will on 3/24/17 at 3:08 PM.
 *
 * @author Will "n9Mtq4" Bresnahan
 */
public class GhostPlayer extends Player {
	
	private static final int SPEED_MULTIPLE = 2;
	
	public GhostPlayer(int x, int y, KeyBoard keyBoard) {
		super(x, y, keyBoard);
		this.forward = Sprites.ghostForward;
		this.backwards = Sprites.ghostBackward;
		this.left = Sprites.ghostLeft;
		this.right = Sprites.ghostLeft.clone();
		this.right.flipY();
	}
	
}
