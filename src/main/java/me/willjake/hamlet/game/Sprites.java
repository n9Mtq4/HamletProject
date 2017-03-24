package me.willjake.hamlet.game;

import me.willjake.hamlet.render.Screen;
import me.willjake.hamlet.render.gfx.AnimatedSprite;
import me.willjake.hamlet.render.gfx.Sprite;
import me.willjake.hamlet.render.gfx.SpriteSheet;

import java.awt.Color;

/**
 * Created by will on 3/24/17 at 2:38 PM.
 *
 * @author Will "n9Mtq4" Bresnahan
 */
public class Sprites {
	
	public static final SpriteSheet characters = new SpriteSheet("/assets/art/CharacterSheet.png", 512);
	public static final SpriteSheet tiles = new SpriteSheet("/assets/art/TileSheet.png", 512);
	
	public static final Sprite voidTile = new Sprite(Screen.ABS_TILE_SIZE, new Color(215, 215, 215));
	public static final Sprite wallTile = new Sprite(Screen.ABS_TILE_SIZE, new Color(100, 100, 100));
	
	public static final AnimatedSprite ghostForward = getAnimatedSprite(3, 1, 2, 16, characters, 60);
	public static final AnimatedSprite ghostBackward = getAnimatedSprite(3, 4, 5, 16, characters, 60);
	public static final AnimatedSprite ghostLeft = getAnimatedSprite(3, 6, 6, 16, characters, 60);
	
	/**
	 * generates an animated sprite
	 * */
	private static AnimatedSprite getAnimatedSprite(int y, int x1, int x2, int size, SpriteSheet sheet, int framerate) {
		
		Sprite[] frames = new Sprite[Math.abs(x1 - x2)];
		
		for (int x = 0; x + x1 < x2; x++) {
			frames[x] = new Sprite(size, x + x1, y, sheet);
		}
		
		return new AnimatedSprite(frames, size, size, framerate);
		
	}
	
}
