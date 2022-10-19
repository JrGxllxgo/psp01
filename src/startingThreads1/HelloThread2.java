package startingThreads1;

public class HelloThread2 extends Thread {

	HelloThread2() {
		System.out.println("He creado " + this.getName());
	}

	public void run() {
		for (int i = 1; i <= 500; i++) {
			System.out.println("Estoy en " + this.getName() + " " + i);
			try {
				this.wait(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
