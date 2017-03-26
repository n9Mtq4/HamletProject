package me.willjake.hamlet.cutscene;

import java.util.ArrayList;

/**
 * Created by jakekinsella on 3/25/17.
 */
public class CutsceneParser {

    public CutsceneParser(String sceneName) {
        this.setupParsing(sceneName);
    }

    public ArrayList<Frame> getFrames() {
        return new ArrayList<Frame>();
    }

    private void setupParsing(String sceneName) {

    }
}
