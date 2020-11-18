package ventanas;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ImagePanel extends JPanel {
	 public BufferedImage mapaMuseo;

	    public ImagePanel(String img) {
	       try {                
	          mapaMuseo = ImageIO.read(new File(img));
	       } catch (IOException ex) {
	       }
	    }

	    @Override
	    protected void paintComponent(Graphics g) {
	        super.paintComponent(g);
	        g.drawImage(mapaMuseo, 0, 0, this); // see javadoc for more info on the parameters            
	    }

	}
