package com.example.restaurante.exceptions;

public class ProdutoNaoEncontradoException extends RuntimeException {
    public ProdutoNaoEncontradoException(Long id) {
        super("Produto com o id " + id +" nao encontrado");
    }
}
