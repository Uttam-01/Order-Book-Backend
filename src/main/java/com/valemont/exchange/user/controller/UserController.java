package com.valemont.exchange.user.controller;

import com.valemont.exchange.user.dto.RegisterRequest;
import com.valemont.exchange.user.model.User;
import com.valemont.exchange.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;
    @PostMapping
    public ResponseEntity<String>  createUser(@RequestBody RegisterRequest request){
        userService.register(request);
        return ResponseEntity.ok("user ki ma chud gi h");
    }
}
