package ile_interdite;
import java.util.ArrayList;

public class Ile {
	public ArrayList<Tuile> case2ile;
        
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
        
}