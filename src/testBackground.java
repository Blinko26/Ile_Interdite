 import java.awt.*;
import javax.swing.*;
 
 
public class testBackground extends JFrame{
 
	public testBackground() {
		setSize(800, 500);
 
		JPanel panTmp = new JPanel();
		panTmp.add(new JLabel("Mon label"));
		JButton toto = new JButton("Suite");
 
		panTmp.add(toto);
		panTmp.setOpaque(false);
 
		JLabel contentPane = new JLabel();
		contentPane.setIcon( new ImageIcon("/users/info/etu-s2/viellarb/Ile_Interdite/Ile_Interdite/src/Image/fond.png"));
		contentPane.setLayout( new BorderLayout() );
		this.setContentPane( contentPane );
 
		this.getContentPane().add(panTmp);
	}
 
	public static void main(String args[]) {
		testBackground objScreen = new testBackground();
		objScreen.setVisible(true);
	}
}
 
class TestImagePanel extends JPanel {
 
	private static final long serialVersionUID = 1L;
	private Image img;
 
	public TestImagePanel(String img) {
		this(new ImageIcon(img).getImage());
	}
 
	public TestImagePanel(Image img) {
		this.img = img;
		Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
		setPreferredSize(size);
		setMinimumSize(size);
		setMaximumSize(size);
		setSize(size);
		setLayout(null);
	}
 
	public void paintComponent(Graphics g) {
		g.drawImage(img, 0, 0, null);
	}
}
