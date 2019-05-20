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
            ile = new Ile();
            int eR[] = {3,4,8,9,10,11,13,14,15,16,17,18,19,20,21,22,23,24,26,27,28,29,33,34}; //Emplacement à attribuer restant
            int i = 0;
            
            ArrayList<Integer> emplacements = new ArrayList<>();
            
            for (Tuile tuile:ile.getCase2ile()){
                if (tuile.getEmplacement()==0) {
                    tuile.setEmplacement(eR[i]);
                    
                }
            }    
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