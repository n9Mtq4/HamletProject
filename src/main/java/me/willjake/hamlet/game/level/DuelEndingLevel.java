package me.willjake.hamlet.game.level;

import me.willjake.hamlet.entity.Direction;
import me.willjake.hamlet.game.entity.*;
import me.willjake.hamlet.level.Level;
import me.willjake.hamlet.level.Tile;

/**
 * Created by will on 3/26/17 at 6:35 PM.
 *
 * @author Will "n9Mtq4" Bresnahan
 */
public class DuelEndingLevel extends Level {
	
	public DuelEndingLevel() {
		super("/assets/world/greathall.png", "/assets/world/greathallfront.png");
		
		Laertes laertes = new Laertes(6, 7);
		laertes.dir = Direction.BACKWARDS;
		
		Claudius claudius = new Claudius(5, 6);
		claudius.dir = Direction.BACKWARDS;
		
		Gertrude gertrude = new Gertrude(7, 6);
		gertrude.dir = Direction.BACKWARDS;
		
		Hamlet hamlet = new Hamlet(6, 9);
		
		Guard guard = new Guard(6, 5);
		
		Fortinbras fortinbras = new Fortinbras(6, 10);

        Ophelia ophelia = new Ophelia(4, 7);
        ophelia.dir = Direction.BACKWARDS;
		
		add(laertes);
		add(claudius);
		add(gertrude);
		add(hamlet);
		add(guard);
		add(fortinbras);
		add(ophelia);
	}
	
	@Override
	public Tile tileTranslator(int tile) {
		return TileTranslator.tileTranslator(tile);
	}
}
