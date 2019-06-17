/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import Controleur.Message;
import Controleur.Observe;
import Controleur.TypesMessages;
import ile_interdite.Application;
import ile_interdite.EtatC;
import ile_interdite.Tuile;
import ile_interdite.CarteTresor;
import ile_interdite.TypeAventurier;
import ile_interdite.TypeCT;
import ile_interdite.Joueur;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.Scanner;
import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author bihanb
 */
public class VueDébut extends Observe {
    
    private JFrame fenetre;
    
    private JLabel titre;
    
    private JButton jouer;
    private JButton regle;
     
    private JPanel panelHaut;
    private JPanel panelMilieu;
    private JPanel panelBas;
    
    private JComboBox nbJoueurs;
    
    private JLabel joueur1;
    private JLabel joueur2;
    private JLabel joueur3;
    private JLabel joueur4;
    
    private JTextField nj1;
    private JTextField nj2;
    private JTextField nj3;
    private JTextField nj4;
    
    private JSlider choixNbJoueurs;
    
        public VueDébut() {
            
            fenetre = new JFrame("Début");
            this.configureWindow(fenetre);
            fenetre.setVisible(true);
            fenetre.setLayout(new GridLayout(3,1));
            panelHaut = new JPanel();
            panelHaut.setLayout(new GridLayout(1,3));
            fenetre.add(panelHaut);
            panelMilieu = new JPanel();
            panelMilieu.setLayout(new GridLayout(10,2));
            fenetre.add(panelMilieu);
            panelBas = new JPanel();
            panelBas.setLayout(new GridLayout(3,4));
            fenetre.add(panelBas);
            
            titre = new JLabel("L'Ile Interdite");
            panelHaut.add(new JLabel());
            panelHaut.add(titre, BorderLayout.CENTER);
            
            jouer = new JButton("jouer");
            jouer.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    fenetre.dispose();
                    Message m = new Message();
                    m.type = TypesMessages.DEMARRER_PARTIE;
                    notifierObservateur(m);
                }
            });
            panelBas.add(new JLabel());
            panelBas.add(new JLabel());
            panelBas.add(new JLabel());
            panelBas.add(new JLabel());
            panelBas.add(new JLabel());
            panelBas.add(new JLabel());
            panelBas.add(new JLabel());
            panelBas.add(new JLabel());
            panelBas.add(new JLabel());
            panelBas.add(jouer);
            
            regle = new JButton("regles");
            panelBas.add(regle);
            
            
            joueur1 = new JLabel("Nom joueur 1 : ");
            joueur2 = new JLabel("Nom joueur 2 : ");
            joueur3 = new JLabel("Nom joueur 3 : ");
            joueur4 = new JLabel("Nom joueur 4 : ");
            
            nj1 = new JTextField("Joueur1");
            nj2 = new JTextField("Joueur2");
            nj3 = new JTextField("Joueur3");
            nj4 = new JTextField("Joueur4");
            
            choixNbJoueurs = new JSlider(SwingConstants.HORIZONTAL, 2, 4, 4);
            choixNbJoueurs.setPaintLabels(true);
            choixNbJoueurs.setPaintTicks(true);
            choixNbJoueurs.setMajorTickSpacing(1);
            choixNbJoueurs.setMinorTickSpacing(1);
            panelMilieu.add(choixNbJoueurs);

            
            panelMilieu.add(new JLabel("Nombre de joueurs : "));
            panelMilieu.add(nbJoueurs);
            
            
            panelMilieu.add(joueur1);
            panelMilieu.add(nj1);
            
            panelMilieu.add(joueur2);
            panelMilieu.add(nj2);           
            
            panelMilieu.add(joueur3);
            panelMilieu.add(nj3);
            
            panelMilieu.add(joueur4);
            panelMilieu.add(nj4);
            
                        
            /*choixNbJoueurs.addChangeListener(new ChangeListener() {
                public void stateChanged(ChangeEvent e) {
                    if(choixNbJoueurs.getValue()==2){
                        nj3.setEnabled(false);
                        nj4.setEnabled(false);
                    }
                    else if (choixNbJoueurs.getValue()==3){
                        
                    }
                    else if (choixNbJoueurs.getValue()==4){
                        
                    }
                }
            });*/
        }
    
    private void configureWindow(JFrame window) {
        window.setSize(600, 400);
        window.setDefaultCloseOperation(javax.swing.JFrame.DO_NOTHING_ON_CLOSE);
        window.addWindowListener(new java.awt.event.WindowListener() {
            public void windowOpened(java.awt.event.WindowEvent e) {}
            public void windowClosed(java.awt.event.WindowEvent e) {}
            public void windowIconified(java.awt.event.WindowEvent e) {}
            public void windowDeiconified(java.awt.event.WindowEvent e) {}
            public void windowActivated(java.awt.event.WindowEvent e) {}
            public void windowDeactivated(java.awt.event.WindowEvent e) {}
            public void windowClosing(java.awt.event.WindowEvent e) { 
                System.exit(0);
            }
        });
    }
}
