package io.github.qxqrose.reflect;

/**
 * @author: qiu
 * 2021/7/28
 */
public class ReflectTest {

    public static void main(String[] args) throws ClassNotFoundException {


        Class<?> aClass = Class.forName("io.github.qxqrose.Student");

        System.out.println(aClass.getSimpleName());

    }
}
