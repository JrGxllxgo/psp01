package SieteYmedio;

import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
	
	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			Socket cliente = new Socket("localhost", 5000);
			DataOutputStream dos = new DataOutputStream(cliente.getOutputStream());
			DataInputStream dis = new DataInputStream(cliente.getInputStream());
			System.out.println(dis.readUTF()); //Esperando jugadores
			System.out.println(dis.readUTF()); //Comienza el juego
			boolean continuar = true;
			while (continuar) {
				System.out.println(dis.readUTF()); //Has cogido la carta xxxx
				System.out.println(dis.readUTF()); //Tu puntuacion
				System.out.println(dis.readUTF()); //¿Quieres continuar?
				dos.writeUTF(sc.next());
				System.out.println(dis.readUTF()); // Esperando tu turno - Te has plantado
				
			}
		
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
