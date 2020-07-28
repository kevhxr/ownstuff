package corejava.concurrent.queuee.delayQueue;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class CacheItem implements Delayed {

    private long expireTime;
    private String key;

    public CacheItem(String key, long expireTime) {
        this.expireTime = expireTime;
        this.key = key;
    }

    public long getExpireTime() {
        return expireTime;
    }

    public String getKey() {
        return key;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return expireTime - TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
    }

    @Override
    public int compareTo(Delayed o) {
        if (this.getDelay(TimeUnit.MICROSECONDS) > o.getDelay(TimeUnit.MICROSECONDS)) {
            return 1;
        } else if (this.getDelay(TimeUnit.MICROSECONDS) < o.getDelay(TimeUnit.MICROSECONDS)) {
            return -1;
        }
        return 0;
    }
}
