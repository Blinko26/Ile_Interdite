package ile_interdite;
public class CarteTresor {
	private TypeCT type;

    public TypeCT getType() {
        return type;
    }

    public void setType(TypeCT type) {
        this.type = type;
    }

    public Joueur getJoueur() {
        return joueur;
    }

    public void setJoueur(Joueur joueur) {
        this.joueur = joueur;
    }
	public Joueur joueur;
}