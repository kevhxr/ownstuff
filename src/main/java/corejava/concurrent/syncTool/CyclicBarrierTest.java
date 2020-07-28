package corejava.concurrent.syncTool;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);

        for (int i = 0; i <3 ; i++) {
            new Thread(()->{
                try {
                    System.out.println(Thread.currentThread().getName()+" gen1 start");
                    cyclicBarrier.await();
                    System.out.println(Thread.currentThread().getName()+" gen1 end");
                    //System.out.println(Thread.currentThread().getName()+" gen2 start");
                    Random random = new Random();
                    Thread.sleep(1000*random.nextInt(5));
                    cyclicBarrier.await();
                    System.out.println(Thread.currentThread().getName()+" gen2 end");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
