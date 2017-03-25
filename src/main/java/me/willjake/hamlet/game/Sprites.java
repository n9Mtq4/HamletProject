package me.willjake.hamlet.game;

import me.willjake.hamlet.render.Screen;
import me.willjake.hamlet.render.gfx.AnimatedSprite;
import me.willjake.hamlet.render.gfx.NoLightSprite;
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
	public static final SpriteSheet hud = new SpriteSheet("/assets/art/hud.png", 32);
	
	public static final Sprite voidTile = new Sprite(Screen.ABS_TILE_SIZE, new Color(215, 215, 215));
	public static final Sprite wallTile = new Sprite(Screen.ABS_TILE_SIZE, new Color(100, 100, 100));
	
	public static final AnimatedSprite kingForward = getAnimatedSprite(0, 1, 3, 16, characters, 60);
	public static final AnimatedSprite kingBackward = getAnimatedSprite(0, 4, 6, 16, characters, 60);
	
	// TODO: implement a standing vs walking in the player / animated sprite class
	public static final Sprite ghostForwardStand = new Sprite(16, 0, 3, characters).upscale(2);
	public static final Sprite ghostBackwardStand = new Sprite(16, 3, 3, characters).upscale(2);
	public static final Sprite ghostLeftStand = new Sprite(16, 6, 3, characters).upscale(2);
	public static final AnimatedSprite ghostForward = getAnimatedSprite(3, 1, 3, 16, characters, 60);
	public static final AnimatedSprite ghostBackward = getAnimatedSprite(3, 4, 6, 16, characters, 60);
	public static final AnimatedSprite ghostLeft = getAnimatedSprite(3, 6, 8, 16, characters, 60);
	
	public static final Sprite guard = new Sprite(16, 6, 0, characters);
	
	public static final Sprite stoneLight = new Sprite(32, 0, 0, tiles);
	public static final Sprite stoneDark = new Sprite(32, 1, 0, tiles);
	public static final Sprite columnTop = new Sprite(32, 2, 0, tiles);
	public static final Sprite columnMid = new Sprite(32, 2, 1, tiles);
	public static final Sprite columnBottom = new Sprite(32, 2, 2, tiles);
	public static final Sprite water = new Sprite(32, 3, 0, tiles);
	public static final Sprite tree0 = new Sprite(32, 4, 0, tiles);
	public static final Sprite tree1 = new Sprite(32, 5, 0, tiles);
	public static final Sprite tree2 = new Sprite(32, 4, 1, tiles);
	public static final Sprite tree3 = new Sprite(32, 5, 1, tiles);
	public static final Sprite tree4 = new Sprite(32, 4, 2, tiles);
	public static final Sprite tree5 = new Sprite(32, 5, 2, tiles);
	public static final Sprite torch = new Sprite(32, 0, 1, tiles);
	public static final Sprite chest = new Sprite(32, 1, 1, tiles);
	public static final Sprite throneTop = new Sprite(32, 3, 1, tiles);
	public static final Sprite throneBottom = new Sprite(32, 3, 2, tiles);
	public static final Sprite stoneBrown = new Sprite(32, 1, 2, tiles);
	public static final Sprite grass = new Sprite(32, 1, 3, tiles);
	public static final Sprite wood = new Sprite(32, 2, 3, tiles);
	public static final Sprite emblem = new Sprite(32, 0, 4, tiles);
	// TODO: still don't have off center emblem, may not need it though
	
	public static final Sprite hudbarStartFull = new NoLightSprite(8, 0, 0, hud);
	public static final Sprite hudbarMidFull = new NoLightSprite(8, 1, 0, hud);
	public static final Sprite hudbarEndFull = new NoLightSprite(8, 2, 0, hud);
	public static final Sprite hudbarStartEmpty = new NoLightSprite(8, 0, 1, hud);
	public static final Sprite hudbarMidEmpty = new NoLightSprite(8, 1, 1, hud);
	public static final Sprite hudbarEndEmpty = new NoLightSprite(8, 2, 1, hud);
	
	/**
	 * generates an animated sprite
	 * */
	private static AnimatedSprite getAnimatedSprite(int y, int x1, int x2, int size, SpriteSheet sheet, int framerate) {
		
		Sprite[] frames = new Sprite[Math.abs(x1 - x2)];
		
		for (int x = 0; x + x1 < x2; x++) {
			frames[x] = new Sprite(size, x + x1, y, sheet).upscale(2);
		}
		
		return new AnimatedSprite(frames, size, size, framerate);
		
	}
	
}
