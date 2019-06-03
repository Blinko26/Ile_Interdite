/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import ile_interdite.Application;
import ile_interdite.EtatC;
import ile_interdite.Tuile;
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
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;


/**
 *
 * @author IUT2
 */
public class VueIle extends Observe {
    private static Application application;
    private static int etatJeu=1;
    private static int debut=0;
    private static int [] emplacementsouris={0,0};
    private static boolean presse=false;
    private static int joueurcourant=1;
    
    
    public static class MyCanvas extends JPanel {

        @Override
        public void paintComponent (Graphics g) {  //permet de dessiner la carte de l'ile
            Graphics2D g2d = (Graphics2D) g;
            Dimension size = getSize();
            
            g2d.setColor(Color.white);
            g2d.fillRect(0, 0, (int) size.getWidth(), (int) size.getHeight());

            
            
            for(int j=0;j<=5;j++){
                for(int i=0;i<=5;i++){
                    if(application.getIle().getTuile(i+1,j+1).getEtat()==EtatC.normale){
                        g2d.setColor(new Color(255,255,127));
                    }
                    if(application.getIle().getTuile(i+1,j+1).getEtat()==EtatC.innondée){
                        g2d.setColor(new Color(0,255,255));
                    }
                    if(application.getIle().getTuile(i+1,j+1).getEtat()==EtatC.sombrée){
                        g2d.setColor(new Color(0,0,255));
                    }
                    //for (int[] tuile : application.getJoueurs().get(0).getRoleJoueur().getPosition().getTuilesAdj()){
                    //    application.getIle().getTuile(tuile[0], tuile [1]).setSurligné(true);
                    //}
                       // if(emplacementsouris[0]==7 && emplacementsouris[1]==2 && application.getIle().getTuile(i+1,j+1).getType()!=TypeC.nulle && application.getIle().getTuile(i+1,j+1)!=application.getIle().getTuile(tuile[0],tuile[1])){
                         //   g2d.setColor(new Color(255,0,255));
                        //}
                    
                    g2d.fillRect(8+2*i+i*(int)((int) (size.getWidth()-30)*7/8)/6, 8+2*j+j*(int)((int) size.getHeight()-30)/6, (int)((int) (size.getWidth()-30)*7/8)/6, (int)((int) size.getHeight()-30)/6);
                    
                }
            }
            int placement=0;
            for(int i=0;i<application.getJoueurs().size();i++){
                int xjoueur=placement+8+2*(application.getJoueurs().get(i).getRoleJoueur().getEmplacement()[0]-1)+(application.getJoueurs().get(i).getRoleJoueur().getEmplacement()[0]-1)*(int)((int) (size.getWidth()-30)*7/8)/6 +(int)((int) (size.getWidth()-30)*7/8)/12-10;
                g2d.setColor(application.getJoueurs().get(i).getRoleJoueur().getCouleur());
                g2d.fillOval(xjoueur,8+2*(application.getJoueurs().get(i).getRoleJoueur().getEmplacement()[1]-1)+(application.getJoueurs().get(i).getRoleJoueur().getEmplacement()[1]-1)*(int)((int) size.getHeight()-30)/6+(int)((int) size.getHeight()-30)/12 -10, 20, 20);
                g2d.setColor(new Color(0,0,0));
                g2d.drawOval(xjoueur,8+2*(application.getJoueurs().get(i).getRoleJoueur().getEmplacement()[1]-1)+(application.getJoueurs().get(i).getRoleJoueur().getEmplacement()[1]-1)*(int)((int) size.getHeight()-30)/6+(int)((int) size.getHeight()-30)/12 -10, 20, 20);
                placement=placement+10;
            }
            
            int ex1=0;
            int ey1=0;
            int ex2=0;
            int ey2=0;
            for(int i=0;i<application.getTrésors().size();i++){
                if(application.getTrésors().get(i).getNom()==ile_interdite.TypeT.calice){
                    g2d.setColor(new Color(0,192,255));
                    ex1=application.getIle().getTuile("Le Palais de Corail").getEmplacementX()-1;
                    ey1=application.getIle().getTuile("Le Palais de Corail").getEmplacementY()-1;
                    ex2=application.getIle().getTuile("Le Palais des Marees").getEmplacementX()-1;
                    ey2=application.getIle().getTuile("Le Palais des Marees").getEmplacementY()-1;
                }
                if(application.getTrésors().get(i).getNom()==ile_interdite.TypeT.cristal){
                    g2d.setColor(new Color(255,64,0));
                    ex1=application.getIle().getTuile("La Caverne du Brasier").getEmplacementX()-1;
                    ey1=application.getIle().getTuile("La Caverne du Brasier").getEmplacementY()-1;
                    ex2=application.getIle().getTuile("La Caverne des Ombres").getEmplacementX()-1;
                    ey2=application.getIle().getTuile("La Caverne des Ombres").getEmplacementY()-1;
                }
                if(application.getTrésors().get(i).getNom()==ile_interdite.TypeT.pierre){
                    g2d.setColor(new Color(128,0,200));
                    ex1=application.getIle().getTuile("Le Temple de La Lune").getEmplacementX()-1;
                    ey1=application.getIle().getTuile("Le Temple de La Lune").getEmplacementY()-1;
                    ex2=application.getIle().getTuile("Le Temple du Soleil").getEmplacementX()-1;
                    ey2=application.getIle().getTuile("Le Temple du Soleil").getEmplacementY()-1;
                }
                if(application.getTrésors().get(i).getNom()==ile_interdite.TypeT.statue){
                    g2d.setColor(new Color(255,200,0));
                    ex1=application.getIle().getTuile("Le Jardin des Murmures").getEmplacementX()-1;
                    ey1=application.getIle().getTuile("Le Jardin des Murmures").getEmplacementY()-1;
                    ex2=application.getIle().getTuile("Le Jardin des Hurlements").getEmplacementX()-1;
                    ey2=application.getIle().getTuile("Le Jardin des Hurlements").getEmplacementY()-1;
                }
                g2d.fillOval(8+2*ex1+ex1*(int)((int) (size.getWidth()-30)*7/8)/6+2,8+2*ey1+ey1*(int)((int) (size.getWidth()-30)*7/8)/6+(int)((int) size.getHeight()-30)/12,10, 15); 
                g2d.fillOval(8+2*ex2+ex2*(int)((int) (size.getWidth()-30)*7/8)/6+2,8+2*ey2+ey2*(int)((int) (size.getWidth()-30)*7/8)/6+(int)((int) size.getHeight()-30)/12,10, 15);
                g2d.setColor(new Color(0,0,0));
                g2d.drawOval(8+2*ex1+ex1*(int)((int) (size.getWidth()-30)*7/8)/6+2,8+2*ey1+ey1*(int)((int) (size.getWidth()-30)*7/8)/6+(int)((int) size.getHeight()-30)/12,10, 15);
                g2d.drawOval(8+2*ex2+ex2*(int)((int) (size.getWidth()-30)*7/8)/6+2,8+2*ey2+ey2*(int)((int) (size.getWidth()-30)*7/8)/6+(int)((int) size.getHeight()-30)/12,10, 15);
            }
            
            g2d.setColor(new Color(255,0,0));
            for(int j=0;j<=5;j++){
                for(int i=0;i<=5;i++){
                    g2d.drawString("Nom : "+application.getIle().getTuile(i+1, j+1).getNom(), 8+2*i+i*(int)((int) (size.getWidth()-30)*7/8)/6+20, 8+2*j+j*(int)((int) size.getHeight()-30)/6+30);
                    g2d.drawString("Coord : "+application.getIle().getTuile(i+1, j+1).getEmplacementX()+", "+application.getIle().getTuile(i+1, j+1).getEmplacementY(), 8+2*i+i*(int)((int) (size.getWidth()-30)*7/8)/6+20, 8+2*j+j*(int)((int) size.getHeight()-30)/6+45);
                }
            } 
            
            for(int i=0;i<application.getJoueurs().size();i++){
                if(application.getIle().getTuile(application.getJoueurs().get(i).getRoleJoueur().getEmplacement()[0],application.getJoueurs().get(i).getRoleJoueur().getEmplacement()[1]).getEtat()==EtatC.sombrée ||application.getIle().getTuile("Heliport").getEtat()==EtatC.sombrée){
                    g2d.setColor(new Color(0,0,255));
                    g2d.fillRect(0, 0, (int) size.getWidth(), (int) size.getHeight());
                    g2d.setColor(new Color(255,0,128));
                    g2d.drawString("Perdu !", size.width/2, size.height/2);
                }
            }
            
            if(debut==0 && !presse){
                g2d.setColor(Color.white);
                g2d.fillRect(0, 0, (int) size.getWidth(), (int) size.getHeight());
                g2d.setColor(new Color(0,0,0));
                g2d.drawString("Pour commencer cliquer", size.width/2, size.height/2);
            }
        }
    }
    
     /*Déclaration des éléments de la fenetre*/
    private JFrame fenetre;
    private JPanel panelMap;
    private JPanel panelBouton;
    
    private MyCanvas canvas;
    
    // private VueIle.MyCanvas ile;
    
    private JLabel joueurCourant; //Indique le joueur courant3
    private JLabel pa; //Indique le joueur courant3

    private JButton finTour;    //Bouton pour finir son tour
    private JButton deplacer;   // bouton pour se deplacer
    private JButton assecher;   // Bouton pour assecher une case
    private JButton donner; //Bouton pour donner une carte
    
    private JComboBox listeDeroulanteBouger;
    private JComboBox listeDeroulanteAssecher;
    
    private String[] tuile;
    private String[] tuileA;
    
    public VueIle(Application appli) {
        
        application = appli;
        
        
        /* Instanciation et configuration du composant fenetre */
        fenetre = new JFrame("Ile interdite");
        this.configureWindow(fenetre);

        panelMap = new JPanel();    //Instanciation de la map
        fenetre.add(panelMap, BorderLayout.WEST);
        
        panelBouton = new JPanel(new GridLayout(6,1));
        fenetre.add(panelBouton, BorderLayout.EAST);
        /****************************************************************/
        canvas = new MyCanvas();
        fenetre.add(canvas);
        
        canvas.addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {
                if (debut==0){
                    debut=1;
                    presse=!presse;
                    application.initPartie();
                }
                if(e.getX()<=2*6+6*(int)((int) (1650-30)*7/8)/6){
                    emplacementsouris[0]=(int)(e.getX()-8)/(2+((1650-30)*7/8)/6)+1;
                    emplacementsouris[1]=(int)(e.getY()-8)/(2+((950-30)*7/8)/6)+1;
                    presse=!presse;
                }
                if(e.getX()>=1475 && e.getX()<=1625 && e.getY()>=10 && e.getY()<=85){
                    System.out.println("Asseché");
                    emplacementsouris[0]=7;
                    emplacementsouris[1]=1;
                }
                if(e.getX()>=1475 && e.getX()<=1625 && e.getY()>=87 && e.getY()<=162){
                    System.out.println("Déplacé");
                    emplacementsouris[0]=7;
                    emplacementsouris[1]=2;
                }
                fenetre.repaint();
            }
            @Override
            public void mousePressed(MouseEvent e) {
            } 

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            } 

            @Override
            public void mouseExited(MouseEvent e) {
            }
        }

);
        
               /*Panel Bouton*/
        
        panelBouton = new JPanel(new GridLayout(20,1));
        fenetre.add(panelBouton, BorderLayout.EAST);
        
        
        
        finTour = new JButton("Fin du Tour");
        deplacer = new JButton("Se Deplacer");
        assecher = new JButton("Assecher une Case");
        donner = new JButton("Donner une carte");
        
        /*Creation de la liste deroulante avec les deplacements possible*/
        int i =0;
        tuile = new String[4];
        
        //application.getJoueur("J"+joueurcourant).getRoleJoueur().setPosition(application.getIle().getTuile(application.getJoueur("J"+joueurcourant).getRoleJoueur().getDepart()));
        /*Rempli la liste déroulante avec les cases où le joueur peut se déplacer*/
        for (Tuile tu : application.getJoueur("J"+joueurcourant).getRoleJoueur().PossibleMouvement()){           
            tuile[i] = tu.getNom(); 
            i++; 
        }
        
        listeDeroulanteBouger = new JComboBox(tuile);   //Instanciation de la liste déroulante
        
        //application.getJoueur("J"+joueurcourant).getRoleJoueur().setPosition(application.getIle().getTuile(application.getJoueur("J"+joueurcourant).getRoleJoueur().getDepart()));
        
        
        
        /*Creation de la liste deroulante avec cases assechables*/
        int j =0;
        tuileA = new String[4];
        
        for (Tuile tu : application.getJoueur("J"+joueurcourant).getRoleJoueur().getTuileAssechable()){           
            tuileA[j] = tu.getNom(); 
            j++; 
        }      
        listeDeroulanteAssecher = new JComboBox(tuileA);   //Instanciation de la liste déroulante      
        
        joueurCourant = new JLabel("Joueur Courant :"+joueurcourant);   //Affiche le joueur dont c'est le tour
        joueurCourant.setForeground(application.getJoueur("J"+joueurcourant).getRoleJoueur().getCouleur()); //Modifie la couleur de l'ecriture en fonction de celle du joueur
        pa = new JLabel("PA :"+ application.getJoueur("J"+joueurcourant).getPA()+"/3"); //Affiche les PA du joueur
        
        panelBouton.add(joueurCourant);
        panelBouton.add(pa);
        panelBouton.add(listeDeroulanteBouger);
        panelBouton.add(deplacer);
        panelBouton.add(listeDeroulanteAssecher);
        panelBouton.add(assecher);
        panelBouton.add(donner);
        panelBouton.add(finTour);
        

        // Action pour le bouton deplacer
        deplacer.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (application.getJoueur("J"+joueurcourant).peutJouer())
                    {                        
                        Message m = new Message();
                        m.type = TypesMessages.DEPLACER;
                        m.joueur = application.getJoueur("J"+joueurcourant);    //Joueur courant
                        m.tuile = application.getJoueur("J"+joueurcourant).getRoleJoueur().PossibleMouvement().get(listeDeroulanteBouger.getSelectedIndex()); //Position du joueur courant
                        notifierObservateur(m);
                        pa.setText("PA :"+ application.getJoueur("J"+joueurcourant).getPA()+"/3");  //Actualise les PA du joueur courant                        
                        //Actualisation de la liste déroulante
                        listeDeroulanteBouger.removeAllItems();
                        int i = 0;
                        for (Tuile tu : application.getJoueur("J"+joueurcourant).getRoleJoueur().PossibleMouvement()){           
                            listeDeroulanteBouger.addItem(tu.getNom());
                            i++; 
                        }
                                              
                        listeDeroulanteBouger.repaint();
                        //FIN TEST
                        
                        listeAssecher();
                        listeDeroulanteAssecher.repaint();  
                    }
                    else{
                        pa.setForeground(Color.red);    //Change la couleur des PA pour avertir le joueur qu'il n'en a plus
                    }
                }
        });
        
        // Action pour le bouton assecher
        assecher.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (application.getJoueur("J"+joueurcourant).peutJouer())
                    {
                        Message m = new Message();
                        m.type = TypesMessages.ASSECHER;
                        m.joueur = application.getJoueur("J"+joueurcourant);
                        m.tuile = application.getJoueur("J"+joueurcourant).getRoleJoueur().getTuileAssechable().get(listeDeroulanteAssecher.getSelectedIndex()); //Position du joueur courant
                        
                        notifierObservateur(m);
                        pa.setText("PA :"+ application.getJoueur("J"+joueurcourant).getPA()+"/3");  //Actualise les PA du joueur courant
                        listeAssecher();
                        listeDeroulanteAssecher.repaint();
                    }
                    else{
                        pa.setForeground(Color.red);    //Change la couleur des PA pour avertir le joueur qu'il n'en a plus
                    }
                }
        });
        
        // Action pour le bouton donner
        donner.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    Message m = new Message();
                    m.type = TypesMessages.DONNER;
                    m.joueur = application.getJoueur("J"+joueurcourant);
                    
                    notifierObservateur(m);
                }
        });
        
        // Action pour le bouton finTour
        finTour.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    Message m = new Message();
                    m.type = TypesMessages.TERMINER_TOUR;
                    m.joueur = application.getJoueur("J"+joueurcourant);
                    /*Modifie le joueur courant*/
                    if (joueurcourant==4){
                        joueurcourant=1;
                    }
                    else {
                        joueurcourant = joueurcourant+1;
                    }
                    //Actualiser les ecritures
                    joueurCourant.setText("Joueur Courant :"+joueurcourant);
                    pa.setText("PA :"+ application.getJoueur("J"+joueurcourant).getPA()+"/3");
                    pa.setForeground(Color.black);
                    //TEST
                        listeDeroulanteBouger.removeAllItems();
                        int i = 0;
                        for (Tuile tu : application.getJoueur("J"+joueurcourant).getRoleJoueur().PossibleMouvement()){           
                            listeDeroulanteBouger.addItem(tu.getNom());
                            i++; 
                        }
                        
                        joueurCourant.setForeground(application.getJoueur("J"+joueurcourant).getRoleJoueur().getCouleur()); //Modifie la couleur de l'ecriture en fonction de celle du joueur
                        listeAssecher();
                        listeDeroulanteAssecher.repaint();
                        listeDeroulanteBouger.repaint();
                    //FIN TEST
                    actualiser();
                    notifierObservateur(m);
                }
        });
        
        
        /****************************************************************/
        
        /* Affichage de la fenetre */
        fenetre.setSize(1650, 950);
        fenetre.setVisible(true);        
    }    
    /*
     *   configureWindow
     *   Configurer de la fenêtre : taille et action à la fermeture
     */
    private void configureWindow(JFrame window) {
        window.setSize(500, 200);
        window.getContentPane().setLayout(new java.awt.BorderLayout());
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
    
    
    public void listeAssecher(){
        listeDeroulanteAssecher.removeAllItems();
        int i = 0;
        for (Tuile tu : application.getJoueur("J"+joueurcourant).getRoleJoueur().getTuileAssechable()){           
            listeDeroulanteAssecher.addItem(tu.getNom());
            i++; 
        }
        listeDeroulanteAssecher.repaint();
    }
    
    public void actualiser(){
        fenetre.repaint();
        listeDeroulanteBouger.repaint();
        joueurCourant.repaint();
        pa.repaint();
        panelBouton.repaint();
    }
  
}
