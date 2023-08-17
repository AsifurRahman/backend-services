package com.asif.backend.config.authentication.service;

import com.asif.backend.payload.request.LoginRequest;
import com.asif.backend.payload.response.JwtResponse;

public interface AuthService {

    JwtResponse authenticateUser(LoginRequest loginRequest);
}
