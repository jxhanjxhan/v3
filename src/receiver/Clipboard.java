package receiver;

/**
 * Classe du presse-papier
 * <br>
 * Clipboard contient le texte qui est gard� dans le presse-papier durant l'utilisation de l'�diteur
 * @author Archibald Jego & Johan Moreira
 * @version 1
 */
public class Clipboard {

	private StringBuffer content;

/**
 * Constructeur sans param�tre d'un nouveau presse-papier, vide
 */	
	public Clipboard() {
		content = new StringBuffer("");
	}

	public String getContent() {
		return content.toString();
	}
	
	public StringBuffer getContentStrBuff() {
		return content;
	}

	public void setContent(String text) {
		content.replace(0, content.length(), text);
	}
}
