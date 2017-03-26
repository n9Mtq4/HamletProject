package me.willjake.hamlet.cutscene;

import me.willjake.hamlet.cutscene.instructions.*;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;

/**
 * Created by jakekinsella on 3/25/17.
 */
public class FrameParser {

    private Node rawFrame;

    public FrameParser(Node rawFrame) {
        this.rawFrame = rawFrame;
    }

    public ArrayList<Instruction> getInstructions() {
        NodeList rawInstructions = ((Element) this.rawFrame).getElementsByTagName("*");

        ArrayList<Instruction> instructions = new ArrayList<Instruction>();
        for (int i = 0; i < rawInstructions.getLength(); i++) {
            instructions.add(this.getInstruction(rawInstructions.item(i)));
        }

        return instructions;
    }

    // This function must be updated with each new instruction
    private Instruction getInstruction(Node rawInstruction) {
        String instructionName = rawInstruction.getNodeName().toLowerCase();

        if (instructionName.equals("move")) {
            return new MoveInstruction(rawInstruction);
        } else if (instructionName.equals("level")) {
            return new LevelInstruction(rawInstruction);
        } else if (instructionName.equals("text")) {
            return new TextInstruction(rawInstruction);
        } else if (instructionName.equals("choice")) {
            return new ChoiceInstruction(rawInstruction);
        } else {
            System.out.println("Unhandled instruction!");
            return null; // pls no
        }
    }
}
