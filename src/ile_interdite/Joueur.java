import ile_interdite.Aventurier;
import java.util.Vector;

public class Joueur {
	private int[] numjoueur;
	private String nomJoueur;
	public Vector<CarteTresor> _deck = new Vector<CarteTresor>();
	public Aventurier roleJoueur;
        

	public void PossibleMouvement() {
		throw new UnsupportedOperationException();
	}

	public void setPosition(Object aNumJ) {
		throw new UnsupportedOperationException();
	}

	public TypeAventurier getRole(Joueur aJoueur) {
		throw new UnsupportedOperationException();
	}

	public int getPointAction() {
		throw new UnsupportedOperationException();
	}

	public int getAction(Joueur aJ) {
		throw new UnsupportedOperationException();
	}

	public Aventurier getMouvement(Joueur aJ) {
		throw new UnsupportedOperationException();
	}

	public Tresor getTresor(Joueur aJ) {
		throw new UnsupportedOperationException();
	}

	public EtatC getAssechement(Aventurier aJ) {
		throw new UnsupportedOperationException();
	}

	public CarteTresor getDonnerCarte(TypeAventurier aJ) {
		throw new UnsupportedOperationException();
	}

	public CarteTresor getCarteSpeciale(TypeAventurier aJ) {
		throw new UnsupportedOperationException();
	}

	public void addCarteToJoueur(Joueur aJ, CarteTresor aCartepioche) {
		throw new UnsupportedOperationException();
	}

	public int getNombreCartesJoueur(Joueur aJ) {
		throw new UnsupportedOperationException();
	}

	public CarteTresor getDefausseCarte(Joueur aJ) {
		throw new UnsupportedOperationException();
	}

	public void removeCarte(CarteTresor aDefausseC) {
		throw new UnsupportedOperationException();
	}
}