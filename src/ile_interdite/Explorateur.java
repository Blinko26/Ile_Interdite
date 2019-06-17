package ile_interdite;

import ile_interdite.Aventurier;
import java.util.ArrayList;

public class Explorateur extends Aventurier {
   

    public Explorateur() {
        super(TypeAventurier.explorateur,Utils.Pion.VERT,"La Porte de Cuivre");
    }

    @Override
    public ArrayList<Tuile> PossibleMouvement() { //retourne les cases sur lesquelles l'explorateur peut se déplacer en fonction de sa position
        ArrayList<Tuile> casesDisp = new ArrayList<>();
        Tuile tu = this.getPosition();
        for(int i[] : tu.getTuilesAdj()) {
            Tuile t = tu.getIledescases().getTuile(i[0],i[1]);
            if(t.getEtat() != EtatC.sombrée) {
                casesDisp.add(t);
            }
	}
        for(int i[] : tu.getTuilesDiag()) {
            Tuile t = tu.getIledescases().getTuile(i[0],i[1]);
            if(t.getEtat() != EtatC.sombrée) {
                casesDisp.add(t);
            }
	}
        return casesDisp;
    }
    
    @Override
    public ArrayList<Tuile> getTuileAssechable(){
        Ile ile = position.getIledescases();
        ArrayList<Tuile> casesAssechable = new ArrayList<>();
        for (int tuile[]: position.getTuilesAdj()) {
            if(ile.getTuile(tuile[0],tuile[1]).getEtat()==EtatC.innondée){
                casesAssechable.add(ile.getTuile(tuile[0],tuile[1]));
            }
        }
        
        for (int tuile[]: position.getTuilesDiag()) {
            if(ile.getTuile(tuile[0],tuile[1]).getEtat()==EtatC.innondée){
                casesAssechable.add(ile.getTuile(tuile[0],tuile[1]));
            }
        }
        
        if(position.getEtat()==EtatC.innondée){
            casesAssechable.add(position);
        }
        
        return casesAssechable;
    }
}