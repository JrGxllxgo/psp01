package peval1psp2223;

/**
 * @author Jose Ramon Gallego Velez
 * @version 1.0.
 * @info Class that we have as a pipe
 */

import java.util.ArrayList;
import java.util.Arrays;

import static java.lang.Thread.sleep;

public class ColegioElectoral {

    Recuento rec = new Recuento(this);

    /**
     * Class that set colors to the texts
     */
    ColorTools color = new ColorTools();

    /**
     * ArrayList queue is to get into this the voters that can vote have a sequence
     */
    private static ArrayList<String> queue = new ArrayList<>();

    /**
     * Array used to have the census
     */
    private static Integer census[] = {1, 2, 3, 4, 6, 8, 10, 11, 13, 14, 15, 18, 19, 20, 22, 23, 24, 28, 29, 30};

    /**
     * Integer countVotes is to count how many votes we have
     */
    private int countVotes = 0;

    /**
     * Constructor of the class
     */
    ColegioElectoral() {
        System.out.println("Colegio electoral abierto");
    }

    /**
     * Method where we get the name of the voter and add it to the queue ArrayList
     *
     * @param name
     */
    public void queueUp(String name) {
        getQueue().add(name);
        System.out.println(name + " se ha puesto en la cola || Posicion en cola: " + getQueue().indexOf(name));
    }

    /**
     * Method where we receive the thread and check if the dni is in the census to add or not to the queue
     *
     * @param name String to have the voter name
     * @param dni  Integer that has the value of the id
     * @param vot
     */
    public void checkDni(String name, int dni, Votante vot) {
        if (Arrays.asList(census).contains(dni)) {
            System.out.println(color.greenTxt() + name + " puede votar" + color.defaultTxt());
            vot.setCanVote(true);
            queueUp(name);
        } else {
            System.out.println(color.redTxt() + name + " no puede votar" + color.defaultTxt());
            vot.setCanVote(false);
        }
    }

    /**
     * Method where the thread starts voting during 1 or 2 seconds, only if is in the census
     *
     * @param name
     * @param vot
     */
    public synchronized void vote(String name, Votante vot) {
        while (!(name.equals(getQueue().get(0))) || rec.isCounting()) { //loop to wait() the thread if the thread is not the first in the queue
            System.out.println("Se ha intentado colar " + name);
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(color.blueTxt() + "***** Comienza a votar " + name + " *****" + color.defaultTxt());
        try {
            sleep((int) (Math.random() * 2000 + 1000)); //time that the voter take to vote
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        countVotes++;
        System.out.println(color.cyanTxt() + "***** Termina de votar " + name + " *****" + color.defaultTxt());
        getQueue().remove(0);
        notifyAll();
    }

    /**
     * Getter of the ArrayList of the queue
     *
     * @return ArrayList queue
     */
    public synchronized ArrayList<String> getQueue() {
        return queue;
    }

    /**
     * Getter of the votes count
     *
     * @return Integer countVotes
     */
    public int getCountVotes() {
        return countVotes;
    }

    /**
     * Getter of the array of teh census
     *
     * @return Integer[] censo
     */
    public static Integer[] getCensus() {
        return census;
    }
}
