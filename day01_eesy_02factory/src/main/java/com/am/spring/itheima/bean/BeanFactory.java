package com.am.spring.itheima.bean;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

public class BeanFactory {

    private static Map<String, Object> beanMap = new ConcurrentHashMap<>();

    static {
        InputStream resourceAsStream = BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
        Properties properties = new Properties();
        try {
            properties.load(resourceAsStream);
        } catch (IOException e) {
            throw new ExceptionInInitializerError(e);
        }
        properties.forEach((k, v) -> {
            try {
                beanMap.put(k.toString(), Class.forName(v.toString()).newInstance());
            } catch (Exception e) {
                throw new ExceptionInInitializerError(e);
            }
        });
    }

    public static Object getBean(String name) {
        return beanMap.get(name);
    }

}
