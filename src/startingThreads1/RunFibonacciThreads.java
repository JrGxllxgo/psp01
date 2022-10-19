package startingThreads1;

public class RunFibonacciThreads {

	public static void main(String[] args) {
		FibonacciThreads fibo = new FibonacciThreads();
		
		fibo.setName("Serie Fibonacci");
		
		fibo.start();

	}

}
