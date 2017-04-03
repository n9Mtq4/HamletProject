package me.willjake.hamlet.game.level;

import me.willjake.hamlet.entity.Direction;
import me.willjake.hamlet.entity.Player;
import me.willjake.hamlet.game.entity.Claudius;
import me.willjake.hamlet.game.entity.Hamlet;
import me.willjake.hamlet.game.entity.Ophelia;
import me.willjake.hamlet.game.entity.Polonius;
import me.willjake.hamlet.level.Level;
import me.willjake.hamlet.level.Tile;
import me.willjake.hamlet.render.Screen;

/**
 * Created by will on 3/26/17 at 6:35 PM.
 *
 * @author Will "n9Mtq4" Bresnahan
 */
public class OpheliaConfrontationLevel extends Level {

	public OpheliaConfrontationLevel() {
		super("/assets/world/greathall.png", "/assets/world/greathallfront.png");
		
		
		Ophelia ophelia = new Ophelia(7, 7);
        ophelia.dir = Direction.BACKWARDS;

		Hamlet hamlet = new Hamlet(7, 8);

        Claudius claudius = new Claudius(6, 4);
        claudius.dir = Direction.BACKWARDS;

        Polonius polonius = new Polonius(8, 4);
        polonius.dir = Direction.BACKWARDS;

		add(claudius);
		add(ophelia);
		add(hamlet);
		add(polonius);
	}

	@Override
    public Player playerInit(Player player) {
        player.x = 6 * Screen.ABS_TILE_SIZE;
        player.y = 8 * Screen.ABS_TILE_SIZE;
        player.dir = Direction.RIGHT;

        return player;
    }
	
	@Override
	public Tile tileTranslator(int tile) {
		
		return TileTranslator.tileTranslator(tile);
		
	}
	
	
}
