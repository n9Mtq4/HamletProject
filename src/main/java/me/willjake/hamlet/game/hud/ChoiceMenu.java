package me.willjake.hamlet.game.hud;

import me.willjake.hamlet.render.Screen;

import java.awt.Graphics;
import java.util.ArrayList;

/**
 * Created by will on 3/26/17 at 1:19 PM.
 *
 * @author Will "n9Mtq4" Bresnahan
 */
public class ChoiceMenu {

    private ArrayList<ChoiceOption> options;

	public void go(String choiceName) {
        ChoiceParser choiceParser = new ChoiceParser(choiceName);
        this.options = choiceParser.getOptions();
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics graphics) {

	}
	
	public void render(Screen screen) {
		
	}
}
