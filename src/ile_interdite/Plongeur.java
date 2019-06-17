package ile_interdite;

import ile_interdite.Aventurier;
import java.util.ArrayList;

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
        
        //On get la position du plongeur
        Tuile tu = this.getPosition();
        Ile ile = tu.getIledescases();
        for(int i[] : tu.getTuilesAdj()) {
            //On chek ses tuiles adjacentes pour voir si :
            // 1 : si elle est sombrée on ne peut pas s'arreter dessus donc on l'add pas dans casesDisp mais dans casesContigues si
            // 2 : sinon on add  dans cases dispo et cases contigu.
            Tuile t = ile.getTuile(i[0],i[1]);
            if(t.getEtat() == EtatC.sombrée) {
                casesContigues.add(t);
            }else if(t.getEtat() == EtatC.innondée || t.getEtat() == EtatC.normale){
                casesDisp.add(t);
                casesContigues.add(t);
            }
            
            //On parcourt l'arrayList casesContigues et pour chaque cases on refais l'etape d'avant
            for(Tuile j : casesContigues){
                for(int y[] : j.getTuilesAdj()){
                    Tuile p = ile.getTuile(i[0],i[1]);
                    if(p.getEtat() == EtatC.sombrée) {
                        casesContigues.add(t);
                    }else if(p.getEtat() == EtatC.innondée || p.getEtat() == EtatC.normale){
                        casesDisp.add(p);
                        casesContigues.add(p);
                    }
               }
            } 
            
        }
        return casesDisp;
        
         
        }/*   
        return casesDisp;
    }*/
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