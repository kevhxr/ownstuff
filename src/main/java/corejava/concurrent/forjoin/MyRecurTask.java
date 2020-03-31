package corejava.concurrent.forjoin;

import java.util.concurrent.RecursiveTask;

public class MyRecurTask extends RecursiveTask {
    @Override
    protected Object compute() {
        return 1;
    }
}
