package ile_interdite;


public class Messager extends Aventurier {

    public Messager() {
        super(TypeAventurier.messager,Utils.Pion.BLANC,"La Porte d’Argent");
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