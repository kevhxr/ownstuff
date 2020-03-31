package corejava.designmodel.cglib;

public class Testcglib {
    public static void main(String[] args) {

        PersonDao pp = new PersonDao();
        pp.deletePerson();

        System.exit(1);

        PersonDao target = new PersonDao();
        Ptransaction transaction = new Ptransaction();
        PersonInterceptor interceptor = new PersonInterceptor(target, transaction);

        PersonDao proxy = (PersonDao) interceptor.createProxy();

        proxy.savePerson();
        System.out.println("=============================");
        proxy.deletePerson();
        System.out.println("=============================");
        proxy.updatePerson();
        System.out.println("=============================");
        for(Person person : proxy.getPersons()){
            System.out.println(person.getName());
        }
    }
}
