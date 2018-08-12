package com.siwoo.wikispring.di;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

public class TestContext {

    ApplicationContext c;

    @Before
    public void setup() {
        c = new AnnotationConfigApplicationContext(AppConfig.class);
        assertNotNull(c);
    }

    public void checkCompositions(ApplicationContext c) {
        assertNotNull(c.getBean(UserService.class));
        assertNotNull(c.getBean("userSv", UserService.class));
        assertNotNull(c.getBean(UserRepository.class));
        assertNotNull(c.getBean(PasswordEncoder.class));
    }
    @Test
    public void compositions() {
        checkCompositions(c);
        c = new ClassPathXmlApplicationContext("spring/di-context.xml");
        checkCompositions(c);
    }

    @Configuration
    public static class RequiredTest {

        @Bean
        UserRepository userRepository() {
            return new SimpleUserRepository();
        }

        @Bean
        UserService userService() {
            return new UserServiceImpl(userRepository(), null);
        }
    }

    @Test(expected = NoSuchBeanDefinitionException.class)
    public void required() {
        c = new AnnotationConfigApplicationContext(RequiredTest.class);
        assertNotNull(c.getBean(UserService.class));
        c.getBean(PasswordEncoder.class);
        fail();
    }

    @Configuration
    public static class QualifierTest {
        @Bean
        UserRepository userRepository() {
            return new SimpleUserRepository();
        }

        @Bean
        UserService userService() {
            return new UserServiceImpl(userRepository(), null);
        }


    }
}
