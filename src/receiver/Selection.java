package receiver;

/**
 * Classe de la selection
 * <br>
 * Selection est caractérisé par:
 * <p>
 * <ul>
 * <li>Un entier start désignant la position du premier caractère sélectionné dans le texte de l'éditeur</li>
 * <li>Un entier end désignant la position du dernier caractère sélectionné</li>
 * </ul>
 * </p>
 * <b>Si start et end sont égaux, la sélection agira alors comme un curseur.</b>
 * @author Archibald Jego & Johan Moreira
 * @version 3
 */

public class Selection {

	private int start;
	private int end;

	public int getStart() {
		return start;
	}
	
	public int getEnd() {
		return end;
	}

/**
 * Constructeur sans paramètre d'une nouvelle sélection, équivalent à un curseur à la position 0
 */
	public Selection() {
		start = 0;
		end = 0;
	}
	
/**
 * Constructeur par clonage d'une sélection à partir d'une autre sélection
 * @since 3
 * @param s
 * une autre sélection
 */
	public Selection (Selection s) {
		start = s.getStart();
		end = s.getEnd();
	}

/**
 * Modifie la position de la sélection
 * @param s
 * début
 * @param e
 * fin
 */
	public void setStartEnd(int s, int e) {
		int tmps;
		int tmpe;
		if(s<=0){tmps = 0;} else{tmps=s;}
		if(e<=0){tmpe = 0;} else{tmpe=e;}
//		if (tmps==tmpe) {throw new ArithmeticException();}
		
		if(tmps>tmpe){
			this.start = tmpe;
			this.end = tmps;
		}
		else{ 
			this.start = tmps;
			this.end = tmpe;
		}
	
	}
}
