package com.siwoo.wikispring.di;

public interface UserRepository {
    User save(User user);
    int countByUsername(String username);
}
