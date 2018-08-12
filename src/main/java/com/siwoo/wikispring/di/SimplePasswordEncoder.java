package com.siwoo.wikispring.di;

import org.springframework.stereotype.Component;

@Component
public class SimplePasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(CharSequence rawPassword) {
        char[] encoded = new char[rawPassword.length()];
        for(int i=0; i<rawPassword.length(); i++) {
            encoded[i] = (char) (rawPassword.charAt(i) + 15);
        }
        return new String(encoded);
    }
}
