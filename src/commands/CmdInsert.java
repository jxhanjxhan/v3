package commands;

import receiver.EditorEngine;

/**
 * @see Command
 * @author Archibald Jego & Johan Moreira
 * @version 1
 */

public class CmdInsert extends Command {

	
	public CmdInsert(EditorEngine e) {
		super(e);
	}

/**
 * @param s
 * texte à insérer
 */
	public void execute(String s){
		e.insert(s);
	}
	
}
