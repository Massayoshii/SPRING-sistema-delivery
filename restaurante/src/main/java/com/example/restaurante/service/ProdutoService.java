package com.example.restaurante.service;

import com.example.restaurante.dto.ProdutoRequest;
import com.example.restaurante.dto.ProdutoResponse;
import com.example.restaurante.dto.RestauranteResponse;
import com.example.restaurante.entity.Produto;
import com.example.restaurante.entity.Restaurante;
import com.example.restaurante.exceptions.ProdutoNaoEncontradoException;
import com.example.restaurante.repository.ProdutoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoResponse criar(ProdutoRequest request){
        Produto produto = new Produto();

        produto.setNome(request.nome());
        produto.setDescricao(request.descricao());
        produto.setPreco(request.preco());
        produto.setDisponivel(request.disponivel());

        Produto salvo = produtoRepository.save(produto);
        return converterParaResponse(salvo);
    }

    public List<ProdutoResponse> listar(){
        return produtoRepository.findAll()
                .stream()
                .map(this::converterParaResponse)
                .toList();
    }

    public ProdutoResponse buscarPorId(Long id){
        Produto produto = produtoRepository.findById(id).orElseThrow(() -> new ProdutoNaoEncontradoException(id));
        return converterParaResponse(produto);
    }

    public ProdutoResponse atualizar(Long id , ProdutoRequest request){
        Produto produto = produtoRepository.findById(id).orElseThrow(() -> new ProdutoNaoEncontradoException(id));

        produto.setNome(request.nome());
        produto.setPreco(request.preco());
        produto.setDescricao(request.descricao());
        produto.setDisponivel(request.disponivel());

        Produto atualizado = produtoRepository.save(produto);
        return  converterParaResponse(atualizado);
    }

    public void remover(Long id){
        Produto produto = produtoRepository.findById(id).orElseThrow(() -> new ProdutoNaoEncontradoException(id));
        produtoRepository.delete(produto);
    }

    private ProdutoResponse converterParaResponse(Produto produto){

        return new ProdutoResponse(
                produto.getId(),
                produto.getNome(),
                produto.getDescricao(),
                produto.getPreco(),
                produto.isDisponivel()
        );
    }

}
