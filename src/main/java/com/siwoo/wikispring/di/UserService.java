package com.siwoo.wikispring.di;

public interface UserService {
    void register(User user, String rawPassword);
}
