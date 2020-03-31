package corejava.concurrent.pureThread;

import java.util.concurrent.Executors;

public class JoinTest {
    public static void main(String[] args) {
        System.out.println("主线程开始执行");
        try {
            Thread t1 = new Thread(()->{

                for(int i=0;i<50;i++){
                    System.out.println("我是child");
                }
            });
            t1.start();
            t1.join(1000);
            for(int i=0;i<50;i++){
                System.out.println("我是main");
                Thread.sleep(100000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("主线程执行完毕");
    }
}
