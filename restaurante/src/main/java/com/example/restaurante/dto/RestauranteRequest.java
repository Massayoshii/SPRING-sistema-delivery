package com.example.restaurante.dto;

import com.example.restaurante.entity.Restaurante;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RestauranteRequest(
        @NotBlank
        @Size(max = 150 , message = "O nome deve ter o maximo de 150 caracteres.")
        String nome,

        @Size(max = 150 , message = "O endereco deve ter o maximo de 150 caracteres.")
        String endereco,

        @Size(max = 30 , message = "O telefone deve ter o maximo de 30 caracteres.")
        String telefone
) {
}
