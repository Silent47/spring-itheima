import com.am.spring.itheima.dao.IAccountDao;
import com.am.spring.itheima.service.IAccountService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BeanTest {

    @Test
    public void testClass() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        IAccountDao accountDao = ac.getBean("accountDao", IAccountDao.class);
        System.out.println(accountDao);
    }

    @Test
    public void testObject() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        IAccountService accountService = (IAccountService) ac.getBean("accountService");
        System.out.println(accountService);
    }

    public static class LazyBean {
        public static boolean isInitialed = false;

        public LazyBean() {
            isInitialed = true;
        }
    }

    /**
     * ApplicationContext   立即加载 Bean
     * BeanFactory          延迟加载 Bean
     */
    @Test
    public void testLazyLoad() {
        Resource resource = new ClassPathResource("lazy.xml");
        BeanFactory factory = new XmlBeanFactory(resource);
        assertFalse(LazyBean.isInitialed);
        LazyBean bean = factory.getBean("lazyBean", LazyBean.class);
        assertTrue(LazyBean.isInitialed);
    }

    public static class BusyBean {
        public static boolean isInitialed = false;

        public BusyBean() {
            isInitialed = true;
        }
    }

    @Test
    public void testBusyLoad() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("busy.xml");
        assertTrue(BusyBean.isInitialed);
        BusyBean bean = applicationContext.getBean("busyBean", BusyBean.class);
        assertTrue(BusyBean.isInitialed);
    }

}
