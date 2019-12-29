import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConstructorTest {

    public static class ConBean {
        private int i;

        public ConBean(int i) {
            this.i = i;
        }

        @Override
        public String toString() {
            return String.format("%s:{%d}", super.toString(), i);
        }
    }

    @Test
    public void test() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        Object bean = applicationContext.getBean("conBean");
        System.out.printf("%s\n", bean);
    }

}
