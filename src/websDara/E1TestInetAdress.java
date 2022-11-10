package websDara;

import java.net.*;

public class E1TestInetAdress {

    public static void main(String[] args) {
        InetAddress dir = null;
        System.out.println("================");
        System.out.println("SALIDA PARA LOCALHOST:");

        try {
            //LOCALHOST
            dir = InetAddress.getByName("localhost");
            pruebaMetodos(dir);

            //URL
            System.out.println("============");
            System.out.println("SALIDA PARA UNA URL: ");
            dir = InetAddress.getByName("www.cbalhaurindelatorre.es");
            pruebaMetodos(dir);

            //Mostrar todas las direcciones de una URL mediante un arrayde tipo InetAdress
            // en este caso vamos a obtener las direcciones asociadas a google
            System.out.println("===========");
            System.out.println("DIRECCIONES IP PARA: " + dir.getHostName());
            InetAddress[] direcciones = InetAddress.getAllByName(dir.getHostName());
            for (int i = 0; i < direcciones.length; i++) {
                System.out.println(direcciones[i].toString());
            }
            System.out.println("======================");
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }

    private static void pruebaMetodos(InetAddress dir) {
        System.out.println("Metodo getByName(): " + dir);
        InetAddress dir2;
        try {
            dir2 = InetAddress.getLocalHost();
            System.out.println("Metodo getLocalHost(): " + dir2);
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
        //otros metodos de la clase
        System.out.println("Metodo getHostName(): " + dir.getHostName());
        System.out.println("Metodo getHostAdress(): " + dir.getHostAddress());
        System.out.println("Metodo toString(): " + dir.toString());
        System.out.println("Metodo getCanonicanHostName(): " + dir.getCanonicalHostName());
    }
}
