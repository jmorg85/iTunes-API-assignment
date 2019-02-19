import java.awt.image.BufferedImage;
import java.net.*;
import java.awt.*;
import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;

//Use the artworkUrl100 for the image

public class Test_GUI extends JPanel{
    public String artworkUrl;

public Test_GUI(String artworkUrl_in)
{
    artworkUrl = artworkUrl_in;
}


    public void makeImage(JFrame frame, String collectionName) throws IOException {


        URL url = new URL(artworkUrl);
        Image image = ImageIO.read(url);

        JLabel label = new JLabel(new ImageIcon(image), 2);
        label.setText(collectionName);
        frame.add(label);
    }


}
