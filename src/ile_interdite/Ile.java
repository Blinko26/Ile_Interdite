package ile_interdite;
import java.util.ArrayList;

public class Ile {
	private ArrayList<Tuile> case2ile;
        private ArrayList<Tuile> tuilesinondees;
        
      public Ile(){
            this.case2ile = new ArrayList<Tuile>();
            
            for (int i = 0; i < 12; i++){   //Ajout des tuiles null (sur les bords)
                int eN[][] = {{1,1},{1,2},{1,5},{1,6},{2,1},{2,6},{5,1},{5,6},{6,1},{6,2},{6,5},{6,6}}; //Emplacement des tuiles dites null qui ne changera jamaiS
                case2ile.add(new Tuile(i,TypeC.nulle,EtatC.sombré,eN[i]));
                case2ile.get(i).setNom("Mer");
            }
            for (int i=12; i<27; i++){      //Ajout des tuiles dites normal
                case2ile.add(new Tuile(i,TypeC.normal,EtatC.normal));
            }
            for (int i = 27; i<29;i++) {    //Ajout des tuiles dites Trésor==> Calice
                case2ile.add(new Tuile(i,TypeC.calice,EtatC.normal));
            }
            for (int i = 29; i<31;i++) {    //Ajout des tuiles dites Trésor==>Cristal
                case2ile.add(new Tuile(i,TypeC.cristal,EtatC.normal));
            }
            for (int i = 31; i<33;i++) {    //Ajout des tuiles dites Trésor==> Pierre
                case2ile.add(new Tuile(i,TypeC.pierre,EtatC.normal));
            }
            for (int i = 33; i<35;i++) {    //Ajout des tuiles dites Trésor==> Statue
                case2ile.add(new Tuile(i,TypeC.statut,EtatC.normal));
            }
             //Ajout des tuiles dites Héliport
            case2ile.add(new Tuile(36,TypeC.héliport,EtatC.normal));
            
        }

   public ArrayList<Tuile> getCase2ile() {
        return case2ile;
    }


   public void setCase2ile(ArrayList<Tuile> case2ile) {
        this.case2ile = case2ile;
    }
   
   public Tuile getTuile(int emplacementXTuile,int emplacementYTuile){
       for(Tuile tuile: case2ile) {
           if (tuile.getEmplacementX()== emplacementXTuile && tuile.getEmplacementY()== emplacementYTuile){
               return tuile;
           }
       }
       return null;
   }
   
   public Tuile getTuile(String nomTuile){
       for(Tuile tuile: case2ile) {
           if (tuile.getNom()==nomTuile){
               return tuile;
           }
       }
       return null;
   }
   
   
   public ArrayList<Tuile> getCasesInondees(){ //Ajout des cases ayant sombrées
       for (Tuile tuile : case2ile) { //Parcourt l'ensemble des cases de l'île
           if (tuile.getEtat()==EtatC.sombré){
               tuilesinondees.add(tuile);
           }
       }
       
       return tuilesinondees;
   }
   
   
   
   //public ArrayList<Tuile> getCasesNonInondees(){ //Ajout des cases n'ayant pas sombrées
   //    for (Tuile tuile : case2ile) {
   //        if (tuile.getEtat()==EtatC.normal || tuile.getEtat()==EtatC.innondé){
   //            tuilesinondees.add(tuile);
   //        }
   //    }
       
   //    return tuilesnoninondees;
   //}
   
    //public ArrayList<Tuile> getTuilesDispoAutourJoueurClassique(){ //Retourne toutes les cases adjacentes n'ayant pas sombrées
    //    for (Tuile tuile : tuilesadj) {
    //        if (tuile.getEtat()!=EtatC.sombré){
    //            tuilesdispos.add(tuile);
    //        }
    //    }
    //    return tuilesdispos;
    //}
    
    //public ArrayList<Tuile> getAllTuilesDispo() {
    //    tuilesdispos=getTuilesDispoAutourJoueurClassique();

    //    for (Tuile tuile : tuilesdiag) {
    //        if (tuile.getEtat()!=EtatC.sombré){
     //           tuilesdispos.add(tuile);
     //       }
     //   }
     //   return tuilesdispos;
    //}

    //public ArrayList<Tuile> getTuilesadj() {
    //    return tuilesadj;
    //}

    //public void setTuilesadj(ArrayList<Tuile> tuilesadj) {
    //    this.tuilesadj = tuilesadj;
    //}

    public ArrayList<Tuile> getTuilesinondees() {
        return tuilesinondees;
    }

    public void setTuilesinondees(ArrayList<Tuile> tuilesinondees) {
        this.tuilesinondees = tuilesinondees;
    }

    //public ArrayList<Tuile> getTuilesnoninondees() {
    //    return tuilesnoninondees;
    //}

    //public void setTuilesnoninondees(ArrayList<Tuile> tuilesnoninondees) {
     //   this.tuilesnoninondees = tuilesnoninondees;
    //}

    //public ArrayList<Tuile> getTuilesdispos() {
    //    return tuilesdispos;
    //}

    //public void setTuilesdispos(ArrayList<Tuile> tuilesdispos) {
    //    this.tuilesdispos = tuilesdispos;
    //}

    //public ArrayList<Tuile> getTuilesdiag() {
    //    return tuilesdiag;
    //}

    //public void setTuilesdiag(ArrayList<Tuile> tuilesdiag) {
    //    this.tuilesdiag = tuilesdiag;
    //}
        
}