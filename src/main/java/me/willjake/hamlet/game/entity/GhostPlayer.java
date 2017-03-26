package me.willjake.hamlet.game.entity;

import me.willjake.hamlet.entity.Player;
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
		this.forward = Sprites.ghostBackward;
		this.backwards = Sprites.ghostForward;
		this.left = Sprites.ghostLeft;
		this.right = Sprites.ghostLeft.clone();
		this.right.flipY();
		this.forwardStanding = Sprites.ghostBackwardStand;
		this.backwardStanding = Sprites.ghostForwardStand;
		this.leftStanding = Sprites.ghostLeftStand;
		this.rightStanding = Sprites.ghostLeftStand.clone();
		this.rightStanding.flipY();
	}
	
	@Override
	public void tick() {
		super.tick();
	}
	
}
