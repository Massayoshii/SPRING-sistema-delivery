package com.example.restaurante.service;

import com.example.restaurante.entity.Produto;
import com.example.restaurante.exceptions.ProdutoNaoEncontradoException;
import com.example.restaurante.repository.ProdutoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public Produto criar(Produto produto){
        return produtoRepository.save(produto);
    }

    public List<Produto> listar(){
        return produtoRepository.findAll();
    }

    public Produto buscarPorId(Long id){
        return produtoRepository.findById(id).orElseThrow(() -> new ProdutoNaoEncontradoException(id));
    }

    public Produto atualizar(Long id , Produto produtoNovo){
        Produto produto = buscarPorId(id);

        produto.setNome(produtoNovo.getNome());
        produto.setPreco(produtoNovo.getPreco());
        produto.setDescricao(produtoNovo.getDescricao());
        produto.setDisponivel(produtoNovo.isDisponivel());
        produto.setRestaurante(produtoNovo.getRestaurante());

        return produtoRepository.save(produto);
    }

    public void remover(Long id){
        Produto produto = buscarPorId(id);
        produtoRepository.delete(produto);
    }
}
