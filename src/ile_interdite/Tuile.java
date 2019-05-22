package ile_interdite;
import ile_interdite.Aventurier;
import java.util.ArrayList;

public class Tuile {
	private int numcase;
        private String nomcase;
	private TypeC type;
	private EtatC etat;
	private int emplacementX;
        private int emplacementY;
        public int tuilesadj[][];
        public int tuilesdiag[][];
	public Ile iledescases;
	public ArrayList<Aventurier> aventuriers;
        private ArrayList<Tuile> tuilesdispos;

        
        
        public Tuile(int numcase, TypeC type, EtatC etat/*, int emplacement*/) { 
            this.numcase = numcase; //Numero d'identification de la tuile
            this.type = type; // Type de la tuile (normal, héliport, calice, cristal, pierre, statue, null)
            this.etat = etat; // Etat de la tuile (Normale, innondée, sombrée)
            this.emplacementX = 0; //Emplacement de la tuile sur l'ile (La map)
            this.emplacementY = 0;
            this.aventuriers = new ArrayList<>(); // Liste des aventuriers sur cette tuile                
            this.nomcase = null;        
        }
                
        @SuppressWarnings("empty-statement")
        public Tuile(int numcase, TypeC type, EtatC etat, int emplacement[]) { 
            this.numcase = numcase; //Numero d'identification de la tuile
            this.type = type; // Type de la tuile (normal, héliport, calice, cristal, pierre, statue, null)
            this.etat = etat; // Etat de la tuile (Normale, innondée, sombrée)
            this.emplacementX = emplacement[0]; //Emplacement de la tuile sur l'ile (La map)
            this.emplacementY = emplacement[1];
            this.aventuriers = new ArrayList<>(); // Liste des aventuriers sur cette tuile
            this.nomcase = null;
            int adjacentes[][] = {{emplacement[0]-1,emplacement[1]},{emplacement[0],emplacement[1]-1},{emplacement[0]+1,emplacement[1]},{emplacement[0],emplacement[1]+1}};
            this.tuilesadj=adjacentes;
            int diagonales[][] = {{emplacement[0]-1,emplacement[1]-1},{emplacement[0]+1,emplacement[1]-1},{emplacement[0]+1,emplacement[1]+1},{emplacement[0]-1,emplacement[1]+1}};
            this.tuilesdiag=diagonales;
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
        if(etat == EtatC.sombrée) {
            Ile ile = getIledescases();
            ArrayList<Tuile> tuilesJouables = ile.getTuilesNonInondees();
            for(Tuile t : tuilesJouables) {
                if(t.nomcase == this.nomcase) {
                    tuilesJouables.remove(t);
                }
            }
            ile.setTuilesNonInondees(tuilesJouables);
        }
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

    
        
        public void setEmplacement(int emplacementX,int emplacementY){
            this.emplacementX = emplacementX;
            this.emplacementY = emplacementY;
        }

        public int getEmplacementX() {
            return emplacementX;
        }
        
        public int getEmplacementY() {
            return emplacementY;
        }
        
        public void setNom(String nom){
            this.nomcase = nom;
        }
        
        public String getNom(){
            return nomcase;
        }
        
}