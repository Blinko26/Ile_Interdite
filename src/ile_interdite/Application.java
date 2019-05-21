package ile_interdite;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Application {
	public Ile ile;
	public Niveaudo niveaudeau;
	public ArrayList<Tresor> trésors = new ArrayList<Tresor>();
	public ArrayList<CarteInondation> cartesInondation = new ArrayList<CarteInondation>();
	public ArrayList<Joueur> joueurs = new ArrayList<Joueur>();
	public ArrayList<CarteTresor> cartesTresor = new ArrayList<CarteTresor>();


        public void initPartie(int nombreJoueur, Joueur j){   //Initialisation de la partie==> Cases aventurier et Inscrire joueurs avec leur pion
            
            for (int i=0; i<nombreJoueur; i++) {
                addJoueur(j);
            }
        }
        
        public Joueur initJoueurs(int numJoueur, String nomJoueur, Aventurier roleJoueur) {  //Initialisation du joueur==> Nom, Numéro, Couleur, Type d'aventurier et pile de cartes persos(vide)
            Joueur j = new Joueur(numJoueur, nomJoueur, roleJoueur);
            return j;
        }
        
        public boolean addJoueur(Joueur j) {
            boolean i;
            i=true;
            
            for (Joueur test : joueurs) {
                if (test.getNumJoueur()==j.getNumJoueur()){
                    i=false;
                }
                else{
                    if (test.getNomJoueur().contentEquals(j.getNomJoueur())){
                        i=false;
                    }
                    else{
                        if (test.getRoleJoueur()==j.getRoleJoueur()){
                            i=false;
                        }
                    }
                }
            }
            
            if (i==true) {
                joueurs.add(j);
                return true;
            }
            else{
                return false;
            }
        }

    public Ile getIle() {
        return ile;
    }

    public Niveaudo getNiveaudeau() {
        return niveaudeau;
    }

    public ArrayList<Tresor> getTrésors() {
        return trésors;
    }

    public ArrayList<CarteInondation> getCartesInondation() {
        return cartesInondation;
    }

    public ArrayList<Joueur> getJoueurs() {
        return joueurs;
    }

    public ArrayList<CarteTresor> getCartesTresor() {
        return cartesTresor;
    }

    public void setIle(Ile ile) {
        this.ile = ile;
    }

    public void setNiveaudeau(Niveaudo niveaudeau) {
        this.niveaudeau = niveaudeau;
    }

    public void setTrésors(ArrayList<Tresor> trésors) {
        this.trésors = trésors;
    }

    public void setCartesInondation(ArrayList<CarteInondation> cartesInondation) {
        this.cartesInondation = cartesInondation;
    }

    public void setJoueurs(ArrayList<Joueur> joueurs) {
        this.joueurs = joueurs;
    }

    public void setCartesTresor(ArrayList<CarteTresor> cartesTresor) {
        this.cartesTresor = cartesTresor;
    }
    
    public void initMap(){   
            ile = new Ile();

            int eR[][] = {{1,3},{1,4},{2,2},{2,3},{2,4},{2,5},{3,1},{3,2},{3,3},{3,4},{3,5},{3,6},{4,1},{4,2},{4,3},{4,4},{4,5},{4,6},{5,2},{5,3},{5,4},{5,5},{6,3},{6,4}}; //Emplacement à attribuer restant
            int i = 0;
            int j = 0;
            
            ArrayList<Integer> emplacements = new ArrayList<>();
            ArrayList<String> noms = Utils.getNomsTuiles();
            

            for (Tuile tuile:ile.getCase2ile()){ //Atribution des emplacements restants aux tuiles restantes et attribution d'un nom
                if (tuile.getEmplacementX()==0 && tuile.getEmplacementY()==0) {
                    i=(int)((Math.random()*24));
                    while(eR[i][0]==0){
                        i=(int)((Math.random()*24));
                    }
                    tuile.setEmplacement(eR[i][0],eR[i][1]);
                    tuile.setNom(noms.get(j));
                    j++;
                    eR[i][0]=0;
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