package ile_interdite;

import ile_interdite.Aventurier;
import java.util.ArrayList;

public class Pilote extends Aventurier {
    
    private int ptActionSpeciale; //le pilote a un point d'action spéciale représentant sa capacité à se déplacer en hélicoptère une fois par tour
    public Pilote() {
        super(TypeAventurier.pilote,Utils.Pion.BLEU,"Heliport");
        ptActionSpeciale = 1;
        
    }
    
    public int getPtActionSpeciale() { //retourne le nombre de point d'action spéciale du pilote
        return ptActionSpeciale;
    }
    
    public ArrayList<Tuile> getPossibleMouvementSpecial() {
        ArrayList<Tuile> casesDispo = new ArrayList<>();
        if(this.getPtActionSpeciale() == 1) {
            Tuile tu = this.getPosition();
            Ile ile = tu.getIledescases();
            for(Tuile t : ile.getTuilesNonInondees()) {
                casesDispo.add(t);
            }
        }
        return casesDispo;
    }
}