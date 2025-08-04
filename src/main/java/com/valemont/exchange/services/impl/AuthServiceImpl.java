package com.valemont.exchange.services.impl;

import com.valemont.exchange.dto.auth.AuthRequest;
import com.valemont.exchange.user.dto.AuthResponse;
import com.valemont.exchange.user.dto.RegisterRequest;
import com.valemont.exchange.model.CustomUserDetails;
import com.valemont.exchange.user.model.User;
import com.valemont.exchange.user.repository.UserRepository;
import com.valemont.exchange.security.JwtService;
import com.valemont.exchange.services.AuthService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired private UserRepository userRepository;
    @Autowired private PasswordEncoder passwordEncoder;
    @Autowired private JwtService jwtService;
    @Autowired private AuthenticationManager authenticationManager;

    @Override
    public AuthResponse register(RegisterRequest request) {
        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        // Set other fields like UUID and stocks here
        userRepository.save(user);
        String token = jwtService.generateToken(new CustomUserDetails(user));
        return new AuthResponse(token);
    }

    @Override
    public AuthResponse authenticate(AuthRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );
        User user = userRepository.findByEmail(request.getEmail()).orElseThrow();
        String token = jwtService.generateToken(new CustomUserDetails(user));
        return new AuthResponse(token);
    }
}
