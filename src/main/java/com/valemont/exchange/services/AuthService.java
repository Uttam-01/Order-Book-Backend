package com.valemont.exchange.services;

import com.valemont.exchange.user.dto.AuthResponse;
import com.valemont.exchange.user.dto.RegisterRequest;
import com.valemont.exchange.dto.auth.AuthRequest;

public interface AuthService {
    AuthResponse register(RegisterRequest request);
    AuthResponse authenticate(AuthRequest request);
}
