package ile_interdite;

public abstract class Aventurier {
	private TypeAventurier type;
	private int[] emplacement;
	public Joueur joueur;
	public Tuile position;

	public void getTuile() {
		throw new UnsupportedOperationException();
	}

	public void PossibleMouvement() {
		throw new UnsupportedOperationException();
	}
}