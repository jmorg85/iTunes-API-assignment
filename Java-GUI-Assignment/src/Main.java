import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, JSONException {
        JFrame frame = new JFrame("iTunes GUI");
        JPanel p = new JPanel();

        //This is my attempt to add a scroll function by trying to add a jpanel that's the size
        //of the frame and put stuff on top of that.

        /*JPanel p2 = new JPanel();
        p2.setPreferredSize(new Dimension(800,800));
        JScrollPane scroll = new JScrollPane(p2, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        frame.add(scroll);*/

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(800,800));
        frame.getContentPane().setBackground(new Color(255,255,255));
        frame.pack();
        frame.setVisible(true);

        GridLayout grid =  new GridLayout(10,3,0,1);
        frame.setLayout(grid);



        Search s = new Search();
        String path = s.search();
        URL myUrl = new URL("http://itunes.apple.com/search?term=" + path + "&entity=album");
        URLConnection myUrlConnection = myUrl.openConnection();

        java.io.InputStream myInputStream = myUrlConnection.getInputStream();
        InputStreamReader myInputStreamReader;
        myInputStreamReader = new InputStreamReader(myInputStream);

        BufferedReader in = new BufferedReader(myInputStreamReader);

        String line, str;

        str = "";
        System.out.print("\n");
        while ((line = in.readLine()) != null)
        {
            str += line;
            //System.out.println(line);
        }
        JSONObject myObject = new JSONObject(str);
        System.out.println(str);
        JSONArray myResultsArray = myObject.getJSONArray("results");
        int n = myResultsArray.length();

        for(int i=0;i<n;i++)
        {
            JSONObject obj = myResultsArray.getJSONObject(i);
            String collectionName = obj.getString("collectionName");
            System.out.println("The collection name is: " +collectionName);
            String artistViewUrl = obj.getString("artistViewUrl");
            System.out.println("The artist view URL is: " + artistViewUrl);
            String collectionViewUrl = obj.getString("collectionViewUrl");
            System.out.println("The collection view url is: " + collectionViewUrl);
            String artworkUrl60 = obj.getString("artworkUrl60");
            String artworkUrl100 = obj.getString("artworkUrl100");
            System.out.println("ArtworkUrl100 is: " + artworkUrl100);
            Test_GUI GUI = new Test_GUI(artworkUrl100);
            GUI.makeImage(frame, collectionName);
        }
    }
}
