package com.desenvolvimento.logica.stockpilot.stockpilot_auth.service;

import com.desenvolvimento.logica.stockpilot.stockpilot_auth.dto.LoginRequest;
import com.desenvolvimento.logica.stockpilot.stockpilot_auth.dto.LoginResponse;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    public LoginResponse login(LoginRequest request) {

        return new LoginResponse(
                null,
                null,
                0l,
                false
        );
    }
}
