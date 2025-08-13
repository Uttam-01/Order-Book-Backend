package com.valemont.exchange.user.controller;

import com.valemont.exchange.user.dto.RegisterRequest;
import com.valemont.exchange.user.dto.UserResponse;
import com.valemont.exchange.user.model.User;
import com.valemont.exchange.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<UserResponse>>  getAllUser(){
        return ResponseEntity.ok(userService.getAllUser());
    }

}
