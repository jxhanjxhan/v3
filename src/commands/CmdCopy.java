package commands;

import receiver.EditorEngine;

/**
 * @see Command
 * @author Archibald Jego & Johan Moreira
 * @version 1
 */

public class CmdCopy extends Command {

	public CmdCopy(EditorEngine e) {
		super(e);
	}
	
	public void execute(){
		e.copy();
	}

}
