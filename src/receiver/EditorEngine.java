package receiver;

import history.HistoryStack;
import history.MementoEngine;


/**
 * Classe du moteur d'un �diteur
 * <br>
 * EditorEngine s'occupe du fonctionnement interne de l'�diteur en manipulant les objets suivants :
 * <p>
 * <ul>
 * <li>Un Buffer, contenant le texte en cours de traitement de l'�diteur</li>
 * <li>Une Selection, contenant les coordonn�s courantes du texte s�lectionn� dans l'�diteur</li>
 * <li>Un Clipboard, contenant le texte pr�sent dans le presse-papier</li>
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
 * Constructeur sans param�tre d'un nouveau moteur d'�diteur
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
 * Permet de mettre � jour la s�lection courante
 * @param s
 * entier correspond � la position du d�but de la s�lection
 * @param e
 * entier correspond � la position de fin de la s�lection
 */
	public void select(int s, int e){
		selection.setStartEnd(Math.min(s, buffer.getContent().length()),(Math.min(e, buffer.getContent().length())));
		int ss = selection.getStart();
		int ee = selection.getEnd();
		System.out.println("- Selection [debut: " + ss + " | fin: " + ee +"]");
	}

/**
 * Couper: Le texte correspondant � la s�lection courante est mis dans le presse-papier et est r�tir� du buffer
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
			System.out.println("- Rien \u00E0� couper!");
		}
	}

/**
 * Copier: Le texte correspondant � la s�lection courante est mis dans le presse-papier
 */
	public void copy() {
		if (selection.getStart() != selection.getEnd()) {
			System.out.println("- Copy [debut: " + selection.getStart()
					+ " | fin: " + selection.getEnd() + "]");
			String text = buffer.getContent(selection);
			clipboard.setContent(text);
		} else {
			System.out.println("- Rien \u00E0� copier!");
		}
	}

/**
 * Copier: Le texte correspondant � la s�lection est remplac� par celui du presse-papier
 */
	public void paste(){
		System.out.println("- Paste [debut: " + selection.getStart() + " | fin: " + selection.getEnd() +"]");
		String text = clipboard.getContent();
		buffer.setContent(text, selection);
		int ss = selection.getStart()+text.length();
		selection.setStartEnd(ss, ss);
	}
	
/**
 * Inserer: La s�lection courante est remplac� par le texte � ins�rer
 * @param mot
 * texte � ins�rer
 */
	public void insert(String mot){
		System.out.println("- Insert [debut: " + selection.getStart() + " | fin: " + selection.getEnd() +"]");
		buffer.setContent(mot,selection);
		int ss = selection.getStart()+mot.length();
		selection.setStartEnd(ss, ss);
	}
	
/**
 * Supprimer: Le texte correspondant � la s�lection courante est r�tir� du buffer
 */
	public void delete(){
		System.out.println("- Delete [debut: " + selection.getStart() + " | fin: " + selection.getEnd() +"]");
		buffer.setContent("",selection);
		int ss = selection.getStart();
		selection.setStartEnd(ss, ss);
	}

/**
 * Cr�er un nouveau MementoEngine � partir de l'�tat courant du moteur
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
 * Restaure l'�tat contenu dans un MementoEngine
 * @see MementoEngine
 * @see HistoryStack
 * @param m
 * l'�tat � restaurer
 * @since 3
 */
	public void setMemento(MementoEngine m) {
		buffer = new Buffer(m.getBuffer());
		selection = new Selection(m.getSelection());
	}

}