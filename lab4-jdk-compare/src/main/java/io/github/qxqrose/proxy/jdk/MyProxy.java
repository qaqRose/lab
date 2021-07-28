package io.github.qxqrose.proxy.jdk;

import io.github.qxqrose.proxy.Hello;
import io.github.qxqrose.proxy.HelloImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author: qiu
 * 2021/7/28
 */
public class MyProxy implements InvocationHandler {

    /**
     * 代理的对象
     */
    private Object target;

    public MyProxy(Object target) {
        this.target = target;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("动态代理：调用方法");
        Object res = method.invoke(target);
        return res;
    }

    public static void main(String[] args) {
        HelloImpl target = new HelloImpl();
        MyProxy myProxy = new MyProxy(target);
        // 获取代理对象
        Hello hello = (Hello) Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                myProxy);

        hello.sayHello();
    }
}
