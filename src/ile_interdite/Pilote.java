package ile_interdite;

import ile_interdite.Aventurier;
import util.Utils.Pion;

public class Pilote extends Aventurier {
    
        private final Pion cPion;

    public Pilote(TypeAventurier type,Joueur joueur) {
        super(type,joueur);
        this.cPion = Pion.BLEU;
        
    }
}