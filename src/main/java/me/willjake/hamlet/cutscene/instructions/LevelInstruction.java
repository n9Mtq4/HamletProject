package me.willjake.hamlet.cutscene.instructions;

import me.willjake.hamlet.render.Display;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 * Change the level
 */
public class LevelInstruction extends Instruction {
	
	private String levelName;
	
	public LevelInstruction(Node rawInstruction) {
		super(rawInstruction);
	}
	
	@Override
	public void run() {
		Display.veryBad.loadLevel(levelName);
		this.isDone = true;
	}

	@Override
	public String getType() {
		return "LEVEL";
	}

	@Override
	public void parseInstruction(Node rawInstruction) {
		Element element = (Element) rawInstruction;
		this.levelName = element.getTextContent();
	}
}
