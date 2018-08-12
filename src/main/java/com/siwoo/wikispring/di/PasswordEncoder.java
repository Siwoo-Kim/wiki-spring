package com.siwoo.wikispring.di;

public interface PasswordEncoder {
    String encode(CharSequence rawPassword);
}
