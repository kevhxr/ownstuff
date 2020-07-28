package corejava.JVM.loadorder;

public class Tiger extends Animal {

    static String tiger = "tigers";
    static String tiger2;

    static {
        System.out.println("tiger static block");
    }

    {
        System.out.println("tiger nonstatic block");
    }

    public Tiger() {
        System.out.println("tiger constructor");
    }

    public void shout(){
        System.out.println("tiger shout");
    }
}
