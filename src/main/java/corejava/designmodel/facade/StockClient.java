package corejava.designmodel.facade;

public class StockClient {
    public static void main(String[] args) {
        FundFacade fundFacade = new FundFacade();
        fundFacade.workBuySell();
    }
}
