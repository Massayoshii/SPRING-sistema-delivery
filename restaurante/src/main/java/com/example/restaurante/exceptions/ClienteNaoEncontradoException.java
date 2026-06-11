package com.example.restaurante.exceptions;

public class ClienteNaoEncontradoException extends RuntimeException {
    public ClienteNaoEncontradoException(Long id) {
        super("Cliente com o id " + id + " nao foi encontrado");
    }
}
