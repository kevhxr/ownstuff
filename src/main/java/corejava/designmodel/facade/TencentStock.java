package corejava.designmodel.facade;

public class TencentStock implements Stock {
    @Override
    public void workBuySell() {
        System.out.println("tenct buy cell stock");
    }
}
