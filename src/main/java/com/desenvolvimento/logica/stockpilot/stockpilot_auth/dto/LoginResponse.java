package com.desenvolvimento.logica.stockpilot.stockpilot_auth.dto;

public record LoginResponse(
        String accessToken,
        String refreshToken,
        long expiresIn,
        boolean firstAccess
) {
}
