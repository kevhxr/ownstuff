package corejava.concurrent.pureThread;

public class MyThread  extends Thread{
    public MyThread(Runnable target) {
        super(target);
    }

    @Override
    public synchronized void start() {
        System.out.println("im start");
        super.start();
    }

    public void myJoin() throws InterruptedException {
        System.out.println("im join");
        super.join();
    }

}