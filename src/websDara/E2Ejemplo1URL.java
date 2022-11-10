package websDara;

import java.net.*;

public class E2Ejemplo1URL {
    public static void main(String[] args) {
        URL url;
        try {
            System.out.println("======ALARM====== Consturctor simple para URL: ");
            url = new URL("http://www.as.com");
            visualizar(url);

            System.out.println("Otro consturctor simple para URL: ");
            url = new URL("http://localhost:80/PFC/gest/ccli_gestion.php?S=3");
            visualizar(url);

            System.out.println("Protocolo para: Protocolo + URL + Puerto + Directorio");
            url = new URL("http", "docs.oracle.com", "/javase/7");
            visualizar(url);

            System.out.println("Cosntructor para un objeto URL y un directorio");
            URL urlBase = new URL("http://docs.oracle.com");
            url = new URL(urlBase, "/javase/7/docs/api/java/net/URL.html");
            visualizar(url);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void visualizar(URL url) {
        System.out.println("\tURL COMPLETA: " + url.toString());
        System.out.println("\tgetProtocol(): " + url.getProtocol());
        System.out.println("\tgetHost(): " + url.getHost());
        System.out.println("\tgetPort(): " + url.getPort());
        System.out.println("\tgetFile(): " + url.getFile());
        System.out.println("\tgetUserInfo(): " + url.getUserInfo());
        System.out.println("\tgetPath(): " + url.getPath());
        System.out.println("\tgetAuthority(): " + url.getAuthority());
        System.out.println("\tgetQuery(): " + url.getQuery());
        System.out.println("===============================================");
    }//fin del método visualizar
}
