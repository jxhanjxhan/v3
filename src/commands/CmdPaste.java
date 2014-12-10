package commands;

import receiver.EditorEngine;

/**
 * @see Command
 * @author Archibald Jego & Johan Moreira
 * @version 1
 */

public class CmdPaste extends Command{

	public CmdPaste(EditorEngine e) {
		super(e);
	}
	
	public void execute(){
		e.paste();
	}
	

}
