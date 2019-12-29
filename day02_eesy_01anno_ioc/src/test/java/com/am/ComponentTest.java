package com.am;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

public class ComponentTest {

    @Component
    public static class ComponentA {

    }

    @Component("comB")
    public static class CompnentB {

    }

    private ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");

    private void testBean(String beanName) {
        Object a = applicationContext.getBean(beanName);
        System.out.printf("%s -> %s.\n", beanName, a);
    }

    @Test
    public void testA() {
        testBean("componentTest.ComponentA");
    }

    @Test
    public void testB() {
        testBean("comB");
    }

}
