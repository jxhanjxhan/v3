package history;

import java.util.Stack;

import receiver.EditorEngine;

/**
 * Classe d'historique d'état de l'éditeur
 * <br>
 * HistoryStack est le gardien des MementoEngines, il permet de faire revenir le moteur de l'éditeur 
 * à d'anciens états, utile lors des commandes Undo et Redo. Il contient:
 * <p>
 * <ul>
 * <li>L'EditorEngine avec lequelle il travaille</li>
 * <li>Une pile "undo" de MementoEngine correspondant aux états passés de l'EditorEngine</li>
 * <li>Une pile "redo" de MementoEngine correspondant aux états futurs de l'EditorEngine</li>
 * </ul>
 * </p>
 * @author Archibald Jego & Johan Moreira
 * @version 3
 */

public class HistoryStack {
	private EditorEngine en;
	private Stack<MementoEngine> undo, redo;

/**
 * Constructeur d'un nouvel HistoryStack
 * @param engine
 * EditorEngine géré par cette historique
 */
	public HistoryStack(EditorEngine engine) {
		en = engine;
		undo = new Stack<MementoEngine>();
		redo = new Stack<MementoEngine>();
	}

/**
 * Revenir à l'état précédent, si possible
 */
	public void undo(){
		if (!undo.empty()) {
		MementoEngine m = undo.pop();
		redo.push(en.getMemento());
		System.out.println("- Undoing");
		en.setMemento(m);
		}
		else System.out.println("Rien \u00E0 annuler!");
	}

	
/**
 * Aller à l'état suivant, si possible
 */
	public void redo(){
		if (!redo.empty()) {
		MementoEngine m = redo.pop();
		undo.push(en.getMemento());
		System.out.println("- Redoing");
		en.setMemento(m);
		}
		else System.out.println("Rien \u00E0 refaire!");
	}

/**
 * Ajoute l'état courant à la pile des états précédents
 */
	public void add() {
		MementoEngine m = en.getMemento();
		undo.push(m);
		redo.clear();
	}
}
