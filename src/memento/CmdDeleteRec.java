package memento;

import receiver.EditorEngine;
import commands.CmdDelete;
import commands.Command;

/**
 * @see CommandRec
 * @see Command
 * @author Archibald Jego & Johan Moreira
 * @version 2
 */

public class CmdDeleteRec extends CmdDelete implements CommandRec{

	public CmdDeleteRec(EditorEngine e) {
		super(e);
		// TODO Auto-generated constructor stub
	}
	
	public void execute(int s, int e, String t) {
		super.execute();		
	}

}
