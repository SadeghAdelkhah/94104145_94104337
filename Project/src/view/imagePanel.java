package view;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by User on 2/5/2017.
 */
public class imagePanel extends JPanel{
    private BufferedImage image;

    public imagePanel(String address) throws IOException{
        try{
            image = ImageIO.read(new File(address));
        }
        catch (IOException ex){
        }
    }
    @Override
    protected void paintComponent(java.awt.Graphics g) {
        super.paint(g);
        g.drawImage(image, 0 , 0, this);
    }

}
