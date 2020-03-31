package corejava.concurrent.forjoin;

import java.util.Stack;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.TimeUnit;

public class ForkTest {

    public static void main(String[] args) throws InterruptedException {
        Stack<Integer> stack = new Stack();
        stack.push(1);
        RecursiveAction task = new MyRecurAction(0,100);
        ForkJoinPool pool = new ForkJoinPool();
        pool.submit(task);
        pool.awaitTermination(2, TimeUnit.SECONDS);
        pool.shutdown();
    }

}


