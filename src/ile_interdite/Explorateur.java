package ile_interdite;

import java.util.ArrayList;
import java.util.Scanner;

public class Explorateur extends Aventurier {
    
    private final Utils.Pion cPion;

    public Explorateur(TypeAventurier type,Joueur joueur) {
        super(TypeAventurier.pilote);
        this.cPion = Utils.Pion.VERT;
    }
    
    public ArrayList<Tuile> getMouvementPossible() {
        Tuile tu = this.getPosition();
        
    }
}