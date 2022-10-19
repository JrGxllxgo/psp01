package semáforo;

public class Semaforo {

	int timer = 60;
	
	String lastLight = "red";
	String preLastLight = "orange";
	
	Boolean redOn = false;
	Boolean greenOn = false;
	Boolean orangeOn = false;
	
	Semaforo(){
		System.out.println("Semaforo en funcionamiento");
	}
	
	public synchronized void turnOn(String color)throws InterruptedException {
		if (color.equals("red")) {
			while ((!lastLight.equals("orange")) && (!preLastLight.equals("green"))&&(timer>0)) {
				wait();
			}
			if (timer > 0) {
				redOn = true;
				System.out.println("El semaforo abre la luz red");
			}
		} else if (color.equals("orange")) {
			while ((!lastLight.equals("green")) && (!preLastLight.equals("red"))&&(timer>0)) {
				wait();
			}
			if (timer > 0) {
				orangeOn = true;
				System.out.println("El semaforo abre la luz orange");
			}
		} else {
			while ((!lastLight.equals("red")) && (!preLastLight.equals("orange"))&&(timer>0)) {
				wait();
			}
			if (timer > 0) {
				greenOn = true;
				System.out.println("El semaforo abre la luz green");
			}
		}
		notifyAll();
	}
	
	public synchronized void turnOff(String color) throws InterruptedException {
		if (color.equals("red")) {
			while ((!redOn)&&(timer>0)) {
				wait();
			}
			if (timer > 0) {
				System.out.println("El semaforo apaga red");
				redOn = false;
				lastLight = "red";
				preLastLight = "orange";
			}

		} else if ((color.equals("orange"))&&(timer>0)) {
			while (!orangeOn) {
				wait();
			}
			if (timer > 0) {
				System.out.println("El semaforo apaga orange");
				orangeOn = false;
				lastLight = "orange";
				preLastLight = "green";
			}
		} else {
			while ((!greenOn)&&(timer>0)) {
				wait();
			}
			if (timer > 0) {
				System.out.println("El semaforo apaga green");
				greenOn = false;
				lastLight = "green";
				preLastLight = "red";
			}
		}
		notifyAll();
	}
	
	public void timerTime() {
		timer--;
		System.out.println(timer);
	}
	
	public synchronized int getTimer() {
		return timer;
	}
}
