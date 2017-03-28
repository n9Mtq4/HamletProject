package me.willjake.hamlet.mainmenu;

import me.willjake.hamlet.render.Display;

/**
 * Created by will on 3/28/17 at 3:09 PM.
 *
 * @author Will "n9Mtq4" Bresnahan
 */
public class ChangeScaleOption extends MenuOption {
	
	private Display display;
	
	public ChangeScaleOption(Display display) {
		super(getText());
		this.display = display;
	}
	
	private static String getText() {
		return "Change scale to " + calcNewScale() + " (Current: " + Display.SCALE + ")";
	}
	
	private static int calcNewScale() {
		switch (Display.SCALE) {
			case 2:
				return 3;
			case 3:
				return 4;
			case 4:
				return 1;
			default:
				return 2; // should never happen
		}
	}
	
	@Override
	public void callback() {
		
		Display.SCALE = calcNewScale();
		display.scaleChange();
		
		setChoiceOption(getText());
		
	}
	
}
