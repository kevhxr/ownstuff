package corejava.concurrent.pureThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DeadLockTest {

    private static String user1 = "kevin";
    private static String user2 = "tom";

    /**
     *
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
