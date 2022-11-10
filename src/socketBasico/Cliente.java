package socketBasico;

import java.net.*;
import java.io.*;
import java.util.*;

public class Cliente {

    final int PORT = 5000;
    Socket cliente;
    String message;
    DataOutputStream output;
    DataInputStream input;
    String msgReceived;
    boolean chat = true;
    public static void main(String[] args) throws IOException {
        Cliente client = new Cliente();
        client.initClient();
    }

    //initialize the client
    public void initClient() throws IOException {
        cliente = new Socket("Localhost", PORT);

        do{
            System.out.println("Write message...");
            Scanner sc = new Scanner(System.in);
            message = sc.nextLine();
            output = new DataOutputStream(cliente.getOutputStream());
            output.writeUTF(message);
            System.out.println("Message send");

            input = new DataInputStream(cliente.getInputStream());
            msgReceived = input.readUTF();

            if(msgReceived.equals("N")){
                System.out.println("Se ha cerrado la conversación");
                chat = false;
            }else{
                System.out.println("\tMessage: " +  msgReceived);
            }
        }while (chat);

        output.close();
        input.close();
        cliente.close();
    }
}
