package corejava.designmodel.proxy.performance;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkProxyMaker implements InvocationHandler {

    Target target;

    public JdkProxyMaker(Target target) {
        this.target = target;
    }

    public static Target newProxyInstance(Target target) {
        return (Target) Proxy.newProxyInstance(JdkProxyMaker.class.getClassLoader(),
                new Class<?>[]{Target.class},
                new JdkProxyMaker(target));
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(target, args);
    }
}
