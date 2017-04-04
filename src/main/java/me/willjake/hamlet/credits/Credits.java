package me.willjake.hamlet.credits;

import me.willjake.hamlet.render.Display;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.font.FontRenderContext;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by will on 4/2/17 at 11:46 PM.
 *
 * @author Will "n9Mtq4" Bresnahan
 */
public class Credits {
	
	// only for 253 seconds or 15180 ticks
	private static final int TICK_LIMIT = 15180;
	
	private static final Font MAIN_FONT = new Font(Font.SANS_SERIF, Font.BOLD, 40);
	private static final int FONT_MULTI = 60;
	private static final double SPEED = 2.0; // bigger = slower
	
	private Display display;
	private int time = 0;
	
	private boolean done = false;
	private boolean textDone = false;
	private String[] texts;
	private int doneAt;
	private boolean initGource = true;
	
	public Credits(Display display) {
		this.display = display;
	}
	
	public void init() {
		try {
			texts = loadText();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void tick() {
		
		// stuff here
		
		if (textDone && initGource) {
			display.launcher.showGource();
			initGource = false;
		}
		
		if (!done) time++;
		
		if (time >= TICK_LIMIT) System.out.println("Warning: Credits is past the desired length of end scene");
		
	}
	
	public void render(Graphics g) {
		
		final Color backupColor = g.getColor();
		
		final FontRenderContext fontRenderContext = ((Graphics2D) g).getFontRenderContext();
		
		final int height = Display.HEIGHT * Display.SCALE;
		final int offSet = (int) ((height) - (time / SPEED));
		
		g.setFont(MAIN_FONT);
		
		
		boolean atLeastOnce = false;
		for (int i = 0; i < texts.length; i++) {
			
			final String text = texts[i];
			final int yPos = i * FONT_MULTI + offSet;
			
			if (yPos < 0 || yPos > height + 40) continue; // constant is font height. too small cuts text early
			atLeastOnce = true;
			
			// render the font
			
			g.drawString(text, calcCenter(text, g.getFont(), fontRenderContext), yPos);
			
		}
		
		if (!atLeastOnce) textDone = true;
		
		g.setColor(backupColor);
		
	}
	
	private static String[] loadText() throws IOException {
		
		ArrayList<String> lines = new ArrayList<String>();
		
		InputStream inputStream = Credits.class.getResourceAsStream("/assets/credits/credits.txt");
		InputStreamReader isr = new InputStreamReader(inputStream);
		BufferedReader br = new BufferedReader(isr);
		
		String line = br.readLine();
		while (line != null) {
			lines.add(line);
			line = br.readLine();
		}
		
		String[] strArray = new String[lines.size()];
		lines.toArray(strArray);
		return strArray;
		
	}
	
	private static int calcCenter(String text, Font font, FontRenderContext fontRenderContext) {
		
		final int width = (int) font.createGlyphVector(fontRenderContext, text).getVisualBounds().getWidth();
		final int centerPos = Display.WIDTH * Display.SCALE;
		
		return (centerPos - width) / 2;
		
	}
	
}
