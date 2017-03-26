package me.willjake.hamlet.cutscene;

import java.util.ArrayList;

/**
 * Created by jakekinsella on 3/25/17.
 */
public class Cutscene {

    private ArrayList<Frame> frames = new ArrayList<Frame>();

    public Cutscene(String sceneName) {
        this.parseScene(sceneName);
    }

    public void play() {

    }

    public void pause() {

    }

    private void parseScene(String sceneName) {
        CutsceneParser cutsceneParser = new CutsceneParser(sceneName);

        this.frames = cutsceneParser.getFrames();
    }
}
