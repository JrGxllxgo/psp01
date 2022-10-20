package EjCarrera;

/*
    Bucle con el random de la zancada con el tiempo y retardo
 */
public class RunnerThread extends Thread{
    Pista pista;
    private static int distance = 7;

    private int startSeconds = (int) System.currentTimeMillis()/1000;
    RunnerThread(Pista pista){
        this.pista = pista;
    }

    @Override
    public void run() {
        System.out.println("Corredor " + this.getName() + " listo para correr");
        pista.startRunning();
        for (int i = 1; i < distance; i++) {
            int tiempoZancada = (int) Math.floor(Math.random() * (30) + 90);
            System.out.println("Corredor " + this.getName() + " || " + i + "m || " + "Tiempo de zancada: " + tiempoZancada +"ms");
            System.out.println("-----------------------------------------------------------------------------------------------");
        }
        int timempoDeFinal = (int) System.currentTimeMillis()/1000;
        int tiempoTotal = startSeconds - timempoDeFinal;
        pista.podium.add(this.getName());
        System.out.println("++++++++++ Corredor " + this.getName() + " HA FINALIZADO LA CARRERA ++++++++++" + tiempoTotal);
        pista.printPodium();
    }
}
