package commands;

import receiver.EditorEngine;

/**
 * Classe des commandes.
 * <br>
 * Une commande doit connaître l'EditorEngine qui lui est attribué pour permettre son execution
 * @author Archibald Jego & Johan Moreira
 * @version 1
 */

public class Command implements ICommand{

	protected EditorEngine e;
	
/**
 * Constructeur d'une nouvelle commande
 * @param e
 * l'EditorEngine qui executera la commande
 */
	public Command(EditorEngine e){
		this.e = e;
	}

/**
 * Permet l'execution de la commande
 */
	@Override
	public void execute() {
		
	}
	
}
