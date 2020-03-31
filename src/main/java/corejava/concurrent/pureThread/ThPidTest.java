package corejava.concurrent.pureThread;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ThPidTest {

    public static void main(String[] args) {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(2);
        for (int i = 0; i < 6; i++) {

            service.scheduleAtFixedRate(() -> {
                Thread.currentThread().setName(Thread.currentThread().getName() + "-hxr");
                try {
                    for (int j = 0; j < 10; j++) {
                        Thread.sleep(5000000);
                        System.out.println("hi " + j + " " + Thread.currentThread().getName());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            },1000,2000, TimeUnit.MILLISECONDS);
        }
        //service.shutdown();
    }
}
