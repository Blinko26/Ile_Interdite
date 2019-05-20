package ile_interdite;

import java.util.ArrayList;


public class Application {
	public Ile ile;
	public Niveaudo niveaudeau;
	public ArrayList<Tresor> trésors = new ArrayList<Tresor>();
	public ArrayList<CarteInondation> cartesInondation = new ArrayList<CarteInondation>();
	public ArrayList<Joueur> joueurs = new ArrayList<Joueur>();
	public ArrayList<CarteTresor> cartesTresor = new ArrayList<CarteTresor>();

        public void initPartie(){   //Initialisation de la partie==> Cases aventurier et Inscrire joueurs avec leur pion
            //Initialisation de l'ile (carte)
            
        }
        
        public void initMap(){
            
        }
        
        
	public void getPointAction(Object aNumJ) {
		throw new UnsupportedOperationException();
	}

	public void typeAventurier(Object aNumJ) {
		throw new UnsupportedOperationException();
	}

	public void DemandeMouvement(Object aNumJ) {
		throw new UnsupportedOperationException();
	}

	private void TourJeu() {
		throw new UnsupportedOperationException();
	}

	public Joueur getJoueur(int aNumJoueur) {
		throw new UnsupportedOperationException();
	}

	public CarteTresor getCartetresor(Joueur aJoueur) {
		throw new UnsupportedOperationException();
	}

	public void addDefausseCarte(CarteTresor aDefausseC) {
		throw new UnsupportedOperationException();
	}

	public void getCarteInondation(CarteInondation aJoueur) {
		throw new UnsupportedOperationException();
	}
}