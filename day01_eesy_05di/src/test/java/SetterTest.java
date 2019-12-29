import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.Properties;
import java.util.Set;

public class SetterTest {

    public static class SetBean {
        private String name;
        private boolean bool;
        private Date date;
        private Set<String> set;
        private Properties properties;

        public SetBean(String name) {
            this.name = name;
        }

        public void setBool(boolean bool) {
            this.bool = bool;
        }

        public void setDate(Date date) {
            this.date = date;
        }

        public void setSet(Set<String> set) {
            this.set = set;
        }

        public void setProperties(Properties properties) {
            this.properties = properties;
        }

        @Override
        public String toString() {
            return String.format("%s:{\n%s=%s,\n%s=%s,\n%s=%s,\n%s=%s,\n%s=%s\n}\n",
                    super.toString(),
                    "name", name,
                    "bool", bool,
                    "date", date,
                    "set", set,
                    "properties", properties);
        }
    }

    @Test
    public void test() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        Object bean = applicationContext.getBean("setBean");
        System.out.printf("%s\n", bean);
    }

}
