package ile_interdite;

import ile_interdite.Aventurier;
import java.util.ArrayList;
import java.util.Collections;

public class Plongeur extends Aventurier {
    
    ArrayList<Tuile> casesAdjacentes = new ArrayList<>();

    
    public Plongeur() {
        super(TypeAventurier.plongeur,Utils.Pion.NOIR,"La Porte de Fer");
        
    }
    
    public ArrayList<Tuile> getCasesAdjacentes(){ //retourne les cases adjacentes à la case où le plongeur se trouve
        return casesAdjacentes;   
    }
    
    @Override
    public ArrayList<Tuile> PossibleMouvement() { //retourne les cases sur lesquelles le plongeur peut se déplacer en fonction de sa position
        //Cette ArrayList retournera les tuiles où le plongeur pourra aller
        ArrayList<Tuile> casesDisp = new ArrayList<>();
        //Cette ArrayList contient les cases INONDEES ou IMMERGEES qui permettront d'avoir un chemin qui perùettront d'avoir les cases Dispos
        ArrayList<Tuile> casesContigues = new ArrayList<>();

        //On vide les ArrayList pour eviter d'avoir des doublons.
        casesDisp.clear();
        casesContigues.clear();
        //On get la position du plongeur
        Tuile tu = this.getPosition();
        Ile ile = tu.getIledescases();

        for(int i[] : tu.getTuilesAdj()) {
            //On check ses tuiles adjacentes pour voir si :
            // 1 : si elle est sombrée on ne peut pas s'arreter dessus donc on l'add pas dans casesDisp mais dans casesContigues si
            // 2 : si innondée : on peut s'arreter dessus et ça peut servir de chemin donc casesContigues et casesDisp
            // 3 : si normale : on ne peut que s'arreter dessus
            Tuile t = ile.getTuile(i[0],i[1]);
            if (t.getType()!=TypeC.nulle) {
                switch(t.getEtat()){
                    case sombrée :
                            casesContigues.add(t);
                        break;

                    case innondée : 
                            casesContigues.add(t);
                            casesDisp.add(t);
                        break;

                    case normale : 
                            casesDisp.add(t);
                            break;
                }
            }

        }
        //On creer un nouvel arrayList car on ne peut pas utilise casesContigues car on le modifie : ConcurrentModificationException !!!
        ArrayList<Tuile> casesContigues2 = new ArrayList<>();
        //Distance max de la carte = 6 cases du coup on boucle 6 fois
        for(int j=0;j<6;j++){
           //Pour chaque tuiles appartenant à l'arrayList casesContigues, on regarde ses tuiles adjacentes
            for(Tuile tuile: casesContigues){
                for(int i[] : tuile.getTuilesAdj()) {
                    //On get les coordonnées des tuiles adjacentes
                    Tuile tuileadj = ile.getTuile(i[0],i[1]);
                    //Si la tuile concernée n'est pas une Mer et on evite les doublons dans les ArrayList
                    if (tuileadj.getType()!=TypeC.nulle &&!casesDisp.contains(tuileadj) && !casesContigues.contains(tuileadj) && !casesContigues2.contains(tuileadj) && tuileadj!=tu) {
                        switch(tuileadj.getEtat()){
                            case sombrée :
                                    casesContigues2.add(tuileadj);
                                break;

                            case innondée : 
                                    casesContigues2.add(tuileadj);
                                    casesDisp.add(tuileadj);
                                break;

                            case normale : 
                                    casesDisp.add(tuileadj);
                                    break;
                        }
                    }
                }
            }
            for(Tuile tuile : casesContigues2){
                casesContigues.add(tuile);
            }
            casesContigues2.clear();
        }
        return casesDisp; 
    }  
}
