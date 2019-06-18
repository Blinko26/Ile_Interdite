package ile_interdite;

import ile_interdite.Aventurier;
import java.util.ArrayList;
import java.util.Collections;

public class Plongeur extends Aventurier {
    
    ArrayList<Tuile> casesAdjacentes = new ArrayList<>();
    ArrayList<Tuile> casesContigues = new ArrayList<>();
    ArrayList<Tuile> casesDisp = new ArrayList<>();
    
    public Plongeur() {
        super(TypeAventurier.plongeur,Utils.Pion.NOIR,"La Porte de Fer");
        
    }
  
    public ArrayList<Tuile> getCasesAdjacentes(){ //retourne les cases adjacentes à la case où le plongeur se trouve
        return casesAdjacentes;   
    }
         
        public ArrayList<Tuile> PossibleMouvement() { //retourne les cases sur lesquelles le plongeur peut se déplacer en fonction de sa position
        casesDisp.clear();
        casesContigues.clear();
        //On get la position du plongeur
        Tuile tu = this.getPosition();
        Ile ile = tu.getIledescases();
        
        for(int i[] : tu.getTuilesAdj()) {
            //On chek ses tuiles adjacentes pour voir si :
            // 1 : si elle est sombrée on ne peut pas s'arreter dessus donc on l'add pas dans casesDisp mais dans casesContigues si
            // 2 : si innondée : on peut s'arreter dessus et ça peut servir de chemin donc casesContigues et casesDisp
            // 3 : si normale : on ne peut que s'arretter dessus
            Tuile t = ile.getTuile(i[0],i[1]);
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
            }
        
            //On parcourt l'arrayList de casesContigues (marche pas car on utilise casescibtuf
            ArrayList<Tuile> casesContigues2 = new ArrayList<>();
            casesContigues2 = casesContigues;
                for(Tuile casesContigue : casesContigues){ 
                    //Pour chaque cases on regarde ses casesAdjacentes et son Etat
                   
                    Ile ile2 = casesContigue.getIledescases();
                    
                   for(int j[] : casesContigue.getTuilesAdj()){
                       Tuile t2 = ile2.getTuile(j[0],j[1]);
                       switch(t2.getEtat()){
                           case sombrée :
                                casesContigues.add(t2);
                                break;
                            
                           case innondée :
                                casesContigues.add(t2);
                                casesDisp.add(t2);
                                break;
                                
                           case normale :
                                 casesDisp.add(t2);
                                 break;
                       }
                    }
                }
            
        }  
        
            //On parcourt l'arrayList casesContigues et pour chaque cases on refais l'etape d'avant
           /*for(Tuile j : casesContigues){
                Tuile tuile = this.getPosition();
                Ile ile1 = tuile.getIledescases();
                for(int y[] : j.getTuilesAdj()){
                    Tuile p = ile1.getTuile(y[0],y[1]);
                    if(p.getEtat() == EtatC.sombrée) {
                        casesContigues.add(p);
                    }else if(p.getEtat() == EtatC.innondée || p.getEtat() == EtatC.normale){
                        casesContigues.add(p);
                        casesDisp.add(p);
                    }
               }
            }*/
           
        return casesDisp;
       
        }
}
    
   /* public void addTuileContiguë(Tuile tu){ 
        
        //Avoir la position tu du plongeur
        tu = this.getPosition();
        //Si sa position = innondée ou sombrée alors on l'ajoute à l'arraylist casesContigu
        if(tu.getEtat() == EtatC.sombrée || tu.getEtat() == EtatC.innondée){
            casesContiguës.add(tu);
        }else{
            casesSeches.add(tu);
        }
        
        //Ensuite chek des Etats des cases adjacentes si au moins 1 = innondée ou sombrée
        //on les add dans l'arraylist casesAdjacentes puis on la parcourt en verifiant leur etats
        //Si EtatC = innondée ou sombrée alorso on add dans casesContigu.
        //Le tout dans une boucle de tant que tu = this.getPosition ===///// tu.getEtat() != Etat.normale
        int[][] adj = tu.getTuilesAdj();
        
        while(tu.getEtat() != EtatC.normale){
            
            
            
            //Ca c'est bon
            Ile ile = tu.getIledescases();
            for(int i[] : tu.getTuilesAdj()) {
                Tuile t = ile.getTuile(i[0],i[1]);
                if(t.getEtat() == EtatC.sombrée || t.getEtat() == EtatC.innondée) {
                    casesContiguës.add(t);
                    
                }
            }
        }
        
        
        
        
    }
    
    public void addTuileSeche(Tuile tu){
        casesSeches.add(tu);
    }
    
    public void ShowPositionsPossibles(){
        for(Tuile i : casesSeches){
            System.out.println("Case :" +i +"tuile seche");
            //Envoyer un message au controleur pour les faire changer de couleur ?
        }
    }*/
    
//}