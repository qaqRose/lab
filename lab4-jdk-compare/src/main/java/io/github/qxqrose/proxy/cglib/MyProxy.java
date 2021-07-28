package io.github.qxqrose.proxy.cglib;

import io.github.qxqrose.proxy.HelloC;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author: qiu
 * 2021/7/28
 */
public class MyProxy implements MethodInterceptor {

    private Object target;

    public MyProxy(Object target) {
        this.target = target;
    }

    public static void main(String[] args) {
        HelloC helloC = new HelloC();

        MyProxy myProxy = new MyProxy(helloC);
        //工具类
        Enhancer en = new Enhancer();
        //设置父类
        en.setSuperclass(helloC.getClass());
        //设置回调函数
        en.setCallback(myProxy);
        //创建子类代理对象
        HelloC o = (HelloC) en.create();
        o.sayHello();

    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("cglib 调用");
        return method.invoke(target);
    }
}
