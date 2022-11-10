package websDara;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.*;

public class EjPrueba {
    public static void main(String[] args) {
        URL url = null;
        try {
            url = new URL("https://www.as.com");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        BufferedReader in;
        try {
            InputStream inputStream = url.openStream();
            in = new BufferedReader(new InputStreamReader(inputStream));
            int numMbappe = 0;
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                if (inputLine.contains("Mbappé") || inputLine.contains("mbappé")){
                    numMbappe++;
                }
                //System.out.println(inputLine);
            }
            System.out.println("Hay " + numMbappe + " palabras de Mbappé");
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
