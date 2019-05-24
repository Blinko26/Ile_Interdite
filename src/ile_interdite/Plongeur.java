package ile_interdite;

import ile_interdite.Aventurier;
import java.util.ArrayList;

public class Plongeur extends Aventurier {

    
    ArrayList<Tuile> casesInondees = new ArrayList<>();
    ArrayList<Tuile> casesSombrees = new ArrayList<>(); 
    ArrayList<Tuile> casesSeches = new ArrayList<>();
    ArrayList<Tuile> casesContigu = new ArrayList<>();
    
    ArrayList<Tuile> casesAdjacentes = new ArrayList<>();
    
    public Plongeur() {
        super(TypeAventurier.plongeur,Utils.Pion.NOIR,"La Porte de Fer");
        
    }
    
    
    public ArrayList<Tuile> getCasesAdjacentes(){
        return casesAdjacentes;   
    }
    
    public ArrayList<Tuile> getCasesInondees(){
        return casesInondees;      
    }
    
    public void addTuileContigu(Tuile tu){
        
        //Avoir la position tu du plongeur
        tu = this.getPosition();
        //Si sa position = innondée ou sombrée alors on l'ajoute à l'arraylist casesContigu
        if(tu.getEtat() == EtatC.sombrée || tu.getEtat() == EtatC.innondée){
            casesContigu.add(tu);
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
                    casesContigu.add(t);
                    
                }
            }
        }
        
        
        
        
    }
    
    public void addTuileSeche(Tuile tu){
        casesSeches.add(tu);
    }
    
    public void ShowPossitionsPossibles(){
        for(Tuile i : casesSeches){
            System.out.println("Case :" +i +"tuile seche");
            //Envoyer un message au controleur pour les faire changer de couleur ?
        }
    }
    
}