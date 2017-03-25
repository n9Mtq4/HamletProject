package me.willjake.hamlet.level;

import me.willjake.hamlet.entity.Entity;
import me.willjake.hamlet.entity.Player;
import me.willjake.hamlet.game.Tiles;
import me.willjake.hamlet.render.Display;
import me.willjake.hamlet.render.Screen;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * Created by jakekinsella on 3/21/17.
 */
public class Level {
	
	private int width;
	private int height;
	public Display display;
	
	private int[] tileMapBack = new int[width * height];
	private int[] tileMapFront = new int[width * height];
	
	private String tileMapBackFile;
	private String tileMapFrontFile;
	
	private ArrayList<Entity> entities = new ArrayList<Entity>();
	
	public Level(String tileMapBack, String tileMapFront) {
		this.tileMapBackFile = tileMapBack;
		this.tileMapFrontFile = tileMapFront;
	}
	
	
	public void tick() {
		for (int i = 0; i < entities.size(); i++) {
			entities.get(i).tick();
		}
	}
	
	/**
	 * renders everything
	 * */
	public void render(int xScroll, int yScroll, Screen screen) {
		screen.setOffSet(xScroll, yScroll);
		int x0 = xScroll >> Screen.TILE_SIZE;
		int x1 = (xScroll + screen.width + (1 << Screen.TILE_SIZE)) >> Screen.TILE_SIZE;
		int y0 = yScroll >> Screen.TILE_SIZE;
		int y1 = (yScroll + screen.height + (1 << Screen.TILE_SIZE)) >> Screen.TILE_SIZE;
		
		for (int y = y0; y < y1; y++) {
			for (int x = x0; x < x1; x++) {
				getTileBack(x, y).render(x, y, screen, this);
			}
		}
		for (int i = 0; i < entities.size(); i++) {
			entities.get(i).render(screen);
		}
	}
	
	public boolean tileCollision(double x, double y, double xd, double yd, int sizex, int sizey, int xOff, int yOff, Entity entity) {
		
		for (int c = 0; c < 4; c++) {
			int xt = (((int) x + (int) xd) + c % 2 * sizex + xOff) / Screen.ABS_TILE_SIZE;
			int yt = (((int) y + (int) yd) + c / 2 * sizey + yOff) / Screen.ABS_TILE_SIZE;
			if (this.getTileBack(xt, yt).isSolid(entity)) return true;
		}
		
		return false;
		
	}
	
	public Player getPlayer() {
		
		for (int i = 0; i < entities.size(); i++) {
			if (entities.get(i) instanceof Player) return (Player) entities.get(i);
		}
//		i hope this never gets reached
		return null;
		
	}
	
	public Tile getTileBack(int x, int y) {
		
		if (checkTileBounds(x, y)) return Tiles.voidTile;
		
		return tileTranslator(tileMapBack[y * width + x]);
		
	}
	
	public Tile getTileFront(int x, int y) {
		
		if (checkTileBounds(x, y)) return Tiles.voidTile;
		
		return tileTranslator(tileMapFront[y * width + x]);
		
	}
	
	public void add(Entity entity) {
		entities.add(entity);
		entity.init(this, display);
	}
	
	public Tile tileTranslator(int tile) {
		return Tiles.voidTile;
	}
	
	public double getLightValue(int x, int y) {
		// TODO: Lets avoid light for now
		return 1.0D;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public void load() {
		loadLevel(tileMapBackFile, tileMapFrontFile);
	}
	
	public void loadLevel(String pathBack, String pathFront) {
		
		try {
			
			BufferedImage i = ImageIO.read(Level.class.getResource(pathBack));
			BufferedImage i1 = ImageIO.read(Level.class.getResource(pathFront));
			// TODO: just assume they are the same size
			this.width = i.getWidth();
			this.height = i.getHeight();
			tileMapBack = new int[width * height];
			tileMapFront = new int[width * height];
//			lightMap = new double[width * height];
			i.getRGB(0, 0, width, height, tileMapBack, 0, width);
			i1.getRGB(0, 0, width, height, tileMapFront, 0, width);
//			generateLightMap();
//			spawnMobs();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public boolean checkTileBounds(int x, int y) {
		return x < 0 || y < 0 || x >= width || y >= height;
	}
	
}
