package SieteYmedio;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class TuberiaServidor {

	private static final int NUMEROJUGADORES = 3;
	ArrayList<Socket> clientes = new ArrayList<>();
	ArrayList<Double> puntuaciones = new ArrayList<>();
	HashMap<Integer, Double> puntuacionesFinales = new HashMap<>();

	public void esperarJugadores(Socket cliente) {
		synchronized (clientes) {
			try {
				DataInputStream dis = new DataInputStream(cliente.getInputStream());
				DataOutputStream dos = new DataOutputStream(cliente.getOutputStream());
				clientes.add(cliente);
				dos.writeUTF("Esperando jugadores...");
				while (clientes.size() < NUMEROJUGADORES)
					clientes.wait();
				puntuaciones.add(0.0);
				dos.writeUTF("Comienza el juego");
				clientes.notifyAll();

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public synchronized boolean jugar(Baraja baraja, Socket cliente) {
		boolean continuar = true;
		try {
			DataInputStream dis = new DataInputStream(cliente.getInputStream());
			DataOutputStream dos = new DataOutputStream(cliente.getOutputStream());
			while (clientes.get(0) != cliente) {
				wait();
			}

			if (puntuaciones.get(0) <= 7.5) {
				String carta = baraja.extraerCarta();
				if (Character.isDigit(carta.charAt(0))) {
					puntuaciones.set(0, puntuaciones.get(0) + Double.parseDouble(String.valueOf(carta.charAt(0))));
				} else {
					puntuaciones.set(0, puntuaciones.get(0) + 0.5);
				}

				dos.writeUTF("Has sacado la carta " + carta);
				System.out.println("El cliente " + cliente.getPort() + " ha sacado la carta " + carta);
				dos.writeUTF("Tu puntucion es " + puntuaciones.get(0));
				System.out
						.println("El cliente " + cliente.getPort() + " tiene una puntuacion de " + puntuaciones.get(0));
				;
				if (puntuaciones.get(0) <= 7.5) {
					dos.writeUTF("¿Quieres continuar? 1 = Si, Otra tecla = No");
					if (dis.readUTF().equals("1")) {
						clientes.add(cliente);
						clientes.remove(0);
						puntuaciones.add(puntuaciones.get(0));
						puntuaciones.remove(0);
						dos.writeUTF("Esperando turno");
					} else {
						continuar = false;

						puntuacionesFinales.put(cliente.getPort(), puntuaciones.get(0));
						dos.writeUTF("Te has plantado con " + puntuaciones.get(0));
						clientes.remove(0);
						puntuaciones.remove(0);
					}
				} else {
					continuar = false;
					puntuacionesFinales.put(cliente.getPort(), puntuaciones.get(0));

					dos.writeUTF("Has perdido, asi que no puedes volver a jugar :(");
					dos.writeUTF("");
					dos.writeUTF("");
					// dis.readUTF(); //NO PONER JAMAS
					dos.writeUTF("");
					clientes.remove(0);
					puntuaciones.remove(0);
				}

			} else {
				continuar = false;
				puntuacionesFinales.put(cliente.getPort(), puntuaciones.get(0));

				dos.writeUTF("Has perdido, asi que no puedes volver a jugar :(");
				dos.writeUTF("");
				dos.writeUTF("");
				dis.readUTF();
				dos.writeUTF("");
				clientes.remove(0);
				puntuaciones.remove(0);
			}

			if (puntuacionesFinales.size() == 3) {
				esperarCupier(baraja);
			}
			notifyAll();
		} catch (InterruptedException e) {
			// TODO: handle exception
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return continuar;
	}

	private void esperarCupier(Baraja baraja) {
		boolean continuar = true;
		Double puntuacionBanca = 0.0;
		String carta;
		while (continuar && puntuacionBanca <= 7.5) {
			carta = baraja.extraerCarta();
			System.out.println("La banca ha sacado la carta " + carta);
			if (Character.isDigit(carta.charAt(0))) {
				puntuacionBanca += Double.parseDouble(String.valueOf(carta.charAt(0)));
			} else {
				puntuacionBanca += 0.5;
			}
			if (puntuacionBanca <= 7.5) {
				System.out.println("La puntuacion de la banca es: " + puntuacionBanca);
				System.out.println("¿Quieres volver a jugar? 1 = Si, Otra tecla = No");
				if (!new Scanner(System.in).next().equals("1")) {
					continuar = false;
				}
			} else {
				continuar = false;
			}

		}

		if (puntuacionBanca > 7.5) {
			System.out.println("La banca ha perdido porque se ha pasado");
		} else {
			System.out.println("La banca se ha plantado");
		}
		puntuacionesFinales.put(-1, puntuacionBanca);

		int personaGanadora = -2;
		double puntuacionPersonaGanadora = 0.0;
		for (Map.Entry<Integer, Double> e : puntuacionesFinales.entrySet()) {
			int persona = e.getKey();
			double puntuacionPersona = e.getValue();

			if ((puntuacionPersona > puntuacionPersonaGanadora && puntuacionPersona < 7.5)
					|| (persona == -1 && puntuacionPersona == puntuacionPersonaGanadora)) { // La segunda condicion
																							// indica que si es el
																							// cupier, en caso de tener
																							// la misma puntuacion igual
																							// que el cliene, ganaria el
																							// cupier
				personaGanadora = persona;
				puntuacionPersonaGanadora = puntuacionPersona;

			}
		}

		if (personaGanadora == -1) {
			System.out.println("Ha ganado la banca con una puntuacion de " + puntuacionPersonaGanadora);

		} else if (personaGanadora == -2) {
			System.out.println("Ha ganado la banca porque todos se han pasado");

		} else {
			System.out.println(
					"Ha ganado el cliente " + personaGanadora + " con una pùntuacion de " + puntuacionPersonaGanadora);
		}

	}

}
