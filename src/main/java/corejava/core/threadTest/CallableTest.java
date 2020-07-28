package corejava.core.threadTest;

import java.util.concurrent.Callable;
import java.util.concurrent.ThreadLocalRandom;

public class CallableTest {
    public static void main(String[] args) throws Exception {

        System.out.println("im start");
        Integer result;
        Callable<Integer> c = new MultiRecon();
        boolean ran;
        try {
            result = c.call();
            ran = true;
        } catch (Throwable ex) {
            result = -20000;
            ran = false;
        }
        if (ran)
            System.out.println("im done: " + result);


    }

    private static class MultiRecon implements Callable<Integer> {
        @Override
        public Integer call() throws Exception {
            Thread.sleep(100);
            System.out.println("start recon");
            ThreadLocalRandom random = ThreadLocalRandom.current();
            System.out.println("finish recon");
            int a = random.nextInt(0, 5);
            if(a>3) {
                a = 1 / 0;
            }
            return a;
        }
    }
}
