package corejava.core;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.LockSupport;

public class MyAQSMain {
    static int count = 0;
    static MyAQSLock myAQSLock = new MyAQSLock();
    static Thread t;

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(2);
        List<Future> submits = new ArrayList<>();
        for (int i = 0; i <1; i++) {
            submits.add(service.submit(()->{
                try {
                    t = Thread.currentThread();
                    myAQSLock.lock();
                    for (int j = 0; j < 10000; j++) {
                        count++;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    myAQSLock.unlock();
                }
            }));
        }
        submits.stream().forEach(future -> {
            try {
                future.get();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        service.shutdown();
        System.out.println(count);
    }
}
