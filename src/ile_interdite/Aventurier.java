package ile_interdite;

import java.awt.Color;

public abstract class Aventurier {
	private TypeAventurier type;
	private int[] emplacement;
	public Joueur joueur;
	public Tuile position;

        public Aventurier(TypeAventurier type,Joueur joueur) {
            this.type = type;
            this.joueur = joueur;
        }
        
	public void getTuile() {
		throw new UnsupportedOperationException();
	}

	public void PossibleMouvement() {
		throw new UnsupportedOperationException();
	}
}