package com.valemont.exchange.user.dto;

import lombok.*;


public record RegisterRequest(
     String email,
     String password
){}