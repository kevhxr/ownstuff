package corejava.concurrent.queuee.delayQueue;

import java.util.concurrent.TimeUnit;

public class DelayQueueTest {
    public static void main(String[] args) throws InterruptedException {
        MyCache myCache = new MyCache();
        new Thread(myCache).start();
        myCache.put("breakfast","egg",
                TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis()+1000));
        myCache.put("lunch","steak",
                TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis()+3000));
        myCache.put("dinner","pasta",
                TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis()+5000));
        System.out.println(myCache.get("breakfast"));
        System.out.println(myCache.get("lunch"));
        System.out.println(myCache.get("dinner"));
        Thread.sleep(2000);
        System.out.println(myCache.get("breakfast"));
        System.out.println(myCache.get("lunch"));
        System.out.println(myCache.get("dinner"));
        //myCache.shutDown();
    }
}
