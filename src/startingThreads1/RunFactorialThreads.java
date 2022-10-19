package startingThreads1;

public class RunFactorialThreads {
	public static void main (String[]args ) {
		FactorialThreads fact = new FactorialThreads();
		
		fact.setName("Hilo Factorial");
		
		fact.start();
	}
}
