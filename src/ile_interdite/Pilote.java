package ile_interdite;

import ile_interdite.Aventurier;

public class Pilote extends Aventurier {
    
        private final Utils.Pion cPion; //le pilote a un type de pion
        private int ptActionSpeciale; //le pilote a un point d'action spéciale représentant sa capacité à se déplacer en hélicoptère une fois par tour

    public Pilote() {
        super(TypeAventurier.pilote);
        this.cPion = Utils.Pion.BLEU;
        this.ptActionSpeciale = 1;
        
    }
    
    public int getPtActionSpeciale() { //retourne le nombre de point d'action spéciale du pilote
        return ptActionSpeciale;
    }
}