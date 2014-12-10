package commands;

import receiver.EditorEngine;

/**
 * @see Command
 * @author Archibald Jego & Johan Moreira
 * @version 1
 */

public class CmdSelect extends Command{

	public CmdSelect(EditorEngine e) {
		super(e);
	}
	
/**
 * @param start
 * entier correspond à la position du début de la sélection
 * @param end
 * entier correspond à la position de fin de la sélection
 */
	public void execute(int start, int end){
		e.select(start, end);
	}
	
}
