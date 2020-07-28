package corejava.JVM.GCTe;


import corejava.core.Student;

public class ReferenceCountingGC {
    public Object instance = null;

    private static final int _1MB = 1024 * 1024;

    private byte[] bigSize = new byte[2 * _1MB];

    public static void main(String[] args) {
        ReferenceCountingGC objA = new ReferenceCountingGC();
        ReferenceCountingGC objB = new ReferenceCountingGC();
        objA.instance = objB;
        objB.instance = objA;

        for (int i = 0; i <10000 ; i++) {
            Object aa = new Object();
        }

        //System.gc();
        test();
        test();
        System.out.println("==============================");
        System.gc();
        System.out.println("==============================");
    }

    public static void test(){

        for (int i = 0; i <10 ; i++) {
            for (int j = 0; j <1000000000 ; j++) {
                Student aa = new Student(1111, "kevinnininiasdandsi");
            }
        }

    }
}
