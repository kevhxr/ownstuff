package corejava.designmodel.proxy.performance;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxyMaker implements MethodInterceptor {

    public CglibProxyMaker() {
    }

    public static <T extends WaiterService> WaiterService newProxyInstance(Class<T> targetInstanceClazz) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(targetInstanceClazz);
        enhancer.setCallback(new CglibProxyMaker());
        return (WaiterService) enhancer.create();
    }

    @Override
    public Object intercept(Object obj,
                            Method method,
                            Object[] args,
                            MethodProxy methodProxy) throws Throwable {
        return methodProxy.invokeSuper(obj, args);
    }
}
