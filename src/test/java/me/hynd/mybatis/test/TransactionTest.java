package me.hynd.mybatis.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.AfterTransaction;
import org.springframework.test.context.transaction.BeforeTransaction;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 * 事务测试
 *
 * Created by hynd on 2015/5/30.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:conf/spring/spring-core.xml",
        "classpath:conf/spring/spring-mybatis-mysql.xml"})
@TransactionConfiguration(transactionManager="transactionManager", defaultRollback=false)
@Transactional
public class TransactionTest {

    private static final Logger logger = LoggerFactory.getLogger(TransactionTest.class);

    @Before
    public void setUp() throws Exception {
    }

    @BeforeTransaction
    public void beforeTransaction() {
        logger.debug("--------beforeTransaction-------");
    }

    @Rollback()
    public void rollback() {
        logger.debug("--------roll back--------");
    }

    @Transactional
    @Test
    public void foo() {
        logger.debug("--------Good--------");
        rollback();
    }

    @AfterTransaction
    public void afterTransaction() {
        logger.debug("--------afterTransaction-------");
    }

}
