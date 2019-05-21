package ile_interdite;
import java.util.ArrayList;

public class Ile {
	public ArrayList<Tuile> case2ile;
        public ArrayList<Tuile> tuilesadj;
        public ArrayList<Tuile> tuilesinondees;
        public ArrayList<Tuile> tuilesnoninondees;
        public ArrayList<Tuile> tuilesdispos;
        public ArrayList<Tuile> tuilesdiag;
        
      public Ile(){
            for (int i = 0; i < 12; i++){   //Ajout des tuiles null (sur les bords)
                int eN[] = {1,2,5,6,7,12,25,30,31,32,35,36}; //Emplacement des tuiles dites null qui ne changera jamais
                Tuile tuile = new Tuile(i,TypeC.nulle,EtatC.sombré);
                tuile.setEmplacement(eN[i]); //Set leur emplacement définitif
                case2ile.add(tuile);
            }
            
            for (int i=13; i<27; i++){      //Ajout des tuiles dites normal
                Tuile tuile = new Tuile(i,TypeC.normal,EtatC.normal);
                case2ile.add(tuile);
            }
            for (int i = 28; i<29;i++) {    //Ajout des tuiles dites Trésor==> Calice
                Tuile tuile = new Tuile(i,TypeC.calice,EtatC.normal);
                case2ile.add(tuile);
            }
            for (int i = 30; i<31;i++) {    //Ajout des tuiles dites Trésor==>Cristal
                Tuile tuile = new Tuile(i,TypeC.cristal,EtatC.normal);
                case2ile.add(tuile);
            }
            for (int i = 32; i<33;i++) {    //Ajout des tuiles dites Trésor==> Pierre
                Tuile tuile = new Tuile(i,TypeC.pierre,EtatC.normal);
                case2ile.add(tuile);
            }
            for (int i = 34; i<35;i++) {    //Ajout des tuiles dites Trésor==> Statue
                Tuile tuile = new Tuile(i,TypeC.statut,EtatC.normal);
                case2ile.add(tuile);
            }
            
            Tuile tuile = new Tuile(36,TypeC.héliport,EtatC.normal); //Ajout des tuiles dites Héliport
                case2ile.add(tuile);
            
            
        }

   public ArrayList<Tuile> getCase2ile() {
        return case2ile;
    }


   public void setCase2ile(ArrayList<Tuile> case2ile) {
        this.case2ile = case2ile;
    }
   
   public Tuile getTuile(int emplacementTuile){
       for(Tuile tuile: case2ile) {
           if (tuile.getEmplacement()== emplacementTuile){
               return tuile;
           }
       }
       return null;
   }
   
   public ArrayList<Tuile> getCasesAdjacentes(Tuile t){ //Ajout des cases au nord, au sud, à l'est et à l'ouest d'une case donnée
       int i;
       i = t.getEmplacement();
       tuilesadj.add(getTuile(i-6)); //case du nord
       tuilesadj.add(getTuile(i-1)); //case de l'ouest
       tuilesadj.add(getTuile(i+1)); //case de l'est
       tuilesadj.add(getTuile(i+6)); //case du sud
       
       return tuilesadj;
   }
   
   public ArrayList<Tuile> getCasesInondees(){ //Ajout des cases ayant sombrées
       for (Tuile tuile : case2ile) { //Parcourt l'ensemble des cases de l'île
           if (tuile.getEtat()==EtatC.sombré){
               tuilesinondees.add(tuile);
           }
       }
       
       return tuilesinondees;
   }
   
   public ArrayList<Tuile> getDiagonales(Tuile t){ //Ajout des cases en diagonale d'une case donnée
       int i;
       i = t.getEmplacement();
       tuilesdiag.add(getTuile(i-7)); //case du nord-ouest
       tuilesdiag.add(getTuile(i-5)); //case du nord-est
       tuilesdiag.add(getTuile(i+5)); //case du sud-ouest
       tuilesdiag.add(getTuile(i+7)); //case du sud-est
       
       return tuilesdiag;
   }
   
   public ArrayList<Tuile> getCasesNonInondees(){ //Ajout des cases n'ayant pas sombrées
       for (Tuile tuile : case2ile) {
           if (tuile.getEtat()==EtatC.normal || tuile.getEtat()==EtatC.innondé){
               tuilesinondees.add(tuile);
           }
       }
       
       return tuilesnoninondees;
   }
   
    public ArrayList<Tuile> getTuilesDispoAutourJoueurClassique(){ //Retourne toutes les cases adjacentes n'ayant pas sombrées
        for (Tuile tuile : tuilesadj) {
            if (tuile.getEtat()!=EtatC.sombré){
                tuilesdispos.add(tuile);
            }
        }
        return tuilesdispos;
    }
    
    public ArrayList<Tuile> getAllTuilesDispo() {
        tuilesdispos=getTuilesDispoAutourJoueurClassique();

        for (Tuile tuile : tuilesdiag) {
            if (tuile.getEtat()!=EtatC.sombré){
                tuilesdispos.add(tuile);
            }
        }
        return tuilesdispos;
    }

    public ArrayList<Tuile> getTuilesadj() {
        return tuilesadj;
    }

    public void setTuilesadj(ArrayList<Tuile> tuilesadj) {
        this.tuilesadj = tuilesadj;
    }

    public ArrayList<Tuile> getTuilesinondees() {
        return tuilesinondees;
    }

    public void setTuilesinondees(ArrayList<Tuile> tuilesinondees) {
        this.tuilesinondees = tuilesinondees;
    }

    public ArrayList<Tuile> getTuilesnoninondees() {
        return tuilesnoninondees;
    }

    public void setTuilesnoninondees(ArrayList<Tuile> tuilesnoninondees) {
        this.tuilesnoninondees = tuilesnoninondees;
    }

    public ArrayList<Tuile> getTuilesdispos() {
        return tuilesdispos;
    }

    public void setTuilesdispos(ArrayList<Tuile> tuilesdispos) {
        this.tuilesdispos = tuilesdispos;
    }

    public ArrayList<Tuile> getTuilesdiag() {
        return tuilesdiag;
    }

    public void setTuilesdiag(ArrayList<Tuile> tuilesdiag) {
        this.tuilesdiag = tuilesdiag;
    }
        
}