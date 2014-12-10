package memento;

import receiver.EditorEngine;
import commands.CmdSelect;
import commands.Command;

/**
 * @see CommandRec
 * @see Command
 * @author Archibald Jego & Johan Moreira
 * @version 2
 */

public class CmdSelectRec extends CmdSelect implements CommandRec{

	public CmdSelectRec(EditorEngine e) {
		super(e);
		// TODO Auto-generated constructor stub
	}
	
	public void execute(int s, int e, String t) {
		super.execute(s,e);		
	}

}
