package me.willjake.hamlet.mainmenu.options;

import me.willjake.hamlet.mainmenu.MenuOption;
import me.willjake.hamlet.render.Display;

/**
 * Created by will on 3/28/17 at 3:07 PM.
 *
 * @author Will "n9Mtq4" Bresnahan
 */
public class PlayOption extends MenuOption {
	
	private Display display;
	
	public PlayOption(Display display) {
		super("Play");
		this.display = display;
	}
	
	@Override
	public void callback() {
		
		display.menu.stopMusic();
		display.startTheGame();
		
	}
	
}
