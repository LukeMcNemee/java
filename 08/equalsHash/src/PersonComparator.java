
import java.util.Comparator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author LukeMcNemee
 */
public class PersonComparator implements Comparator {

    @Override
    public int compare(Object t, Object t1) {
        if (t == null || t1 == null) {
            throw new NullPointerException();
        } else if (t.getClass() != t.getClass() || t.getClass() != Person.class) {
            throw new ClassCastException();
        }
        Person p1 = (Person) t;
        Person p2 = (Person) t1;
        if( p1.getName().compareTo(p2.getName()) != 0){
            return p1.getName().compareTo(p2.getName());
        } else if (p1.getAge() > p2.getAge()) {
            return -1;
        } else if (p1.getAge() < p2.getAge()) {
            return 1;
        } else {
            return p1.getName().compareTo(p2.getName());
        }
    }
}



