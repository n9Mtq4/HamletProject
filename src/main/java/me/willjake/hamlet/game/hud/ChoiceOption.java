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
    
    public ChoiceOption(String text, String cutsceneName) {
        this.text = text;
        this.cutsceneName = cutsceneName;
    }

    public String getText() {
        return text;
    }

    public String getCutsceneName() {
        return cutsceneName;
    }

    private void setup(Element rawOption) {
        this.text = rawOption.getTextContent();
        this.cutsceneName = rawOption.getAttribute("cutscene");
    }
    
}
