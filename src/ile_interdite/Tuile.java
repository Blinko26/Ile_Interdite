package ile_interdite;
import ile_interdite.Aventurier;
import java.util.ArrayList;

public class Tuile {
	private int numcase; //numéro de la tuile
        private String nomcase; //nom de la tuile
	private TypeC type; //type de la tuile
	private EtatC etat; //etat de la tuile
	private int emplacementX; //position en X de la tuile
        private int emplacementY; //position en Y de la tuile
        public int tuilesadj[][]; //position en XY des tuiles nord, sud, est et ouest
        public int tuilesdiag[][]; //position en XY des tuiles nord-est, nord-ouest, sud-est, sud-ouest
	public Ile iledescases; //ile à laquelle la tuile appartient
	public ArrayList<Aventurier> aventuriers; //liste des aventuriers présents sur la tuile
        private boolean surligne=false;

        
        
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
    
        public int getEmplacementX() { //retourne la position en X de la case
            return emplacementX;
        }
        
        public int getEmplacementY() { //retourne la position en Y de la case
            return emplacementY;
        }
        
         public void setEmplacement(int emplacementX,int emplacementY){ //permet de donner un emplacement à la carte
            this.emplacementX = emplacementX;
            this.emplacementY = emplacementY;
        }   
        
        public String getNom(){ //retourne le nom de la case
            return nomcase;
        }
        
        public void setNom(String nom){ //permet de donner un nom à la case
            this.nomcase = nom;
        }
        
        public int[][] getTuilesAdj() { //retourne les position des cases adjacentes (nord, sud, est, ouest)
            return tuilesadj;
        }
        
        public int[][] getTuilesDiag() { //retourne les position des cases adjacentes diagonales (nord-est, nord-ouest, sud-est, sud-ouest)
            return tuilesdiag;
        }
        
        public void setSurligné(boolean sur){
            this.surligne= sur;
        }
        
}