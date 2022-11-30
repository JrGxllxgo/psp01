package SieteYmedio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	public static void main(String[] args) {
		try {
			ServerSocket serverSocket = new ServerSocket(5000);
			TuberiaServidor tuberiaServidor = new TuberiaServidor();
			Baraja baraja = new Baraja();
			while(true) {
				System.out.println("Esperando conexion...");
				Socket cliente = serverSocket.accept();
				new Thread(new HiloServidor(cliente, tuberiaServidor, Thread.activeCount(), baraja)).start();;
			}
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
