package StrartingPipes;

public class Principal {

	public static void main(String[] args) {
		MyPipe t = new MyPipe();
		
		MyThread h1 = new MyThread(t);
		MyThread h2 = new MyThread(t);
		
		h1.start();
		h2.start();

	}

}
