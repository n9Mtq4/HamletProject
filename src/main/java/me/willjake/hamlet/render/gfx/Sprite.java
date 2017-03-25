package me.willjake.hamlet.render.gfx;

import java.awt.Color;
import java.awt.image.BufferedImage;

/**
 * Created by will on 3/21/17 at 2:42 PM.
 *
 * @author Will "n9Mtq4" Bresnahan
 */
public class Sprite {
	
	public final int SIZE;
	public final int SIZE_MASK;
	public int x;
	public int y;
	public int width;
	public int height;
	public int[] pixels;
	public boolean effectedByLight = true;
	private SpriteSheet sheet;
	
	public Sprite(int size, Color color) {
		this.SIZE = size;
		this.SIZE_MASK = SIZE - 1;
		this.width = SIZE;
		this.height = SIZE;
		pixels = new int[width * height];
		setColor(color.getRGB());
	}
	
	public Sprite(int width, int height) {
		this.SIZE = width;
		this.SIZE_MASK = SIZE - 1;
		this.width = width;
		this.height = height;
		pixels = new int[width * height];
	}
	
	public Sprite(int size, int x, int y, SpriteSheet sheet) {
		this.SIZE = size;
		this.SIZE_MASK = SIZE - 1;
		this.width = SIZE;
		this.height = SIZE;
		this.x = x * SIZE;
		this.y = y * SIZE;
		this.sheet = sheet;
		pixels = new int[width * height];
		load();
	}
	
	private void load() {
		
		for (int y = 0; y < SIZE; y++) {
			for (int x = 0; x < SIZE; x++) {
				pixels[x + y * SIZE] = sheet.pixels[(x + this.x) + (y + this.y) * sheet.width];
			}
		}
		
	}
	
	public void flipY() {
		// http://stackoverflow.com/a/36189912/5196460
		int[] newPixels = new int[pixels.length];
		for (int i = 0; i < pixels.length; i++) {
			newPixels[i] = pixels[i - 2 * (i % width) + width - 1];
		}
		pixels = newPixels;
	}
	
	private void setColor(int color) {
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = color;
		}
	}
	
	public BufferedImage toBufferedImage() {
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_4BYTE_ABGR);
		image.setRGB(0, 0, width, height, pixels, 0, width);
		return image;
	}
	
	public void tick() {
		
	}
	
	public Sprite getSpriteForRender() {
		return this;
	}
	
	public Sprite clone() {
		final Sprite sprite = new Sprite(SIZE, SIZE);
		for (int i = 0; i < pixels.length; i++) {
			sprite.pixels[i] = pixels[i];
		}
		return sprite;
	}
	
}
