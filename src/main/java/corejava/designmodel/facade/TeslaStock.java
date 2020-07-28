package corejava.designmodel.facade;

public class TeslaStock implements Stock {
    @Override
    public void workBuySell() {
        System.out.println("tesla buy cell stock");
    }
}
