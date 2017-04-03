package me.willjake.hamlet.cutscene.instructions;

import me.willjake.hamlet.render.Display;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 * Display a textbox
 */
public class TextInstruction extends Instruction {
	
	private String textName;
	private boolean running = false;

	public TextInstruction(Node rawInstruction) {
		super(rawInstruction);

        this.running = false;
	}
	
	@Override
	public void run() {
        if (!this.running) {
            Display.veryBad.hud.textBox.showText(textName);
        }

		this.running = true;
	}

	@Override
    public boolean isDone() {
	    return this.running && !Display.veryBad.hud.textBox.show;
    }
	
	@Override
	public void parseInstruction(Node rawInstruction) {
		Element element = (Element) rawInstruction;
		this.textName = element.getTextContent();
	}
}
