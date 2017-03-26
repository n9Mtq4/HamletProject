package me.willjake.hamlet.game.hud;

import me.willjake.hamlet.game.GameState;
import me.willjake.hamlet.render.Display;
import me.willjake.hamlet.render.Screen;

import java.awt.Color;
import java.awt.Font;
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
	
	private static final Font TITLE_FONT = new Font(Font.SANS_SERIF, Font.PLAIN, 14);
	private static final Font NORMAL = new Font(Font.SANS_SERIF, Font.PLAIN, 14);
	private static final Font SELECTED = new Font(Font.SANS_SERIF, Font.BOLD, 14);
	
	private static final int BORDERX = 10;
	
	private Display display;
	private String title;
	private ArrayList<ChoiceOption> options;
	
	private int selectedOption = 0;
	
	public ChoiceMenu(Display display) {
		this.display = display;
	}
	
	public void debug(String title, String... choices) {
		
		this.title = title;
		this.options.clear();
		
		for (String choice : choices) {
			options.add(new ChoiceOption(choice, "cutscene_" + choice));
		}
		
		display.gameState = GameState.CHOICE;
		
	}
	
	public void go(String choiceName) {
		ChoiceParser choiceParser = new ChoiceParser(choiceName);
		this.options = choiceParser.getOptions();
	}
	
	public void fireSelect() {
		// TODO: trigger the next cutscene???
		final ChoiceOption selected = options.get(selectedOption);
	}
	
	public void tick() {
		
		// handles the keyboard inputs for selecting an option
		if (display.gameState == GameState.CHOICE) {
			if (display.keyBoard.select) {
				fireSelect();
			}
			else if (display.keyBoard.up) selectedOption--;
			else if (display.keyBoard.down) selectedOption++;
			selectedOption %= options.size();
		}
		
	}
	
	public void render(Graphics g) {
		
		g.setColor(Color.WHITE);
		
	}
	
	public void render(Screen screen) {
		
	}
	
}
