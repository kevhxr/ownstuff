package corejava.JVM.loadorder;

public class LoTest {
    public static void main(String[] args) {
        //System.out.println(Tiger.tiger2);
        System.out.println("=============");
        WhieTiger tiger = new WhieTiger();
        tiger.shout();
        //tiger.shout();
    }
}
