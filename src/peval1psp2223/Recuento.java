package peval1psp2223;

public class Recuento extends Thread{

    ColegioElectoral myCollege;

    private boolean show = true;
    private boolean counting = true;
    Recuento(ColegioElectoral myCollege){
        this.myCollege = myCollege;
    }

    @Override
    public void run() {
        while(show){
            try {
                setCounting(true);
                sleep(10000);
                setCounting(false);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Van " + myCollege.getCountVotes() + " votos");

            if ( (myCollege.getCountVotes() == myCollege.getCenso().length)){
                show = false;
            }
        }
    }

    public boolean isCounting() {
        return counting;
    }

    public void setCounting(boolean counting) {
        this.counting = counting;
    }
}
