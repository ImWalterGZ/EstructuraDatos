import lista.LinkedList;
import lista.Nodo;

import java.sql.ClientInfoStatus;
import java.util.Iterator;
import java.util.Random;

// Compendio de estructuras de datos de la materia Estructuras de datos
 // Lets f go
public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();

//        list.add(1);
//        list.add(13);
//        list.add(33);
//        list.add(-3);

//        Random random = new Random();
//        for (int i = 0; i < 1000 ; i++){
//            list.add(random.nextInt(1,50));
//        }


        // Get Prev Element
//        Nodo<Integer> last = list.getPrevElement(33);
//        if (last != null) System.out.printf(" %d ", last.getValue());
//
//        for ( Iterator <Integer> iterator = list.iterator(); iterator.hasNext();){
//            System.out.printf(" %d \n", iterator.next() );
//        }


        // getElement
        list.add(4);
        list.add(-3);
        list.add(8);
        list.add(32);

        System.out.println(list.getElement(4));
        list.remove(4);
        System.out.println(list.getElement(4));


    }
}