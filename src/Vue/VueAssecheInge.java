/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;
import Controleur.Observe;
import ile_interdite.Joueur;
import ile_interdite.Tuile;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import ile_interdite.EtatC;
/**
 *
 * @author bretonem
 */
public class VueAssecheInge extends Observe {
    private JPanel mainPanel;
    
    
    private JLabel titre;
    private JButton annuler;
    private JButton assecher;
    private JComboBox caseAChoisir;
    private JFrame fenetre;
    
    
    public VueAssecheInge(){
        fenetre = new JFrame();
        mainPanel = new JPanel(new GridLayout(4,1));
        
        caseAChoisir = new JComboBox();
        annuler = new JButton("Ne pas assécher de deuxième case");
        assecher = new JButton("Assecher une deuxième case");
        
        titre= new JLabel("Voulez-vous assecher une deuxième case ?");
        mainPanel.add(titre);
        fenetre.add(mainPanel);
        
        configureWindow(fenetre);
    }
    
    public void lancerVueAssecheInge(Joueur j){
        for (Tuile tuile : j.getRoleJoueur().getTuileAssechable()){
            caseAChoisir.addItem(tuile.getNom());   
        }    
        mainPanel.add(caseAChoisir);
        mainPanel.add(assecher);

        mainPanel.add(new JLabel());
        mainPanel.add(annuler);
    }
    
    private void configureWindow(JFrame window) {
        window.setSize(200, 300);
        window.setVisible(true);
        window.setResizable(false);
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

    public JButton getAssecher() {
        return assecher;
    }
    
    public JButton getAnnuler() {
        return annuler;
    }
    
    public JComboBox getTuileSelected(){
        return caseAChoisir;
    }
    
    public void fermerFenetre(){
        fenetre.dispose();
    }
}
