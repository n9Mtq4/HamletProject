package me.willjake.hamlet.cutscene.instructions;

import me.willjake.hamlet.render.Display;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 * Display a textbox
 */
public class TextInstruction extends Instruction {
	
	private String textName;
	
	public TextInstruction(Node rawInstruction) {
		super(rawInstruction);
	}
	
	@Override
	public void run() {
		// TODO: Display textbox
		Display.veryBad.hud.textBox.showText(textName);
	}
	
	@Override
	public void parseInstruction(Node rawInstruction) {
		Element element = (Element) rawInstruction;
		this.textName = element.getTextContent();
	}
}