package ile_interdite;

import ile_interdite.Aventurier;

public class Navigateur extends Aventurier {

    public Navigateur() {
        super(TypeAventurier.navigateur,Utils.Pion.JAUNE,"La Porte d’Or");
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