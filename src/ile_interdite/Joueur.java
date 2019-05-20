package ile_interdite;
        
import ile_interdite.Aventurier;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Comparator;

public class Joueur {
	private int numJoueur;
	private String nomJoueur;
	public ArrayList<CarteTresor> cartesT = new ArrayList<CarteTresor>();
	public Aventurier roleJoueur;
        
        public Joueur(int numJoueur, String nomJoueur, Aventurier roleJoueur){
            this.numJoueur= numJoueur;
            this.nomJoueur = nomJoueur;
            cartesT = new ArrayList<CarteTresor>();
            this.roleJoueur = roleJoueur;
        }

        public int getNumJoueur() {
            return numJoueur;
        }

        public String getNomJoueur() {
            return nomJoueur;
        }

        public ArrayList<CarteTresor> getCartesT() {
            return cartesT;
        }

        public Aventurier getRoleJoueur() {
            return roleJoueur;
        }

        public void setNumJoueur(int numJoueur) {
            this.numJoueur = numJoueur;
        }

        public void setNomJoueur(String nomJoueur) {
            this.nomJoueur = nomJoueur;
        }   

        public void setCartesT(ArrayList<CarteTresor> cartesT) {
            this.cartesT = cartesT;
        }

        public void setRoleJoueur(Aventurier roleJoueur) {
            this.roleJoueur = roleJoueur;
        }

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