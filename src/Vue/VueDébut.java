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
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;

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
    
        public VueDébut() {
            
            fenetre = new JFrame("Début");
            this.configureWindow(fenetre);
            fenetre.setVisible(true);
            fenetre.setLayout(new BorderLayout());
            
            panelHaut = new JPanel();
            panelHaut.setLayout(new BorderLayout());
            fenetre.add(panelHaut, BorderLayout.NORTH);
            panelMilieu = new JPanel();
            fenetre.add(panelMilieu, BorderLayout.CENTER);
            panelBas = new JPanel();
            panelBas.setLayout(new GridLayout());
            fenetre.add(panelBas, BorderLayout.SOUTH);
            
            titre = new JLabel("L'ile interdite");
            panelHaut.add(titre, BorderLayout.CENTER);
            
            jouer = new JButton("jouer");
            panelBas.add(jouer);
            
            regle = new JButton("regles");
            panelBas.add(regle);
            
            
        }
    
    private void configureWindow(JFrame window) {
        window.setSize(500, 200);
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
