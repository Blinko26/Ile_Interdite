package ile_interdite;
public class Niveaudo {
	private int[] niveau; //niveau de l'eau
	private int[] niveauinondation; //niveau d'innondation

    public int[] getNiveau() { //retourne le niveau de l'eau
        return niveau;
    }

    public void setNiveau(int[] niveau) { //permet de donner un niveau d'eau
        this.niveau = niveau;
    }

    public int[] getNiveauinondation() { //retourne le niveau d'innondation
        return niveauinondation;
    }

    public void setNiveauinondation(int[] niveauinondation) { //permet de donner un niveau d'innondation
        this.niveauinondation = niveauinondation;
    }
}