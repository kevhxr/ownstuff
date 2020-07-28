package corejava.designmodel.proxy;

public class Car implements Vehicle, Product {
    @Override
    public void run() {
        System.out.println("Car run");
    }

    @Override
    public void getPrice(int price) {
        System.out.println("price of car:" + price);
    }

    @Override
    public void owner(User user) {
        System.out.println(user.getName()+"  "+user.getAge());
    }

    protected void engineStart(){
        System.out.println("start engine");
    }
}
