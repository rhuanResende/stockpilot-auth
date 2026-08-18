package com.desenvolvimento.logica.stockpilot.stockpilot_auth.controller;

import com.desenvolvimento.logica.stockpilot.stockpilot_auth.dto.LoginRequest;
import com.desenvolvimento.logica.stockpilot.stockpilot_auth.dto.LoginResponse;
import com.desenvolvimento.logica.stockpilot.stockpilot_auth.service.AuthService;
import com.desenvolvimento.logica.stockpilot.stockpilot_common.dto.ApiResponse;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;

@RestController
@RequestMapping("${app.api.base}/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<Void>> login(
            @Valid @RequestBody LoginRequest request,
            HttpServletResponse response) {

        LoginResponse loginResponse = authService.login(request);

        ResponseCookie accessCookie = ResponseCookie
                .from("access_token", loginResponse.accessToken())
                .httpOnly(true)
                .secure(true)
                .sameSite("None")
                .path("/")
                .maxAge(Duration.ofMinutes(5))
                .build();

        ResponseCookie refreshCookie = ResponseCookie
                .from("refresh_token", loginResponse.refreshToken())
                .httpOnly(true)
                .secure(true)
                .sameSite("None")
                .path("${app.api.base}/auth/refresh")
                .maxAge(Duration.ofMinutes(30))
                .build();

        response.addHeader(HttpHeaders.SET_COOKIE, accessCookie.toString());
        response.addHeader(HttpHeaders.SET_COOKIE, refreshCookie.toString());

        return ResponseEntity.ok(new ApiResponse<>(
                true,
                "Login realizado com sucesso."
        ));
    }
}
