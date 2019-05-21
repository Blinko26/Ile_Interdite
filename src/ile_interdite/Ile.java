package ile_interdite;
import java.util.ArrayList;

public class Ile {
	private ArrayList<Tuile> case2ile;
        
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
       Tuile tuiltest = new Tuile(40,TypeC.normal,EtatC.innondé);
       for(Tuile tuile: case2ile) {
           if (tuile.getEmplacementX()== emplacementXTuile && tuile.getEmplacementY()== emplacementYTuile){
               return tuile;
           }
       }
       return tuiltest;
   }
        
}