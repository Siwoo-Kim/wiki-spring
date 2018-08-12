package com.siwoo.wikispring.di;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class SimpleUserRepository implements UserRepository {
    Map<String, User> data = new HashMap<>();

    @Override
    public User save(User user) {
        return data.put(user.getName(), user);
    }

    @Override
    public int countByUsername(String username) {
        return data.containsKey(username)? 1: 0;
    }
}
