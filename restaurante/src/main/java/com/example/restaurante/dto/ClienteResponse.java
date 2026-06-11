package com.example.restaurante.dto;

public record ClienteResponse(
        String nome,
        String email,
        String telefone,
        String endereco
) {
}
