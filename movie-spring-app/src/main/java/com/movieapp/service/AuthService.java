package com.movieapp.service;

import com.movieapp.auth.AuthResponse;
import com.movieapp.auth.LoginRequest;
import com.movieapp.auth.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    public AuthResponse login(LoginRequest request) {
        return null;
    }

    public AuthResponse register(RegisterRequest request) {

    }
}
