package receiver;

import java.util.ArrayList;
import java.util.Iterator;

import memento.Memento;

/**
 * Classe d'un enregistreur
 * <br>
 * Recorder permet de g�rer l'enregistrement des commandes et contient:
 * <p>
 * <ul>
 * <li>Une liste de Memento de commandes enregistrables (les commandes enregistr�s)</li>
 * <li>Un bool�en permetant de savoir si l'enregistrement est en cours ou non</li>
 * </ul>
 * </p>
 * @author Archibald Jego & Johan Moreira
 * @version 2
 */

public class Recorder {

	private ArrayList<Memento> lm;
	private boolean isRecording;

/**
 * Constructeur sans param�tre d'un nouvel enregistreur
 */
	public Recorder() {
		lm = new ArrayList<Memento>();
		isRecording = false;
	}

/**
 * Ajoute un Memento � l'enregistrement	
 * @param m
 * Memento de commande enregistrable � ajouter
 */
	public void add(Memento m) {
		if (isRecording) {
			lm.add(m);
		}
	}

/**
 * Joue l'enregistrement, si un enregistrement est cours il est d'abord arr�t�	
 */
	public void play() {
		if(isRecording) {
			this.stop();
		}
		if (lm.isEmpty()) {
			System.out.println("- Aucune commande enregistr\u00E9e!");
		} else {
			System.out.println("- Lecture de l'enregistrement");
			Iterator<Memento> it = lm.iterator();

			while (it.hasNext()) {
				Memento m = it.next();
				m.execute();
			}
		}
	}

/**
 * Lance un nouvel enregistrement, effacant l'enregistrement pr�c�dent
 */
	public void start() {
		System.out.println("- Debut de l'enregistrement");
		lm = new ArrayList<Memento>(); //remet l'enregistrement � zero
		isRecording = true;
	}

/**
 * Arrete l'enregistrement en cours
 */
	public void stop() {
		if(!isRecording) {
			System.out.println("- Pas d'enregistrement en cours");
		}
		else {
		System.out.println("- Fin de l'enregistrement");
		isRecording = false;
		}
	}

	public boolean isRecording() {
		return isRecording;
	}
}