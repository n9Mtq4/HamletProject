package me.willjake.hamlet.game.hud;

import me.willjake.hamlet.hud.Hud;
import me.willjake.hamlet.render.Screen;

/**
 * Created by will on 3/25/17 at 6:41 PM.
 *
 * @author Will "n9Mtq4" Bresnahan
 */
public class HudImplementation extends Hud {
	
	private HudBar insanityBar = new HudBar();
	
	@Override
	public void tick() {
		
	}
	
	@Override
	public void render(Screen screen) {
		
		insanityBar.render(screen);
		
	}
	
}
