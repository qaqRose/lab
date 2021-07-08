package com.github.qaqRose;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * @author qiu
 * 2021/5/26
 */
public class Main {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:context.xml");

//        Resource resource = new ClassPathResource("context.xml");
//        BeanFactory factory = new XmlBeanFactory(resource);

        Object simple = applicationContext.getBean("simple");

        System.out.println(simple);
    }
}
