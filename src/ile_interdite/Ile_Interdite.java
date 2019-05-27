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
package ile_interdite;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.Scanner;


/**
 *
 * @author IUT2
 */
public class Ile_Interdite {
    private static Application application = new Application();
    private static int etatJeu=1;
    private static int debut=0;
    public static class MyCanvas extends JPanel {

        public MyCanvas () {
        }

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
                    g2d.fillRect(8+2*i+i*(int)((int) size.getWidth()-30)/6, 8+2*j+j*(int)((int) size.getHeight()-30)/6, (int)((int) size.getWidth()-30)/6, (int)((int) size.getHeight()-30)/6);
                }
            }
            
            for(int i=0;i<application.getJoueurs().size();i++){
                g2d.setColor(application.getJoueurs().get(i).getRoleJoueur().getCouleur());
                g2d.fillOval(8+2*(application.getJoueurs().get(i).getRoleJoueur().getEmplacement()[0]-1)+(application.getJoueurs().get(i).getRoleJoueur().getEmplacement()[0]-1)*(int)((int) size.getWidth()-30)/6 +(int)((int) size.getWidth()-30)/12-10,8+2*(application.getJoueurs().get(i).getRoleJoueur().getEmplacement()[1]-1)+(application.getJoueurs().get(i).getRoleJoueur().getEmplacement()[1]-1)*(int)((int) size.getHeight()-30)/6+(int)((int) size.getHeight()-30)/12 -10, 20, 20);
                g2d.setColor(new Color(0,0,0));
                g2d.drawOval(8+2*(application.getJoueurs().get(i).getRoleJoueur().getEmplacement()[0]-1)+(application.getJoueurs().get(i).getRoleJoueur().getEmplacement()[0]-1)*(int)((int) size.getWidth()-30)/6 +(int)((int) size.getWidth()-30)/12-10,8+2*(application.getJoueurs().get(i).getRoleJoueur().getEmplacement()[1]-1)+(application.getJoueurs().get(i).getRoleJoueur().getEmplacement()[1]-1)*(int)((int) size.getHeight()-30)/6+(int)((int) size.getHeight()-30)/12 -10, 20, 20);

            }
            
            g2d.setColor(new Color(255,0,0));
            for(int j=0;j<=5;j++){
                for(int i=0;i<=5;i++){
                    g2d.drawString("Nom : "+application.getIle().getTuile(i+1, j+1).getNom(), 8+2*i+i*(int)((int) size.getWidth()-30)/6+20, 8+2*j+j*(int)((int) size.getHeight()-30)/6+30);
                    g2d.drawString("Coord : "+application.getIle().getTuile(i+1, j+1).getEmplacementX()+", "+application.getIle().getTuile(i+1, j+1).getEmplacementY(), 8+2*i+i*(int)((int) size.getWidth()-30)/6+20, 8+2*j+j*(int)((int) size.getHeight()-30)/6+45);
                }
            }
            for(int i=0;i<application.getJoueurs().size();i++){
                if(application.getIle().getTuile(application.getJoueurs().get(i).getRoleJoueur().getEmplacement()[0],application.getJoueurs().get(i).getRoleJoueur().getEmplacement()[1]).getEtat()==EtatC.sombrée){
                    g2d.setColor(new Color(0,0,255));
                    g2d.fillRect(0, 0, (int) size.getWidth(), (int) size.getHeight());
                    g2d.setColor(new Color(255,0,128));
                    g2d.drawString("Perdu !", size.width/2, size.height/2);
                }
            }
            if(application.getIle().getTuile("Heliport").getEtat()==EtatC.sombrée){
                g2d.setColor(new Color(0,0,255));
                g2d.fillRect(0, 0, (int) size.getWidth(), (int) size.getHeight());
                g2d.setColor(new Color(255,0,128));
                g2d.drawString("Perdu !", size.width/2, size.height/2);
            }
            
            if(debut==0){
                g2d.setColor(Color.white);
                g2d.fillRect(0, 0, (int) size.getWidth(), (int) size.getHeight());
                g2d.setColor(new Color(0,0,0));
                g2d.drawString("Pour commencer taper 5", size.width/2, size.height/2);
            }
        }
    }
    
    /* Composant fenêtre */
    private static JFrame window;
    private MyCanvas canvas;

    public Ile_Interdite() {
        

        
        /* Instanciation et configuration du composant fenetre */
        window = new JFrame("Ile interdite");
        this.configureWindow(window);

        /****************************************************************/
        canvas = new MyCanvas();
        window.add(canvas);
        
        /****************************************************************/
        
        /* Affichage de la fenetre */
        window.setSize(400, 400);
        window.setVisible(true);        
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
    
    public static void main(String[] args) { new Ile_Interdite();
        application.initMap();
        application.initJoueurs(6);
        application.initCartes();
        
        int valeur=0;
        while(etatJeu==1){
            Scanner entree = new Scanner(System.in);
            System.out.print("Saisir un entier :\n\tCommencer-5\n\tInonder-3\n\tAction ?");
            valeur = entree.nextInt();
            if(valeur==5 && debut==0){
                debut=1;
                application.initPartie();
            }
            if (debut==1){
                if(valeur==3){
                application.innonder(4);
                
            }
            }
            window.repaint();
            
            for(int i=0;i<application.getJoueurs().size();i++){
                if(application.getIle().getTuile(application.getJoueurs().get(i).getRoleJoueur().getEmplacement()[0],application.getJoueurs().get(i).getRoleJoueur().getEmplacement()[1]).getEtat()==EtatC.sombrée){
                   System.out.println("coule");
                    etatJeu=0; 
                }
            }
            
            if(application.getIle().getTuile("Heliport").getEtat()==EtatC.sombrée){
                System.out.println("perdu");
                etatJeu=0;
            }
        }   
    }
    
}
