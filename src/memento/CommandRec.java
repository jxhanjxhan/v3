package memento;

/**
 * Interface des commandes enregistrables
 * @author Archibald Jego & Johan Moreira
 * @version 2
 */

public interface CommandRec {

/**
 * Les commandes doivent etre executables qu'elles prennent en paramètre une selection, du texte, 
 * ou aucun argument, pour ne pas avoir à les différencier
 */
	void execute(int s, int e, String t);
	

}
