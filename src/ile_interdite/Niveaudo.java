package ile_interdite;
public class Niveaudo {
	private int niveau; //niveau de l'eau
	private int niveauInondation; //niveau d'innondation

    public Niveaudo(){
        
    }
        
    public int getNiveau() { //retourne le niveau de l'eau
        return niveau;
    }

    public void setNiveau(int niveau) { //permet de donner un niveau d'eau
        this.niveau = niveau;
    }

    public int getNiveauinondation() { //retourne le niveau d'innondation
        return niveauInondation;
    }

    public void setNiveauinondation(int niveauinondation) { //permet de donner un niveau d'innondation
        this.niveauInondation = niveauinondation;
    }
    
    public void monterEau(){ //Augmente le niveau de l'eau de 1
        this.niveau = niveau+1;
        updateInnondation();
    }
    
    public void updateInnondation(){ //Met a jour le niveau d'innondation en fonction du niveau d'eau
        if (getNiveau()<3){
            setNiveauinondation(2);
        }
        else if (getNiveau()<6){
            setNiveauinondation(3);            
        }
        else if (getNiveau()<9){
            setNiveauinondation(4);            
        }
    }
    
    public void initNiveauDeau(int difficulté){
        setNiveau(difficulté);
        updateInnondation();
    }
}