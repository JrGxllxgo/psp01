package EjSupermercado;

public class Cliente extends Thread{

    Supermarket mySupermarket;
    private String name;
    Cliente(Supermarket miSupermercado, String nombre){
        this.mySupermarket = miSupermercado;
        this.name = nombre;
    }

    @Override
    public void run() {
        System.out.println(name + " ha entrado a hacer la compra");
        mySupermarket.buy(name);
        mySupermarket.ponerEnCola(name);
        mySupermarket.printCola();
        try {
            mySupermarket.Pagar(name);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
