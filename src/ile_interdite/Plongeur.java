package ile_interdite;

import ile_interdite.Aventurier;
import util.Utils.Pion;

public class Plongeur extends Aventurier {
    
    private final Pion cPion;

    public Plongeur(TypeAventurier type,Joueur joueur) {
        super(type,joueur);
        this.cPion = Pion.NOIR;
        
    }
}