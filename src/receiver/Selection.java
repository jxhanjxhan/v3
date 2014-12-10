package receiver;

/**
 * Classe de la selection
 * <br>
 * Selection est caract�ris� par:
 * <p>
 * <ul>
 * <li>Un entier start d�signant la position du premier caract�re s�lectionn� dans le texte de l'�diteur</li>
 * <li>Un entier end d�signant la position du dernier caract�re s�lectionn�</li>
 * </ul>
 * </p>
 * <b>Si start et end sont �gaux, la s�lection agira alors comme un curseur.</b>
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
 * Constructeur sans param�tre d'une nouvelle s�lection, �quivalent � un curseur � la position 0
 */
	public Selection() {
		start = 0;
		end = 0;
	}
	
/**
 * Constructeur par clonage d'une s�lection � partir d'une autre s�lection
 * @since 3
 * @param s
 * une autre s�lection
 */
	public Selection (Selection s) {
		start = s.getStart();
		end = s.getEnd();
	}

/**
 * Modifie la position de la s�lection
 * @param s
 * d�but
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
