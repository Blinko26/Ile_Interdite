package ile_interdite;

import java.awt.Color;
import java.util.Comparator;
import java.util.Scanner;

public abstract class Aventurier {
	private TypeAventurier type;
	private int [] emplacement={0,0};
        private final Utils.Pion cPion;
        private String tuiledepart;
        public Tuile position;
        
        public Aventurier(TypeAventurier type,Utils.Pion pion,String depart) {
            this.type = type;
            this.cPion=pion;
            this.tuiledepart=depart;
        }

    public TypeAventurier getType() {
        return type;
    }

    public int[] getEmplacement() {
        return emplacement;
    }

    public Tuile getPosition() {
        return position;
    }
    
    public Color getCouleur() {
        return cPion.getCouleur();
    }
    public String getDepart(){
        return tuiledepart;
    }

    public void setType(TypeAventurier type) {
        this.type = type;
    }

    public void setEmplacement(int emplacementX,int emplacementY) {
        this.emplacement[0] = emplacementX;
        this.emplacement[1] = emplacementY;
    }

    public void setPosition(Tuile position) {
        this.position = position;
    }
    
    public void getMouvement(){
            
    }
        
	public void getTuile() {
		throw new UnsupportedOperationException();
	}

	public void PossibleMouvement() {
		throw new UnsupportedOperationException();
	}
        
        public static final Comparator<Aventurier> TriAventurierType = new Comparator<Aventurier>() {
        @Override
        public int compare(Aventurier a1, Aventurier a2) {
            if (a1.getType()==a2.getType()) {
                return 1;
            }
        
            else {
                return -1;
            }
        }
    };
}