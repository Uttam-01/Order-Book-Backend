package com.valemont.exchange.user.dto;

import java.time.LocalDateTime;

public record UserResponse(
        String name,
        String email,
        LocalDateTime registrationDate
) {
}
