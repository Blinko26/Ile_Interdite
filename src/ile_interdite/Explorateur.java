package ile_interdite;

import java.util.ArrayList;
import java.util.Scanner;
import util.Utils.Pion;

public class Explorateur extends Aventurier {
    
    private final Pion cPion;

    public Explorateur(TypeAventurier type,Joueur joueur) {
        super(type,joueur);
        this.cPion = Pion.VERT;
    }
    
    @Override
        public void getMouvement(){
            ArrayList<Tuile> tuilesadj = new ArrayList<Tuile>();
            Ile ile = this.position.getIledescases();
            tuilesadj=ile.getCasesAdjacentes(position);
            ile.getTuilesDispoAutourJoueurClassique();
            
            for (Tuile t : ile.getTuilesdispos()) {
                System.out.println("Une tuile disponible a pour emplacement : " + t.getEmplacement());
            }
            
            System.out.println("Choisissez une case disponible");
            Scanner sc = new Scanner(System.in);
            int tuilechoisie = sc.nextInt();
            
            for (Tuile t : ile.getTuilesdispos()) {
                if (t.getEmplacement()==tuilechoisie) {
                    setPosition(ile.getTuile(tuilechoisie));
                }
            }
        }
}