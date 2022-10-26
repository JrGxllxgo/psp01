package peval1psp2223;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ColegioElectoral {

    private static ArrayList<String> queue = new ArrayList<>();
    private static boolean canVote = false;
    private static Integer censo[] = {1, 2, 3, 4, 6, 8, 10, 11, 13, 14, 15, 18, 19, 20, 22, 23, 24, 28, 29, 30};

    ColegioElectoral() {
        System.out.println("Colegio electoral abierto");
    }

    public static void queueUp(String name){
        System.out.println(name + " se ha puesto en la cola");
        queue.add(name);
    }

    public static void checkDni(String name, int dni){
        if(Arrays.asList(censo).contains(dni)){
            System.out.println(name + " puede votar");
            canVote = true;
        }else{
            System.out.println(name + " no puede votar");
            canVote = false;
        }
    }
}
