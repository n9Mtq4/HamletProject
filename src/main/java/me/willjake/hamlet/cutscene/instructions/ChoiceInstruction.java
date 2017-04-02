package me.willjake.hamlet.cutscene.instructions;

import me.willjake.hamlet.render.Display;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 * Display a choice and switch cutscene based off of it
 */
public class ChoiceInstruction extends Instruction {
	
	private String choiceName;
	private String deathName;
	
	public ChoiceInstruction(Node rawInstruction) {
		super(rawInstruction);
	}
	
	@Override
	public void run() {
        if (this.deathName != null && this.deathName != "") {
            // TODO: Kill them
        }
		Display.veryBad.hud.choiceMenu.go(choiceName);
	}
	
	@Override
	public void parseInstruction(Node rawInstruction) {
		Element element = (Element) rawInstruction;
		this.choiceName = element.getTextContent();
		this.deathName = element.getAttribute("death");
	}
}
