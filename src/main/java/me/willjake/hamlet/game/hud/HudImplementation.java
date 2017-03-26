package me.willjake.hamlet.game.hud;

import me.willjake.hamlet.hud.Hud;
import me.willjake.hamlet.hud.TextBox;
import me.willjake.hamlet.render.Screen;

import java.awt.Graphics;

/**
 * Created by will on 3/25/17 at 6:41 PM.
 *
 * @author Will "n9Mtq4" Bresnahan
 */
public class HudImplementation extends Hud {
	
	public HudBar insanityBar = new HudBar();
	public TextBox textBox = new TextBox();
	public ChoiceMenu choiceMenu = new ChoiceMenu();
	
	@Override
	public void tick() {
		textBox.tick();
		choiceMenu.tick();
	}
	
	@Override
	public void render(Screen screen) {
		
		insanityBar.render(screen);
		textBox.render(screen);
		choiceMenu.render(screen);
		
	}
	
	@Override
	public void render(Graphics graphics) {
		textBox.render(graphics);
		choiceMenu.render(graphics);
	}
	
}
