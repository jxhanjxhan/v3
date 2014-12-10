package memento;

/**
 * Classe memento pour l'enregistrement d'une commande, contient:
 * <p>
 * <ul>
 * <li>Une commande enregistrable.</li>
 * <li>Un entier s et e pour le cas des selections.</li>
 * <li>Un chaine de texte t pour le cas des insertions.</li>
 * </ul>
 * </p>
 * @author Archibald Jego & Johan Moreira
 * @version 2
 */
public class Memento {
	
    private CommandRec c;
    private int s;
    private int e;
    private String t;

/**
 * Constructeur d'un memento de commande enregistrable, � partir de cette commande
 * @param c
 * la commande enregistrable � enregistrer
 */
    public Memento (CommandRec c) {
    	this.c=c;
    }
    
    public void setString(String s) {
    	this.t=s;
    }
    
	public void setStartEnd(int s, int e) {
		this.s=s;
		this.e=e;
	}

/**
 * Les commandes doivent etre executables qu'elles prennent en param�tre une selection, du texte, 
 * ou aucun argument, pour ne pas avoir � les diff�rencier
 */	
    public void execute(){
    	c.execute(s,e,t);
    }

}
