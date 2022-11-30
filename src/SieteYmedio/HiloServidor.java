package SieteYmedio;

import java.net.Socket;

public class HiloServidor implements Runnable {

	Socket cliente;
	TuberiaServidor tuberiaServidor;
	Baraja baraja;
	public HiloServidor(Socket cliente, TuberiaServidor tuberiaServidor, int activeCount, Baraja baraja) {
		this.baraja = baraja;
		this.tuberiaServidor = tuberiaServidor;
		this.cliente = cliente;
	}

	@Override
	public void run() {
		tuberiaServidor.esperarJugadores(cliente);
		boolean continuar = true;
		while(continuar) {
			continuar = tuberiaServidor.jugar(baraja, cliente);
		}

	}

}
