package ile_interdite;

import java.util.ArrayList;
import java.util.Scanner;

public class Explorateur extends Aventurier {
    
    private final Utils.Pion cPion;

    public Explorateur(TypeAventurier type,Joueur joueur) {
        super(TypeAventurier.pilote);
        this.cPion = Utils.Pion.VERT;
    }
    
    public ArrayList<Tuile> getMouvementPossible() {
        ArrayList<Tuile> casesDisp = new ArrayList<>();
        Tuile tu = this.getPosition();
        Ile ile = tu.getIledescases();
        for(int i[] : tu.getTuilesAdj()) {
            Tuile t = ile.getTuile(i[1],i[2]);
            if(t.getEtat() != EtatC.sombrée) {
                casesDisp.add(t);
            }
        for(int j[] : tu.getTuilesDiag()) {
            Tuile t2 = ile.getTuile(j[1],j[2]);
            if(t.getEtat() != EtatC.sombrée) {
                casesDisp.add(t2);
            }
        
        }
    }
        return casesDisp;
    }
}