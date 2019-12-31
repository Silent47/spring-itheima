package com.am;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:bean.xml")
public class JdbcTemplateTest {

    public static class Account {
        private int id;
        private String name;
        private float money;

        public void setId(int id) {
            this.id = id;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setMoney(float money) {
            this.money = money;
        }

        @Override
        public String toString() {
            return "Account{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", money=" + money +
                    '}';
        }
    }

    @Component
    public static class JdbcBean {

        @Autowired
        private JdbcTemplate jdbcTemplate;

        List<Account> selectAll() {
            return jdbcTemplate.query("select * from account", new BeanPropertyRowMapper(Account.class));
        }
    }

    @Autowired
    private JdbcBean jdbcBean;

    @Test
    public void test() {
        List<Account> list = jdbcBean.selectAll();
        System.out.println(list);
    }

}
