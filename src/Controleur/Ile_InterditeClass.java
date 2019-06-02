/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;
import ile_interdite.Application;
import ile_interdite.EtatC;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JLabel;


/**
 *
 * @author IUT2
 */
public class Ile_InterditeClass extends Observe {
    /*Partie Déclaration*/
    
    private static Application application;
    private static int etatJeu;
    private static int debut;
    private static int [] emplacementsouris;
    private static boolean presse;
    private static int joueurcourant;
    
    
    /*Déclaration des éléments de la fenetre*/
    private JFrame fenetre;
    private JPanel panelMap;
    private JPanel panelBouton;
    
   // private VueIle.MyCanvas ile;
    
    private JLabel joueurCourant; //Indique le joueur courant
    
    private JButton finTour;    //Bouton pour finir son tour
    private JButton deplacer;   // bouton pour se deplacer
    private JButton assecher;   // Bouton pour assecher une case
    private JButton donner; //Bouton pour donner une carte
    
    public Ile_InterditeClass (){
        fenetre = new JFrame("Ile Interdite");  //Instanciation de la fenetre
        fenetre.setLayout(new BorderLayout());
        
        panelMap = new JPanel();    //Instanciation de la map
        fenetre.add(panelMap, BorderLayout.WEST);
        
       // ile = new VueIle.MyCanvas();    //Instantiation du dessin
       // panelMap.add(ile);   //Ajout du dessin au panelMap
        
        
        /*Panel Bouton*/
        
        panelBouton = new JPanel(new GridLayout(6,1));
        fenetre.add(panelBouton, BorderLayout.EAST);
        
        finTour = new JButton("Fin du Tour");
        deplacer = new JButton("Se Deplacer");
        assecher = new JButton("Assecher une Case");
        donner = new JButton("Donner une carte");
        
        panelBouton.add(finTour);
        panelBouton.add(deplacer);
        panelBouton.add(assecher);
        panelBouton.add(donner);
        
        
        
    }  
    
    public void afficher() {
        /* Affichage de la fenetre */
        fenetre.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        fenetre.setSize(1650, 950);
        fenetre.setVisible(true);      
    }
    
}
