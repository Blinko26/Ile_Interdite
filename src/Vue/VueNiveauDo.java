/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.swing.*;
import javax.imageio.ImageIO;

/**
 *
 * @author viellarb
 */
public class VueNiveauDo extends JFrame{
    
    private ImageIcon image ;
    private JPanel mainPanel;
    private JLabel imgLabel;
    
    public VueNiveauDo(int niveau) {
        image = new ImageIcon("/Image/niveauDesEaux"+niveau+".png");
        imgLabel = new JLabel(new ImageIcon(image.getImage()));
        mainPanel.add(imgLabel);
        this.add(mainPanel);
    }
    
}
