package peval2prsp2223;

import java.net.*;
import java.io.*;
import java.util.*;

public class Cliente {
    final int PORT = 5000;
    Socket cliente;
    DataOutputStream output;
    DataInputStream input;
    String msgReceived;
    String msgSend;

    private static Scanner keybReader = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        System.out.println("Cliente llamando");
        Cliente cliente = new Cliente();

        cliente.initClient();
    }
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

        msgSend="";
        while (!msgSend.equals("salir")) {
            msgReceived = input.readUTF();
            System.out.println("Servidor: " + msgReceived);

            System.out.print("Escribe el mensaje: ");
            msgSend = keybReader.nextLine();
            output.writeUTF(msgSend);
        }

        System.out.println(input.readUTF());
        System.out.println("Hasta luego!!");

        output.close();
        input.close();
        cliente.close();
    }
}
