package startingThreads1;

import java.util.Scanner;

public class ColorThread extends Thread{
	
	
	
	ColorThread(){
	}
	
	public void run() {
		System.out.println("Hola, el mundo es de color "+ this.getName());
	}
}
