package peval1psp2223;

public class Votante extends Thread{

    ColegioElectoral myCollege;
    private String name;
    private int dni;

    Votante(ColegioElectoral myCollege, String name, int i){
        this.myCollege = myCollege;
        this.name = name;
        this.dni = i;
        this.setName(this.name);
    }

    @Override
    public void run() {
        System.out.println(this.getName() + " ha entrado al colegio electoral.");
        myCollege.checkDni(name, this.dni);
    }
}
