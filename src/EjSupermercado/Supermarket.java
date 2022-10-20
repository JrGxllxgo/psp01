package EjSupermercado;

import java.util.ArrayList;

import static java.lang.Thread.sleep;

public class Supermarket {

    private static boolean canPay = false;

    private ArrayList <String> cola =  new ArrayList<>();

    Supermarket(){
        System.out.println("Caja abierta");
    }

    public void buy(String name){
        System.out.println("Empieza a comprar");
        int tiempoCompra = (int) Math.floor(Math.random() * (5000 - 1000) + 1000);
        try {
            sleep(tiempoCompra);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(name + " ha comprado en " + tiempoCompra + "ms");
    }

    public void ponerEnCola(String name){
        System.out.println(name + " se ha puesto en la cola");
        cola.add(name);
    }

    public synchronized void Pagar(String nombre) throws InterruptedException {
        for (int i = 0; i < cola.size(); i++) {
            System.out.println("***** Comienza a pagar " + cola.get(i) + " *****");
            sleep(tiempoCobro());
            System.out.println("***** Termina de pagar " + cola.get(i) + " *****");
            cola.remove(i);
        }
    }

    public void printCola(){
        System.out.println("---------- COLA ----------");
        for (int i = 0; i < cola.size(); i++) {
            System.out.println(cola.get(i));
        }
        System.out.println("---------------------------------------");
    }

    private int tiempoCobro(){
        return (int) (Math.random() * 3000 + 1000);
    }
}
