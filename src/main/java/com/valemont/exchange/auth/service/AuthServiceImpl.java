package com.valemont.exchange.auth.service;

import com.valemont.exchange.auth.dto.AuthRequest;
import com.valemont.exchange.auth.dto.AuthResponse;
import com.valemont.exchange.auth.model.CustomUserDetails;
import com.valemont.exchange.config.JwtUtils;
import com.valemont.exchange.user.model.User;
import com.valemont.exchange.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthServiceImpl implements AuthService{


    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private  final JwtUtils jwtUtils;

   @Override
    public AuthResponse register(AuthRequest request) {
       if (userRepository.existsByEmail(request.getEmail())) {
           throw new IllegalStateException("Email is already registered");
       }
       User user1  = User.builder()
               .email(request.getEmail())
               .password(passwordEncoder.encode(request.getPassword()))
               .build();
       userRepository.save(user1);
       Authentication authentication;
       try {
           authentication = authenticationManager.authenticate(
                   new UsernamePasswordAuthenticationToken(
                           request.getEmail(),
                           request.getPassword()
                   )
           );
       }catch (Exception e){
           throw new IllegalStateException("Invalid email and password");
       }
       CustomUserDetails customUserDetails = (CustomUserDetails) authentication.getPrincipal();
       User user = customUserDetails.getUser();

       String token = jwtUtils.generateToken(user.getEmail());
       return new AuthResponse(token);
    }

    @Override
    public AuthResponse login(AuthRequest request) {
        Authentication authentication;
        try {
            authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getEmail(),
                            request.getPassword()
                    )
            );
        }catch (Exception e){
            throw new IllegalStateException("Invalid email and password");
        }
        CustomUserDetails customUserDetails = (CustomUserDetails) authentication.getPrincipal();
        User user = customUserDetails.getUser();

        String token = jwtUtils.generateToken(user.getEmail());
        return new AuthResponse(token);
    }
}
