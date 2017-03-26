package me.willjake.hamlet.game;

import me.willjake.hamlet.game.tiles.Chest;
import me.willjake.hamlet.game.tiles.ColumnBottom;
import me.willjake.hamlet.game.tiles.ColumnMid;
import me.willjake.hamlet.game.tiles.ColumnTop;
import me.willjake.hamlet.game.tiles.Grass;
import me.willjake.hamlet.game.tiles.SolidTile;
import me.willjake.hamlet.game.tiles.StoneBrown;
import me.willjake.hamlet.game.tiles.StoneDark;
import me.willjake.hamlet.game.tiles.StoneLight;
import me.willjake.hamlet.game.tiles.ThroneBottom;
import me.willjake.hamlet.game.tiles.ThroneTop;
import me.willjake.hamlet.game.tiles.TiledFloor;
import me.willjake.hamlet.game.tiles.VoidTile;
import me.willjake.hamlet.game.tiles.Water;
import me.willjake.hamlet.game.tiles.Wood;
import me.willjake.hamlet.render.gfx.Sprite;

import java.awt.Color;

/**
 * Created by will on 3/24/17 at 3:01 PM.
 *
 * @author Will "n9Mtq4" Bresnahan
 */
public class Tiles {
	
	public static final VoidTile voidTile = new VoidTile();
	public static final SolidTile SOLID_TILE = new SolidTile(new Sprite(32, Color.BLACK));
	
	public static final Chest CHEST_TILE = new Chest();
	public static final ColumnBottom COLUMN_BOTTOM = new ColumnBottom();
	public static final ColumnMid COLUMN_MID = new ColumnMid();
	public static final ColumnTop COLUMN_TOP = new ColumnTop();
	public static final Grass GRASS = new Grass();
	public static final StoneBrown STONE_BROWN = new StoneBrown();
	public static final StoneDark STONE_DARK = new StoneDark();
	public static final StoneLight STONE_LIGHT = new StoneLight();
	public static final ThroneBottom THRONE_BOTTOM = new ThroneBottom();
	public static final ThroneTop THRONE_TOP = new ThroneTop();
	public static final Water WATER = new Water();
	public static final Wood WOOD = new Wood();
	public static final TiledFloor TILED_FLOOR = new TiledFloor();
	
}
