package ile_interdite;
public class CarteTresor {
	private TypeCT type; //type de carte trésor
        public Joueur joueur; //joueur possèdant la carte
        
    public CarteTresor(TypeCT type){
            this.type=type;
            this.joueur=null;
    }
        
    public TypeCT getType() { //retourne le type de la carte
        return type;
    }

    public void setType(TypeCT type) { //permet de donner un type à la carte
        this.type = type;
    }

    public Joueur getJoueur() { //retourne le joueur possèdant la carte
        return joueur;
    }

    public void setJoueur(Joueur joueur) { //permet d'associer la carte à un joueur
        this.joueur = joueur;
    }
}