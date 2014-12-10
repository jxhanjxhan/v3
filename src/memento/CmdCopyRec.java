package memento;

import receiver.EditorEngine;
import commands.CmdCopy;
import commands.Command;

/**
 * @see CommandRec
 * @see Command
 * @author Archibald Jego & Johan Moreira
 * @version 2
 */

public class CmdCopyRec extends CmdCopy implements CommandRec{

	public CmdCopyRec(EditorEngine e) {
		super(e);
		// TODO Auto-generated constructor stub
	}
	
	public void execute(int s, int e, String t) {
		super.execute();		
	}

}
