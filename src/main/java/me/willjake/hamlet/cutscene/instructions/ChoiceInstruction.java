package me.willjake.hamlet.cutscene.instructions;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 * Display a choice and switch cutscene based off of it
 */
public class ChoiceInstruction extends Instruction {
	
	private String choiceName;
	
	public ChoiceInstruction(Node rawInstruction) {
		super(rawInstruction);
	}
	
	@Override
	public void run() {
		// TODO: Display choice
	}
	
	@Override
	public void parseInstruction(Node rawInstruction) {
		Element element = (Element) rawInstruction;
		this.choiceName = element.getTextContent();
	}
}
