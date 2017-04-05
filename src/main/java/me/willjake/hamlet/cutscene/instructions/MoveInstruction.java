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
    private boolean hidden;
    private boolean running = false;

    public MoveInstruction(Node rawInstruction) {
        super(rawInstruction);
        this.running = false;
    }

    @Override
    public void run() {
        if (!running) {
            final Mob mob = (Mob) Display.veryBad.level.getSprite(spriteString);
            if (mob != null) {
                mob.cutsceneMove(x, y);

                mob.hidden = this.hidden;
            }
        }

        this.running = true;
    }

    @Override
    public boolean isDone() {
        return this.running && ((Mob) Display.veryBad.level.getSprite(spriteString)).isAnimationDone;
    }

    @Override
    public String getType() {
        return "MOVE";
    }

    @Override
    public void parseInstruction(Node rawInstruction) {
        Element element  = (Element) rawInstruction;
        this.x = Integer.parseInt(element.getAttribute("x"));
        this.y = Integer.parseInt(element.getAttribute("y"));
        this.spriteString = element.getTextContent();

        String rawHidden = element.getAttribute("hidden");
        this.hidden = false;
        if (!rawHidden.equals("")) {
            this.hidden = Boolean.parseBoolean(element.getAttribute("hidden"));
        }
    }
}
