package com.valemont.exchange.user.service;

import com.valemont.exchange.user.dto.AuthResponse;
import com.valemont.exchange.user.dto.RegisterRequest;
import com.valemont.exchange.user.model.User;
import com.valemont.exchange.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final  UserRepository userRepository;
    @Override
    public void register(RegisterRequest request) {
        User user = User.builder()
                .email(request.email())
                .password(request.password())
                .build();
        userRepository.save(user);
    }
}
