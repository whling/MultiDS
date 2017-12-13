package com.ifeng.test;

import com.ifeng.test.pojo.User;
import com.ifeng.test.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by whling on 2017/12/12.
 */
public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{
                "classpath:spring.xml"
        });
        UserService userService = context.getBean(UserService.class);
        User user1 = new User(7, "galaxy", "sumsung phone");
        User user2 = userService.getUserById(5);
        user2.setUsername("xiaomi");
        user2.setDesc("mi");
        userService.testTransaction(user1, user2);
    }
}
