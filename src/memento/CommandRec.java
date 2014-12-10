package memento;

/**
 * Interface des commandes enregistrables
 * @author Archibald Jego & Johan Moreira
 * @version 2
 */

public interface CommandRec {

/**
 * Les commandes doivent etre executables qu'elles prennent en param�tre une selection, du texte, 
 * ou aucun argument, pour ne pas avoir � les diff�rencier
 */
	void execute(int s, int e, String t);
	

}
