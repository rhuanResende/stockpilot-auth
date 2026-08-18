package com.desenvolvimento.logica.stockpilot.stockpilot_auth.dto;

import jakarta.validation.constraints.NotBlank;

public record LoginRequest(
        @NotBlank(message = "CPF é obrigatório.")
        String document,

        @NotBlank(message = "Senha é obrigatória.")
        String password
) {
}
