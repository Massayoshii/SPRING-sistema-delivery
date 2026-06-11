package com.example.restaurante.dto;

import com.example.restaurante.entity.Restaurante;

public record RestauranteResponse(
        Long id,
        String nome,
        String endereco,
        String telefone
) {
}
