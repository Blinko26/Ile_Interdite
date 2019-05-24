package ile_interdite;

import ile_interdite.Aventurier;

public class Pilote extends Aventurier {
    
    private int ptActionSpeciale; //le pilote a un point d'action spéciale représentant sa capacité à se déplacer en hélicoptère une fois par tour
    public Pilote() {
        super(TypeAventurier.pilote,Utils.Pion.BLEU,"Heliport");

        
    }
    
    public int getPtActionSpeciale() { //retourne le nombre de point d'action spéciale du pilote
        return ptActionSpeciale;
    }
}