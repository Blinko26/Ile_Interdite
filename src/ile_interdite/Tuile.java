package ile_interdite;
import ile_interdite.Aventurier;
import java.util.ArrayList;

public class Tuile {
	private int numcase;
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
        }

    
        
        public void setEmplacement(int emplacement){
            this.emplacement = emplacement;
        }

        public int getEmplacement() {
            return emplacement;
        }
        
}