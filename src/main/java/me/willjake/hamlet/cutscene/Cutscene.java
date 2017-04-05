package me.willjake.hamlet.cutscene;

import java.util.ArrayList;

/**
 * Created by jakekinsella on 3/25/17.
 */
public class Cutscene {
	
	private ArrayList<Frame> frames = new ArrayList<Frame>();
	private int onFrame = 0;

	public Cutscene(String sceneName) {
		this.parseScene(sceneName);
		this.onFrame = 0;
	}

	public boolean isDone() {
	    return this.onFrame >= this.frames.size() && !this.frames.get(this.frames.size() - 1).hasChoice();
    }

	public void tick() {
	    if (this.frames.size() == 0) return;

		if (this.onFrame < this.frames.size()) {
            if (this.frames.get(this.onFrame).isDone()) {
                this.onFrame++;
            } else {
                this.frames.get(this.onFrame).play();
            }
        }
	}

	private void parseScene(String sceneName) {
		CutsceneParser cutsceneParser = new CutsceneParser(sceneName);
		this.frames = cutsceneParser.getFrames();
	}
}
