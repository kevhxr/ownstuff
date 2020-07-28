package corejava.concurrent.pureThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DeadLockTest {

    private static String user1 = "kevin";
    private static String user2 = "tom";

    /**
     * -Djava.rmi.server.hostname=127.0.0.1
     * -Dcom.sun.management.jmxremote
     * -Dcom.sun.management.jmxremote.port=9990
     * -Dcom.sun.management.jmxremote.ssl=false
     * -Dcom.sun.management.jmxremote.authenticate=false
     *
     * @param args
     */

    public static void main(String[] args) {

        ExecutorService service = Executors.newFixedThreadPool(2);
        service.submit(() -> transferMoney(user1, user2, 100));
        service.submit(() -> transferMoney(user2, user1, 100));
        service.shutdown();

    }

    /**
     * 当一个线程需要获取 Object 的锁时，会被放入 EntrySet 中进行等待，
     * 如果该线程获取到了锁，成为当前锁的 owner。如果根据程序逻辑，
     * 一个已经获得了锁的线程缺少某些外部条件，而无法继续进行下去（例如生产者发现队列已满或者消费者发现队列为空），
     * 那么该线程可以通过调用 wait 方法将锁释放，进入 wait set 中阻塞进行等待，
     * 其它线程在这个时候有机会获得锁，去干其它的事情，从而使得之前不成立的外部条件成立，
     * 这样先前被阻塞的线程就可以重新进入 EntrySet 去竞争锁。
     * 这个**外部条件**在 monitor 机制中称为**条件变量**。
     * <p>
     * Java 对象存储在内存中，分别分为三个部分，即对象头、实例数据和对齐填充，而在其对象头中，保存了锁标识
     * 任何一个JAVA对象都可以作为Monitor机制的monitor object
     * <p>
     * 每个对象都存在着一个 monitor 与之关联，对象与其 monitor 之间的关系存在多种实现方式，
     * 如monitor可以与对象一起创建销毁或当线程试图获取对象锁时自动生成，
     * 但当一个 monitor 被某个线程持有后，它便处于锁定状态。
     */

    public static void transferMoney(String from, String to, int amount) {
        synchronized (from) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (to) {
                System.out.println(from + " send " + to + ": " + amount);
            }
        }
    }
}
