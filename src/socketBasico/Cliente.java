package socketBasico;

import java.net.*;
import java.io.*;
import java.util.*;

public class Cliente {

    final int PORT = 5000;
    Socket cliente;
    String message;
    DataOutputStream output;

    public static void main(String[] args) throws IOException {
        Cliente client = new Cliente();
        client.initClient();
    }

    //initialize the client
    public void initClient() throws IOException {
        cliente = new Socket("192.168.1.219", PORT);
        System.out.println("Write message...");
        Scanner sc = new Scanner(System.in);
        message = sc.nextLine();
        output = new DataOutputStream(cliente.getOutputStream());
        output.writeUTF(message);
        System.out.println("Message send");
        output.close();
        cliente.close();
    }
}
