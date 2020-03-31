package corejava.concurrent.forjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.ForkJoinWorkerThread;
import java.util.concurrent.RecursiveAction;

public class MyRecurAction extends RecursiveAction {
    private static final int THRESHOLD = 50; //最多只能打印50个数
    private int start;
    private int end;

    public MyRecurAction(int start, int end) {
        super();
        this.start = start;
        this.end = end;
    }

    @Override
    protected void compute() {
        if (end - start < THRESHOLD) {
            for (int i = start; i < end; i++) {
                System.out.println(Thread.currentThread().getName() + "的i值：" + i);
            }
        } else {
            int middle = (start + end) / 2;
            MyRecurAction left = new MyRecurAction(start, middle);
            MyRecurAction right = new MyRecurAction(middle, end);
            //并行执行两个“小任务”
            System.out.println(
                    Thread.currentThread().getClass().getName()
            );/*
            left.fork();
            right.fork();*/
            invokeAll(left,right);
        }
    }
/*
    public final ForkJoinTask<V> fork() {
        Thread t;
        if ((t = Thread.currentThread()) instanceof ForkJoinWorkerThread) {
            ((ForkJoinWorkerThread) t).workQueue.push(this);
        } else {
            ForkJoinPool.common.externalPush(this);
        }
        return this;
    }*/
}