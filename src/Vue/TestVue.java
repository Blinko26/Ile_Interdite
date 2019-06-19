/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import Controleur.Controleur;
import Vue.VueIle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import ile_interdite.CarteTresor;
import ile_interdite.TypeCT;

/**
 *
 * @author viellarb
 */
public class TestVue {
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        // TODO code application logic here
       ArrayList<CarteTresor> carteT = new ArrayList<>();
       CarteTresor carte = new CarteTresor(TypeCT.cristal);
       
       for(int i =0; i<5;i++){
          carteT.add(carte);
       }
       
       
       
       new VueDeck(carteT);     
    }

}
