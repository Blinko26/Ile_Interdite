package ile_interdite;

import ile_interdite.Aventurier;
import util.Utils.Pion;

public class Ingénieur extends Aventurier {
    
    private final Pion cPion;

    public Ingénieur(TypeAventurier type,Joueur joueur) {
        super(type,joueur);
        this.cPion = Pion.ROUGE;
    }
}