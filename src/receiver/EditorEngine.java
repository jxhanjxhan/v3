package receiver;

import history.HistoryStack;
import history.MementoEngine;


/**
 * Classe du moteur d'un éditeur
 * <br>
 * EditorEngine s'occupe du fonctionnement interne de l'éditeur en manipulant les objets suivants :
 * <p>
 * <ul>
 * <li>Un Buffer, contenant le texte en cours de traitement de l'éditeur</li>
 * <li>Une Selection, contenant les coordonnés courantes du texte sélectionné dans l'éditeur</li>
 * <li>Un Clipboard, contenant le texte présent dans le presse-papier</li>
 * </ul>
 * </p>
 * @author Archibald Jego & Johan Moreira
 * @version 3
 */

public class EditorEngine {

	private Buffer buffer;
	private Selection selection;
	private Clipboard clipboard;

/**
 * Constructeur sans paramètre d'un nouveau moteur d'éditeur
 */
	public EditorEngine(){
		buffer = new Buffer();
		selection = new Selection();
		clipboard = new Clipboard();
	}

	public void setBuffer(Buffer b) {
		buffer=b;
	}

	public void  setSelection(Selection sel) {
		selection=sel;
	}

	public void setClipboard(Clipboard clip) {
		clipboard=clip;
	}

	public Buffer getBuffer() {
		return buffer;
	}

	public Selection getSelection() {
		return selection;
	}

	public Clipboard getClipboard() {
		return clipboard;
	}

/**
 * Permet de mettre à jour la sélection courante
 * @param s
 * entier correspond à la position du début de la sélection
 * @param e
 * entier correspond à la position de fin de la sélection
 */
	public void select(int s, int e){
		selection.setStartEnd(Math.min(s, buffer.getContent().length()),(Math.min(e, buffer.getContent().length())));
		int ss = selection.getStart();
		int ee = selection.getEnd();
		System.out.println("- Selection [debut: " + ss + " | fin: " + ee +"]");
	}

/**
 * Couper: Le texte correspondant à la sélection courante est mis dans le presse-papier et est rétiré du buffer
 */
	public void cut() {
		int ss = selection.getStart();
		if (ss != selection.getEnd()) {
			System.out.println("- Cut [debut: " + selection.getStart()
					+ " | fin: " + selection.getEnd() + "]");
			String text = buffer.getContent(selection);
			clipboard.setContent(text);
			buffer.setContent("", selection);
			selection.setStartEnd(ss, ss);
		} else {
			System.out.println("- Rien \u00E0  couper!");
		}
	}

/**
 * Copier: Le texte correspondant à la sélection courante est mis dans le presse-papier
 */
	public void copy() {
		if (selection.getStart() != selection.getEnd()) {
			System.out.println("- Copy [debut: " + selection.getStart()
					+ " | fin: " + selection.getEnd() + "]");
			String text = buffer.getContent(selection);
			clipboard.setContent(text);
		} else {
			System.out.println("- Rien \u00E0  copier!");
		}
	}

/**
 * Copier: Le texte correspondant à la sélection est remplacé par celui du presse-papier
 */
	public void paste(){
		System.out.println("- Paste [debut: " + selection.getStart() + " | fin: " + selection.getEnd() +"]");
		String text = clipboard.getContent();
		buffer.setContent(text, selection);
		int ss = selection.getStart()+text.length();
		selection.setStartEnd(ss, ss);
	}
	
/**
 * Inserer: La sélection courante est remplacé par le texte à insérer
 * @param mot
 * texte à insérer
 */
	public void insert(String mot){
		System.out.println("- Insert [debut: " + selection.getStart() + " | fin: " + selection.getEnd() +"]");
		buffer.setContent(mot,selection);
		int ss = selection.getStart()+mot.length();
		selection.setStartEnd(ss, ss);
	}
	
/**
 * Supprimer: Le texte correspondant à la sélection courante est rétiré du buffer
 */
	public void delete(){
		System.out.println("- Delete [debut: " + selection.getStart() + " | fin: " + selection.getEnd() +"]");
		buffer.setContent("",selection);
		int ss = selection.getStart();
		selection.setStartEnd(ss, ss);
	}

/**
 * Créer un nouveau MementoEngine à partir de l'état courant du moteur
 * @see MementoEngine
 * @see HistoryStack
 * @return
 * un nouveau MementoEngine
 * @since 3
 */
	public MementoEngine getMemento() {
		return new MementoEngine(buffer, selection);
	}

/**
 * Restaure l'état contenu dans un MementoEngine
 * @see MementoEngine
 * @see HistoryStack
 * @param m
 * l'état à restaurer
 * @since 3
 */
	public void setMemento(MementoEngine m) {
		buffer = new Buffer(m.getBuffer());
		selection = new Selection(m.getSelection());
	}

}