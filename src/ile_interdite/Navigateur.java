package ile_interdite;

import ile_interdite.Aventurier;
import util.Utils.Pion;

public class Navigateur extends Aventurier {
    
    private final Pion cPion;

    public Navigateur(TypeAventurier type,Joueur joueur) {
        super(type,joueur);
        this.cPion = Pion.JAUNE;
    }
    
}