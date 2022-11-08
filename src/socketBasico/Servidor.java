package socketBasico;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

    final int PORT = 5000;
    ServerSocket server;
    Socket socket;
    DataInputStream input;
    String msgReceived;

    public static void main(String[] args) throws IOException {
        Servidor server = new Servidor();
        server.initServer();
    }

    public void initServer() throws IOException {
        server = new ServerSocket(PORT);
        socket = new Socket();

        System.out.println("Waiting Connection...");
        socket = server.accept();
        input = new DataInputStream(socket.getInputStream());
        System.out.println("Client connected");
        msgReceived = input.readUTF();
        System.out.println("Message: " + msgReceived);

        input.close();
        socket.close();
        server.close();
        System.out.println("End Connecion");
    }
}
