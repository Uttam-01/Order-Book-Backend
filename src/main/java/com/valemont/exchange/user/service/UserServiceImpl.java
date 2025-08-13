package com.valemont.exchange.user.service;

import com.valemont.exchange.user.dto.AuthResponse;
import com.valemont.exchange.user.dto.RegisterRequest;
import com.valemont.exchange.user.dto.UserResponse;
import com.valemont.exchange.user.model.User;
import com.valemont.exchange.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final  UserRepository userRepository;

    @Override
    public List<UserResponse> getAllUser() {
         List<User> user = userRepository.findAll();

         return  user.stream()
                 .map(user1 -> new UserResponse(
                         user1.getName(),
                         user1.getEmail(),
                         user1.getCreatedAt()
                 )).toList();
    }
}
