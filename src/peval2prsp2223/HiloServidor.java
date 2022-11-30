package peval2prsp2223;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class HiloServidor implements Runnable {

    /**
     * Socket for the client
     */
    Socket client;
    /**
     * Integer with the depart selected
     */
    int depart;
    /**
     * String with the text received
     */
    String msgReceived;
    /**
     * String with the username
     */
    String userName;
    /**
     * String with the text to send
     */
    String msgSend;
    /**
     * Dataoutputstream for receive data
     */
    DataOutputStream output;
    /**
     * DataInput stream for send data
     */
    DataInputStream input;
    /**
     * Scanner to write data with the keyb
     */
    Scanner keybReader = new Scanner(System.in);

    int conexiones;
    /**
     * Integer with the max num of the connections
     */
    int CONEXIONESMAX = 3;

    /**
     * Constructor with params to start server
     *
     * @param client     Socket
     * @param depart     Integer with the depart selected
     * @param username   String with username
     * @param conexiones Integer with the number of connections
     * @throws IOException
     */
    public HiloServidor(Socket client, int depart, String username, int conexiones) throws IOException {
        this.client = client;
        this.depart = depart;
        this.userName = username;
        this.conexiones = conexiones;

        output = new DataOutputStream(client.getOutputStream());
        input = new DataInputStream(client.getInputStream());
    }

    /**
     * Run method that start the thread
     */
    @Override
    public void run() {

        if(conexiones > CONEXIONESMAX){
            try {
                output.writeUTF("completo");
                client.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }else{
            /**
             * Integer with the time that it starts
             */
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
                /**
                 * Integer with the total time
                 */
                int totalLlamada = (int) (System.currentTimeMillis() - inicioLlamada) / 6000;
                /**
                 * Float with the price of the call
                 */
                float cobro = (float) (totalLlamada * 1.20);
                output.writeUTF("Tiempo de llamada: " + totalLlamada + " minutos, precio: " + cobro + "€");
                client.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * Method to make a conversation between server and clients
     *
     * @throws IOException
     */
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
