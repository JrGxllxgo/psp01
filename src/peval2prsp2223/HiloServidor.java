package peval2prsp2223;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class HiloServidor implements Runnable {

    Socket client;
    int depart;
    String msgReceived;
    String userName;
    String msgSend;
    DataOutputStream output;
    DataInputStream input;
    Scanner keybReader = new Scanner(System.in);

    public HiloServidor(Socket client, int depart, String username) throws IOException {
        this.client = client;
        this.depart = depart;
        this.userName = username;

        output = new DataOutputStream(client.getOutputStream());
        input = new DataInputStream(client.getInputStream());
    }

    @Override
    public void run() {
        int inicioLlamada = (int) System.currentTimeMillis();

        switch (depart) {
            case 1:
                try {
                    output.writeUTF("BIENVENIDO a futurologia");

                    conversacion();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                break;
            case 2:
                try {
                    output.writeUTF("BIENVENIDO a meeting");

                    conversacion();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                break;
            case 3:
                try {
                    output.writeUTF("BIENVENIDO a compras");

                    conversacion();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                break;
        }

        try {
            int totalLlamada = (int) (System.currentTimeMillis() - inicioLlamada) / 6000;
            float cobro = (float) (totalLlamada * 1.20);
            output.writeUTF("Tiempo de llamada: " + totalLlamada + " minutos, precio: " + cobro + "€");
            client.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void conversacion() throws IOException {
        msgReceived = "";
        while (!msgReceived.equals("salir")) {
            msgReceived = input.readUTF();
            System.out.println("Cliente " + userName + ": " + msgReceived);

            if(!msgReceived.equals("salir")){
                System.out.print("Escribe el mensaje: ");
                msgSend = keybReader.nextLine();
                output.writeUTF(msgSend);
            }else{
                System.out.println("El cliente" + userName + " ha colgado.");
            }
        }
    }
}
