package startingThreads1;

public class RunLoteriaThread {
	
	public static void main(String[]args) {

		Thread decenasMillar = new Thread(new LoteriaThread("Decenas de Millar"));
		Thread unidadesMillar = new Thread(new LoteriaThread("Unidades de Millar"));
		Thread centenas = new Thread(new LoteriaThread("Centenas"));
		Thread decenas = new Thread(new LoteriaThread("Decenas"));
		Thread unidades = new Thread(new LoteriaThread("Unidades"));
		
		System.out.println("Comienza el sorteo...");
		
		try {
			decenasMillar.start();
			decenasMillar.join();
			
			unidadesMillar.start();
			unidadesMillar.join();
			
			centenas.start();
			centenas.join();
			
			decenas.start();
			decenas.join();
			
			unidades.start();
			unidades.join();
		}catch (InterruptedException e){
			e.printStackTrace();
		}
		
	}
}
