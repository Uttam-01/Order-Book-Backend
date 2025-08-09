package com.valemont.exchange.auth.service;


import com.valemont.exchange.auth.dto.AuthRequest;
import com.valemont.exchange.auth.dto.AuthResponse;


public interface AuthService {
    AuthResponse register(AuthRequest request);
    AuthResponse login(AuthRequest request);
}
