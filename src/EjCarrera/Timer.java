package EjCarrera;

public class Timer extends Thread{

    Pista pista;

    Timer(Pista pista){
        this.pista = pista;
    }

    public void run(){
        try{
            System.out.println("Preparados");
            sleep(1000);
            System.out.println("Listos");
            sleep(1000);
            System.out.println("YA!");
            pista.startRace();
        }catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
