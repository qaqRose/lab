package io.github.qxqrose.lab7.reflect.simple;

import io.github.qxqrose.lab7.reflect.Hello;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author: QXQ
 * @time: 2021/9/1 10:56
 */
public class Main {

    /**
     * 1. 正常情况下 使用 NativeMethodAccessorImpl
     * @param args
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Hello instance = new Hello();

        Class<?> clazz = instance.getClass();

        Method hello = clazz.getMethod("say", String.class);

        Object world = hello.invoke(instance, "world");

    }
}
