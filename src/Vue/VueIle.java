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
package Vue;

import Controleur.Message;
import Controleur.Message;
import Controleur.Observe;
import Controleur.Observe;
import Controleur.TypesMessages;
import Controleur.TypesMessages;
import ile_interdite.Application;
import ile_interdite.EtatC;
import ile_interdite.Tuile;
import ile_interdite.CarteTresor;
import ile_interdite.EtatT;
import ile_interdite.TypeAventurier;
import ile_interdite.TypeCT;
import ile_interdite.Joueur;
import ile_interdite.TypeT;
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
                g2d.fillOval(8+2*ex1+ex1*(int)((int) (size.getWidth()-30)*7/8)/6+2,8+2*ey1+ey1*(int)((int) (size.getHeight()-30))/6+(int) ((size.getHeight()/6)*3/4),10, 15); 
                g2d.fillOval(8+2*ex2+ex2*(int)((int) (size.getWidth()-30)*7/8)/6+2,8+2*ey2+ey2*(int)((int) (size.getHeight()-30))/6+(int) ((size.getHeight()/6)*3/4),10, 15);
                g2d.setColor(new Color(0,0,0));
                g2d.drawOval(8+2*ex1+ex1*(int)((int) (size.getWidth()-30)*7/8)/6+2,8+2*ey1+ey1*(int)((int) (size.getHeight()-30))/6+(int) ((size.getHeight()/6)*3/4),10, 15);
                g2d.drawOval(8+2*ex2+ex2*(int)((int) (size.getWidth()-30)*7/8)/6+2,8+2*ey2+ey2*(int)((int) (size.getHeight()-30))/6+(int) ((size.getHeight()/6)*3/4),10, 15);
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
        }
    }
    
    public static class CanvasT extends JPanel {

        @Override
        public void paintComponent (Graphics g) {  //permet de dessiner la carte de l'ile
            Graphics2D g2d = (Graphics2D) g;
            Dimension size = getSize();
            
            g2d.setColor(Color.white);
            g2d.fillRect(0, 0, (int) size.getWidth(), (int) size.getHeight());
            
            g2d.setColor(new Color(128,128,128));
            if(application.getTrésors().get(0).getEtat()==EtatT.trouvé){
                g2d.setColor(new Color(0,192,255));
            }
                g2d.fillOval(size.width/5-10,size.height/2-15,20,30); 
                g2d.setColor(new Color(0,0,0));
                g2d.drawOval(size.width/5-10,size.height/2-15,20, 30);
                
            g2d.setColor(new Color(128,128,128));
            if(application.getTrésors().get(1).getEtat()==EtatT.trouvé){
                g2d.setColor(new Color(255,64,0));
            }
                g2d.fillOval(size.width/5*2-10,size.height/2-15,20,30); 
                g2d.setColor(new Color(0,0,0));
                g2d.drawOval(size.width/5*2-10,size.height/2-15,20, 30);
            
            g2d.setColor(new Color(128,128,128));
            if(application.getTrésors().get(0).getEtat()==EtatT.trouvé){
                g2d.setColor(new Color(128,0,200));
            }
                g2d.fillOval(size.width/5*3-10,size.height/2-15,20,30); 
                g2d.setColor(new Color(0,0,0));
                g2d.drawOval(size.width/5*3-10,size.height/2-15,20, 30);
                
            g2d.setColor(new Color(128,128,128));
            if(application.getTrésors().get(0).getEtat()==EtatT.trouvé){
                g2d.setColor(new Color(255,200,0));
            }
                g2d.fillOval(size.width/5*4-10,size.height/2-15,20,30); 
                g2d.setColor(new Color(0,0,0));
                g2d.drawOval(size.width/5*4-10,size.height/2-15,20, 30);
            
        }
    }
    
     /*Déclaration des éléments de la fenetre*/
    private JFrame fenetre;
    private JPanel panelMap;
    private JPanel panelBouton;
    
    private MyCanvas canvas;
    private CanvasT canvasTresor;
    
    // private VueIle.MyCanvas ile;
    
    private JLabel joueurCourant; //Indique le joueur courant3
    private JLabel pa; //Indique le joueur courant3
    private JLabel tr;

    private JButton finTour;    //Bouton pour finir son tour
    private JButton deplacer;   // bouton pour se deplacer
    private JButton assecher;   // Bouton pour assecher une case
    private JButton donner; //Bouton pour donner une carte
    private JButton voirdeck;
    private JButton voler;
    private JButton gagnerTresor;
    private JButton defausser;
    
    private JComboBox listeDeroulanteBouger;
    private JComboBox listeDeroulanteAssecher;
    private JComboBox listeDeroulanteJoueurs;
    private JComboBox listeDeroulanteDeck;
    private JComboBox listeDeroulanteDonner;
    private JComboBox listeDeroulantePilote;
    
    private String[] tuile;
    private String[] tuileA;
    private String[] joueursdispo;
    private TypeCT[] carteJD;
    private TypeCT[] carteD;
    private String[] tuileP;
    
    private boolean adonné=false;
    
    public VueIle(Application appli) {
        
        application = appli;
        
        
        /* Instanciation et configuration du composant fenetre */
        fenetre = new JFrame("Ile interdite");
        fenetre.setVisible(false);
        this.configureWindow(fenetre);
        
        JFrame menu = new JFrame();
        menu.setSize(500, 500);
        JPanel panelMenu = new JPanel();
        JButton boutonJouer = new JButton();
        boutonJouer.setText("Jouer");
        menu.add(panelMenu);
        panelMenu.add(boutonJouer);
        menu.setVisible(true);


        panelMap = new JPanel();    //Instanciation de la map
        fenetre.add(panelMap, BorderLayout.WEST);
        
        panelBouton = new JPanel(new GridLayout(6,1));
        fenetre.add(panelBouton, BorderLayout.EAST);
        /****************************************************************/
        canvas = new MyCanvas();
        fenetre.add(canvas);
        
        /*canvas.addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {
                if (debut==0){
                    debut=1;
                    presse=!presse;
                    application.initPartie();
                    listeAssecher();
                    listeDeroulanteAssecher.repaint(); 
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

);*/
        
               /*Panel Bouton*/
        
        panelBouton = new JPanel(new GridLayout(20,1));
        fenetre.add(panelBouton, BorderLayout.EAST);
        
        
        
        finTour = new JButton("Fin du tour");
        deplacer = new JButton("Se deplacer");
        assecher = new JButton("Assecher une case");
        voirdeck = new JButton("Voir le deck");
        donner = new JButton("Donner une carte");
        voler = new JButton("S'envoler");
        gagnerTresor = new JButton("Gagner le trésor");
        defausser = new JButton("Défausser une carte trésor");
        gagnerTresor = new JButton("Gagner le tresor");
        canvasTresor= new CanvasT();
        
        /*Creation de la liste deroulante avec les deplacements possible*/
        int i =0;
        tuile = new String[application.getJoueur("J"+joueurcourant).getRoleJoueur().PossibleMouvement().size()];
        
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
        tuileA = new String[application.getJoueur("J"+joueurcourant).getRoleJoueur().getTuileAssechable().size()];
        
        for (Tuile tu : application.getJoueur("J"+joueurcourant).getRoleJoueur().getTuileAssechable()){           
            tuileA[j] = tu.getNom(); 
            j++; 
        }      
        listeDeroulanteAssecher = new JComboBox(tuileA);   //Instanciation de la liste déroulante      
        
        
        joueurCourant = new JLabel("Joueur Courant :"+application.getJoueur("J"+joueurcourant).getRoleJoueur().getRoleToString());   //Affiche le joueur dont c'est le tour
        pa = new JLabel("PA :"+ application.getJoueur("J"+joueurcourant).getPA()+"/3"); //Affiche les PA du joueur
        tr = new JLabel("Trésors :");
        
        
        
        panelBouton.add(joueurCourant);
        panelBouton.add(pa);
        panelBouton.add(listeDeroulanteBouger);
        panelBouton.add(deplacer);
        panelBouton.add(listeDeroulanteAssecher);
        panelBouton.add(assecher);
        panelBouton.add(finTour);
        panelBouton.add(tr);
        panelBouton.add(canvasTresor);
        
        if(application.getJoueur("J1").getRoleJoueur().getType()==TypeAventurier.pilote){
            j=0;
            tuileP = new String[application.getIle().getTuilesNonSombrees().size()-1-application.getJoueur("J"+joueurcourant).getRoleJoueur().PossibleMouvement().size()];
            
            for (Tuile tu : application.getIle().getTuilesNonSombrees()){
                boolean nonadj=true;
                for(Tuile tuadj : application.getJoueur("J"+joueurcourant).getRoleJoueur().PossibleMouvement()){
                    if(tu==tuadj){
                        nonadj=false;
                    }
                }
                if(application.getJoueur("J"+joueurcourant).getRoleJoueur().getPosition()!=tu && nonadj){
                    tuileP[j] = tu.getNom();
                    j++; 
                }
                
            }
            listeDeroulantePilote = new JComboBox(tuileP);
            
            panelBouton.remove(finTour);
            panelBouton.remove(tr);
            panelBouton.remove(gagnerTresor);
            panelBouton.add(listeDeroulantePilote);
            panelBouton.add(voler);
            panelBouton.add(finTour);
            panelBouton.add(tr);
            panelBouton.add(gagnerTresor);
        }    
        

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
                        for (Tuile tu : application.getJoueur("J"+joueurcourant).getRoleJoueur().PossibleMouvement()){           
                            listeDeroulanteBouger.addItem(tu.getNom());
                        }
                                              
                        listeDeroulanteBouger.repaint();
                        //FIN TEST
                        
                        listeAssecher();
                        listeDeroulanteAssecher.repaint();
                        if (!application.getJoueur("J"+joueurcourant).peutJouer()){
                            pa.setForeground(Color.red);    //Change la couleur des PA pour avertir le joueur qu'il n'en a plus
                        }
                        boutonsDonner();
                        boutonsTresor();
                    }
                }
        });
        
        // Action pour le bouton assecher
        assecher.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (application.getJoueur("J"+joueurcourant).peutJouer() && application.getJoueur("J"+joueurcourant).getRoleJoueur().getTuileAssechable().size()!=0)
                    {
                        Message m = new Message();
                        m.type = TypesMessages.ASSECHER;
                        m.joueur = application.getJoueur("J"+joueurcourant);
                        m.tuile = application.getJoueur("J"+joueurcourant).getRoleJoueur().getTuileAssechable().get(listeDeroulanteAssecher.getSelectedIndex()); //Position du joueur courant
                        
                        notifierObservateur(m);
                        pa.setText("PA :"+ application.getJoueur("J"+joueurcourant).getPA()+"/3");  //Actualise les PA du joueur courant
                        listeAssecher();
                        listeDeroulanteAssecher.repaint();
                        if (!application.getJoueur("J"+joueurcourant).peutJouer()){
                            pa.setForeground(Color.red);    //Change la couleur des PA pour avertir le joueur qu'il n'en a plus
                        }
                    }
                }
        });
        
        /*voirdeck.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    System.out.println("voirdeck");
                    Joueur joueurdeck=null;
                    int joueur;   
                    joueur=listeDeroulanteJoueurs.getSelectedIndex();
                    int j=0;
                    for(Joueur jo:application.getJoueurs()){
                        if(jo!=application.getJoueur("J"+joueurcourant)){
                            if(joueur==j){
                                joueurdeck=jo;
                            }
                            j++;
                        }
                    }
                    
                    j=0;
                    carteJD = new TypeCT[joueurdeck.getCartesT().size()];

                    for (CarteTresor ct : joueurdeck.getCartesT()){           
                        carteJD[j] = ct.getType(); 
                        j++; 
                    }
                    listeDeroulanteDeck = new JComboBox(carteJD);
                    
                    panelBouton.remove(finTour);
                    panelBouton.remove(listeDeroulanteDonner);
                    panelBouton.remove(donner);
                    panelBouton.add(listeDeroulanteDeck);
                    panelBouton.add(listeDeroulanteDonner);
                    panelBouton.add(donner);
                    panelBouton.add(finTour);
                    actualiser();
                }
        });
        */
        
        // Action pour le bouton donner
        donner.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (application.getJoueur("J"+joueurcourant).peutJouer() && application.getJoueur("J"+joueurcourant).getCartesT().size()!=0){
                        
                        Message m = new Message();
                        m.type = TypesMessages.DONNER;
                        m.joueur = application.getJoueur("J"+joueurcourant);
                        int j=0;
                        int i=listeDeroulanteJoueurs.getSelectedIndex();
                        for (Joueur joueur : application.getJoueurs()){
                                if(joueur.getRoleJoueur().getPosition()==application.getJoueur("J"+joueurcourant).getRoleJoueur().getPosition()&& joueur!=application.getJoueur("J"+joueurcourant)){
                                    if(listeDeroulanteJoueurs.getSelectedIndex()==j){
                                        m.receveur=joueur;
                                    }
                                    j=j+1;
                                }
                        }
                        m.carte = application.getJoueur("J"+joueurcourant).getCartesT().get(listeDeroulanteDonner.getSelectedIndex());

                        notifierObservateur(m);
                        listeDeroulanteDonner.removeAllItems();
                        for (CarteTresor ct : application.getJoueur("J"+joueurcourant).getCartesT()){           
                            listeDeroulanteDonner.addItem(ct.getType());
                        }                    
                        listeDeroulanteBouger.repaint();
                        pa.setText("PA :"+ application.getJoueur("J"+joueurcourant).getPA()+"/3");  //Actualise les PA du joueur courant
                        listeDeroulanteDonner.repaint();
                        if (!application.getJoueur("J"+joueurcourant).peutJouer()){
                            pa.setForeground(Color.red);    //Change la couleur des PA pour avertir le joueur qu'il n'en a plus
                        }
                    }
                }    
                
        });
        
        if (application.getJoueur("J"+joueurcourant).getCartesT().size()>5) {
            
            System.out.println("oui");
            panelBouton.add(listeDeroulanteDonner);
            System.out.println("oui");
            panelBouton.add(defausser);
            System.out.println("oui");
            panelBouton.remove(listeDeroulanteBouger);
            System.out.println("oui");
            panelBouton.remove(deplacer);
            System.out.println("oui");
            panelBouton.remove(listeDeroulanteAssecher);
            System.out.println("oui");
            panelBouton.remove(assecher);
            System.out.println("oui");
            panelBouton.remove(finTour);
            
            
            defausser.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    Message m = new Message();
                    m.type = TypesMessages.DEFAUSSER;
                    m.joueur=application.getJoueur("J"+joueurcourant);
                    
                    m.carte = application.getJoueur("J"+joueurcourant).getCartesT().get(listeDeroulanteDonner.getSelectedIndex());
                    
                    notifierObservateur(m);
                    
                    listeDeroulanteDonner.removeAllItems();
                    for (CarteTresor ct : application.getJoueur("J"+joueurcourant).getCartesT()){           
                        listeDeroulanteDonner.addItem(ct.getType());
                    }                    
                    listeDeroulanteDonner.repaint();
                    
                    panelBouton.remove(listeDeroulanteDonner);
                    panelBouton.remove(defausser);
                    panelBouton.add(listeDeroulanteBouger);
                    panelBouton.add(deplacer);
                    panelBouton.add(listeDeroulanteAssecher);
                    panelBouton.add(assecher);
                    panelBouton.add(finTour);
                }
            });
            
        }
        
        voler.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (application.getJoueur("J"+joueurcourant).peutJouer())
                    {            
                        Message m = new Message();
                        m.type = TypesMessages.DEPLACER;
                        m.joueur = application.getJoueur("J"+joueurcourant);    //Joueur courant
                        m.tuile = application.getCasesDeplacementPilote().get(listeDeroulantePilote.getSelectedIndex()); //Position du joueur courant
                        notifierObservateur(m);
                        pa.setText("PA :"+ application.getJoueur("J"+joueurcourant).getPA()+"/3");  //Actualise les PA du joueur courant                        
                        
                        panelBouton.remove(listeDeroulantePilote);
                        panelBouton.remove(voler);
                        
                        //Actualisation de la liste déroulante
                        listeDeroulanteBouger.removeAllItems();
                        for (Tuile tu : application.getJoueur("J"+joueurcourant).getRoleJoueur().PossibleMouvement()){           
                            listeDeroulanteBouger.addItem(tu.getNom());
                        }
                                              
                        listeDeroulanteBouger.repaint();
                        //FIN TEST
                        
                        listeAssecher();
                        listeDeroulanteAssecher.repaint();
                        if (!application.getJoueur("J"+joueurcourant).peutJouer()){
                            pa.setForeground(Color.red);    //Change la couleur des PA pour avertir le joueur qu'il n'en a plus
                        }
                        boutonsDonner();
                        boutonsTresor();
                    }
                }
        });
        
        finTour.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    Message m = new Message();
                    m.type = TypesMessages.TERMINER_TOUR;
                    m.joueur = application.getJoueur("J"+joueurcourant);
                    if(application.getCartesTresor().size()>0){
                        application.getJoueur("J"+joueurcourant).addCarteToJoueur(application.getCartesTresor().get(0));
                        application.getCartesTresor().remove(0);
                        application.getJoueur("J"+joueurcourant).addCarteToJoueur(application.getCartesTresor().get(0));
                        application.getCartesTresor().remove(0);
                    }
                    /*Modifie le joueur courant*/
                    if (joueurcourant==application.getJoueurs().size()){
                        joueurcourant=1;
                    }
                    else {
                        joueurcourant = joueurcourant+1;
                    }
                    //Actualiser les ecritures
                    joueurCourant.setText("Joueur Courant :"+application.getJoueur("J"+joueurcourant).getRoleJoueur().getRoleToString());
                    pa.setText("PA :"+ application.getJoueur("J"+joueurcourant).getPA()+"/3");
                    pa.setForeground(Color.black);
                    //TEST
                        listeDeroulanteBouger.removeAllItems();
                        for (Tuile tu : application.getJoueur("J"+joueurcourant).getRoleJoueur().PossibleMouvement()){           
                            listeDeroulanteBouger.addItem(tu.getNom()); 
                        }
                        
                        listeAssecher();
                        listeDeroulanteAssecher.repaint();
                        listeDeroulanteBouger.repaint();
                        
                        boutonsDonner();
                        boutonsPilote();
                        boutonsTresor();
                    //FIN TEST
                    actualiser();
                    notifierObservateur(m);
                }
        });
        
        // Action pour le bouton finTour
        gagnerTresor.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    Message m = new Message();
                    m.type = TypesMessages.GAGNER_TRESOR;
                    m.tuile = application.getJoueur("J"+joueurcourant).getRoleJoueur().getPosition();
                    notifierObservateur(m);
                    actualiser();
                }
        });
        
        
        /****************************************************************/
        
        /* Affichage de la fenetre */

        
            boutonJouer.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                menu.dispose();
               fenetre.setVisible(true);
               fenetre.setSize(1650, 950);
               application.initPartie();
               listeAssecher();

            }
        });
        
                
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
    
    public void boutonsPilote(){
        int j=0;
        int joueurprecedent;
        if(joueurcourant==1)
            joueurprecedent=4;
        else{
            joueurprecedent=joueurcourant-1;
        }
        
        if(application.getJoueur("J"+joueurprecedent).getRoleJoueur().getType()==TypeAventurier.pilote){
            panelBouton.remove(listeDeroulantePilote);
            panelBouton.remove(voler);
            panelBouton.remove(voler);
        }
        
        if(application.getJoueur("J"+joueurcourant).getRoleJoueur().getType()==TypeAventurier.pilote){
            tuileP = new String[application.getIle().getTuilesNonSombrees().size()-1-application.getJoueur("J"+joueurcourant).getRoleJoueur().PossibleMouvement().size()];
            
            for (Tuile tu : application.getIle().getTuilesNonSombrees()){
                boolean nonadj=true;
                for(Tuile tuadj : application.getJoueur("J"+joueurcourant).getRoleJoueur().PossibleMouvement()){
                    if(tu==tuadj){
                        nonadj=false;
                    }
                }
                if(application.getJoueur("J"+joueurcourant).getRoleJoueur().getPosition()!=tu && nonadj){
                    tuileP[j] = tu.getNom();
                    j++; 
                }
            }      
            listeDeroulantePilote = new JComboBox(tuileP);
            
            panelBouton.remove(finTour);
            panelBouton.remove(tr);
            panelBouton.remove(canvasTresor);
            panelBouton.add(listeDeroulantePilote);
            panelBouton.add(voler);
            panelBouton.add(finTour);
            panelBouton.add(tr);
            panelBouton.add(canvasTresor);
            
        }
    }
    
    public void boutonsDonner(){
        boolean seul=true;
        int nbjoueurs=0;
        for (Joueur joueur : application.getJoueurs()){           
            if(joueur.getRoleJoueur().getPosition()==application.getJoueur("J"+joueurcourant).getRoleJoueur().getPosition()&& joueur!=application.getJoueur("J"+joueurcourant)){ 
                seul=false;
                nbjoueurs++;
            }
        }
        
        int joueurprecedent;
        if(joueurcourant==1){
            joueurprecedent=4;
        }else{
            joueurprecedent=joueurcourant-1;
        }
        
        if(application.getJoueur("J"+joueurprecedent).getRoleJoueur().getPosition()==application.getJoueur("J"+joueurcourant).getRoleJoueur().getPosition()&& adonné){
            panelBouton.remove(listeDeroulanteJoueurs);
            panelBouton.remove(listeDeroulanteDonner);
            panelBouton.remove(donner);
            adonné=false;
        }
        
        if(!seul){
            adonné=true;
            int j =0;
            joueursdispo = new String[nbjoueurs];

            for (Joueur joueur : application.getJoueurs()){           
                if(joueur.getRoleJoueur().getPosition()==application.getJoueur("J"+joueurcourant).getRoleJoueur().getPosition()&& joueur!=application.getJoueur("J"+joueurcourant)){ 
                    joueursdispo[j] = joueur.getNomJoueur();
                    j++;
                }
            }
            listeDeroulanteJoueurs = new JComboBox(joueursdispo);

            j=0;
            carteD = new TypeCT[application.getJoueur("J"+joueurcourant).getCartesT().size()];

            for (CarteTresor ct : application.getJoueur("J"+joueurcourant).getCartesT()){           
                carteD[j] = ct.getType(); 
                j++; 
            }
            listeDeroulanteDonner = new JComboBox(carteD);

            panelBouton.remove(finTour);
            panelBouton.remove(tr);
            panelBouton.remove(canvasTresor);
            panelBouton.add(listeDeroulanteJoueurs);
            panelBouton.add(voirdeck);
            panelBouton.add(listeDeroulanteDonner);
            panelBouton.add(donner);
            panelBouton.add(finTour);
            panelBouton.add(tr);
            panelBouton.add(canvasTresor);
        }else if(adonné){
            panelBouton.remove(listeDeroulanteJoueurs);
            panelBouton.remove(listeDeroulanteDonner);
            panelBouton.remove(donner);
            adonné=false;
        }
    }
    
    public void boutonsTresor(){
        int calice=0;
        int cristal=0;
        int pierre=0;
        int statue=0;
        for(CarteTresor c:application.getJoueur("J"+joueurcourant).getCartesT()){
           if(c.getType()==TypeCT.calice){
               calice++;
           } else if(c.getType()==TypeCT.cristal){
               cristal++;
           } else if(c.getType()==TypeCT.pierre){
               pierre++;
           } else if(c.getType()==TypeCT.statue){
               statue++;
           }
        }
        if((application.getJoueur("J"+joueurcourant).getRoleJoueur().getPosition()==application.getIle().getTuile("Le Palais de Corail") 
        || application.getJoueur("J"+joueurcourant).getRoleJoueur().getPosition()==application.getIle().getTuile("Le Palais des Marees"))
        && calice>=4){
            gagnerTresor.setBackground(new Color(0,192,255));
            panelBouton.add(gagnerTresor);
        } else if((application.getJoueur("J"+joueurcourant).getRoleJoueur().getPosition()==application.getIle().getTuile("La Caverne du Brasier") 
        || application.getJoueur("J"+joueurcourant).getRoleJoueur().getPosition()==application.getIle().getTuile("La Caverne des Ombres"))
        && cristal>=4){
            gagnerTresor.setBackground(new Color(255,64,0));
            panelBouton.add(gagnerTresor);
        } else if((application.getJoueur("J"+joueurcourant).getRoleJoueur().getPosition()==application.getIle().getTuile("Le Temple de La Lune") 
        || application.getJoueur("J"+joueurcourant).getRoleJoueur().getPosition()==application.getIle().getTuile("Le Temple du Soleil"))
        && pierre>=4){
            gagnerTresor.setBackground(new Color(128,0,200));
            panelBouton.add(gagnerTresor);
        } else if((application.getJoueur("J"+joueurcourant).getRoleJoueur().getPosition()==application.getIle().getTuile("Le Jardin des Murmures") 
        || application.getJoueur("J"+joueurcourant).getRoleJoueur().getPosition()==application.getIle().getTuile("Le Jardin des Hurlements"))
        && statue>=4){
            gagnerTresor.setBackground(new Color(255,200,0));
            panelBouton.add(gagnerTresor);
        }
        else{
            panelBouton.remove(gagnerTresor);
        }
    }

    public void actualiser(){
        fenetre.repaint();
        listeDeroulanteBouger.repaint();
        listeDeroulanteAssecher.repaint();
        joueurCourant.repaint();
        pa.repaint();
        canvasTresor.repaint();
        panelBouton.repaint();
    }
  
}
