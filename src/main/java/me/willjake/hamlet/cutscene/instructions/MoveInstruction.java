package me.willjake.hamlet.cutscene.instructions;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 * Move sprite to an x and y value
 */
public class MoveInstruction extends Instruction {

    private int x, y, spriteNumber;

    public MoveInstruction(Node rawInstruction) {
        super(rawInstruction);
    }

    @Override
    public void run() {
        // TODO: Move the sprite around
    }

    @Override
    public void parseInstruction(Node rawInstruction) {
        Element element  = (Element) rawInstruction;
        this.x = Integer.parseInt(element.getAttribute("x"));
        this.y = Integer.parseInt(element.getAttribute("x"));
        this.spriteNumber = Integer.parseInt(element.getTextContent());
    }
}
