package ile_interdite;

import ile_interdite.Aventurier;

public class Ingénieur extends Aventurier {
    
    private boolean aAsseche;
    
    public Ingénieur() { 
        super(TypeAventurier.ingénieur,Utils.Pion.ROUGE,"La Porte de Bronze");
        setAsseche();
        
    }
    
    @Override
    public boolean getAAsseche() {
        return aAsseche;
    }
    
    public void setAsseche() {
        this.aAsseche = false;
    }
    
}