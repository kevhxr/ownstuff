package corejava.concurrent.syncTool;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(3);

        for (int i = 0; i <5 ; i++) {
            new Thread(()->{
                Random random = new Random();
                try {
                    Thread.sleep(1000*random.nextInt(3));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                latch.countDown();
                System.out.println(Thread.currentThread().getName()+" count down done");
            }).start();
        }
        System.out.println("reach the gate");
        latch.await();
        System.out.println("through the gate");
    }
}
