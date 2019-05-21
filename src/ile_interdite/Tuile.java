package ile_interdite;
import ile_interdite.Aventurier;
import java.util.ArrayList;

public class Tuile {
	private int numcase;
        private String nomcase;
	private TypeC type;
	private EtatC etat;
	private int emplacement;
	public Ile iledescases;
	public ArrayList<Aventurier> aventuriers;
        
        
        public Tuile(int numcase, TypeC type, EtatC etat/*, int emplacement*/) { 
            this.numcase = numcase; //Numero d'identification de la tuile
            this.type = type; // Type de la tuile (normal, héliport, calice, cristal, pierre, statue, null)
            this.etat = etat; // Etat de la tuile (Normale, innondée, sombrée)
            this.emplacement = 0; //Emplacement de la tuile sur l'ile (La map)
            this.aventuriers = new ArrayList<>(); // Liste des aventuriers sur cette tuile
            aventuriers = new ArrayList<Aventurier>(); //Aventurier sur la tuile 
            this.nomcase = null;
        }

    public int getNumcase() {
        return numcase;
    }

    public void setNumcase(int numcase) {
        this.numcase = numcase;
    }

    public TypeC getType() {
        return type;
    }

    public void setType(TypeC type) {
        this.type = type;
    }

    public EtatC getEtat() {
        return etat;
    }

    public void setEtat(EtatC etat) {
        this.etat = etat;
    }

    public Ile getIledescases() {
        return iledescases;
    }

    public void setIledescases(Ile iledescases) {
        this.iledescases = iledescases;
    }

    public ArrayList<Aventurier> getAventuriers() {
        return aventuriers;
    }

    public void setAventuriers(ArrayList<Aventurier> aventuriers) {
        this.aventuriers = aventuriers;
    }

    
        
        public void setEmplacement(int emplacement){
            this.emplacement = emplacement;
        }

        public int getEmplacement() {
            return emplacement;
        }
        
        public void setNom(String nom){
            this.nomcase = nom;
        }
        
        public String getNom(){
            return nomcase;
        }
        
}