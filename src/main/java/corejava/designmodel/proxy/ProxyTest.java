package corejava.designmodel.proxy;

import java.lang.reflect.Proxy;
import java.util.Arrays;


/**
 *
 * 在运行时创建一个实现某些给定接口的新类（也称“动态代理类”）及其实例（对象）,
 * 代理的是接口(Interfaces)，不是类(Class)，也不是抽象类。在运行时才知道具体的实现
 *
 *
 */
public class ProxyTest {

    public static void main(String[] args) {
        Class<?>[] interfaces = Car.class.getInterfaces();
        Arrays.stream(interfaces).forEach(a-> System.out.println(a.getName()));
        System.out.println("=====================");
        Class[] classes = new Class[]{Vehicle.class};
        Arrays.stream(classes).forEach(a-> System.out.println(a.getName()));

        System.out.println("=====================");
        System.out.println();
        Vehicle car = new Car();
        Product product = (Product) Proxy.newProxyInstance(car.getClass().getClassLoader(),
                new Class[]{Vehicle.class, Product.class}, new VehicleProxy(car));
       //product.getPrice(100);
        product.owner(new User("kevin",20));
    }
}
