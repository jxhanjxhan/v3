package history;

import receiver.Buffer;
import receiver.Selection;

/**
 * Classe memento pour l'enregistrement de l'état d'un EditorEngine
 * <p>
 * <ul>
 * <li>MementoEngine contient:</li>
 * <li>Un buffer</li>
 * <li>Une selection</li>
 * </ul>
 * </p>
 * Le presse-papier n'est volontairement pas enregistré par choix fonctionnel.
 * @author Archibald Jego & Johan Moreira
 * @version 3
 */

public class MementoEngine {

	private Buffer buffer;
	private Selection selec;

/**
 * Constructeur d'un nouveau memento d'EditorEngine par clonage de son buffer et de sa sélection
 * @param b
 * buffer de l'EditorEngine à enregistrer
 * @param s
 * selection de l'EditorEngine à enregistrer
 */
	public MementoEngine(Buffer b, Selection s) {
		buffer = new Buffer(b);
		selec = new Selection(s);
	}
	
	public Buffer getBuffer(){
		return buffer;
	}
	
	public Selection getSelection(){
		return selec;
	}

}
