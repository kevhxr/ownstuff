package corejava.core;

import java.util.concurrent.locks.LockSupport;

public class ParkTest {

    static MyThread t = new MyThread();

    public static void main(String[] args) throws InterruptedException {
        t.start();
        Thread.sleep(3000);
        LockSupport.unpark(t);
        t.join();

    }

    private static class MyThread extends Thread{

        @Override
        public void run() {
            LockSupport.park();
            System.out.println("sdadsa");
        }
    }
}
