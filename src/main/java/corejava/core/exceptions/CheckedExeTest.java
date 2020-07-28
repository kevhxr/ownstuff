package corejava.core.exceptions;

public class CheckedExeTest {

    public static void main(String[] args) {
        try{
            throwCheck();
        }catch (Exception e){
            System.out.println(e);
        }
        throwCheck();
    }

    public static void throwCheck(){
        //throw new InterruptedException("sd");
        throw new IllegalArgumentException("sd");
    }
}
