import lista.LinkedList;

import java.sql.ClientInfoStatus;
import java.util.Iterator;
import java.util.Random;

// Compendio de estructuras de datos de la materia Estructuras de datos
 // Lets f go
public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();


        Random random = new Random();
        for (int i = 0; i < 1000 ; i++){
            list.add(random.nextInt(1,50));
        }


        System.out.println(list.getPrevElement(5).getValue());

    }
}