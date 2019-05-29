package ile_interdite;

public class CarteInondation {
	private String nomcarte; //nom de la carte
        private int[] numcarte; //numéro de la carte
        
    CarteInondation(String nom){
        this.nomcarte=nom;
    }

    public String getNomCarte() { //retourne le nom de la carte
        return nomcarte;
    }

    public void setNomCarte(String nomcarte) { //permet de modifier le nom de la carte
        this.nomcarte = nomcarte;
    }

    public int[] getNumcarte() { //retourne le numéro de la carte
        return numcarte;
    }

    public void setNumcarte(int[] numcarte) { //permet de donner un numéro à la carte
        this.numcarte = numcarte;
    }
}