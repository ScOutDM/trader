package ru.itpark.trader.service;

import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itpark.trader.entity.UserEntity;
import ru.itpark.trader.exception.AccountNotFoundByIDException;
import ru.itpark.trader.repository.UserRepository;

import java.util.List;

@Primary
@Service
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    private final PasswordEncoder encoder;

    public UserService(UserRepository userRepository, PasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.encoder = encoder;
    }

    public List<UserEntity> findByAllUsers() {
        return userRepository.findAll();
    }

    public UserEntity findById(int id) {
        return userRepository.findById(id)
                .orElseThrow(()-> new AccountNotFoundByIDException());
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository
                .findByUsername(username)
                .orElseThrow();
    }
}
