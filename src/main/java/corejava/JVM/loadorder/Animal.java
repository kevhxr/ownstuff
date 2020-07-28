package corejava.JVM.loadorder;

public class Animal {

    static String animal = "animals";

    static {
        System.out.println("animal static block");
    }

    {
        System.out.println("animal nonstatic block");
    }
    public void shout(){
        System.out.println("Animal shout");
    }

    public Animal() {
        System.out.println("animal constructor");
    }
}
