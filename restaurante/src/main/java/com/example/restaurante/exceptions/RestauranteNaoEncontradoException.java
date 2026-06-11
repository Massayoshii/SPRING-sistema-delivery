package com.example.restaurante.exceptions;

public class RestauranteNaoEncontradoException extends RuntimeException {
    public RestauranteNaoEncontradoException(Long id) {
        super("Restaurante com id " + id + " não encontrado");
    }
}
