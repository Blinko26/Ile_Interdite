package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import static javax.swing.SwingConstants.CENTER;
import javax.swing.border.MatteBorder;
import util.Utils.Pion;

 
public class VueAventurier  {
     
    private final JPanel panelBoutons ;
    private final JPanel panelCentre ;
    private final JFrame window;
    private final JPanel panelAventurier;
    private final JPanel mainPanel;
    private final JButton btnBouger  ;
    private final JButton btnAssecher;
    private final JButton btnAutreAction;
    private final JButton btnTerminerTour;
    private JTextField position;
   
   
   
    
    public VueAventurier(String nomJoueur, String nomAventurier, Color couleur){

        this.window = new JFrame();
        window.setSize(350, 200);
        //le titre = nom du joueur 
        window.setTitle(nomJoueur);
        mainPanel = new JPanel(new BorderLayout());
        this.window.add(mainPanel);

        mainPanel.setBackground(new Color(230, 230, 230));
        mainPanel.setBorder(BorderFactory.createLineBorder(couleur, 2)) ;

        // =================================================================================
        // NORD : le titre = nom de l'aventurier sur la couleurActive du pion

        this.panelAventurier = new JPanel();
        panelAventurier.setBackground(couleur);
        panelAventurier.add(new JLabel(nomAventurier,SwingConstants.CENTER ));
        mainPanel.add(panelAventurier, BorderLayout.NORTH);
   
        // =================================================================================
        // CENTRE : 1 ligne pour position courante
        this.panelCentre = new JPanel(new GridLayout(2, 1));
        this.panelCentre.setOpaque(false);
        this.panelCentre.setBorder(new MatteBorder(0, 0, 2, 0, couleur));
        mainPanel.add(this.panelCentre, BorderLayout.CENTER);
        
        panelCentre.add(new JLabel ("Position", SwingConstants.CENTER));
        position = new  JTextField(30); 
        position.setHorizontalAlignment(CENTER);
        panelCentre.add(position);


        // =================================================================================
        // SUD : les boutons
        this.panelBoutons = new JPanel(new GridLayout(2,2));
        this.panelBoutons.setOpaque(false);
        mainPanel.add(this.panelBoutons, BorderLayout.SOUTH);

        this.btnBouger = new JButton("Bouger") ;
        this.btnAssecher = new JButton( "Assecher");
        this.btnAutreAction = new JButton("AutreAction") ;
        this.btnTerminerTour = new JButton("Terminer Tour") ;
        
        this.panelBoutons.add(btnBouger);
        this.panelBoutons.add(btnAssecher);
        this.panelBoutons.add(btnAutreAction);
        this.panelBoutons.add(btnTerminerTour);

        this.window.setVisible(true);
    } 
    
    public void setPosition(String pos) {
        this.position.setText(pos);
    }
    
     public JButton getBtnAutreAction() {
        return btnAutreAction;
    }
    
    public String getPosition() {
        return position.getText();
    }

    public JButton getBtnBouger() {
        return btnBouger;
    }
    
    public JButton getBtnAssecher() {
        return btnAssecher;
    }

    public JButton getBtnTerminerTour() {
        return btnTerminerTour;
    }
 
     public static void main(String [] args) {
        // Instanciation de la fenêtre 
        VueAventurier vueAventurier = new VueAventurier("Manon", "Explorateur",Pion.ROUGE.getCouleur() );
    }
}

 

