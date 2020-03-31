package corejava.designmodel.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

public class VehicleProxy implements InvocationHandler {

    private Vehicle vehicle;

    public VehicleProxy(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("--------------before--------------");
        if(method.getName().equals("owner")){
            System.out.println(args.length);
            Arrays.stream(args).forEach(a->{
                if(a instanceof User){
                    System.out.println("[]:"+((User)a).getAge());
                }else{
                    System.out.println(a);
                }
            });
        }
        Object invoke = method.invoke(vehicle, args);
        System.out.println("--------------after--------------");
        return invoke;
    }
}
