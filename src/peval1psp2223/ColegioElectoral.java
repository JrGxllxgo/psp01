package peval1psp2223;

import java.util.ArrayList;
import java.util.Arrays;

import static java.lang.Thread.sleep;

public class ColegioElectoral {

    Recuento rec = new Recuento(this);
    private static ArrayList<String> queue = new ArrayList<>();
    private static Integer censo[] = {1, 2, 3, 4, 6, 8, 10, 11, 13, 14, 15, 18, 19, 20, 22, 23, 24, 28, 29, 30};

    private int countVotes = 0;

    ColegioElectoral() {
        System.out.println("Colegio electoral abierto");
    }

    public void queueUp(String name){
        getQueue().add(name);
        System.out.println(name + " se ha puesto en la cola || Posicion en cola: " + getQueue().indexOf(name));
    }

    public void checkDni(String name, int dni, Votante vot){
        if(Arrays.asList(censo).contains(dni)){
            System.out.println(name + " puede votar");
            vot.setCanVote(true);
            queueUp(name);
        }else{
            System.out.println(name + " no puede votar");
            vot.setCanVote(false);
        }
    }

    public synchronized void vote(String name,Votante vot){
        while (!(name.equals(getQueue().get(0))) || !(rec.isCounting())){
            System.out.println("Se ha intentado colar " + name);
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("***** Comienza a votar " + name + " *****");
        try {
            sleep((int) (Math.random() * 2000 + 1000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        countVotes ++;
        System.out.println("***** Termina de votar " + name + " *****");
        getQueue().remove(0);
        notifyAll();
    }

    public synchronized ArrayList<String> getQueue() {
        return queue;
    }

    public int getCountVotes() {
        return countVotes;
    }

    public static Integer[] getCenso() {
        return censo;
    }
}
