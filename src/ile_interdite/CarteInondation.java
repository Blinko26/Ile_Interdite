package ile_interdite;

public class CarteInondation {
	private String nomcarte;
        CarteInondation(String nom){
            this.nomcarte=nom;
        }

    public String getNomCarte() {
        return nomcarte;
    }

    public void setNomCarte(String nomcarte) {
        this.nomcarte = nomcarte;
    }
}