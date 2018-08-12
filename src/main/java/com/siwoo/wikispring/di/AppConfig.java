package com.siwoo.wikispring.di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    UserRepository userRepository() {
        return new SimpleUserRepository();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new SimplePasswordEncoder();
    }

    @Bean(name = "userSv")
    UserService userService() {
        return new UserServiceImpl(userRepository(), null);
    }
}
