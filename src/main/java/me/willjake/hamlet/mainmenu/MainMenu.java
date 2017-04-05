package me.willjake.hamlet.mainmenu;

import me.willjake.hamlet.mainmenu.options.ChangeScaleOption;
import me.willjake.hamlet.mainmenu.options.DebugOption;
import me.willjake.hamlet.mainmenu.options.NoSoundOption;
import me.willjake.hamlet.mainmenu.options.PlayOption;
import me.willjake.hamlet.render.Display;

import javax.sound.sampled.Clip;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.font.FontRenderContext;
import java.util.ArrayList;

/**
 * Created by will on 3/28/17 at 2:47 PM.
 *
 * @author Will "n9Mtq4" Bresnahan
 */
public class MainMenu {
	
	public static final String GAME_TITLE = "The Ghost Inside";
	
	public static final int TITLE_Y = 50;
	
	public static final int CHOICE_YOFFSET = 120;
	public static final int FONT_SPACING = 30;
	
	public static final Font TITLE_FONT = new Font(Font.SANS_SERIF, Font.BOLD, 50);
	public static final Font OPTION_FONT = new Font(Font.SANS_SERIF, Font.PLAIN, 24);
	public static final Font SELECTED_OPTION_FONT = new Font(Font.SANS_SERIF, Font.BOLD, 24);
	
	public ArrayList<MenuOption> menuOptions = new ArrayList<MenuOption>();
	public int selectedOption = 0;
	
	private Display display;
	
	private Clip music;
	private boolean musicPlaying = false;
	
	public MainMenu(Display display) {
		this.display = display;
		
		menuOptions.add(new PlayOption(display));
		menuOptions.add(new ChangeScaleOption(display));
		menuOptions.add(new NoSoundOption(display));
		menuOptions.add(new DebugOption());
		
		display.addSound("mainmenu");
		startMusic();
		
	}
	
	public void startMusic() {
		if (musicPlaying) return;
		musicPlaying = true;
		music = display.playSound("mainmenu");
		display.music = music;
		music.loop(Clip.LOOP_CONTINUOUSLY);
	}
	
	public void stopMusic() {
		if (!musicPlaying) return;
		musicPlaying = false;
		music.stop();
	}
	
	public void upArrow() {
		selectedOption--;
		if (selectedOption <= -1) selectedOption = menuOptions.size() - 1;
		selectedOption %= menuOptions.size();
	}
	
	public void downArrow() {
		selectedOption++;
		if (selectedOption <= -1) selectedOption = menuOptions.size() - 1;
		selectedOption %= menuOptions.size();
	}
	
	public void select() {
		menuOptions.get(selectedOption).callback();
	}
	
	public void render(final Graphics g) {
		
		final Color backupColor = g.getColor();
		
		g.setColor(Color.BLACK);
		
		final FontRenderContext fontRenderContext = ((Graphics2D) g).getFontRenderContext();
		
		g.setFont(TITLE_FONT);
		g.drawString(GAME_TITLE, calcCenter(GAME_TITLE, TITLE_FONT, fontRenderContext), TITLE_Y);
		
		for (int i = 0; i < menuOptions.size(); i++) {
			
			final MenuOption menuOption = menuOptions.get(i);
			final String text = menuOption.getChoiceOption();
			
			if (selectedOption == i) g.setFont(SELECTED_OPTION_FONT);
			else g.setFont(OPTION_FONT);
			
			g.drawString(text, calcCenter(text, g.getFont(), fontRenderContext), FONT_SPACING * i + CHOICE_YOFFSET);
			
			
		}
		
		g.setColor(backupColor);
		
	}
	
	private int calcCenter(String text, Font font, FontRenderContext fontRenderContext) {
		
		final int width = (int) font.createGlyphVector(fontRenderContext, text).getVisualBounds().getWidth();
		final int centerPos = Display.WIDTH * Display.SCALE;
		
		return (centerPos - width) / 2;
		
	}
	
}
