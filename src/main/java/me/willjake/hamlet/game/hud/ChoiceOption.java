package me.willjake.hamlet.game.hud;

import org.w3c.dom.Element;

/**
 * Created by jakekinsella on 3/26/17.
 */
public class ChoiceOption {

    private String text;
    private String cutsceneName;

    public ChoiceOption(Element rawOption) {
        this.setup(rawOption);
    }

/*
    public void choose() {
        // TODO: Switch to different cutscene
    }

    public void render(Graphics graphics) {
        // TODO: Render option
    }
*/

    private void setup(Element rawOption) {
        this.text = rawOption.getTextContent();
        this.cutsceneName = rawOption.getAttribute("cutscene");
    }
}
