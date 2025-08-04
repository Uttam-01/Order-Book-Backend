package com.valemont.exchange.services;

import com.valemont.exchange.dto.auth.AuthResponse;
import com.valemont.exchange.dto.auth.RegisterRequest;
import com.valemont.exchange.dto.auth.AuthRequest;

public interface AuthService {
    AuthResponse register(RegisterRequest request);
    AuthResponse authenticate(AuthRequest request);
}
