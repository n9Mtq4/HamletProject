package me.willjake.hamlet.hud;

import me.willjake.hamlet.render.Display;
import me.willjake.hamlet.render.Screen;

import java.awt.*;
import java.awt.font.FontRenderContext;
import java.util.ArrayList;

/**
 * Created by will on 3/25/17 at 6:50 PM.
 *
 * @author Will "n9Mtq4" Bresnahan
 */
public class TextBox {

	private static final int BORDERX = 10;
	private static final int BORDERY = 50;
    private static final int CHARACTERS_PER_LINE = 97;
    private static final int LINE_PADDING = 3; //px
	private static final double LIFE_MODIFIER = 0.2; // % of a second for each character

	private boolean show = false;
	private int life = 0;
	private int xOff = 0;
	private int yOff = 0;
    private ArrayList<String> text;

	private Font font;

	public TextBox() {
        this.font = new Font(Font.SANS_SERIF, Font.PLAIN, 14);
    }

	public void render(Screen screen) {
		xOff = screen.xOff; // TODO: very bad
		yOff = screen.yOff;
	}

	public void render(Graphics graphics) {
		if (!show) return;

        this.drawTextBox(graphics);
        this.drawText(graphics);
	}
	
	public void tick() {
		life--;
		
		if (life <= 0) {
			show = false;
		}
	}

	public void go(String text, boolean bold) {
	    if (bold) {
            this.font = new Font(Font.SANS_SERIF, Font.BOLD, 14);
        } else {
            this.font = new Font(Font.SANS_SERIF, Font.PLAIN, 14);
        }

        show = true;
        this.text = this.splitTextIntoLines(text);
        this.life = (int) (text.length() * LIFE_MODIFIER) * 100; // Totally random formula, pls ignore
    }

    public void go(String text) {
        go(text, false);
    }

    // Purposely ignores splitting words, sorta unnecessary
    private ArrayList<String> splitTextIntoLines(String text) {
	    ArrayList<String> lines = new ArrayList<String>();

        int charAt;
	    for (charAt = 0; charAt < text.length() - CHARACTERS_PER_LINE; charAt += CHARACTERS_PER_LINE) {
            lines.add(text.substring(charAt, charAt + CHARACTERS_PER_LINE));
        }

        if (charAt < text.length()) {
            lines.add(text.substring(charAt, text.length()));
        }

        return lines;
    }

	private void drawTextBox(Graphics graphics) {
        FontRenderContext fontRenderContext = ((Graphics2D) graphics).getFontRenderContext();

        graphics.setColor(Color.WHITE);
        graphics.fillRoundRect(BORDERX, BORDERY, Display.WIDTH * Display.SCALE - BORDERX * 2, (int) this.getTotalTextHeight(fontRenderContext) + 20, BORDERX * 2, BORDERX * 2);
    }

    private void drawText(Graphics graphics) {
        FontRenderContext fontRenderContext = ((Graphics2D) graphics).getFontRenderContext();

	    graphics.setColor(Color.BLACK);
        graphics.setFont(this.font);

        int startY = BORDERX + 60;
        for (int i = 0; i < this.text.size(); i++) {
            String string = this.text.get(i);
            int height = (int) this.getTextHeight(string, fontRenderContext);

            graphics.drawString(string, BORDERX * 2, startY + (i * height));
        }
    }

    private double getTotalTextHeight(FontRenderContext fontRenderContext) {
        double totalHeight = 0;
	    for (String string : this.text) {
	        totalHeight += this.getTextHeight(string, fontRenderContext);
        }

        return totalHeight;
    }

    private double getTextHeight(String text, FontRenderContext fontRenderContext) {
        return this.font.createGlyphVector(fontRenderContext, text).getVisualBounds().getHeight() + LINE_PADDING;
    }
}
