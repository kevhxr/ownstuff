package corejava.designmodel.cglib;

import java.util.ArrayList;
import java.util.List;

public class PersonDao extends AbstractDao {
    public void savePerson() {
        System.out.println("savePerson");
    }


    protected void deletePerson() {
        System.out.println("deletePerson");
    }


    public void updatePerson() {
        System.out.println("updatePerson");

    }

    public List<Person> getPersons() {
        List<Person> persons = new ArrayList<>();
        Person person1 = new Person(1, "person1");
        Person person2 = new Person(2, "person2");
        persons.add(person1);
        persons.add(person2);
        return persons;
    }
}
