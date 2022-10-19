package kingdom;

public class Palacio {

	String lastPerson = ("Rey");
	
	Boolean canTalk = false;

	Palacio() {
		System.out.println("Palacio abierto");
	}

	public synchronized void talk(String person) {
		while(lastPerson.contains("Caballero")) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(canTalk) {
			System.out.println("Saludos rey");
		}else {
			System.out.println("Saludos caballeros");
			lastPerson = "Rey";
			canTalk = true;
		}
		
		notifyAll();
	}
}
