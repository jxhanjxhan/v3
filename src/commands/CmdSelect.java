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
 * entier correspond � la position du d�but de la s�lection
 * @param end
 * entier correspond � la position de fin de la s�lection
 */
	public void execute(int start, int end){
		e.select(start, end);
	}
	
}
