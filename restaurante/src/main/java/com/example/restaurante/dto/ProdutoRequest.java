package com.example.restaurante.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public record ProdutoRequest(
        @NotBlank
        @Size(max = 150 , message = "O nome deve ter o maximo de 150 caracteres.")
        String nome,

        @Size(max = 500 , message = "A descricao deve ter o maximo de 500 caracteres.")
        String descricao,

        @Size(max = 10 , message = "O preco deve ter o maximo de 10 caracteres.")
        BigDecimal preco,

        @NotBlank
        boolean disponivel
) {
}
