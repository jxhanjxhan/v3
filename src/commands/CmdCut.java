package commands;

import receiver.EditorEngine;

/**
 * @see Command
 * @author Archibald Jego & Johan Moreira
 * @version 1
 */

public class CmdCut extends Command {

	public CmdCut(EditorEngine e) {
		super(e);
	}
	
	public void execute(){
		e.cut();
	}
	

}
