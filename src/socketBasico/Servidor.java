package socketBasico;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Servidor {

    final int PORT = 5000;
    ServerSocket server;
    Socket socket;
    DataInputStream input;
    String msgReceived;
    String msgSend;
    DataOutputStream output;
    boolean chat = true;

    public static void main(String[] args) throws IOException {
        Servidor server = new Servidor();
        server.initServer();
    }

    public void initServer() throws IOException {
        server = new ServerSocket(PORT);
        socket = new Socket();

        // espera la conexión del cliente
        System.out.println("Waiting Connection...");
        socket = server.accept();
        input = new DataInputStream(socket.getInputStream());
        System.out.println("Client connected");


        do{
            msgReceived = input.readUTF();
            // saca en pantalla el mensaje enviado por el cliente
            System.out.println("\tMessage: " + msgReceived);

            // escribe el mensaje que le mandará al cliente
            System.out.println("Write message...");
            Scanner sc = new Scanner(System.in);
            msgSend = sc.nextLine();
            output = new DataOutputStream(socket.getOutputStream());
            output.writeUTF(msgSend);
            System.out.println("Message send");
            if(msgSend.equals("N")){
                chat = false;
            }
        }while(chat);


        output.close();
        input.close();
        socket.close();
        server.close();
        System.out.println("End Connection");
    }
}
