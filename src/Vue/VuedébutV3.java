/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;


import Controleur.Message;
import Controleur.Observe;
import Controleur.TypesMessages;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
    private javax.swing.JButton Aide;
    private javax.swing.JButton Jouer;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JColorChooser jColorChooser1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JLabel nbJoueurs;
    private javax.swing.JLabel nj1;
    private javax.swing.JLabel nj2;
    private javax.swing.JLabel nj3;
    private javax.swing.JLabel nj4;
    private javax.swing.JTextField nomJoueur2;
    private javax.swing.JTextField nomJoueur3;
    private javax.swing.JTextField nomJoueur4;
    private javax.swing.JTextField nomjoueur1;
    private java.awt.Label titre;
    private JLabel difficulté;
    private JComboBox choixDifficulté;
    
    public VuedébutV3() {
        fenetre = new JFrame();
        configureWindow(fenetre);
        buttonGroup1 = new javax.swing.ButtonGroup();
        titre = new java.awt.Label();
        nbJoueurs = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        nj1 = new javax.swing.JLabel();
        nj2 = new javax.swing.JLabel();
        nj3 = new javax.swing.JLabel();
        nj4 = new javax.swing.JLabel();
        nomjoueur1 = new javax.swing.JTextField();
        nomJoueur2 = new javax.swing.JTextField();
        nomJoueur3 = new javax.swing.JTextField();
        nomJoueur4 = new javax.swing.JTextField();
        Jouer = new javax.swing.JButton();
        Aide = new javax.swing.JButton();
        difficulté = new javax.swing.JLabel();
        choixDifficulté = new javax.swing.JComboBox<>();

        titre.setText("l'Ile Interdite");

        nbJoueurs.setText("Choisissez le nombre de joueurs : ");

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("2 joueurs");

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("3 joueurs");

        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setText("4 joueurs");

        nj1.setText("Nom joueur 1 : ");

        nj2.setText("Nom joueur 2 : ");

        nj3.setText("Nom joueur 3 : ");

        nj4.setText("Nom joueur 4 : ");

        nomjoueur1.setText("Joueur1");

        nomJoueur2.setText("Joueur2");

        nomJoueur3.setText("Joueur3");

        nomJoueur4.setText("Joueur4");

        Jouer.setText("Jouer");
        Jouer.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               fenetre.dispose();
                    Message m = new Message();
                    m.type = TypesMessages.DEMARRER_PARTIE;
                    notifierObservateur(m);
           } 
        });


        Aide.setText("Aide");
        
        difficulté.setText("Choisissez la diffculté");

        choixDifficulté.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Novice", "Normale", "Elite", "Légendaire" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(fenetre.getContentPane());
        fenetre.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Jouer)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Aide)
                .addGap(89, 89, 89))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jRadioButton3)
                            .addComponent(jRadioButton2)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(nbJoueurs)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jRadioButton1))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(nj4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(nomJoueur4))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(nj3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(nomJoueur3))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(nj2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(nomJoueur2))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(nj1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(nomjoueur1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(difficulté)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(choixDifficulté, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(205, 205, 205)
                        .addComponent(titre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(titre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nbJoueurs)
                    .addComponent(jRadioButton1)
                    .addComponent(difficulté)
                    .addComponent(choixDifficulté, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton3)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nj1)
                    .addComponent(nomjoueur1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nj2)
                    .addComponent(nomJoueur2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nj3)
                    .addComponent(nomJoueur3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nj4)
                    .addComponent(nomJoueur4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Jouer)
                    .addComponent(Aide)))
        );
    }                            

    private void configureWindow(JFrame window) {
        window.setSize(700, 400);
        window.setVisible(true);
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
