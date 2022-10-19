package StrartingPipes;

public class MyThread extends Thread {

	MyPipe t;

	MyThread(MyPipe t) {
		this.t = t;

		System.out.println("Thread created " + this.getName());
	}

	public void run() {
		for (int i = 0; i < 20; i++) {
			t.print(this.getName());
		}
	}
}
