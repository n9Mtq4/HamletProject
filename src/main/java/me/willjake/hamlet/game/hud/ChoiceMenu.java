package me.willjake.hamlet.game.hud;

import me.willjake.hamlet.game.GConstants;
import me.willjake.hamlet.game.GameState;
import me.willjake.hamlet.render.Display;
import me.willjake.hamlet.render.Screen;

import java.awt.*;
import java.awt.font.FontRenderContext;
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
	private static final int LINE_PADDING = 10; //px
	
	private Display display;
	private ArrayList<ChoiceOption> options;
	
	private int selectedOption = 0;
	private String choicePrompt;
    private boolean show = false;
	
	public ChoiceMenu(Display display) {
        this.display = display;
    }
	
	public void go(String choiceName) {
		ChoiceParser choiceParser = new ChoiceParser(choiceName);
		this.choicePrompt = choiceParser.getChoicePrompt();
		this.options = choiceParser.getOptions();

        display.gameState = GameState.CHOICE;

        this.show = true;
	}
	
	public void fireSelect() {
		final ChoiceOption selected = options.get(selectedOption);

		// clean up after ourselves.
		display.gameState = GameState.IN_GAME;
		this.show = false;
		this.options.clear();
		this.selectedOption = 0;

        if (selected.getDeathName() != null && !selected.getDeathName().equals("")) {
            Display.veryBad.setDead(selected.getDeathName(), true);
        }

        Display.veryBad.sanity -= (selected.getSanityChange() * GConstants.SANITY_COEF);

		display.switchCutscene(selected.getCutsceneName());
	}
	
	public void tick() {
		// does nothing right now
		// key events are handled in the display class
	}
	
	public void upPressed() {
		selectedOption--;
		if (selectedOption <= -1) selectedOption = options.size() - 1;
		selectedOption %= options.size();
	}
	
	public void downPressed() {
		selectedOption++;
		if (selectedOption <= -1) selectedOption = options.size() - 1;
		selectedOption %= options.size();
	}
	
	public void selectPressed() {
		fireSelect();
	}
	
	public void render(Graphics g) {
	    if (!this.show) {
	        return;
        }

        this.renderBox(g);
	    this.renderText(g);
	}
	
	public void render(Screen screen) {}

	private void renderBox(Graphics g) {
        g.setColor(Color.WHITE);
        int height = this.getHeight(((Graphics2D) g).getFontRenderContext());
        g.fillRoundRect(BORDERX, Display.getWindowHeight() - height - LINE_PADDING, Display.getWindowWidth() - 2 * BORDERX, height, BORDERX * 2, BORDERX * 2);
    }

    private void renderText(Graphics g) {
	    FontRenderContext fontRenderContext = ((Graphics2D) g).getFontRenderContext();
        int height = this.getHeight(fontRenderContext);

        int firstLineY = (int) (Display.getWindowHeight() - height + getTextHeight(TITLE_FONT, fontRenderContext));

        g.setColor(Color.BLACK);

        g.setFont(TITLE_FONT);
        g.drawString(this.choicePrompt, BORDERX + LINE_PADDING, firstLineY);

        for (int i = 0; i < this.options.size(); i++) {
            g.setFont(NORMAL);
            if (i == this.selectedOption) {
                g.setFont(SELECTED);
            }

            g.drawString(this.options.get(i).getText(), BORDERX + LINE_PADDING * 3, (int) (firstLineY + ((i + 1) * getTextHeight(g.getFont(), fontRenderContext))));
        }
    }

	private int getHeight(FontRenderContext fontRenderContext) {
	    return (int) (this.getTextHeight(TITLE_FONT, fontRenderContext) + (this.getTextHeight(NORMAL, fontRenderContext)) * this.options.size() + LINE_PADDING * 2);
    }

    private double getTextHeight(Font font, FontRenderContext fontRenderContext) {
        return font.createGlyphVector(fontRenderContext, "Random irrelevant text").getVisualBounds().getHeight() + LINE_PADDING;
    }
}
