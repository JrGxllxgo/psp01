package kingdom;

public class main {

	public static void main(String[] args) {
		Palacio palace = new Palacio();
		
		Personas knight1 = new Personas(palace, "Caballero 1");
		Personas knight2 = new Personas(palace, "Caballero 2");
		Personas knight3 = new Personas(palace, "Caballero 3");
		Personas king = new Personas(palace, "Rey");

		knight1.start();
		king.start();
		knight2.start();
		knight3.start();
	}

}
