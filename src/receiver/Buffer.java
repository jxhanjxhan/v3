package receiver;

/**
 * Classe du buffer
 * <br>
 * Buffer contient le texte manipulé par l'éditeur
 * @author Archibald Jego & Johan Moreira
 * @version 3
 */
public class Buffer {

	private StringBuffer text;

/**
 * Constructeur sans paramètre d'un nouveau buffer, vide
 */
	public Buffer() {
		text = new StringBuffer("");
	}
	
/**
 * Constructeur par clonage d'un buffer à partir d'un autre buffer
 * @since 3
 * @param b
 * un autre buffer
 */
	public Buffer(Buffer b) {
		text = new StringBuffer(b.getContent());
	}
	
	public void setText(StringBuffer strb){
		text=strb;
	}
	
/**
 * @return le contenu du buffer
 */
	public String getContent(){
		return text.toString();
	}

/**
 * @param sel
 * une selection
 * @return le contenu du buffer entre les bornes de la selection
 */
	public String getContent(Selection sel){
	/*	int tmps;
		int tmpe;
		if(sel.getStart()>=text.toString().length()){tmps = Math.max(text.toString().length()-1,0) ;} else{tmps=sel.getStart();}
		if(sel.getEnd()>=text.toString().length()){tmpe = Math.max(text.toString().length()-1,0) ;} else{tmpe=sel.getEnd();}
	*/	
		return text.substring(sel.getStart(), sel.getEnd());
	}
	
/**
 * Insert du texte dans le buffer à l'endroit indiqué par la sélection (peut remplacer du texte)
 * @param t
 * texte à insérer
 * @param sel
 * position d'insertion du texte
 */
	public void setContent(String t, Selection sel) {
		int tmps;
		int tmpe;
		if(sel.getStart()>=text.toString().length()){tmps = text.toString().length();} else{tmps=sel.getStart();}
		if(sel.getEnd()>=text.toString().length()){tmpe = text.toString().length() ;} else{tmpe=sel.getEnd();}
//		tmps=sel.getStart();
//		tmpe=sel.getEnd();
		
		if (tmps != tmpe) {
			text.replace(tmps, tmpe, t);
		} else {
			text.insert(tmps, t);
		}
	}
}
