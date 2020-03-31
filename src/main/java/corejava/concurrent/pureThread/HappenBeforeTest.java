package corejava.concurrent.pureThread;


/**
 * 可以证明只有当start()启动后 才能执行join（）
 * 也就是说 当join（）在前面的话就失去了意义
 */
public class HappenBeforeTest {
    public static void main(String[] args) throws Exception {
        MyThread a = new MyThread(()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("thread finish");
        });
        a.start();
        a.myJoin();
        System.out.println("main finish ");
    }

}

