package sockets;

import java.io.*;
import java.net.*;

public class E2Ejemplo2URL {
    public static void main(String[] args) {
        URL url = null;
        try {
            url = new URL("https://www.cbalhaurindelatorre.es");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        BufferedReader in;
        try {
            InputStream inputStream = url.openStream();
            in = new BufferedReader(new InputStreamReader(inputStream));
            String inputLine;
            while ((inputLine = in.readLine()) != null) System.out.println(inputLine);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }//fin del main
}//FIN DEL PROGRAMA