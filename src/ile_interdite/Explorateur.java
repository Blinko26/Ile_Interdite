package ile_interdite;

import ile_interdite.Aventurier;
import java.util.ArrayList;

public class Explorateur extends Aventurier {
   

    public Explorateur() {
        super(TypeAventurier.explorateur,Utils.Pion.VERT,"La Porte de Cuivre");
    }

    
    public ArrayList<Tuile> getMouvementPossible() {
        ArrayList<Tuile> casesDisp = new ArrayList<>();
        Tuile tu = this.getPosition();
        Ile ile = tu.getIledescases();
        for(int i[] : tu.getTuilesAdj()) {
            Tuile t = ile.getTuile(i[0],i[1]);
            if(t.getEtat() != EtatC.sombrée) {
                casesDisp.add(t);
            }
        for(int j[] : tu.getTuilesDiag()) {
            Tuile t2 = ile.getTuile(j[0],j[1]);
            if(t.getEtat() != EtatC.sombrée) {
                casesDisp.add(t2);
            }
        
        }
    }
        return casesDisp;


}
}