package ile_interdite;

public class CarteInondation {
	private int[] numcarte; //numéro de la carte

    public int[] getNumcarte() { //retourne le numéro de la carte
        return numcarte;
    }

    public void setNumcarte(int[] numcarte) { //permet de donner un numéro à la carte
        this.numcarte = numcarte;
    }

    public String getNom() { //retourne le nom de la carte
        return nom;
    }

    public void setNom(String nom) { //permet de donner un nom à la carte
        this.nom = nom;
    }
	private String nom;
}