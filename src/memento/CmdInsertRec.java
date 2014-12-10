package memento;

import receiver.EditorEngine;
import commands.CmdInsert;
import commands.Command;

/**
 * @see CommandRec
 * @see Command
 * @author Archibald Jego & Johan Moreira
 * @version 2
 */

public class CmdInsertRec extends CmdInsert implements CommandRec{

	public CmdInsertRec(EditorEngine e) {
		super(e);
		// TODO Auto-generated constructor stub
	}
	
	public void execute(int s, int e, String str) {
		super.execute(str);		
	}

}
