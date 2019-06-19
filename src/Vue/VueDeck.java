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
    private JButton[] buttonCarte; 
    private ImageIcon imgCarte;
    private File path;
    private JLabel joueur;
    private JButton btGauche;
    private JButton btDroite;
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
       
       
       
       btGauche = new JButton("<==");
       btDroite = new JButton("==>");
       
       mainPanel.add(btDroite, BorderLayout.EAST);       
       mainPanel.add(btGauche, BorderLayout.WEST);
       mainPanel.add(panelCartes, BorderLayout.CENTER);
       this.add(mainPanel);
       this.setVisible(true);
       
    }
    
    public void actualiserDeck(ArrayList<CarteTresor> cartesT){
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
    }
}
