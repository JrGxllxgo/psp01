package peval1psp2223;

public class Votante extends Thread{

    ColegioElectoral myCollege;
    private String name;
    private int dni;

    private boolean canVote = false;

    Votante(ColegioElectoral myCollege, String name, int i){
        this.myCollege = myCollege;
        this.name = name;
        this.dni = i;
        this.setName(this.name);
    }

    @Override
    public void run() {
        System.out.println(this.getName() + " ha entrado al colegio electoral.");
        myCollege.checkDni(name, this.dni, this);
        if(canVote){
            myCollege.vote(name, this);
        }

        System.out.println(this.getName() + " ha salido del colegio electoral.");
    }

    public boolean getCanVote() {
        return canVote;
    }

    public void setCanVote(boolean canVote) {
        this.canVote = canVote;
    }
}
