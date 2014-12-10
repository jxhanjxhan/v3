package memento;

import receiver.EditorEngine;
import commands.CmdCut;
import commands.Command;

/**
 * @see CommandRec
 * @see Command
 * @author Archibald Jego & Johan Moreira
 * @version 2
 */

public class CmdCutRec extends CmdCut implements CommandRec{

	public CmdCutRec(EditorEngine e) {
		super(e);
		// TODO Auto-generated constructor stub
	}
	
	public void execute(int s, int e, String t) {
		super.execute();		
	}

}
