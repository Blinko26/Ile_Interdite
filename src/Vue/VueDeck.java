/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import ile_interdite.CarteTresor;
import ile_interdite.Joueur;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author viellarb
 */
public class VueDeck extends JPanel {
    private JPanel mainPanel;
    private JPanel panelCartes;
    private JPanel panelOption;
    private JPanel panelJoueur;
    
    private JButton[] buttonCarte; 
    private ImageIcon imgCarte;
    private File path;
    private JLabel joueur;
    
    private JButton j1;
    private JButton j2;
    private JButton j3;
    private JButton j4;
    
    private JButton buttonDonner;
    private JButton buttonRetour;
    private JButton buttonDeffauser;
    
    
    public VueDeck(ArrayList<CarteTresor> cartesT){
       mainPanel = new JPanel(new BorderLayout());
       panelCartes = new JPanel();  
       
       // main window
        JFrame frame = new JFrame("Niveau D'Eau");
        frame.setSize(300,200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
       //panel option
       panelOption = new JPanel(new GridLayout(3,1));
       
       buttonDonner = new JButton("Donner Carte");
       buttonRetour = new JButton("Retour");
       buttonDonner.setEnabled(false);
       buttonRetour.setEnabled(false);
       
       
       panelOption.add(buttonDonner);
       panelOption.add(buttonRetour);
       
       buttonDonner.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent arg0) {
               throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
           }
       });
       
       buttonRetour.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent arg0) {
                   for(int i =0; i<cartesT.size();i++){
                        buttonCarte[i].setEnabled(true);
                   }
                   buttonDonner.setEnabled(false);
                   buttonRetour.setEnabled(false);           }
       });
       
       mainPanel.add(panelOption, BorderLayout.SOUTH);
       
       joueur = new JLabel("test");
       mainPanel.add(joueur , BorderLayout.NORTH);
       
       int i=0; 
       buttonCarte = new JButton[cartesT.size()];
       for(CarteTresor carte:cartesT){
           //Création du bouton avec l'image
           path = new File("");
           imgCarte = new ImageIcon(path.getAbsolutePath()+"/src/Image/"+carte.getType().toString()+".png");
           buttonCarte[i]= new JButton(imgCarte);
           panelCartes.add(buttonCarte[i]);
           //ajout de son actionlistener
           int test = i;
           buttonCarte[i].addActionListener(new ActionListener() {
               
               public void actionPerformed(ActionEvent arg0) {
                   
                   for(int i =0; i<cartesT.size();i++){
                       if (i!=test){
                            buttonCarte[i].setEnabled(false);
                            
                       }
                   }
                   buttonDonner.setEnabled(true);
                   buttonRetour.setEnabled(true);
               }
           });
           i++;
       }
            
       j1 = new JButton("J1");
       j2 = new JButton("J2");
       j3 = new JButton("J3");
       j4 = new JButton("J4");
       
       panelJoueur = new JPanel(new GridLayout(1,4));
       panelJoueur.add(j1);
       panelJoueur.add(j2);
       panelJoueur.add(j3);
       panelJoueur.add(j4);
       
       mainPanel.add(panelJoueur, BorderLayout.SOUTH);       
       mainPanel.add(panelCartes, BorderLayout.CENTER);
       this.add(mainPanel);
       this.setVisible(true);
       
    }
    
    public void actualiserDeck(Joueur j,ArrayList<CarteTresor> cartesT){
       panelCartes.removeAll();
       buttonDonner.setEnabled(false);
       buttonRetour.setEnabled(false);
       int i=0; 
       buttonCarte = new JButton[cartesT.size()];
       for(CarteTresor carte:cartesT){
           //Création du bouton avec l'image
           path = new File("");
           imgCarte = new ImageIcon(path.getAbsolutePath()+"/src/Image/"+carte.getType().toString()+".png");
           buttonCarte[i]= new JButton(imgCarte);
           panelCartes.add(buttonCarte[i]);
           //ajout de son actionlistener
           int test = i;
           buttonCarte[i].addActionListener(new ActionListener() {
               
               public void actionPerformed(ActionEvent arg0) {
                   
                   for(int i =0; i<cartesT.size();i++){
                       if (i!=test){
                            buttonCarte[i].setEnabled(false);
                            
                       }
                   }
                   buttonDonner.setEnabled(true);
                   buttonRetour.setEnabled(true);
               }
           });
           i++;
       }
       buttonRetour.removeAll();
       buttonRetour.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent arg0) {
                   for(int i =0; i<cartesT.size();i++){
                        buttonCarte[i].setEnabled(true);
                   }
                   buttonDonner.setEnabled(false);
                   buttonRetour.setEnabled(false);           }
       });
       
       joueur.setText("Deck de : "+j.getNomJoueur()+" "+j.getRoleJoueur().getRoleToString());
    }

    public JButton getJ1() {
        return j1;
    }

    public JButton getJ2() {
        return j2;
    }

    public JButton getJ3() {
        return j3;
    }

    public JButton getJ4() {
        return j4;
    }
    
   public void setROUGE(JButton bt){
       bt.setBackground(java.awt.Color.red);
   }
   
   public void setColorDefault(JButton bt){
       bt.setBackground(java.awt.Color.LIGHT_GRAY);
   }
   
}
