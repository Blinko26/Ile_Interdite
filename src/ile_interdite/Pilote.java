package ile_interdite;

import ile_interdite.Aventurier;
import java.util.ArrayList;

public class Pilote extends Aventurier {
    
    public Pilote() {
        super(TypeAventurier.pilote,Utils.Pion.BLEU,"Heliport");
    }

    @Override
    public boolean getAAsseche() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setAsseche() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}