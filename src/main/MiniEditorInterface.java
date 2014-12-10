package main;

import java.util.Scanner;


/**
 * Classe d'interface de l'éditeur, en ligne de commande
 * 
 * @author Archibald Jego & Johan Moreira
 * @version 3
 */

public class MiniEditorInterface {
	
/**
 * Fonction principale qui créé un nouvelle éditeur, scan les commandes de l'utilisateur, et les renvoie à l'éditeur
 */
	public static void main(String[] args) {
		
		MiniEditor editor = new MiniEditor();
		
		boolean b = true;

		while (b){
			Scanner sca = new Scanner(System.in);
			System.out.println(editor);
			System.out.println("Entrez une commande: [I]nsert [S]elect [C]opy [X]Cut [V]Paste [D]elete [Q]uit");
			System.out.println("                     [R]ecord [E]nd [P]lay    [Z]Undo [Y]Redo");
			String s =  sca.nextLine()+" ";
			char c = Character.toUpperCase(s.charAt(0));
			editor.command(c);
			if(c=='Q') {b=false;}
		}
	}
}
