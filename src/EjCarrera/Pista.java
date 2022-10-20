package EjCarrera;

import java.util.ArrayList;

public class Pista {

    private static boolean start = false;

    public ArrayList<String> podium = new ArrayList<String>();

    Pista (){
        System.out.println("Pista preparada para la carrera");
    }

    public void printPodium(){
        for (int i = 0; i < podium.size(); i++) {
            System.out.println("Puesto " + (i+1) + " --> dorsal " + this.podium.get(i));
        }
    }

    public synchronized void startRunning(){
        while(!start){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public synchronized void startRace(){
        start = true;
        notifyAll();
    }
}
