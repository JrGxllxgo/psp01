package peval2prsp2223;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Servidor {

    final int PORT = 5000;
    /**
     * Socket for the server
     */
    private ServerSocket servidor;
    /**
     * DataInput stream for send data
     */
    private DataInputStream input;
    /**
     * Dataoutputstream for receive data
     */
    private DataOutputStream output;

    int conexiones = 0;

    public static void main(String[] args) throws IOException {
        Servidor myServer = new Servidor();
        myServer.initServer();
    }

    public void initServer() throws IOException {
        servidor = new ServerSocket(PORT);
        System.out.println("Waiting Connection...");


        do {
            Socket mySocket = servidor.accept();

            input = new DataInputStream(mySocket.getInputStream());
            output = new DataOutputStream(mySocket.getOutputStream());

            output.writeUTF("Elija el nombre de usuario: ");

            String userName = input.readUTF();

            System.out.println("");

            System.out.println("Client connected");

            output.writeUTF("Bienvenido al CALL CENTER elija un departamento:" +
                    "\n1: Futurologia" +
                    "\n2: Meeting" +
                    "\n3: Compras");

            int dept = input.readInt();
            switch (dept) {
                case 1:
                    output.writeUTF("Derivando a futurologia...");
                    System.out.println("Puerto de Cliente: " + mySocket.getPort() +
                            "\nIP Cliente: " + mySocket.getLocalAddress() +
                            "\nElección: FUTUROLOGIA" +
                            "\nNombre de usuario: " + userName);
                    break;
                case 2:
                    output.writeUTF("Derivando a meeting...");
                    System.out.println("Puerto de Cliente: " + mySocket.getPort() +
                            "\nIP Cliente: " + mySocket.getLocalAddress() +
                            "\nElección: MEETING" +
                            "\nNombre de usuario: " + userName);
                    break;
                case 3:
                    output.writeUTF("Derivando a compras...");
                    System.out.println("Puerto de Cliente: " + mySocket.getPort() +
                            "\nIP Cliente: " + mySocket.getLocalAddress() +
                            "\nElección: COMPRAS" +
                            "\nNombre de usuario: " + userName);
                    break;
            }

            conexiones++;
            Thread cliHilo = new Thread(new HiloServidor(mySocket, dept, userName,conexiones));
            cliHilo.start();
        } while (true);
    }
}
