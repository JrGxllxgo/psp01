package EjSupermercado;

public class Main {
    public static void main(String[] args) {
        Supermarket miSupermercado = new Supermarket();
        for (int i = 1; i <= 5; i++) {
            Thread Cliente = new Thread(new Cliente(miSupermercado, "Cliente " + i));
            Cliente.start();
        }
    }
}
