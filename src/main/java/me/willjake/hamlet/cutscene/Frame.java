package me.willjake.hamlet.cutscene;

import me.willjake.hamlet.cutscene.instructions.Instruction;
import org.w3c.dom.Node;

import java.util.ArrayList;

/**
 * Created by jakekinsella on 3/25/17.
 */
public class Frame {

    private ArrayList<Instruction> instructions;

    public Frame(Node rawFrame) {
        this.parseFrame(rawFrame);
    }

    public void play() {
        for (Instruction instruction : this.instructions) {
            instruction.run();
        }
    }

    private void parseFrame(Node rawFrame) {
        FrameParser frameParser = new FrameParser(rawFrame);
        this.instructions = frameParser.getInscructions();
    }
}
