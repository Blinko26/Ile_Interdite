package ile_interdite;

import util.Utils.Pion;

public class Messager extends Aventurier {
    
    private final Pion cPion;

    public Messager(TypeAventurier type,Joueur joueur) {
        super(type,joueur);
        this.cPion = Pion.BLANC;
    }
}