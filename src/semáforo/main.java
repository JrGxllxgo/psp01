package semáforo;

public class main {

	public static void main(String[] args) throws InterruptedException {
		Semaforo sem = new Semaforo();
		Temporizador temp = new Temporizador(sem);

		Light greenLight = new Light(sem, "green");
		Light orangeLight = new Light(sem, "orange");
		Light redLight = new Light(sem, "red");

		temp.start();
		greenLight.start();
		orangeLight.start();
		redLight.start();

		try {
			redLight.join();
			greenLight.join();
			orangeLight.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
