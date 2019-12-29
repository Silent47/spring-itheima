import com.am.spring.itheima.config.SpringConfiguration;
import com.am.spring.itheima.domain.Account;
import com.am.spring.itheima.service.IAccountService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Random;
import java.util.UUID;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = SpringConfiguration.class)
@TestPropertySource("classpath:test.properties")
public class AmTest {

//    private ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfiguration.class);
//    private IAccountService accountService = applicationContext.getBean(IAccountService.class);

    @Autowired
    private IAccountService accountService;

    @Value("${test.accountId}")
    private int testAccountId;

    @Test
    public void testGetAll() {
        System.out.println(accountService.getAllAccount());
    }

    @Test
    public void testGet() {
        System.out.println(accountService.getAccount(testAccountId));
    }

    @Test
    public void testAdd() {
        Account account = new Account();
        account.setMoney(new Random().nextFloat());
        account.setName(UUID.randomUUID().toString());
        accountService.addAccount(account);
    }

    @Test
    public void testUpdate() {
        Account account = new Account();
        account.setId(testAccountId);
        account.setMoney(new Random().nextFloat());
        account.setName(UUID.randomUUID().toString());
        accountService.updateAccount(account);
    }

    @Test
    public void testRemove() {
        accountService.removeAccount(testAccountId);
    }

}
