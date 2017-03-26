package me.willjake.hamlet.cutscene;

import me.willjake.hamlet.cutscene.instructions.Instruction;
import org.w3c.dom.Node;

import java.util.ArrayList;

/**
 * Created by jakekinsella on 3/25/17.
 */
public class FrameParser {

    private Node rawFrame;

    public FrameParser(Node rawFrame) {
        this.rawFrame = rawFrame;
    }

    public ArrayList<Instruction> getInscructions() {
        return new ArrayList<Instruction>();
    }
}
