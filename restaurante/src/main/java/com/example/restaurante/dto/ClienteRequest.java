package com.example.restaurante.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ClienteRequest(
        @NotBlank
        @Size(max = 150 , message = "O nome deve ter o maximo de 150 caracteres.")
        String nome ,

        @Email
        @Size(max = 150 , message = "O email deve ter o maximo de 150 caracteres.")
        String email,

        @Size(max = 20 , message = "O telefone deve ter o maximo de 20 caracteres.")
        String telefone,

        @Size(max = 200 , message = "O endereco deve ter o maximo de 200 caracteres.")
        String endereco
) {
}
