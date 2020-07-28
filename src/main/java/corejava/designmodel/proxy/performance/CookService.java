package corejava.designmodel.proxy.performance;

public class CookService implements Target {
    @Override
    public int work(int i) {
        return i + 1;
    }
}
