package corejava.designmodel.facade;

public class FundFacade {

    Stock tencentStock;
    Stock teslaStock;

    public FundFacade() {
        tencentStock = new TencentStock();
        teslaStock = new TeslaStock();
    }

    public void workBuySell() {
        tencentStock.workBuySell();
        teslaStock.workBuySell();
    }

}
