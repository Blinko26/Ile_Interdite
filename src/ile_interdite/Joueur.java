package ile_interdite;
        
import ile_interdite.Aventurier;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Comparator;

public class Joueur {
	private int numJoueur; //numéro du joueur
	private String nomJoueur; //nom du joueur
	public ArrayList<CarteTresor> cartesT; //inventaire de cartes trésor du joueur
	public Aventurier roleJoueur; //aventurier associé au joueur
        public int pointAction = 3;
        
        public Joueur(int numJoueur, String nomJoueur, Aventurier roleJoueur){
            this.numJoueur= numJoueur;
            this.nomJoueur = nomJoueur;
            cartesT = new ArrayList<CarteTresor>();
            this.roleJoueur = roleJoueur;
        }

        public int getNumJoueur() { //retourne le numéro du joueur, soit sa place dans le tour
            return numJoueur;
        }

        public String getNomJoueur() { //retourne le nom du joueur
            return nomJoueur;
        }

        public ArrayList<CarteTresor> getCartesT() { //retourne les cartes possedées par le joueur
            return cartesT;
        }

        public Aventurier getRoleJoueur() { //retourne l'aventurier associé au joueur
            return roleJoueur;
        }

        public void setNumJoueur(int numJoueur) { //permet de donner un numéro au joueur
            this.numJoueur = numJoueur;
        }

        public void setNomJoueur(String nomJoueur) { //permet de donner un nom au joueur
            this.nomJoueur = nomJoueur;
        }   

        public void setCartesT(ArrayList<CarteTresor> cartesT) { //permet d'associer un inventaire de cartes à un joueur
            this.cartesT = cartesT;
        }

        public void setRoleJoueur(Aventurier roleJoueur) { //permet d'associer un aventurier au joueur
            this.roleJoueur = roleJoueur;
        }

	public ArrayList<CarteTresor> getCarteSpeciale() { //permet de ne récupérer que les cartes spéciales de ce joueur
		ArrayList<CarteTresor> cartesT = this.getCartesT();
                ArrayList<CarteTresor> cartesS = new ArrayList<>();
                for(CarteTresor c : cartesT) {
                    if(c.getType() == TypeCT.hélicoptère || c.getType() == TypeCT.sac2sable) {
                        cartesS.add(c);
                    }
                }
                return cartesS;
	}

	public void addCarteToJoueur(CarteTresor aCartepioche) { //permet de rajouter une carte à l'inventaire du joueur
		this.cartesT.add(aCartepioche);
	}

	public int getNombreCartesJoueur() { //permet de connaitre le nombre de cartes du joueur
            return this.getCartesT().size();
	}

	public void removeCarte(CarteTresor aDefausseC) { //permet de retirer une carte de l'inventaire du joueur
		this.cartesT.remove(aDefausseC);
        }
        
        public void initPointAction(){
            this.pointAction = 3;
        }
        
        public void removePA(int pa){
            this.pointAction = this.pointAction-pa;
        }
        
        public int getPA(){
            return pointAction;
        }
        
        public boolean peutJouer(){
            if (getPA()>0){
                return true;
            }
            else{
                return false;
            }
        }
}
