package ile_interdite;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public abstract class Aventurier {
	private TypeAventurier type; //type de l'aventurier
	private int [] emplacement={0,0}; //emplacement de l'aventurier sur l'ile
        private final Utils.Pion cPion; //pion associé à l'aventurier
        private String tuiledepart; //tuile sur laquelle commence l'aventurier
        public Tuile position; //tuile laquelle l'aventurier se trouve
        
        public Aventurier(TypeAventurier type,Utils.Pion pion,String depart) {
            this.type = type;
            this.cPion=pion;
            this.tuiledepart=depart;
        }

    public TypeAventurier getType() { //retourne le type de l'aventurier
        return type;
    }

    public int[] getEmplacement() { //retourne l'emplacement de l'aventurier
        return emplacement;
    }

    public Tuile getPosition() { //retourne la position de l'aventurier
        return position;
    }
    
    public Color getCouleur() { //retourne la couleur du pion de l'aventurier
        return cPion.getCouleur();
    }
    public String getDepart(){ //retourne le nom de la case sur laquelle commence l'aventurier
        return tuiledepart;
    }

    public void setType(TypeAventurier type) { //permet de donner un type à l'aventurier
        this.type = type;
    }

    public void setEmplacement(int emplacementX,int emplacementY) { //permet de donner un emplacement à l'aventurier
        this.emplacement[0] = emplacementX;
        this.emplacement[1] = emplacementY;
    }

    public void setPosition(Tuile position) { //permet de donner une position à l'aventurier
        this.position = position;
    }

	public ArrayList<Tuile> PossibleMouvement() { //retourne les cases sur lequelles l'aventurier peut se déplacer
        ArrayList<Tuile> casesDisp = new ArrayList<>();
        Tuile tu = this.getPosition();
        Ile ile = tu.getIledescases();
        for(int i[] : tu.getTuilesAdj()) {
            Tuile t = ile.getTuile(i[0],i[1]);
            if(t.getEtat() != EtatC.sombrée) {
                casesDisp.add(t);
            }
            
	}
        return casesDisp;
        }
        
}