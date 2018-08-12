package com.siwoo.wikispring.di;

import com.siwoo.wikispring.di.exception.UserAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("userSv")
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(@Autowired UserRepository userRepository, @Autowired(required = false) PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void register(User user, String rawPassword) {
        if(userRepository.countByUsername(user.getName()) > 0) {
            throw new UserAlreadyExistsException();
        }
        user = User.newInstance(user.getName(), passwordEncoder.encode(rawPassword));
        userRepository.save(user);
    }
}
