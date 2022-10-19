package startingThreads1;

import java.util.Scanner;

public class RunColorThread {

	public static void main(String[] args) {
		HelloThread2 h1 = new HelloThread2();
		HelloThread2 h2 = new HelloThread2();
		HelloThread2 h3 = new HelloThread2();

		h1.setName(introKeyb());
		h2.setName(introKeyb());
		h3.setName(introKeyb());
		
		h1.start();
		h2.start();
		h3.start();
	}
	
	public static String introKeyb() {
		System.out.println("Introduzca el color deseado");
		Scanner keyboard = new Scanner(System.in);
		String color = keyboard.nextLine();
		return color;
	}

}
