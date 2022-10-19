package startingThreads1;

/*
 * Run; ejecucion del hilo, lo que va a hacer
 * 
 * Start; lanza el hilo y llama al run
 */
public class RunThread2 {
	public static void main(String[] args) {
		HelloThread2 h1 = new HelloThread2();
		HelloThread2 h2 = new HelloThread2();
		
		h1.setName("My Thread 1");
		h2.setName("My Thread 2");
		
		
		System.out.println("Hilos creados");
		
		h1.start();
		h2.start();
		
		System.out.println("Programa finalizado");
	}
}
	