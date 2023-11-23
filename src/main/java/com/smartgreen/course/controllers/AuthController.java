package com.smartgreen.course.controllers;

import com.smartgreen.course.models.body.AuthResponse;
import com.smartgreen.course.models.entity.User;
import com.smartgreen.course.services.JwtService;
import com.smartgreen.course.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;

@RestController
@RequestMapping(path = "/api/v1/course-services/auth")
public class AuthController {
    @Autowired
    private UserService userService;
    @Autowired
    private JwtService jwtService;
    @PostMapping("/register")
    public  ResponseEntity<?> register(@RequestBody User user) throws NoSuchAlgorithmException {
        AuthResponse<?> authResponse = userService.register(user);
        return ResponseEntity.status(200)
                .body(authResponse);
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody  User user){
        AuthResponse<?> authResponse =  userService.Login(user);
        return ResponseEntity.status(200)
                .body(authResponse);
    }
    @PostMapping("/midle")
    public String test(@RequestHeader("Authorization") String auth){
        return jwtService.getPayloadBearerToken(auth) ;
    }
}
