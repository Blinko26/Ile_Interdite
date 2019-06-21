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
 * @author bihanb
 */
public class VueCartesSpé extends Observe {
    private JPanel mainPanel;
    
    
    private JLabel titre;
    private JButton voler;
    private JButton assecher;
    private JComboBox caseAChoisir;
    private JFrame fenetre;
    
    
    public VueCartesSpé(){
        fenetre = new JFrame();
        mainPanel = new JPanel(new GridLayout(4,1));
        
        caseAChoisir = new JComboBox();
        voler = new JButton("S'envoler");
        assecher = new JButton("Assecher");
        
        titre= new JLabel("Utilisez votre carte spécial");
        mainPanel.add(titre);
        fenetre.add(mainPanel);
        
        configureWindow(fenetre);
    }
    
    public void lancerVueCarteSpé(Joueur j, Boolean helOrSac){
        if(helOrSac){
            for (Tuile tuile : j.getRoleJoueur().getPosition().getIledescases().getCase2ile()){
                if(tuile.getEtat() !=EtatC.sombrée){
                    caseAChoisir.addItem(tuile.getNom());
                }    
            }
            
            mainPanel.add(caseAChoisir);
            mainPanel.add(voler);
        }
        else{
            for (Tuile tuile : j.getRoleJoueur().getPosition().getIledescases().getCase2ile()){
                if(tuile.getEtat() ==EtatC.innondée){
                    caseAChoisir.addItem(tuile.getNom());
                }    
            }
            mainPanel.add(caseAChoisir);
            mainPanel.add(assecher);
        }
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

    public JButton getVoler() {
        return voler;
    }

    public JButton getAssecher() {
        return assecher;
    }
    
    public JComboBox getTuileSelected(){
        return caseAChoisir;
    }
    public void fermerFenetre(){
        fenetre.dispose();
    }
}
