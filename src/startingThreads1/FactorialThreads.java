package startingThreads1;

public class FactorialThreads extends Thread {
	private int num = 5;
	private int res = 1;

	FactorialThreads() {
		System.out.println(this.getName()+" creado");
	}

	public void run() {
		for (int i = 1; i <= num; i++) {
			System.out.println(res = res * i);
		}
	}
}
