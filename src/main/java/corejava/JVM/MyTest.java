package corejava.JVM;

import org.junit.Test;

public class MyTest {
    @Test
    public void test44(){

        try {
            Class.forName("corejava.JVM.InitTest");
            System.out.println("#########分割符(上面是Class.forName的加载过程，下面是ClassLoader的加载过程)##########");
            ClassLoader.getSystemClassLoader().loadClass("corejava.JVM.InitTest");


            Class<?> x = Class.forName("[I");
            System.out.println(x);

            x = ClassLoader.getSystemClassLoader().loadClass("[I");
            System.out.println(x);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}