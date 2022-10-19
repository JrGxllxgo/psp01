package kingdom;

public class Personas extends Thread{

	Palacio palace;
	
	Personas(Palacio palace, String name){
		this.palace = palace;
		
		this.setName(name);
		
		System.out.println("Ha llegado " + this.getName());
	}
	
	public void run() {
		palace.talk(this.getName());
	}
}
