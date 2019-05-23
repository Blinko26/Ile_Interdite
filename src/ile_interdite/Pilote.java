package ile_interdite;

import ile_interdite.Aventurier;

public class Pilote extends Aventurier {
    
        private final Utils.Pion cPion;

    public Pilote() {
        super(TypeAventurier.pilote);
        this.cPion = Utils.Pion.BLEU;
        
    }
}