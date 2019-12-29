import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class BeanFactoryTest {

    public static class Factory {

        private static ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");

        public Object getBean() {
            return getStaticBean();
        }

        public static Object getStaticBean() {
            return applicationContext.getBean("bean");
        }
    }

    private static ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("factory.xml");

    @Test
    public void testGetMethod() {
        BeanTest.Bean bean = (BeanTest.Bean) applicationContext.getBean("factoryBean");
        System.out.println(bean);
        assertNotNull(bean);
//        applicationContext.close();
    }

    @Test
    public void testStaticGetMethod() {
        BeanTest.Bean bean = (BeanTest.Bean) applicationContext.getBean("factoryStaticBean");
        System.out.println(bean);
        assertNotNull(bean);
//        applicationContext.close();
    }

}
