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
import java.awt.Polygon;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author IUT2
 */
public class Ile_Interdite {
    public static class MyCanvas extends JPanel {

        public MyCanvas () {
        }

        @Override
        public void paintComponent (Graphics g) {  
            Graphics2D g2d = (Graphics2D) g;
            Dimension size = getSize();
            
            g2d.setColor(Color.white);
            g2d.fillRect(0, 0, (int) size.getWidth(), (int) size.getHeight());
            
            g2d.setColor(new Color(0,0,255));
            for(int j=0;j<=5;j++){
                for(int i=0;i<=5;i++){
                    if(i==2 && j==0||i==1 && j==1 ||i==0 && j==2||i==1 && j==4 ||i==2 &&j==5){
                        g2d.setColor(new Color(255,255,127));
                    }
                    if(i==4 && j==0||i==5 && j==1 ||i==0 && j==4 ||i==5 && j==4 ||i==4 &&j==5){
                        g2d.setColor(new Color(0,0,255));
                    }
                    g2d.fillRect(8+2*i+i*(int)((int) size.getWidth()-30)/6, 8+2*j+j*(int)((int) size.getHeight()-30)/6, (int)((int) size.getWidth()-30)/6, (int)((int) size.getHeight()-30)/6);
                }
            }
            Application application = new Application();         
            application.initMap();
            
            g2d.setColor(new Color(255,0,0));
            for(int j=0;j<=5;j++){
                for(int i=0;i<=5;i++){
                    g2d.drawString("Nom : "+application.getIle().getTuile(i+1, j+1).getNom(), 8+2*i+i*(int)((int) size.getWidth()-30)/6+20, 8+2*j+j*(int)((int) size.getHeight()-30)/6+30);
                    g2d.drawString("Coord : "+application.getIle().getTuile(i+1, j+1).getEmplacementX()+", "+application.getIle().getTuile(i+1, j+1).getEmplacementY(), 8+2*i+i*(int)((int) size.getWidth()-30)/6+20, 8+2*j+j*(int)((int) size.getHeight()-30)/6+45);
                }
            }
        }
    }
    
    /* Composant fenêtre */
    private JFrame window;
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
    
    public static void main(String[] args) { new Ile_Interdite(); }
    
    public void innondationIHM(String nomtuile){
        
    }
}
