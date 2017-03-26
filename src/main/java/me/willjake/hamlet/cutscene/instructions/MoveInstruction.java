package me.willjake.hamlet.cutscene.instructions;

import me.willjake.hamlet.entity.Mob;
import me.willjake.hamlet.render.Display;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 * Move sprite to an x and y value
 */
public class MoveInstruction extends Instruction {
    private int x, y;
    private String spriteString;

    public MoveInstruction(Node rawInstruction) {
        super(rawInstruction);
    }

    @Override
    public void run() {
        // TODO: Move the sprite around
	    ((Mob) Display.veryBad.level.getSprite(spriteString)).moveTo(x, y);
    }

    @Override
    public void parseInstruction(Node rawInstruction) {
        Element element  = (Element) rawInstruction;
        this.x = Integer.parseInt(element.getAttribute("x"));
        this.y = Integer.parseInt(element.getAttribute("y"));
        this.spriteString = element.getTextContent();
    }
}
