package semáforo;

public class Temporizador extends Thread{
	Semaforo sem;
	
	Temporizador(Semaforo sem){
		this.sem = sem;
	}
	
	public void run() {
		for (int i = 0; i < 60; i++) {
			sem.timerTime();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Termina el tiempo");
	}
}
