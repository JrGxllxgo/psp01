package StrartingPipes;

public class MyPipe {

	int n = 0;
	String lastThread = "Thread-0";

	MyPipe() {
		System.out.println("Pipe created");
	}

	public synchronized void print(String hilo) {

		if (hilo.equals(lastThread)) {
			try {
				// System.out.println(hilo + " se queria colar");
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		n++;
		System.out.println("Showing thread: " + hilo + " la vez " + n);
		lastThread = hilo;

		notifyAll();
	}

}
