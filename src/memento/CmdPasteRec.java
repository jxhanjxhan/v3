package memento;

import receiver.EditorEngine;
import commands.CmdPaste;
import commands.Command;

/**
 * @see CommandRec
 * @see Command
 * @author Archibald Jego & Johan Moreira
 * @version 2
 */

public class CmdPasteRec extends CmdPaste implements CommandRec{

	public CmdPasteRec(EditorEngine e) {
		super(e);
		// TODO Auto-generated constructor stub
	}
	
	public void execute(int s, int e, String t) {
		super.execute();		
	}

}
