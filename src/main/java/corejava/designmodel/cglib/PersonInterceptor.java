package corejava.designmodel.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class PersonInterceptor implements MethodInterceptor {

    private Object target;
    private Ptransaction ptransaction;

    public PersonInterceptor(Object target, Ptransaction ptransaction) {
        this.target = target;
        this.ptransaction = ptransaction;
    }

    public Object createProxy() {
        Enhancer enhancer = new Enhancer();
        enhancer.setCallback(this);//回调函数  拦截器
        enhancer.setSuperclass(this.target.getClass());//设置代理对象的父类
        Object proxyObj = enhancer.create();
        if(proxyObj instanceof PersonDao){
            System.out.println(proxyObj.getClass().getName());
        }
        return proxyObj;
    }


    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        if (method.getName().equals("updatePerson")
                || method.getName().equals("savePerson")
                || method.getName().equals("deletePerson")) {
            ptransaction.beginTrans();
            method.invoke(target, objects);
            ptransaction.commit();
            return null;
        } else {
            return method.invoke(target, objects);
        }
    }
}
