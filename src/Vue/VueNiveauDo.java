/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import java.awt.*;
import java.awt.image.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.imageio.ImageIO;

/**
 *
 * @author viellarb
 */
public class VueNiveauDo extends JPanel{
    

    private JPanel mainPanel;
    private JLabel imgLabel;
    private BufferedImage image;
    
    public VueNiveauDo(int niveau) {
        
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        
        mainPanel = new JPanel();

        // main window
        JFrame frame = new JFrame("Niveau D'Eau");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        File path = new File("");
        try {
            image = ImageIO.read(new File(path.getAbsolutePath()+"/src/Image/niveauDesEaux"+niveau+".png"));
        } catch (IOException ex) {
            Logger.getLogger(VueNiveauDo.class.getName()).log(Level.SEVERE, null, ex);
        }
        imgLabel = new JLabel(new ImageIcon(image.getScaledInstance((int) (size.getWidth()*0.30), (int) (size.getHeight()*0.9), Image.SCALE_DEFAULT)));
        mainPanel.add(imgLabel);

        // add the Jpanel to the main window
        this.add(mainPanel); 

    }
    
    public void monteDesEaux(int niveau){
        this.mainPanel.remove(imgLabel);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        File path = new File("");
        try {
            image = ImageIO.read(new File(path.getAbsolutePath()+"/src/Image/niveauDesEaux"+niveau+".png"));
        } catch (IOException ex) {
            Logger.getLogger(VueNiveauDo.class.getName()).log(Level.SEVERE, null, ex);
        }
        imgLabel = new JLabel(new ImageIcon(image.getScaledInstance((int) (dim.getWidth()*0.15), (int) (dim.getHeight()*0.9), Image.SCALE_DEFAULT)));
        mainPanel.add(imgLabel);
        this.validate();
        this.repaint();
    }
    
}
