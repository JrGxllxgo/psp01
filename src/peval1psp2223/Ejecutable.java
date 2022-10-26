package peval1psp2223;

public class Ejecutable {
    public static void main(String[] args) {

        ColegioElectoral myCollege =  new ColegioElectoral();
        Recuento rec =  new Recuento(myCollege);

        for (int i = 1; i <= 30; i++) {
            Thread Votante = new Thread(new Votante(myCollege, "Ciudadano "+ i, i));
            Votante.start();
        }

        rec.start();
    }
}
