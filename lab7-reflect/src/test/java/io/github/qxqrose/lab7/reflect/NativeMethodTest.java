package io.github.qxqrose.lab7.reflect;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author: QXQ
 * @time: 2021/9/1 11:00
 */
public class NativeMethodTest {

    @Test
    public void testInvoke() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Hello instance = new Hello();

        Class<?> clazz = instance.getClass();

        Method hello = clazz.getMethod("say", String.class);

        Object world = hello.invoke(instance, "world");

        Assert.assertEquals("hello,world", world.toString());
    }

    @Test
    public void nativeMethodTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Hello instance = new Hello();

        Class<?> clazz = instance.getClass();

        Method method = clazz.getMethod("say", String.class);

        // 原生调用
        for (int i = 0; i < 16; i++) {
            Object world = method.invoke(instance, "world");
        }

        // 字节码调用
        Object world = method.invoke(instance, "world");

    }

    /**
     * sun.reflect.noInflation 设置为true
     * 设置vm参数  -Dsun.reflect.noInflation=true
     * 采用字节码生成反射
     */
    @Test
    public void asmMethodTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        Hello instance = new Hello();

        Class<?> clazz = instance.getClass();

        Method method = clazz.getMethod("say", String.class);

        for (int i = 0; i < 16; i++) {
            Object world = method.invoke(instance, "world");
        }
        Object world = method.invoke(instance, "world");
    }
}
