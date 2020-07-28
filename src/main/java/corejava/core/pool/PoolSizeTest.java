package corejava.core.pool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class PoolSizeTest {

    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 8,
                0L, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<>(3));
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardPolicy());

        System.out.println(executor.getQueue().size());
        //创建15个线程
        for (int i = 0; i < 8; i++) {
            final int a = i;
            Thread.sleep(10);
            executor.submit(() -> {
                try {
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName()
                            + " --- " + a + "   --- " + executor.getQueue().size());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        executor.shutdown();
    }
}
