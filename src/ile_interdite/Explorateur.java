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
}