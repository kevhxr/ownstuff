package corejava.concurrent.queuee;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TimeUnit;


/**
 *
 * tryTransfer will wait given timeout,
 * if still no consumer will not put & return
 *
 * Node {isData;   false if this is a request node}
 *
 * node里标记了等待线程awaitMatch用park等待
 *
 *
 * a）NOW，立即返回，没有匹配到立即返回，不做入队操作
 *
 *     对应的方法有：poll()、tryTransfer(e)
 *
 * b）ASYNC，异步，元素入队但当前线程不会阻塞（相当于无界LinkedBlockingQueue的元素入队）
 *
 *     对应的方法有：add(e)、offer(e)、put(e)、offer(e, timeout, unit)
 *
 * c）SYNC，同步，元素入队后当前线程阻塞，等待被匹配到
 *
 *     对应的方法有：take()、transfer(e)
 *
 * d）TIMED，有超时，元素入队后等待一段时间被匹配，时间到了还没匹配到就返回元素本身
 *
 *     对应的方法有：poll(timeout, unit)、tryTransfer(e, timeout, unit)
 *
 *
 *
 *
 *
 * LinkedTransferQueue的实现方式是使用一种叫做双重队列的数据结构；
 *
 * 不管是取元素还是放元素都会入队；
 *
 */
public class LinkedTransferQueueTest {


    public static void main(String[] args) throws InterruptedException {

        LinkedTransferQueue<String> queue = new LinkedTransferQueue();
        new Thread(()->{
            try {
                /**
                 * xfer haveData = true
                 */
                //queue.tryTransfer("wc",1, TimeUnit.SECONDS);
                queue.tryTransfer("wc");//return immediately if no consumer & not put
                System.out.println("done put");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(()->{
            try {
                Thread.sleep(3000);
                /**
                 * xfer haveData = false
                 */
                String take = queue.take();
                System.out.println(take);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
