package com.movieapp.service;


import com.movieapp.auth.AuthResponse;
import com.movieapp.auth.LoginRequest;
import com.movieapp.auth.RegisterRequest;

public interface IAuthService {
    AuthResponse login(LoginRequest loginDto);
    String register(RegisterRequest registerDto);
}