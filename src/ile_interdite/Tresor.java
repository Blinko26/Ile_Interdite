package ile_interdite;
public class Tresor {
	private TypeT nom; //nom du trésor
	private EtatT etat; //etat du trésor

    public TypeT getNom() { //retourne le nom du trésor
        return nom;
    }

    public void setNom(TypeT nom) { //permet de donner un nom au trésor
        this.nom = nom;
    }

    public EtatT getEtat() { //retourne l'état du trésor
        return etat;
    }

    public void setEtat(EtatT etat) { //permet de donner un état au trésor
        this.etat = etat;
    }
}