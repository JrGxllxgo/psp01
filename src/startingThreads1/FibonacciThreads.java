package startingThreads1;

import java.util.Scanner;

public class FibonacciThreads extends Thread {

	int numSerie = introKeyb("Introduzca el numero para la serie fibonacci");
	int numSuma = 1;
	int num1 = 0;
	int num2 = 1;

	FibonacciThreads() {
		System.out.println(this.getName() + " creado");
	}

	public void run() {
		for (int i = 0; i < numSerie; i++) {
			System.out.println(numSuma);

			numSuma = num1 + num2;

			num1 = num2;

			num2 = numSuma;
		}
	}

	public static int introKeyb(String txt) {
		System.out.println(txt);
		Scanner keyboard = new Scanner(System.in);
		int num = keyboard.nextInt();
		return num;
	}
}
