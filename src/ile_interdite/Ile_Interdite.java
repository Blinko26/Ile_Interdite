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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
    private static int [] emplacementsouris={0,0};
    private static boolean presse=false;
    private static int joueurcourant=1;
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
                    //for (int[] tuile : application.getJoueurs().get(0).getRoleJoueur().getPosition().getTuilesAdj()){
                    //    application.getIle().getTuile(tuile[0], tuile [1]).setSurligné(true);
                    //}
                       // if(emplacementsouris[0]==7 && emplacementsouris[1]==2 && application.getIle().getTuile(i+1,j+1).getType()!=TypeC.nulle && application.getIle().getTuile(i+1,j+1)!=application.getIle().getTuile(tuile[0],tuile[1])){
                         //   g2d.setColor(new Color(255,0,255));
                        //}
                    
                    g2d.fillRect(8+2*i+i*(int)((int) (size.getWidth()-30)*7/8)/6, 8+2*j+j*(int)((int) size.getHeight()-30)/6, (int)((int) (size.getWidth()-30)*7/8)/6, (int)((int) size.getHeight()-30)/6);
                    
                }
            }
            
            for(int i=0;i<application.getJoueurs().size();i++){
                g2d.setColor(application.getJoueurs().get(i).getRoleJoueur().getCouleur());
                g2d.fillOval(8+2*(application.getJoueurs().get(i).getRoleJoueur().getEmplacement()[0]-1)+(application.getJoueurs().get(i).getRoleJoueur().getEmplacement()[0]-1)*(int)((int) (size.getWidth()-30)*7/8)/6 +(int)((int) (size.getWidth()-30)*7/8)/12-10,8+2*(application.getJoueurs().get(i).getRoleJoueur().getEmplacement()[1]-1)+(application.getJoueurs().get(i).getRoleJoueur().getEmplacement()[1]-1)*(int)((int) size.getHeight()-30)/6+(int)((int) size.getHeight()-30)/12 -10, 20, 20);
                g2d.setColor(new Color(0,0,0));
                g2d.drawOval(8+2*(application.getJoueurs().get(i).getRoleJoueur().getEmplacement()[0]-1)+(application.getJoueurs().get(i).getRoleJoueur().getEmplacement()[0]-1)*(int)((int) (size.getWidth()-30)*7/8)/6 +(int)((int) (size.getWidth()-30)*7/8)/12-10,8+2*(application.getJoueurs().get(i).getRoleJoueur().getEmplacement()[1]-1)+(application.getJoueurs().get(i).getRoleJoueur().getEmplacement()[1]-1)*(int)((int) size.getHeight()-30)/6+(int)((int) size.getHeight()-30)/12 -10, 20, 20);

            }
            
            g2d.setColor(new Color(255,0,0));
            for(int j=0;j<=5;j++){
                for(int i=0;i<=5;i++){
                    g2d.drawString("Nom : "+application.getIle().getTuile(i+1, j+1).getNom(), 8+2*i+i*(int)((int) (size.getWidth()-30)*7/8)/6+20, 8+2*j+j*(int)((int) size.getHeight()-30)/6+30);
                    g2d.drawString("Coord : "+application.getIle().getTuile(i+1, j+1).getEmplacementX()+", "+application.getIle().getTuile(i+1, j+1).getEmplacementY(), 8+2*i+i*(int)((int) (size.getWidth()-30)*7/8)/6+20, 8+2*j+j*(int)((int) size.getHeight()-30)/6+45);
                }
            }
            g2d.setColor(new Color(196,196,196));
            g2d.fillRect((int)size.width-175,10,150,75);
            g2d.setColor(new Color(0,0,0));
            g2d.drawRect((int)size.width-175,10,150,75);
            if(application.getIle().getTuile(application.getJoueurs().get(joueurcourant-1).getRoleJoueur().getEmplacement()[0],application.getJoueurs().get(joueurcourant).getRoleJoueur().getEmplacement()[1]).getEtat()==EtatC.normale){
                  g2d.setColor(new Color(128,128,128));
            }  
            g2d.drawString("Assecher",(int)size.width-165,50);
            
            g2d.setColor(new Color(196,196,196));
            g2d.fillRect((int)size.width-175,87,150,75);
            g2d.setColor(new Color(0,0,0));
            g2d.drawRect((int)size.width-175,87,150,75);
            g2d.drawString("Y aller",(int)size.width-165,127);
            
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
        canvas.addMouseListener(new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {
                if (debut==0){
                    debut=1;
                    presse=!presse;
                    application.initPartie();
                }
                if(e.getX()<=2*6+6*(int)((int) (1650-30)*7/8)/6){
                    System.out.println("bite");
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
                window.repaint();
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
        
        /****************************************************************/
        
        /* Affichage de la fenetre */
        window.setSize(1650, 950);
        window.setVisible(true);        
    }    
    /*
     *   configureWindow
     *   Configurer de la fenêtre : taille et action à la fermeture
     */
    private void configureWindow(JFrame window) {
        window.setSize(500, 200);
        window.setResizable(false);
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
       // application.tourDeJeu(xsouris,ysouris,joueurcourant);
        
            
            //for(int i=0;i<application.getJoueurs().size();i++){
            //    if(application.getIle().getTuile(application.getJoueurs().get(i).getRoleJoueur().getEmplacement()[0],application.getJoueurs().get(i).getRoleJoueur().getEmplacement()[1]).getEtat()==EtatC.sombrée){
            //        etatJeu=0; 
            //    }
            //}
            
            //if(application.getIle().getTuile("Heliport").getEtat()==EtatC.sombrée){
            //    etatJeu=0;
            //}
        }   
    
}
