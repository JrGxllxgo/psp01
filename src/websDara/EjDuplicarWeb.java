package websDara;

/**
 * Programa que lee la pagina de as y sustituye la palabra Mbappé por mcguire y lo escribe en un archivo .txt
 */

import java.io.*;
import java.net.URL;

public class EjDuplicarWeb {
    public static void main(String[] args) {
        URL url = null;
        try {
            FileWriter mirrorWeb = new FileWriter("D:/2 DAM/Psp/mirrorWebs/mbappeAs.txt");
            url = new URL("https://www.as.com");
            BufferedReader in;InputStream inputStream = url.openStream();
            in = new BufferedReader(new InputStreamReader(inputStream));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                String line = inputLine;
                if(inputLine.contains("Mbappé")){
                    line = inputLine.replace("Mbappé","McGuire");
                }
                mirrorWeb.write(line);
            }
            in.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
