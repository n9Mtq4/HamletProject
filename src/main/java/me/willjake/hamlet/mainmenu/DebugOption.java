package me.willjake.hamlet.mainmenu;

import me.willjake.hamlet.render.Display;

/**
 * Created by will on 3/28/17 at 4:23 PM.
 *
 * @author Will "n9Mtq4" Bresnahan
 */
public class DebugOption extends MenuOption {
	
	public DebugOption() {
		super(getText());
	}
	
	@Override
	public void callback() {
		Display.DEBUG = !Display.DEBUG;
		setChoiceOption(getText());
	}
	
	private static String getText() {
		return "Turn " + (Display.DEBUG ? "off" : "on") + " debug mode";
	}
	
}
