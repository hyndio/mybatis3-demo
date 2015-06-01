package me.hynd.mybatis.test;

import me.hynd.mapper.AccountMapper;
import me.hynd.model.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by hynd on 2015/6/1.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:conf/spring/spring-core.xml",
        "classpath:conf/spring/spring-mybatis-mysql.xml"})
public class ProxyTest {

    @Autowired
    private AccountMapper accountMapper;

    @Test
    public void findAccount() {

        Account account = this.accountMapper.getAccountByUsername("j2ee");



    }
}
