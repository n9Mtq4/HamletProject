package me.willjake.hamlet.game.hud;

import org.w3c.dom.Element;

/**
 * Created by jakekinsella on 3/26/17.
 */
public class ChoiceOption {

    private String text;
    private String cutsceneName;
    private String deathName;
    private int sanityChange;

    public ChoiceOption(Element rawOption) {
        this.setup(rawOption);
    }
    
    public ChoiceOption(String text, String cutsceneName) {
        this.text = text;
        this.cutsceneName = cutsceneName;
    }

    public String getText() {
        return this.text;
    }

    public String getDeathName() {
        return this.deathName;
    }

    public int getSanityChange() {
        return this.sanityChange;
    }

    public String getCutsceneName() {
        return this.cutsceneName;
    }

    private void setup(Element rawOption) {
        this.text = rawOption.getTextContent();
        this.cutsceneName = rawOption.getAttribute("cutscene");

        this.deathName = rawOption.getAttribute("death");

        String rawSanityChange = rawOption.getAttribute("sanity");

        if (rawSanityChange.equals("")) {
            this.sanityChange = 0;
        } else {
            this.sanityChange = Integer.parseInt(rawSanityChange);
        }
    }
    
}
