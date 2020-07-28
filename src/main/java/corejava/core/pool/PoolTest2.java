package corejava.core.pool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class PoolTest2 {

    public static void main(String[] args) {
        //使用只能5个有限队列，corePoolSize=15, maxPoolSize=15
        ThreadPoolExecutor executor = new ThreadPoolExecutor(15, 18,
                0L, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<>(5));

        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardPolicy());


        //创建15个线程
        for (int i = 0; i < 20; i++) {
            executor.execute(new MyThread(i,executor));
        }

        executor.shutdown();
    }

    public static class MyThread implements Runnable {

        private int flag;
        private boolean inQueue;
        private ThreadPoolExecutor executor;

        public MyThread(int flag, ThreadPoolExecutor executor) {
            this.flag = flag;
            this.executor = executor;
        }

        @Override
        public void run() {
            int a = executor.getQueue().size();
            if(0<a){
                System.out.println(executor.getQueue().size());
                MyThread poll = (MyThread) executor.getQueue().poll();
                System.out.println(a+"-"+this.getFlag()+"-"+poll.getFlag());

            }
            System.out.println("线程编号：" + getFlag() + "   是否被加入队列：" + inQueue);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public boolean isInQueue() {
            return inQueue;
        }

        public void setInQueue(boolean inQueue) {
            this.inQueue = inQueue;
        }

        public int getFlag() {
            return flag;
        }
    }
}
