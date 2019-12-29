import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class BeanTest {

    public static class Bean
    {
    }

    @Test
    public void testBean() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        Bean bean = applicationContext.getBean("bean", Bean.class);
        System.out.println(bean);
        assertNotNull(bean);
    }

}
