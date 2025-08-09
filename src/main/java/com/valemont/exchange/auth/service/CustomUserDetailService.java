package com.valemont.exchange.auth.service;

import com.valemont.exchange.auth.model.CustomUserDetails;
import com.valemont.exchange.user.model.User;
import com.valemont.exchange.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;


public class CustomUserDetailService implements UserDetailsService {
    private final CustomUserDetails customUserDetail;
    private final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> user =  userRepository.findByEmail(email);


}
