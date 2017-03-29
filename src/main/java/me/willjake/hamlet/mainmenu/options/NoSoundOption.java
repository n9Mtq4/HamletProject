package me.willjake.hamlet.mainmenu.options;

import me.willjake.hamlet.mainmenu.MenuOption;
import me.willjake.hamlet.render.Display;

/**
 * Created by will on 3/28/17 at 9:29 PM.
 *
 * @author Will "n9Mtq4" Bresnahan
 */
public class NoSoundOption extends MenuOption {
	
	private Display display;
	
	public NoSoundOption(Display display) {
		super(getText());
		this.display = display;
	}
	
	@Override
	public void callback() {
		
		Display.playSound = !Display.playSound;
		
		if (Display.playSound) display.menu.startMusic();
		else display.menu.stopMusic();
		
		setChoiceOption(getText());
		
	}
	
	private static String getText() {
		return "Turn " + (Display.playSound ? "off" : "on") + " sound";
	}
	
}
