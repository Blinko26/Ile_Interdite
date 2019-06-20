/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;
import Controleur.Controleur;
import Controleur.Message;
import Controleur.Observe;
import Controleur.TypesMessages;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author viellarb
 */
public class VueDefaite extends Observe{
    private JPanel panelBouton;
    
    private JButton rejouer;
    private JButton quitter;
    private JLabel perdu;
    private JLabel contentPane;

    private ImageIcon imgBack;
    private File path;
    
    private JPanel panBack;

    private JFrame fenetre;
    
    public VueDefaite(){        
        // main window
        fenetre = new JFrame("Défaite");
        
        
        panelBouton = new JPanel(new GridLayout(2,5));
        fenetre.add(panelBouton);
        
        rejouer = new JButton("Rejouer");
        quitter = new JButton("Quitter");

        
        perdu = new JLabel("Vous avez perdu");
        perdu.setFont(new Font("Liberation Serif", Font.PLAIN, 50));
        perdu.setForeground(java.awt.Color.gray);
        perdu.setHorizontalAlignment(JLabel.CENTER);
        perdu.setVerticalAlignment(JLabel.CENTER);
        
        panBack = new JPanel();
        panBack.setOpaque(false);
        path = new File("");
        imgBack = new ImageIcon(path.getAbsolutePath()+"/src/Image/fondinscription.jpg");
        contentPane = new JLabel();
        contentPane.setIcon(imgBack);
        contentPane.setLayout(new BorderLayout());
        contentPane.setOpaque(false);
        fenetre.setContentPane(contentPane);
        fenetre.getContentPane().add(panBack);
        
        fenetre.add(perdu, BorderLayout.CENTER);
        
        panelBouton.add(new JLabel());
        panelBouton.add(rejouer);
        panelBouton.add(new JLabel());
        panelBouton.add(quitter);
        for(int i = 0; i<6; i++){
            panelBouton.add(new JLabel());
        }
        
        perdu.setOpaque(false);
        quitter.setOpaque(false);
        rejouer.setOpaque(false);
        panelBouton.setOpaque(false);
        fenetre.add(panelBouton, BorderLayout.SOUTH);
        
        rejouer.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               fenetre.dispose();
                    Message m = new Message();
                    m.type = TypesMessages.REJOUER;    
                    notifierObservateur(m);
           } 
        });
        
        quitter.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               fenetre.dispose();
           } 
        });
        
        configureWindow(fenetre);
    }
    
        private void configureWindow(JFrame window) {
        window.setSize(imgBack.getIconWidth()-200, imgBack.getIconHeight()-300);
        window.setVisible(true);
        window.setResizable(true);
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
