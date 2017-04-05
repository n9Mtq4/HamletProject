package me.willjake.hamlet.cutscene;

import me.willjake.hamlet.cutscene.instructions.Instruction;
import org.w3c.dom.Node;

import java.util.ArrayList;

/**
 * Created by jakekinsella on 3/25/17.
 */
public class Frame {

    private boolean isDone = false;
	private ArrayList<Instruction> instructions;
	
	public Frame(Node rawFrame) {
		this.parseFrame(rawFrame);
	}
	
	public void play() {
        this.isDone = true;
		for (Instruction instruction : this.instructions) {
		    if (!instruction.isDone()) {
                instruction.run();
                this.isDone = false;
            }
		}
	}

	public boolean isDone() {
        return this.isDone;
    }

    public boolean hasChoice() {
		for (Instruction instruction : this.instructions) {
			if (instruction.getType().equals("CHOICE")) {
				return true;
			}
		}

		return false;
	}

	private void parseFrame(Node rawFrame) {
		FrameParser frameParser = new FrameParser(rawFrame);
		this.instructions = frameParser.getInstructions();
	}
}
