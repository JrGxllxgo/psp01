package peval1psp2223;

/**
 * @author Jose Ramon Gallego Velez
 * @version 1.0.
 * @info Program that has 30 voters and they have their own id, if they are not in the census they cannot vote
 * for the referendum, they go to a queue and wait their turn to vote, it takes between 1 and 2 seconds, every
 * 10 seconds the system count how many votes we have and when it finish it says the results.
 * <p>
 * This is the main class
 */
public class Ejecutable {
    public static void main(String[] args) {

        ColegioElectoral myCollege = new ColegioElectoral();
        Recuento rec = new Recuento(myCollege);

        for (int i = 1; i <= 30; i++) { //loop where we create the voters using their name as "Ciudadano x" and the i like the id
            Thread Votante = new Thread(new Votante(myCollege, "Ciudadano " + i, i));
            Votante.start();
        }

        rec.start();
    }
}
