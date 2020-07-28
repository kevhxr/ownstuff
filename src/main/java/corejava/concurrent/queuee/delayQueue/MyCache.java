package corejava.concurrent.queuee.delayQueue;

import java.util.HashMap;
import java.util.concurrent.DelayQueue;

public class MyCache implements Runnable {

    private HashMap<String, String> map = new HashMap<>();
    private boolean stop = false;
    private DelayQueue<CacheItem> queue = new DelayQueue<CacheItem>();


    public void put(String key, String value, long expireTime) {
        CacheItem cacheItem = new CacheItem(key, expireTime);
        queue.put(cacheItem);
        map.put(key, value);
    }

    public String get(String key) {
        return map.get(key);
    }

    public void shutDown() {
        stop = true;
    }

    @Override
    public void run() {
        while (!stop) {
            CacheItem cacheItem = queue.poll();
            if (cacheItem != null) {
                map.remove(cacheItem.getKey());
                System.out.println(cacheItem.getKey() + " been removed after "
                        + cacheItem.getExpireTime());
            }
        }
    }
}
