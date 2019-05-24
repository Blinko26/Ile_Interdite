package ile_interdite;

import ile_interdite.Aventurier;
import java.util.ArrayList;

public class Pilote extends Aventurier {
    
    private int ptActionSpeciale; //le pilote a un point d'action spéciale représentant sa capacité à se déplacer en hélicoptère une fois par tour
    public Pilote() {
        super(TypeAventurier.pilote,Utils.Pion.BLEU,"Heliport");
        this.setPtActionSpeciale(); //nombre de points d'action spéciale du pilote
        
    }
    
    public int getPtActionSpeciale() { //retourne le nombre de point d'action spéciale du pilote
        return ptActionSpeciale;
    }
    
    public void setPtActionSpeciale() { //remet le nombre de points d'action spéciale du pilote à 1
        this.ptActionSpeciale =1;
    }
    
    public ArrayList<Tuile> getPossibleMouvementSpecial() { //retourne les cases sur lesquelles le pilote peut se déplacer avec son action spéciale
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