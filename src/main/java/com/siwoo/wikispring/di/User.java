package com.siwoo.wikispring.di;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @ToString
public class User {
    private final String name;
    private final String password;

    private User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    static User newInstance(String name, String password) {
        return new User(name, password);
    }
}
