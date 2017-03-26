package me.willjake.hamlet.game.hud;

import me.willjake.hamlet.game.GameState;
import me.willjake.hamlet.render.Display;
import me.willjake.hamlet.render.Screen;

import java.awt.Graphics;
import java.util.ArrayList;

/**
 * Created by will on 3/26/17 at 1:19 PM.
 * 
 * renders on the bottom of the screen
 * uses up and down to select
 * 
 * @author Will "n9Mtq4" Bresnahan
 */
public class ChoiceMenu {
	
	private Display display;
	private ArrayList<ChoiceOption> options;
	
	private int selectedOption = 0;
	private String choicePrompt;
	
	public ChoiceMenu(Display display) {
		this.display = display;
	}
	
	public void debug(String title, String... choices) {
		
	}
	
	public void go(String choiceName) {
		ChoiceParser choiceParser = new ChoiceParser(choiceName);
		this.choicePrompt = choiceParser.getChoicePrompt();
		this.options = choiceParser.getOptions();

		System.out.println(choicePrompt);
	}
	
	public void tick() {
		
		// handles the keyboard inputs for selecting an option
		if (display.gameState == GameState.CHOICE) {
			if (display.keyBoard.up) selectedOption--;
			else if (display.keyBoard.down) selectedOption++;
			selectedOption %= options.size();
		}
		
	}
	
	public void render(Graphics graphics) {
		
		
		
	}
	
	public void render(Screen screen) {
		
	}
	
}
