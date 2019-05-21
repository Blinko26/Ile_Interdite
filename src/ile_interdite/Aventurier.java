package ile_interdite;

import java.awt.Color;
import java.util.Comparator;

public abstract class Aventurier {
	private TypeAventurier type;
	private int[] emplacement;
	public Joueur joueur;
	public Tuile position;
        
        public Aventurier(TypeAventurier type,Joueur joueur) {
            this.type = type;
            this.joueur = joueur;
        }

    public TypeAventurier getType() {
        return type;
    }

    public int[] getEmplacement() {
        return emplacement;
    }

    public Joueur getJoueur() {
        return joueur;
    }

    public Tuile getPosition() {
        return position;
    }

    public void setType(TypeAventurier type) {
        this.type = type;
    }

    public void setEmplacement(int[] emplacement) {
        this.emplacement = emplacement;
    }

    public void setJoueur(Joueur joueur) {
        this.joueur = joueur;
    }

    public void setPosition(Tuile position) {
        this.position = position;
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