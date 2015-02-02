
import com.sun.xml.internal.ws.client.ContentNegotiation;
import java.util.ArrayList;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author LukeMcNemee
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        List<Person> personsList = new ArrayList<>();

        Person[] personsArray = new Person[10];

        for (int i = 0; i < 10; i++) {
            //personsArray[i] = new Person("HUGO " + i, (int) (Math.random() * 100));

            personsList.add(new Person("HUGO " + i, (int) (Math.random() * 100)));
        }


        
        bogoSort(personsList);        
        System.out.println(personsList.toString());
    }

    public void bubbleSort(List<Person> persons) {

        for (int i = 0; i < persons.size(); i++) {
            boolean change = false;
            for (int j = 0; j < persons.size() - 1; j++) {
                Person A = persons.get(j);
                Person B = persons.get(j + 1);
                if (A.compareTo(B) > 0) {
                    persons.set(j, B);
                    persons.set(j + 1, A);
                    change = true;
                }
            }
            if (change == false) {
                return;
            }
        }
    }

    public static void bogoSort(List<Person> persons) {
        boolean sorted = true;
        Long count = new Long(0);
        do {
            count++;
            sorted = true;
            Collections.shuffle(persons);
            for (int i = 0; i < persons.size() - 1; i++) {
                if (persons.get(i).compareTo(persons.get(i + 1)) > 0) {
                    sorted = false;
                }
            }
        } while (!sorted);
        System.out.println(count);
    }
}
