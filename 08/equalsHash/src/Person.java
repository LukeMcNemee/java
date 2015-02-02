
import java.util.Objects;

/**
 *
 * @author LukeMcNemee
 */
public class Person implements Comparable<Person> {

    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) throws IllegalAccessException {
        if (age <= 0) {
            throw new IllegalArgumentException("negative age");
        } else {
            this.age = age;
        }

        //this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" + "name=" + name + ", age=" + age + "}\n";
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.name);
        hash = 13 * hash + this.age;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Person other = (Person) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (this.age != other.age) {
            return false;
        }
        return true;
    }

    
    @Override
    public int compareTo(Person p) {
        if (p == null) {
            throw new NullPointerException();
        } 
        
        if (p.getAge() > age) {
            return -1;
        } else if (p.getAge() < age) {
            return 1;
        } else {
            return 0;
            //return p.getName().compareTo(name);
        }    
    }

}
