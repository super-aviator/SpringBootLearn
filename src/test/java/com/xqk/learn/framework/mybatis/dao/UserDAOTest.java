package com.xqk.learn.framework.mybatis.dao;

import com.xqk.learn.framework.LearnApplication;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,classes = LearnApplication.class)
@RunWith(SpringRunner.class)
public class UserDAOTest {
    @Autowired
    private UserDAO userDAO;

    @Test
    public void testInsert() {
    }
}