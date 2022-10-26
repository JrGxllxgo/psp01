package peval1psp2223;

/**
 * @author Jose Ramon Gallego Velez
 * @version 1.0.
 * @info Class where we use the thread with the values and some getters y setters
 */

public class Votante extends Thread {

    ColegioElectoral myCollege;

    /**
     * String name is used to set the name of the thread
     */
    private String name;

    /**
     * Integer dni is teh id of the voter
     */
    private int dni;

    /**
     * boolean canVote is used to set if the voter can vote
     */
    private boolean canVote = false;

    /**
     * Constructor of the class
     *
     * @param myCollege the class
     * @param name      String to set the name as the class one
     * @param i         Integer to set as the dni of the voter
     */
    Votante(ColegioElectoral myCollege, String name, int i) {
        this.myCollege = myCollege;
        this.name = name;
        this.dni = i;
        this.setName(this.name);
    }

    /**
     * Run method of the thread
     */
    @Override
    public void run() {
        System.out.println(this.getName() + " ha entrado al colegio electoral.");
        myCollege.checkDni(name, this.dni, this); //call a method to check if it can vote or not
        if (canVote) { //conditional to vote if it is possible
            myCollege.vote(name, this);
        }

        System.out.println(this.getName() + " ha salido del colegio electoral.");
    }

    /**
     * Setter of the boolean value to can vote or not
     *
     * @param canVote boolean
     */
    public void setCanVote(boolean canVote) {
        this.canVote = canVote;
    }
}
