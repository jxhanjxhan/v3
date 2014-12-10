package main;

import history.HistoryStack;
import java.util.Scanner;
import memento.*;
import receiver.EditorEngine;
import receiver.Recorder;
import commands.*;

/**
 * Classe principale de l'�diteur
 * <br>
 * Un �diteur est caract�ris� par les informations suivantes :
 * <p>
 * <ul>
 * <li>Un EditorEngine, qui traite les commandes primaires et leurs r�percutions dans l'�diteur.</li>
 * <li>Un Recorder, qui traite les commandes d'enregistrement.</li>
 * <li>Un HystoryStack qui g�re l'historique de l'�diteur et traite les commandes Undo et Redo</li>
 * </ul>
 * </p>
 * @author Archibald Jego & Johan Moreira
 * @version 3
 */
public class MiniEditor {

	private EditorEngine ee;
	private Recorder r;
	private HistoryStack h;

	private String stringFournie;
	
/**
 * Constructeur sans param�tre d'un nouvel �diteur
 */
	public MiniEditor() {
		ee = new EditorEngine();
		r = new Recorder();
		h = new HistoryStack(ee);
	}

/**
 * Cette fonction n'est pas utilis�e
 * @return la chaine de caract�re � ins�rer en court de traitement
 */
	public String getStringFournie() {
		return stringFournie;
	}

/**
 * Affichage de l'�diteur utilis� par l'interface.
 * La selection est situ�e au dessus pour connaitre son emplacement par rapport au texte.
 * \/ correspond � une position, ___ correspond � une s�lection.
 * @return le contenu de l'�diteur et la s�lection courante
 */
	public String toString() {
		//curseur ou selection
		int start = ee.getSelection().getStart();
		int end = ee.getSelection().getEnd();
		String select = "Curseur:     ";
		for (int i = 0; i < end; i++) {
			if (i < start) {select += " ";}
			if (i >= start) {select += "_";}
		}
		if (start == end) {
			select = select.substring(0, select.length() - 1); // retire un espace...
			select += "\\/"; //... pour mettre le curseur
		}
		// texte
		String text = "Votre texte: " + ee.getBuffer().getContent();
		return select+"\n"+text;
	}

/**
 * Cette fonction analyse les commandes de l'interface et les traite de la facon suivante:
 * <p><ul>
 * <li>Si aucun enregistrement est en court un nouvel objet Commande est cr�e pour l'EditorEngine (v1)
 * <li>Si un enregistrement est en court, un objet CommandeRec est cr�� pour l'EditorEngine, aujout� au Recorder et ex�cut� (v2)
 * <li>Les commandes Recorde, End, Play sont directement renvoy� au Recorder (v2)
 * <li>Les commandes qui modifient le contenu de l'�diteur demande � l'HystoryStack d'ajouter un nouvel �tat (v3)
 * <li>Les commandes Undo et Redo sont directement renvoy� � l'HystoryStack (v3)
 * </ul></p>
 * @param c
 * caract�re correspondant � la commande tap�e dans l'interface
 */
	public void command(Character c) {
		switch (c) {

		case 'C': {

			if (r.isRecording()) {
				CmdCopyRec com = new CmdCopyRec(ee);
				Memento m = new Memento(com);
				r.add(m);
				com.execute();
			} else {
				new CmdCopy(ee).execute();
			}
			break;
		}

		case 'X': {
			
			h.add();
			
			if (r.isRecording()) {
				CmdCutRec com = new CmdCutRec(ee);
				Memento m = new Memento(com);
				r.add(m);
				com.execute();
			} else {
				new CmdCut(ee).execute();
			}
			break;
		}

		case 'V': {
			
			h.add();
			
			if (r.isRecording()) {
				CmdPasteRec com = new CmdPasteRec(ee);
				Memento m = new Memento(com);
				r.add(m);
				com.execute();
			} else {
				new CmdPaste(ee).execute();
			}
			break;
		}

		case 'D': {
			
			h.add();
			
			if (r.isRecording()) {
				CmdDeleteRec com = new CmdDeleteRec(ee);
				Memento m = new Memento(com);
				r.add(m);
				com.execute();
			} else {
				new CmdDelete(ee).execute();
			}
			break;
		}

		case 'I': {
			System.out.println("Tapez le texte \u00E0� ins\u00E9rer:");
			Scanner sc = new Scanner(System.in);
			String str = sc.nextLine();
			stringFournie = str;
			
			h.add();
			
			if (r.isRecording()) {
				CmdInsertRec com = new CmdInsertRec(ee);
				Memento m = new Memento(com);
				m.setString(str);
				r.add(m);
				m.execute();
			} else {
				new CmdInsert(ee).execute(str);
			}
			
			break;
		}

		case 'S': {
			int start = 0,end = 0;
			try {
				Scanner sc = new Scanner(System.in);
				System.out.println("Tapez le debut de la selection");
				start = sc.nextInt();
				System.out.println("Tapez la fin de la selection");
				end = sc.nextInt();
				
			} catch (Exception e) {
				System.out.println("Nombre invalide!");
				break;
				
			}
			
			h.add();
			
			if (r.isRecording()) {
				CmdSelectRec com = new CmdSelectRec(ee);
				Memento m = new Memento(com);
				m.setStartEnd(start, end);
				r.add(m);
				m.execute();
			} else {
				new CmdSelect(ee).execute(start, end);
			}
			
			break;
		}

		case 'R': {
			r.start();
			break;
		}

		case 'E': {
			r.stop();
			break;
		}

		case 'P': {
			
			h.add();
			
			r.play();
			break;
		} 
		
		case 'Z': {
			h.undo();
			break;
		} 
		
		case 'Y': {
			h.redo();
			break;
		} 

		case 'Q': {
			System.out.println("Bye!");
			break;
		}

		default: {
			System.out.println("Commande invalide. Recommencez!");
		}
		}
	}
}
