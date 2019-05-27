package ile_interdite;

public class CarteInondation {
	private String nomcarte;
        private int[] numcarte; //numéro de la carte
        
    CarteInondation(String nom){
        this.nomcarte=nom;
    }

    public String getNomCarte() {
        return nomcarte;
    }

    public void setNomCarte(String nomcarte) {
        this.nomcarte = nomcarte;
    }

    public int[] getNumcarte() { //retourne le numéro de la carte
        return numcarte;
    }

    public void setNumcarte(int[] numcarte) { //permet de donner un numéro à la carte
        this.numcarte = numcarte;
    }
}