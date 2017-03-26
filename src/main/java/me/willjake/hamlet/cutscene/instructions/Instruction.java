package me.willjake.hamlet.cutscene.instructions;

import org.w3c.dom.Node;

/**
 * Created by jakekinsella on 3/25/17.
 */
public abstract class Instruction {
	
	public Instruction(Node rawInstruction) {
		parseInstruction(rawInstruction);
	}
	
	public abstract void run();
	
	abstract void parseInstruction(Node rawInstruction);
}
