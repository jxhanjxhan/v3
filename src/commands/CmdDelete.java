package commands;

import receiver.EditorEngine;

/**
 * @see Command
 * @author Archibald Jego & Johan Moreira
 * @version 1
 */

public class CmdDelete extends Command {

	public CmdDelete(EditorEngine e) {
		super(e);
	}
	
	public void execute(){
		e.delete();
	}
	
}
