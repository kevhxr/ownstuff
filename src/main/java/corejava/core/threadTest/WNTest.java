package corejava.core.threadTest;

import org.junit.Test;

public class WNTest {

    public Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {

        WNTest wnTest = new WNTest();

        Thread t1 = new Thread(() -> wnTest.producer());
        Thread t2 = new Thread(() -> wnTest.consumer());
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("done");
    }

    public void producer() {
        synchronized (lock) {
            try {
                System.out.println("produce enter");
                lock.wait();
                System.out.println("produce start");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void consumer() {
        synchronized (lock) {
            try {
                System.out.println("start notify");
                lock.notifyAll();
                System.out.println("finish notify");
                System.out.println("=================");
                Thread.sleep(5000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void ddd(){
        System.out.println("sssddd".substring(0,3));
    }
}
