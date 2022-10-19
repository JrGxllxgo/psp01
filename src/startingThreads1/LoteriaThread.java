package startingThreads1;

public class LoteriaThread implements Runnable{
	
	Thread t;
	long retardo;
	
	LoteriaThread(String name){
		t = new Thread (this);
		t.setName(name);
		this.retardo = retardo;
	}

	@Override
	public void run() {
		int numero = (int) Math.random()*10;
	}
	

}
