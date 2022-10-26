package peval1psp2223;

import java.awt.*;

/**
 * @author Jose Ramon Gallego Velez
 * @version 1.0.
 * @info Class where every 10 seconds we print the count of votes
 */

public class Recuento extends Thread {
    /**
     * Use to use some methos of ColegioElectoral class
     */
    ColegioElectoral myCollege;

    /**
     * Class that set colors to the texts
     */
    ColorTools color = new ColorTools();

    /**
     * Boolean show is used to say if the loop should continue
     */
    private boolean show = true;

    /**
     * Boolean counting tp say if it continues or not
     */
    private boolean counting;

    private int lastVoteCount = 0;

    /**
     * Class constructor
     *
     * @param myCollege
     */
    Recuento(ColegioElectoral myCollege) {
        this.myCollege = myCollege;
    }

    /**
     * Run method of the thread
     */
    @Override
    public void run() {
        while (show) { //loop where we show votes and sleep the thread to show it every 10 seconds
            try {
                setCounting(true);
                sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(color.yellowTxt() + "Han habido " + (myCollege.getCountVotes() - lastVoteCount) + " votos" + color.defaultTxt());
            lastVoteCount = myCollege.getCountVotes();
            setCounting(false);

            if ((myCollege.getCountVotes() == myCollege.getCensus().length)) { //conditional to stop when the count votes is as the number of teh census
                System.out.println(color.purpleTxt() + "Han habido para el referendum " + myCollege.getCountVotes() + " votos" + color.defaultTxt());
                show = false;
            }
        }
    }

    /**
     * Method to get the value of counting
     *
     * @return counnting
     */
    public boolean isCounting() {
        return counting;
    }

    /**
     * Methos where we set the value of counting
     *
     * @param counting
     */
    public void setCounting(boolean counting) {
        this.counting = counting;
    }
}
