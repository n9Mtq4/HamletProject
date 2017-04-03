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
    private boolean hidden = false;
    private boolean noHiddenUpdate = false;

    public MoveInstruction(Node rawInstruction) {
        super(rawInstruction);
    }

    @Override
    public void run() {
        
        final Mob mob = (Mob) Display.veryBad.level.getSprite(spriteString);
        if (mob != null) {
            mob.cutsceneMove(x, y);
            if (!noHiddenUpdate) {
                mob.hidden = this.hidden;
            }
        }
        
    }

    @Override
    public boolean isDone() {
        return ((Mob) Display.veryBad.level.getSprite(spriteString)).isAnimationDone;
    }

    @Override
    public void parseInstruction(Node rawInstruction) {
        Element element  = (Element) rawInstruction;
        this.x = Integer.parseInt(element.getAttribute("x"));
        this.y = Integer.parseInt(element.getAttribute("y"));
        this.spriteString = element.getTextContent();

        String rawHidden = element.getAttribute("hidden");
        if (!rawHidden.equals("")) {
            this.hidden = Boolean.parseBoolean(element.getAttribute("hidden"));
            this.noHiddenUpdate = false;
        }else {
            this.noHiddenUpdate = true;
        }
    }
}
