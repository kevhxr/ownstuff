package corejava.concurrent.pureThread;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * shutdown和awaitTermination为接口ExecutorService定义的两个方法，一般情况配合使用来关闭线程池。
 * 方法简介
 * shutdown方法：平滑的关闭ExecutorService，当此方法被调用时，ExecutorService停止接收新的任务并且等待已经提交的任务（
 * 包含提交正在执行和提交未执行）执行完成。当所有提交任务执行完毕，线程池即被关闭。
 * <p>
 * awaitTermination方法：接收人timeout和TimeUnit两个参数，用于设定超时时间及单位。当等待超过设定时间时，
 * 会监测ExecutorService是否已经关闭，若关闭则返回true，否则返回false。一般情况下会和shutdown方法组合使用。
 */
public class LimitedConcurrent {

    final static int MAX_QPS = 2;

    final static Semaphore semaphore = new Semaphore(MAX_QPS);

    public static void main(String[] args) throws InterruptedException {
        //启动一个定时执行执行任务的线程池，线程池中线程的数量为1，启动一秒后开始执行，每隔0.5秒执行一次
        Executors.newScheduledThreadPool(1).scheduleAtFixedRate(() -> {
            System.out.println("execute.......");
            semaphore.release(MAX_QPS);//释放曾经被占用过的坑
        }, 5000, 200000, TimeUnit.MILLISECONDS);

        //创建一个有一百个线程的线程池
        ExecutorService pool = Executors.newFixedThreadPool(100);
        //提交一百个线程，去执行任务
        for (int i = 20; i > 0; i--) {
            final int x = i;
            pool.submit(() -> {
                ThreadLocal value = new ThreadLocal();
                value.set("aaa");
                semaphore.acquireUninterruptibly(1);//每个线程只获取一个坑
                remoteCall(x, 0);
                //semaphore.release(1);
                value.set(null);
                value.remove();
            });
        }
        pool.shutdown();
        pool.awaitTermination(5, TimeUnit.SECONDS);
        System.out.println("DONE");
    }

    private static void remoteCall(int i, int j) {
        System.out.println(new Date() + "   " +
                Thread.currentThread().getName() + " " + i + "  " + j);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
