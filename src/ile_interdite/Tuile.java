package ile_interdite;
import ile_interdite.Aventurier;
import java.util.ArrayList;

public class Tuile {
	private int[] numcase;
	private TypeC type;
	private EtatC etat;
	private int[] emplacement;
	public Ile iledescases;
	public ArrayList<Aventurier> aventuriers = new ArrayList<>();
        
        Tuile() { 
            this.etat = normal;
            aventuriers = new ArrayList<Aventurier>();
        }
}