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
            this.emplacementX = emplacement[0]; //Emplacement en X de la tuile sur l'ile (La map)
            this.emplacementY = emplacement[1]; //Emplacement en Y de la tuile sur l'ile (La map)
            this.aventuriers = new ArrayList<>(); // Liste des aventuriers sur cette tuile
            this.nomcase = null; //nom de la case
            int adjacentes[][] = {{emplacement[0]-1,emplacement[1]},{emplacement[0],emplacement[1]-1},{emplacement[0]+1,emplacement[1]},{emplacement[0],emplacement[1]+1}};
            this.tuilesadj=adjacentes;
            int diagonales[][] = {{emplacement[0]-1,emplacement[1]-1},{emplacement[0]+1,emplacement[1]-1},{emplacement[0]+1,emplacement[1]+1},{emplacement[0]-1,emplacement[1]+1}};
            this.tuilesdiag=diagonales;
        }
    
    public Tuile getTuile(int x, int y) { //retourne la tuile à l'emplacement xy, ou null si pas trouvée
        Tuile res = null;
        for(Tuile tu : this.getIledescases().getCase2ile()) {
            if(tu.emplacementX == x && tu.emplacementY == y) {
                res = tu;
            }
        }
            return res;
    }    
        
    public int getNumcase() { //retourne le numéro de la case
        return numcase;
    }

    public void setNumcase(int numcase) { //permet de donner un numéro à une case
        this.numcase = numcase;
    }

    public TypeC getType() { //retourne le type de la case
        return type;
    }

    public void setType(TypeC type) { //permet de donner un type à une case
        this.type = type;
    }

    public EtatC getEtat() { //retourne l'état de la case
        return etat;
    }

    public void setEtat(EtatC etat) { //permet de changer l'état de la case et met à jour les listes de cases
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

    public Ile getIledescases() { //retourne l'ile contenant la case
        return iledescases;
    }

    public void setIledescases(Ile iledescases) { //permet de donner une ile à la case
        this.iledescases = iledescases;
    }

    public ArrayList<Aventurier> getAventuriers() { //retourne les aventuriers présents sur la case
        return aventuriers;
    }

    public void setAventuriers(ArrayList<Aventurier> aventuriers) { //permet d'affecter un aventurier à la case 
        this.aventuriers = aventuriers;
    }

    
        
        public void setEmplacement(int emplacementX,int emplacementY){ //permet de donner un emplacement à la carte
            this.emplacementX = emplacementX;
            this.emplacementY = emplacementY;
        }

        public int getEmplacementX() { //retourne la position en X de la case
            return emplacementX;
        }
        
        public int getEmplacementY() { //retourne la position en Y de la case
            return emplacementY;
        }
        
        public void setNom(String nom){ //permet de donner un nom à la case
            this.nomcase = nom;
        }
        
        public String getNom(){ //retourne le nom de la case
            return nomcase;
        }
        
        public int[][] getTuilesAdj() { //retourne les position des cases adjacentes (nord, sud, est, ouest)
            return tuilesadj;
        }
        
        public int[][] getTuilesDiag() { //retourne les position des cases adjacentes diagonales (nord-est, nord-ouest, sud-est, sud-ouest)
            return tuilesdiag;
        }
        
}