package ile_interdite;
public class Niveaudo {
	private int[] _niveau; //niveau de l'eau
	private int[] _niveauinondation; //niveau d'innondation

    public int[] getNiveau() { //retourne le niveau de l'eau
        return _niveau;
    }

    public void setNiveau(int[] _niveau) { //permet de donner un niveau d'eau
        this._niveau = _niveau;
    }

    public int[] getNiveauinondation() { //retourne le niveau d'innondation
        return _niveauinondation;
    }

    public void setNiveauinondation(int[] _niveauinondation) { //permet de donner un niveau d'innondation
        this._niveauinondation = _niveauinondation;
    }
}