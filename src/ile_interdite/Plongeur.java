package ile_interdite;

import ile_interdite.Aventurier;
import java.util.ArrayList;

public class Plongeur extends Aventurier {
    
    ArrayList<Tuile> casesAdjacentes = new ArrayList<>();
    
    public Plongeur() {
        super(TypeAventurier.plongeur,Utils.Pion.NOIR,"La Porte de Fer");
        
    }
  
    public ArrayList<Tuile> getCasesAdjacentes(){ //retourne les cases adjacentes à la case où le plongeur se trouve
        return casesAdjacentes;   
    }
    
        //public ArrayList<Tuile> getMouvementPossible() { //retourne les cases sur lesquelles le plongeur peut se déplacer en fonction de sa position
        //ArrayList<Tuile> casesDisp = new ArrayList<>();
        //Tuile tu = this.getPosition();
        //Ile ile = tu.getIledescases();
        //for(int i[] : tu.getTuilesAdj()) {
        //    Tuile t = ile.getTuile(i[0],i[1]);
          
        //}   
        //return casesDisp;
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