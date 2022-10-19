package semáforo;

public class Light extends Thread{

	Semaforo sem;
	
	Light(Semaforo sem, String color){
		this.sem = sem;
		
		this.setName(color);
		
		System.out.println("Bombilla " + this.getName() + " colocada");
	}
	
	public void run() {
		while (sem.getTimer() > 0) {
			try {
				sem.turnOn(this.getName());
				Thread.sleep(5000);
				sem.turnOff(this.getName());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Termina el hilo "+this.getName());
	}
}
