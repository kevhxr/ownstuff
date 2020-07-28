package corejava.core.threadTest;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureTaskTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> myTask = new FutureTask<>(() -> {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 11;
        });
        myTask.run();
        System.out.println(myTask.get());
        System.out.println(myTask.get());
    }
}
