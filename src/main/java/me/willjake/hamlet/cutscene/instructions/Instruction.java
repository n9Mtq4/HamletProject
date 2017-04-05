package me.willjake.hamlet.cutscene.instructions;

import org.w3c.dom.Node;

/**
 * Created by jakekinsella on 3/25/17.
 */
public abstract class Instruction {

    boolean isDone = false;

	public Instruction(Node rawInstruction) {
		parseInstruction(rawInstruction);
	}
	
	public abstract void run();

	public boolean isDone() {
        return this.isDone;
    }

    public abstract String getType();

	abstract void parseInstruction(Node rawInstruction);
}
