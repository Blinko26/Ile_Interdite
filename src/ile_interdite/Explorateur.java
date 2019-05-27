package ile_interdite;

import ile_interdite.Aventurier;
import java.util.ArrayList;

public class Explorateur extends Aventurier {
   

    public Explorateur() {
        super(TypeAventurier.explorateur,Utils.Pion.VERT,"La Porte de Cuivre");
    }

    
    public ArrayList<Tuile> getMouvementPossible() { //retourne les cases sur lesquelles l'explorateur peut se déplacer en fonction de sa position
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
    public ArrayList<Tuile> CasesAssechables() { //retourne les cases asséchables par l'explorateur
            ArrayList<Tuile> casesAsech = new ArrayList<>();
            Tuile tu = this.getPosition();
            if(tu.getEtat() == EtatC.innondée) {
                casesAsech.add(tu);
            }
            Ile ile = tu.getIledescases();
            for(int i[] : tu.getTuilesAdj()) {
                Tuile t = ile.getTuile(i[0],i[1]);
                if(t.getEtat() == EtatC.innondée) {
                    casesAsech.add(t);
                }
            }
            for(int j[] : tu.getTuilesDiag()) {
                Tuile t2 = ile.getTuile(j[0],j[1]);
                if(t2.getEtat() != EtatC.innondée) {
                    casesAsech.add(t2);
                }
        
            }
        return casesAsech;
}