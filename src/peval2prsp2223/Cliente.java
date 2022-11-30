package peval2prsp2223;

/**
 * @author José Ramón Gallego Vélez
 * @date 21/11/2022
 * @version 0
 * @info On this class we start the client
 */

import java.net.*;
import java.io.*;
import java.util.*;

public class Cliente {
    /**
     * Integer with the port we´ll use
     */
    final int PORT = 5000;
    /**
     * Socket for the client
     */
    Socket cliente;
    /**
     * Dataoutputstream for receive data
     */
    DataOutputStream output;
    /**
     * DataInput stream for send data
     */
    DataInputStream input;
    /**
     * String with the text received
     */
    String msgReceived;
    /**
     * String with the text to send
     */
    String msgSend;
    /**
     * Scanner to write data with the keyb
     */
    private static Scanner keybReader = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        System.out.println("Cliente llamando");
        Cliente cliente = new Cliente();

        cliente.initClient();
    }

    /**
     * Method to strart the client and the conversartion
     *
     * @throws IOException
     */
    public void initClient() throws IOException {
        cliente = new Socket("localhost", PORT);

        input = new DataInputStream(cliente.getInputStream());
        output = new DataOutputStream(cliente.getOutputStream());

        //leer peticion de nombre
        msgReceived = input.readUTF();
        System.out.println(msgReceived);

        //introducir el nombre del usuario
        String user = keybReader.nextLine();
        output.writeUTF(user);

        //donde desea derivar???
        msgReceived = input.readUTF();
        System.out.println("Servidor: " + msgReceived);

        //eleccion de derivado
        int deptOtion = Integer.parseInt(keybReader.nextLine());
        output.writeInt(deptOtion);

        System.out.println(input.readUTF());

        boolean chat = true;
        msgSend = "";
        msgReceived = "";
        while (chat) {

            if (msgReceived.equals("completo")) {
                System.out.println("Servidor completo");
                chat = false;
            } else if (msgSend.equals("salir")) {
                System.out.println("Servidor: " + msgReceived);
                chat = false;
            } else {
                msgReceived = input.readUTF();
                System.out.println("Servidor: " + msgReceived);

                System.out.print("Escribe el mensaje: ");
                msgSend = keybReader.nextLine();
                output.writeUTF(msgSend);
            }
        }

        System.out.println(input.readUTF());
        System.out.println("Hasta luego!!");

        output.close();
        input.close();
        cliente.close();
    }
}
