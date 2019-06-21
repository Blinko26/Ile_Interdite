/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controleur;

import ile_interdite.Joueur;
import ile_interdite.Tuile;
import ile_interdite.CarteTresor;

/**
 *
 * @author moi
 */
public class Message {
    // Liste des types de messages
    public TypesMessages type;  // type de message
    public Joueur joueur;  // Champ utilisé pour le message DEMARRER_PARTIE
    public Tuile tuile; //Champ Utilisé pour Deplacer et assecher
    public Joueur receveur;
    public CarteTresor carte; //Champ Utilisé pour Donner
    public int nbJoueurs;
    public String nj1;
    public String nj2;
    public String nj3;
    public String nj4;
    public int difficulté;
    public boolean aasseche;
    public String raisonMort;
    public boolean victoire;
}
