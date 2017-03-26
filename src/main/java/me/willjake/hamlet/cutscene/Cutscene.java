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
	}
	
	public void playNextFrame() {
		if (this.onFrame < this.frames.size()) {
            this.frames.get(this.onFrame).play();
            this.onFrame++;
        } else {
		    System.out.println("Cutscene is complete");
        }
	}
	
	public void pause() {
		
	}
	
	private void parseScene(String sceneName) {
		CutsceneParser cutsceneParser = new CutsceneParser(sceneName);
		this.frames = cutsceneParser.getFrames();
	}
}
