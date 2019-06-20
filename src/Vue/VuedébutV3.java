/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;


import Controleur.Message;
import Controleur.Observe;
import Controleur.TypesMessages;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Label;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author bihanb
 */

/**
 *
 * @author bihanb
 */
public class VuedébutV3 extends Observe {
    
    private JFrame fenetre;
    private JButton Aide;
    private JButton Jouer;
    private ButtonGroup buttonGroup1;
    private JRadioButton jRadioButton1;
    private JRadioButton jRadioButton2;
    private JRadioButton jRadioButton3;
    private JLabel nbJoueurs;
    private JLabel nj1;
    private JLabel nj2;
    private JLabel nj3;
    private JLabel nj4;
    private JTextField nomJoueur2;
    private JTextField nomJoueur3;
    private JTextField nomJoueur4;
    private JTextField nomjoueur1;
    private Label titre;
    private JLabel difficulté;
    private JComboBox choixDifficulté;
    private ImageIcon imgBackground;
    private JLabel contentPane;
    private JPanel panBack;
    private JPanel panelBouton;
    private JPanel panelNbJoueur;
    private JPanel panelDifficulte;
    private JPanel panelNomJoueur;
    private JPanel panelBas;
    
    public VuedébutV3() {
        fenetre = new JFrame();
        buttonGroup1 = new ButtonGroup();
        titre = new Label();
        nbJoueurs = new JLabel();
        jRadioButton1 = new JRadioButton();
        jRadioButton2 = new JRadioButton();
        jRadioButton3 = new JRadioButton();
        jRadioButton1.setOpaque(false);
        jRadioButton2.setOpaque(false);      
        jRadioButton3.setOpaque(false);     
        nj1 = new JLabel();
        nj2 = new JLabel();
        nj3 = new JLabel();
        nj4 = new JLabel();
        nomjoueur1 = new JTextField();
        nomJoueur2 = new JTextField();
        nomJoueur3 = new JTextField();
        nomJoueur4 = new JTextField();     
        Jouer = new JButton();
       
        Aide = new JButton("Aide");
        difficulté = new JLabel("Choisissez la diffculté");
        choixDifficulté = new JComboBox<>();
        
        panBack = new JPanel();
        panBack.setOpaque(false);
        File path = new File("");
        imgBackground = new ImageIcon(path.getAbsolutePath()+"/src/Image/fond.png");
        contentPane = new JLabel();
        contentPane.setIcon(imgBackground);
        contentPane.setLayout(new BorderLayout());
        fenetre.setContentPane(contentPane);
        
        fenetre.getContentPane().add(panBack);
        
        nbJoueurs.setText("Nombre de Joueurs : ");

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("2 joueurs");

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("3 joueurs");
        
        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setText("4 joueurs");
        jRadioButton3.setSelected(true);

        nj1.setText("Nom joueur 1 : ");
        nj2.setText("Nom joueur 2 : ");
        nj3.setText("Nom joueur 3 : ");
        nj4.setText("Nom joueur 4 : ");

        nomjoueur1.setText("Joueur1");
        nomJoueur2.setText("Joueur2");
        nomJoueur3.setText("Joueur3");
        nomJoueur4.setText("Joueur4");
        
        JPanel panelTest = new JPanel(new GridLayout(3,3));
        panelBouton = new JPanel(new GridLayout(4,1));
        panelNbJoueur = new JPanel(new GridLayout(1,4));
        panelDifficulte = new JPanel(new GridLayout(1,5));
        panelNomJoueur = new JPanel(new GridLayout(2,4));
        panelBas = new JPanel(new GridLayout(3,5,60,60)); 
        panelBas.add(Jouer);
        
        panelNbJoueur.add(nbJoueurs);
        panelNbJoueur.add(jRadioButton1);
        panelNbJoueur.add(jRadioButton2);
        panelNbJoueur.add(jRadioButton3);
        panelBouton.add(panelNbJoueur);
        
        panelDifficulte.add(new JLabel());
        panelDifficulte.add(difficulté, BorderLayout.WEST);
        panelDifficulte.add(new JLabel());
        panelDifficulte.add(choixDifficulté, BorderLayout.EAST);
        panelDifficulte.add(new JLabel());
        panelBouton.add(panelDifficulte);
        
        panelNomJoueur.add(nj1);
        panelNomJoueur.add(nomjoueur1);
        panelNomJoueur.add(nj2);
        panelNomJoueur.add(nomJoueur2);
        panelNomJoueur.add(nj3);
        panelNomJoueur.add(nomJoueur3);
        panelNomJoueur.add(nj4);
        panelNomJoueur.add(nomJoueur4);
        panelBouton.add(panelNomJoueur);
        for(int i = 0; i<6; i++){
           panelBas.add(new JLabel()); 
        }
        panelBas.add(Jouer);
        panelBas.add(new JLabel());
        panelBas.add(Aide);
        for(int i = 0; i<6; i++){
           panelBas.add(new JLabel()); 
        }
        
        panelBouton.setOpaque(true);
        
        panelBouton.setOpaque(false); 
        panelNbJoueur.setOpaque(false); 
        panelDifficulte.setOpaque(false); 
        panelNomJoueur.setOpaque(false);
        panelBas.setOpaque(false);
        panelTest.setOpaque(false);
        
        panelTest.add(new JLabel());
        panelTest.add(panelBouton);
        panelTest.add(panelBas);
        
        fenetre.add(panelTest, BorderLayout.CENTER);
                
        
        Jouer.setText("Jouer");
        Jouer.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               fenetre.dispose();
                    Message m = new Message();
                    m.type = TypesMessages.DEMARRER_PARTIE;
                    if (jRadioButton1.isSelected()){
                        m.nbJoueurs = 2;
                    }
                    else if (jRadioButton2.isSelected()){
                        m.nbJoueurs = 3;
                    }
                    else if (jRadioButton1.isSelected()){
                        m.nbJoueurs = 4;
                    }
                    
                    m.nj1 = nomjoueur1.getText();
                    m.nj2= nomJoueur2.getText();
                    m.nj3= nomJoueur3.getText();
                    m.nj4= nomJoueur4.getText();
                    m.difficulté=choixDifficulté.getSelectedItem().toString();
                    notifierObservateur(m);
           } 
        });       
        
        choixDifficulté.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Novice", "Normale", "Elite", "Légendaire" }));

                configureWindow(fenetre);

    }

    class TestImagePanel extends JPanel {

            private static final long serialVersionUID = 1L;
            private Image img;

            public TestImagePanel(String img) {
                    this(new ImageIcon(img).getImage());
            }

            public TestImagePanel(Image img) {
                    this.img = img;
                    Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
                    setPreferredSize(size);
                    setMinimumSize(size);
                    setMaximumSize(size);
                    setSize(size);
                    setLayout(null);
            }

            public void paintComponent(Graphics g) {
                    g.drawImage(img, 0, 0, null);
            }
    }
    
    private void configureWindow(JFrame window) {
        window.setSize(imgBackground.getIconWidth(), imgBackground.getIconHeight()+30);
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
}
