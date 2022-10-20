package EjCarrera;

/*
    Clase ejecutable para hacer una carrera
 */
public class Main {
    public static void main(String[] args) {
        Pista pista = new Pista();
        Timer timer = new Timer(pista);

        RunnerThread runner1 = new RunnerThread(pista);
        runner1.setName("1");
        RunnerThread runner2 = new RunnerThread(pista);
        runner2.setName("2");
        RunnerThread runner3 = new RunnerThread(pista);
        runner3.setName("3");
        RunnerThread runner4 = new RunnerThread(pista);
        runner4.setName("4");
        RunnerThread runner5 = new RunnerThread(pista);
        runner5.setName("5");
        RunnerThread runner6 = new RunnerThread(pista);
        runner6.setName("6");
        RunnerThread runner7 = new RunnerThread(pista);
        runner7.setName("7");
        RunnerThread runner8 = new RunnerThread(pista);
        runner8.setName("8");

        timer.start();
        runner1.start();
        runner2.start();
        runner3.start();
        runner4.start();
        runner5.start();
        runner6.start();
        runner7.start();
        runner8.start();
    }
}
