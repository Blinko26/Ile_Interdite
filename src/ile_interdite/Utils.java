/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ile_interdite;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import javax.swing.JOptionPane;


/**
 *
 * @author Eric
 */
public class Utils {
 
    public static enum EtatTuile {
        ASSECHEE("Asséchée"), 
        INONDEE("Inondée"),
        COULEE("Coulée");

        String libelle ;
        
        EtatTuile(String libelle) {
            this.libelle = libelle ;
        }

        @Override
        public String toString() {
            return this.libelle ;
        }
    }

    public static enum Pion {
        ROUGE("Rouge", new Color(255, 0, 0)),
        VERT("Vert", new Color(0, 195, 0)),
        BLEU("Bleu", new Color(55,194,198)),
        JAUNE("Jaune", new Color(255, 255, 0)),
        BLANC("Blanc", new Color(0, 0, 0)),
        NOIR("Noir", new Color(255, 255, 255)) ;    

        private final String libelle ;
        private final Color couleur ;


        Pion (String libelle, Color couleur) {
            this.libelle = libelle ;
            this.couleur = couleur ;
        }

        @Override
        public String toString() {
            return this.libelle ;
        }

        public Color getCouleur() {
            return this.couleur ;
        }

        static Pion getFromName(String name) {
            if (ROUGE.name().equals(name)) return ROUGE ;
            if (VERT.name().equals(name)) return VERT ;
            if (BLEU.name().equals(name)) return BLEU ;
            if (BLANC.name().equals(name)) return BLANC ;
            if (NOIR.name().equals(name)) return NOIR ;
            if (JAUNE.name().equals(name)) return JAUNE ;
            return null ;
        }
    }

    /*public static ArrayList<Aventurier> melangerAventuriers(ArrayList<Aventurier> arrayList) {
        if (Parameters.ALEAS) {
            Collections.shuffle(arrayList);
        }
        return arrayList ;
    }*/
    
    /**
     * Permet de poser une question à laquelle l'utilisateur répond par oui ou non
     * @param question texte à afficher
     * @return true si l'utilisateur répond oui, false sinon
     */
    public static Boolean poserQuestion(String question) {
        System.out.println("Divers.poserQuestion(" + question + ")");
        int reponse = JOptionPane.showConfirmDialog (null, question, "", JOptionPane.YES_NO_OPTION) ;
        System.out.println("\tréponse : " + (reponse == JOptionPane.YES_OPTION ? "Oui" : "Non"));
        return reponse == JOptionPane.YES_OPTION;
    }    
    
    /**
     * Permet d'afficher un message d'information avec un bouton OK
     * @param message Message à afficher 
     */
    public static void afficherInformation(String message) {
        JOptionPane.showMessageDialog(null, message, "Information", JOptionPane.OK_OPTION);
    }
    
    public static ArrayList<String> getNomsTuiles(){
        ArrayList<String> listeNomsTuiles = new ArrayList<>();
        listeNomsTuiles.add("Le Pont des Abimes");
        listeNomsTuiles.add("La Porte de Bronze");
        listeNomsTuiles.add("La Caverne des Ombres");
        listeNomsTuiles.add("La Porte de Fer");
        listeNomsTuiles.add("La Porte d’Or");
        listeNomsTuiles.add("Les Falaises de l’Oubli");
        listeNomsTuiles.add("Le Palais de Corail");
        listeNomsTuiles.add("La Porte d’Argent");
        listeNomsTuiles.add("Les Dunes de l’Illusion");
        listeNomsTuiles.add("Heliport");
        listeNomsTuiles.add("La Porte de Cuivre");
        listeNomsTuiles.add("Le Jardin des Hurlements");
        listeNomsTuiles.add("La Foret Pourpre");
        listeNomsTuiles.add("Le Lagon Perdu");
        listeNomsTuiles.add("Le Marais Brumeux");
        listeNomsTuiles.add("Observatoire");
        listeNomsTuiles.add("Le Rocher Fantome");
        listeNomsTuiles.add("La Caverne du Brasier");
        listeNomsTuiles.add("Le Temple du Soleil");
        listeNomsTuiles.add("Le Temple de La Lune");
        listeNomsTuiles.add("Le Palais des Marees");
        listeNomsTuiles.add("Le Val du Crepuscule");
        listeNomsTuiles.add("La Tour du Guet");
        listeNomsTuiles.add("Le Jardin des Murmures");
        return listeNomsTuiles;
    }
}
