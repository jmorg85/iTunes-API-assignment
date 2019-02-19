import javax.swing.*;
import java.util.Scanner;

public class Search {

    public String search()

    {
        String artist = JOptionPane.showInputDialog(null, "Type in an artist's name.");

        String urlStr = "";

        String[] myStrings = artist.split(" ");
        int n = myStrings.length;
        for (int i = 0; i < n - 1; i++) {
            urlStr += myStrings[i] + "+";
        }
        urlStr += myStrings[n - 1];
        return urlStr;
    }
}
